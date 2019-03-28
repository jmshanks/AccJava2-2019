
package foobar;

public class Foo implements Stuff {

    @Override
    public void doStuff() {
        System.out.println("Stuff.");
    }

    @Override
    public void doStuff2() {
        System.out.println("Stuff 2!");
    }
    
    public void doStuff3() {
        System.out.println("Stuff three. Just because.");
    }
}
