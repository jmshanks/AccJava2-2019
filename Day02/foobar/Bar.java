
package foobar;

public class Bar implements Stuff {

    @Override
    public void doStuff() {
        System.out.println("Stuff");
    }

    @Override
    public void doStuff2() {
        System.out.println("Stuff 2!");
    }
    
    public void doMoreStuff() {
        System.out.println("More Stuff?!");
    }
}
