
package enumsareawesome;

public class Card implements Comparable {
    Suit suit;
    Rank rank;
    
    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE}
    public enum Suit 
    {
        DIAMONDS(3), CLUBS(4), HEARTS(5), SPADES(6);
        
        //You can add data to enums, too.
        public int x;
        
        Suit(int x) {
            this.x = x;
        }
    
        //And you can add static and instance methods.
        public static void foo() {
            System.out.println("Hi");
        }
        
        public void bar() {
            System.out.println("Bar");
        }
    }

    public Card(String suit, String rank) {
        this.suit = Suit.valueOf(suit);
        this.rank = Rank.valueOf(rank);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
    @Override
    public int compareTo(Object o) {
        Card c = (Card)o;
        if (this.suit == c.suit) {
            return this.rank.compareTo(c.rank);
        }
        return this.suit.compareTo(c.suit);
    }
}
