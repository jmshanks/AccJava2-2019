/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthmonth;

public class Person {
    public int birthDay;
    public Month birthMonth;
    
    public Person(int birthDay, Month birthMonth) throws StupidException {
        if (birthDay < 1)
        {
            throw new StupidException("The day is less than 1");
        }
        else if (birthDay > birthMonth.getNumberOfDays())
        {
            throw new StupidException("There are only " + 
                    birthMonth.getNumberOfDays() + " in " + birthMonth);
        }

//This code would correct them.
//        if (birthDay < 1) {
//            System.out.println("You're stupid.");
//            birthDay = 1;
//        }
//        else if (birthDay > birthMonth.getNumberOfDays()) {
//            System.out.println("You're stupid.");
//            birthDay = birthMonth.getNumberOfDays();
//        }
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
    }
}
