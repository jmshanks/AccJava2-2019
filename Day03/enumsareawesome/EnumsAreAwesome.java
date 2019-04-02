
package enumsareawesome;

import apple.laf.JRSUIConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnumsAreAwesome {
    
    public static void main(String[] args) {
        
        Color c = Color.PURPLE;
        
        switch(c) {
            case RED:
                System.out.println("Red!");
                break;
            case GREEN:
                System.out.println("Green!");
                break;
            default:
                System.out.println("I don't know what color I am.");
        }
        
        doCardStuff();
    }
    
    public static void doCardStuff() {
        
        List<Card> cards = new ArrayList();
        for (Enum suit : Card.Suit.values()) {
            for (Enum rank : Card.Rank.values()) {
                System.out.println(suit.ordinal());
                Card c = new Card(suit.name(), rank.name());
                cards.add(c);
            }
        }
        Deck deck = new Deck(cards);
        for(Card c : deck.cards) {
            System.out.println(c);
        }
        System.out.println("\n\n");
        Collections.shuffle(deck.cards, new Random(System.currentTimeMillis()));
        for(Card c : deck.cards) {
            System.out.println(c);
        }
        System.out.println("\n\n");
        Collections.sort(deck.cards);
        for(Card c : deck.cards) {
            System.out.println(c);
        }
        System.out.println("\n\n");
        Card.Suit.foo();
        Card.Suit.SPADES.bar();
    }
    
}
