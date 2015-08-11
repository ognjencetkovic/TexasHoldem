package ba.bitcamp.texas.run;

import java.util.ArrayList;

import ba.bitcamp.texas.run.Card.Suit;
import ba.bitcamp.texas.run.Card.Value;

public class HandEvaluator {
    
    private static final int NO_OF_RANKINGS  = 6;
    private static final int MAX_NO_OF_PAIRS = 2;
    private static final int[] RANKING_FACTORS = {371293, 28561, 2197, 169, 13, 1};
    
    private HandValueType type;
    private int value = 0;
    private final Card[] cards;
    private int[] rankDist = new int[Value.values().length];
    private int[] suitDist = new int[Suit.values().length];
    private int noOfPairs = 0;
    private int[] pairs = new int[MAX_NO_OF_PAIRS];
    private int flushSuit = -1;
    private int flushRank = -1;
    private int straightRank = -1;
    private boolean wheelingAce = false;
    private int tripleRank = -1;
    private int quadRank = -1;
    private int[] rankings = new int[NO_OF_RANKINGS];
    
    public HandEvaluator(ArrayList<Card> hand) {
        cards = (Card[]) hand.toArray();
        
        // Find patterns.
        calculateDistributions();
        findStraight();
        findFlush();
        findDuplicates();
        
        // Find special values.
        boolean isSpecialValue =
                (isStraightFlush() ||
                 isFourOfAKind()   ||
                 isFullHouse()     ||
                 isFlush()         ||
                 isStraight()      ||
                 isThreeOfAKind()  ||
                 isTwoPairs()      ||
                 isOnePair());
        if (!isSpecialValue) {
            calculateHighCard();
        }
        
        // Calculate value.
        for (int i = 0; i < NO_OF_RANKINGS; i++) {
            value += rankings[i] * RANKING_FACTORS[i];
        }
    }
    
    public HandValueType getType() {
        return type;
    }
    
    public int getValue() {
        return value;
    }
    
    private void calculateDistributions() {
        for (Card card : cards) {
            rankDist[card.getValue().ordinal()]++;
            suitDist[card.getSuit().ordinal()]++;
        }
    }
    
    private void findFlush() {
        for (int i = 0; i < Card.NO_OF_SUITS; i++) {
            if (suitDist[i] >= 5) {
                flushSuit = i;
                for (Card card : cards) {
                    if (card.getSuit() == flushSuit) {
                        if (!wheelingAce || card.getRank() != Card.ACE) {
                            flushRank = card.getRank();
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
    
    private void findStraight() {
        boolean inStraight = false;
        int rank = -1;
        int count = 0;
        for (int i = Value.values().length - 1; i >= 0 ; i--) {
            if (rankDist[i] == 0) {
                inStraight = false;
                count = 0;
            } else {
                if (!inStraight) {
                    inStraight = true;
                    rank = i;
                }
                count++;
                if (count >= 5) {
                    straightRank = rank;
                    break;
                }
            }
        }
        if ((count == 4) && (rank == Card.FIVE) && (rankDist[Card.ACE] > 0)) {
            wheelingAce = true;
            straightRank = rank;
        }
    }
    
    private void findDuplicates() {
        // Find quads, triples and pairs.
        for (int i = Value.values().length - 1; i >= 0 ; i--) {
            if (rankDist[i] == 4) {
                quadRank = i;
            } else if (rankDist[i] == 3) {
                tripleRank = i;
            } else if (rankDist[i] == 2) {
                if (noOfPairs < MAX_NO_OF_PAIRS) {
                    pairs[noOfPairs++] = i;
                }
            }
        }
    }
    
    private void calculateHighCard() {
        type = HandValueType.HIGH_CARD;
        rankings[0] = type.getValue();
        // Get the five highest ranks.
        int index = 1;
        for (Card card : cards) {
            rankings[index++] = card.getRank();
            if (index > 5) {
                break;
            }
        }
    }
    
    private boolean isOnePair() {
        if (noOfPairs == 1) {
            type = HandValueType.ONE_PAIR;
            rankings[0] = type.getValue();
            // Get the rank of the pair.
            int pairRank = pairs[0];
            rankings[1] = pairRank;
            // Get the three kickers.
            int index = 2;
            for (Card card : cards) {
                int rank = card.getRank();
                if (rank != pairRank) {
                    rankings[index++] = rank;
                    if (index > 4) {
                        // We don't need any more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isTwoPairs() {
        if (noOfPairs == 2) {
            type = HandValueType.TWO_PAIRS;
            rankings[0] = type.getValue();
            // Get the value of the high and low pairs.
            int highRank = pairs[0];
            int lowRank  = pairs[1];
            rankings[1] = highRank;
            rankings[2] = lowRank;
            // Get the kicker card.
            for (Card card : cards) {
                int rank = card.getRank();
                if ((rank != highRank) && (rank != lowRank)) {
                    rankings[3] = rank;
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isThreeOfAKind() {
        if (tripleRank != -1) {
            type = HandValueType.THREE_OF_A_KIND;
            rankings[0] = type.getValue();
            rankings[1] = tripleRank;
            // Get the remaining two cards as kickers.
            int index = 2;
            for (Card card : cards) {
                int rank = card.getRank();
                if (rank != tripleRank) {
                    rankings[index++] = rank;
                    if (index > 3) {
                        // We don't need any more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isStraight() {
        if (straightRank != -1) {
            type = HandValueType.STRAIGHT;
            rankings[0] = type.getValue();
            rankings[1] = straightRank;
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isFlush() {
        if (flushSuit != -1) {
            type = HandValueType.FLUSH;
            rankings[0] = type.getValue();
            int index = 1;
            for (Card card : cards) {
                if (card.getSuit() == flushSuit) {
                    int rank = card.getRank();
                    if (index == 1) {
                        flushRank = rank;
                    }
                    rankings[index++] = rank;
                    if (index > 5) {
                        // We don't need more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isFullHouse() {
        if ((tripleRank != -1) && (noOfPairs > 0)) {
            type = HandValueType.FULL_HOUSE;
            rankings[0] = type.getValue();
            rankings[1] = tripleRank;
            rankings[2] = pairs[0];
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isFourOfAKind() {
        if (quadRank != -1) {
            type = HandValueType.FOUR_OF_A_KIND;
            rankings[0] = type.getValue();
            rankings[1] = quadRank;
            // Get the remaining card as kicker.
            int index = 2;
            for (Card card : cards) {
                int rank = card.getRank();
                if (rank != quadRank) {
                    rankings[index++] = rank;
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isStraightFlush() {
        if (straightRank != -1 && flushRank == straightRank) {
            // Flush and Straight (possibly separate); check for Straight Flush.
            int straightRank2 = -1;
            int lastSuit = -1;
            int lastRank = -1;
            int inStraight = 1;
            int inFlush = 1;
            for (Card card : cards) {
                int rank = card.getValue().ordinal();
                int suit = card.getSuit().ordinal();
                if (lastRank != -1) {
                    int rankDiff = lastRank - rank;
                    if (rankDiff == 1) {
                        // Consecutive rank; possible straight!
                        inStraight++;
                        if (straightRank2 == -1) {
                            straightRank2 = lastRank;
                        }
                        if (suit == lastSuit) {
                            inFlush++;
                        } else {
                            inFlush = 1;
                        }
                        if (inStraight >= 5 && inFlush >= 5) {
                            // Straight!
                            break;
                        }
                    } else if (rankDiff == 0) {
                        // Duplicate rank; skip.
                    } else {
                        // Non-consecutive; reset.
                        straightRank2 = -1;
                        inStraight = 1;
                        inFlush = 1;
                    }
                }
                lastRank = rank;
                lastSuit = suit;
            }
            
            if (inStraight >= 5 && inFlush >= 5) {
                if (straightRank == Card.Value.ACE.ordinal()) {
                    // Royal Flush.
                    type = HandValueType.ROYAL_FLUSH;
                    rankings[0] = type.getValue();
                    return true;
                } else {
                    // Straight Flush.
                    type = HandValueType.STRAIGHT_FLUSH;
                    rankings[0] = type.getValue();
                    rankings[1] = straightRank2;
                    return true;
                }
            } else if (wheelingAce && inStraight >= 4 && inFlush >= 4) {
                // Steel Wheel (Straight Flush with wheeling Ace).
                type = HandValueType.STRAIGHT_FLUSH;
                rankings[0] = type.getValue();
                rankings[1] = straightRank2;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
