
package interfacefun;

public class InterfaceFun {

    public static void main(String[] args) {
        Person bob = new Person();
        bob.setName("Bob");
        Person sharon = new Person();
        sharon.setName("Sharon");
        int bobFirst = bob.compareTo(sharon);
        int sharonFirst = sharon.compareTo(bob);
        Cat peter = new Cat();
        Shape s1 = new Rectangle();
        
        Noisable n1 = bob;
        Noisable n2 = peter;
        Drawable d1 = bob;
        Drawable d2 = peter;
        
        Object[] allTheThings = {bob, s1, sharon, s1, peter, s1};
        
        //The ultimate example of Polymorphism. Just having a bunch of objects.
        for (Object o : allTheThings) {
            
            //We can check for instanceof Interfaces, just like Classes
            if (o instanceof Noisable) {
                Noisable d = (Noisable)o;
                d.makeNoise();
            }
            else {
                System.out.println("Not Noisable.");
            }
        }
        
        //We can create collections of Interfaces, for polymorphism's sake
        //And the compiler will keep you from adding unqualified objects
        Noisable[] noisyBoyz = {n1, n2};
        Drawable[] drawables = {bob, peter, d2, new Rectangle(), d1, new Person()};
        
        //We can loop over the collection, as usual
        for(Noisable n : noisyBoyz) {
            
            //This is generally bad to do, but just shows how to use instanceof
            // to cast back down to a specific instance type. Sometimes you have
            // to get your hands dirty, though...
            if (n instanceof Person) {
                System.out.println(((Person)n).getName());
            }
            n.makeNoise();
            n.makeNoise2();
        }
        
        //Looping over drawables, same thing, different interface
        for(Drawable d : drawables) {
            d.draw();
            System.out.println("");
        }
        
        //And we can always just call things directly...
        bob.speak();
        bob.makeNoise();
        n1.makeNoise();
        n2.makeNoise();
        d2.draw();
    }
}
