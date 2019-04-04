/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesandstuff;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public int id;
    public String firstName;
    public String lastName;
    public List<Integer> grades;

    public Student(int id, String firstName, String lastName, List<Integer> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }
}
