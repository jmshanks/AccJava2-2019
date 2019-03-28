
package foobar;

public class FooBar {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();
        Stuff stuff1 = new Foo();
        Stuff stuff2 = new Bar();
        foo.doStuff();
        foo.doStuff2();
        foo.doStuff3();
        bar.doStuff();
        bar.doStuff2();
        bar.doMoreStuff();
        stuff1.doStuff();
        stuff1.doStuff2();
        
        if (stuff1 instanceof Foo) {
            ((Foo)stuff1).doStuff3();
            System.out.println("I'm inside the if.");
        }
        else if (stuff1 instanceof Bar)
            ((Bar)stuff1).doMoreStuff();
        
        stuff2.doStuff();
        stuff2.doStuff2();
        
        if (stuff2 instanceof Foo)
            ((Foo)stuff2).doStuff3();
        else if (stuff2 instanceof Bar)
            ((Bar)stuff2).doMoreStuff();
    }
}
