package interfacefun;

public class Person implements Noisable, Drawable, Comparable<Person> {
    
    //This creates CLASS VARIABLES, which means there's 1 variable for the class
    // rather than 1 varaible PER INSTANCE.
    public static boolean hasSkeleton = true;
    private static String kingdom = "Mammal";
    
    //This is creating a CONSTANT CLASS VARIABLE, meaning it can't change.
    public static final String compositeMaterial = "Carbon";

    //Instance variables, with PRIVATE level access, so only person can access them
    //That means if I want them public facing, I would provide getters and setters
    private String name;
    private int age;
    private int weight;
    private String gender;
    private Cat pet;
    private String favoriteIceCream;

    //This is a default constructor. It's called default because it takes no 
    // arguments and just...sets default values, hopefully for all values.
    public Person() {
        
        //I *COULD* use the setters instead, which would be more 'proper', but
        // this is a constructor, so people usually get lazy and direct access.
        this.name = String.valueOf(this.hashCode());
        this.age = 42;
        this.weight = 226;
        this.gender = "Fluid";
        this.pet = null;
    }

    //This is a more complicated setter, because the Cat has an Owner reference
    // which needs to be me, if I set the Cat to be my pet. So I have to go
    // through the Cat's setOwner to set the cat's owner to myself after I set 
    // the cat as my pet. The extra check for this.pet.getOwner() != this 
    // means that if I'm not already the owner, make me the owner. This prevents
    // an infinite cycle of setting the cat as my pet, which sets me as the pet's
    // owner, which sets the the cat as my pet, which sets me as the pet's owner
    // which sets me...well, you get the idea.
    // Add a print statement if you want to watch this stuff work
    // ...and probably a print statement in the setOwner for the Cat, too.
    public void setPet(Cat pet) {
        this.pet = pet;
        if (this.pet.getOwner() != this) {
            this.pet.setOwner(this);
        }
    }
    
    //You can have getters and setters for static (class) variables as well.
    // And they'd be accessed by Person.getKingdom() rather than via an instance
    // The instance can be used too, technically, but it's an 'icky' thing to do
    public static String getKingdom() {
        return kingdom;
    }

    public static void setKingdom(String kingdom) {
        Person.kingdom = kingdom;
    }
    
    public void speak() {
        System.out.println("Hi");
    }

    @Override
    public void makeNoise() {
        this.speak();
    }

    @Override
    public void makeNoise2() {
        System.out.println("You suck.");
    }
    
    

    @Override
    public void draw() {
        System.out.println("    O");
        System.out.println("   /|\\");
        System.out.println("    |");
        System.out.println("   / \\");
    }
    
    //STANDARD GETTERS AND SETTERS FROM HERE

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Cat getPet() {
        return pet;
    }

    public String getFavoriteIceCream() {
        return favoriteIceCream;
    }

    public void setFavoriteIceCream(String favoriteIceCream) {
        this.favoriteIceCream = favoriteIceCream;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
