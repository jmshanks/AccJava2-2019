
package birthmonth;

public class BirthMonth {

    public static void main(String[] args) {
        //Can only do this if doesn't throw, or throws RuntimeException
//        Person p3 = new Person(33, Month.MARCH); 
        
        try {
            Person p = new Person(1111, Month.MARCH);
            System.out.println(p.birthDay + " of " + p.birthMonth);
            Person p2 = new Person(-1, Month.FEBRUARY);
            System.out.println(p2.birthDay + " of " + p2.birthMonth);
        }
        catch (StupidException e) {
            System.out.println("You were stupid, apparently. " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Something weird happened: " + e);
        }
        finally {
            System.out.println("Finally");
        }
        System.out.println("Hello, World!");
        
    }
    
}
