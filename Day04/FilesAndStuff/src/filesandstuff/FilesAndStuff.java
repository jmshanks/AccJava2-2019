/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesandstuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesAndStuff {

    public static void main(String[] args) {
        //Call whichever you want to see used.
    }

    /**
     * A function showing how to Serialize and Deserialize objects.
     * Note that the o.close() really should be handled better. If an exception
     * is thrown, then the file won't be closed. This is bad form. Do better.
     */
    public static void doSerializationStuff() {
        List<Integer> grades = new ArrayList();
        grades.add(100);
        grades.add(99);
        grades.add(98);
        Student bob = new Student(10112, "Bob", "Juanita", grades);

        try {
            FileOutputStream f = new FileOutputStream(new File("myFreezeDriedStudent.asdf"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(bob);
            o.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        bob = null;

        try {
            FileInputStream f = new FileInputStream(new File("myFreezeDriedStudent.asdf"));
            ObjectInputStream o = new ObjectInputStream(f);
            Object obj = o.readObject();
            if (obj instanceof Student) {
                Student s = (Student) obj;
                System.out.println("Student is: " + s.firstName + " " + s.lastName);
            }
            o.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Shows how to read a student's info from a file. In this case the info is
     * id, firstName, lastName, & the rest are grades. Each line is a different
     * student. This doesn't create the student info, that's an exercise left
     * for the reader, if you like. Or you can manually make yourself a file.
     */
    public static void doStudentStuff() {
        Path filePath = Paths.get("students.txt");
        try {
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                String[] items = line.split(",");
                int studentId = Integer.parseInt(items[0]);
                String firstName = items[1];
                String lastName = items[2];
                double sum = 0;
                int count = 0;
                for (int i = 3; i < items.length; ++i) {
                    sum += Double.parseDouble(items[i]);
                    count++;
                }
                double avg = sum / count;
                System.out.println(firstName + " " + lastName + ": " + avg);
            }
        } catch (IOException e) {
            System.out.println("Go away, seriously");
        }
    }

    /**
     * Shows how to read and write files using Files, which is the most modern
     * way. You can (and sometimes need to) use BufferedReaders and Streams and
     * such, but this is the way you should probably use, when you can.
     */
    public static void doFilesStuff() {
        Path filePath = Paths.get("new-file.txt");
        List<String> lines = new ArrayList();
        lines.add("Hello, world!");
        try {
            Files.write(filePath, lines, Charset.forName("UTF-8"));
//            Files.write(filePath, lines, Charset.forName("UTF-8"), 
//                    StandardOpenOption.APPEND); //For appending
        } catch (IOException e) {
            System.out.println("Go away.");
        }

        try {
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Go away, seriously");
        }
    }

    /**
     * Shows how to use a BufferedReader and BufferedWriter to read and write 
     * files. In this case we're using Strings, but it's also possible to write
     * bytes and other more 'raw' formats.
     */
    public static void doBufferedStuff() {
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("help-me.txt"), "UTF-8"))) {
                    writer.write("Help me!\n");
                    writer.write("And I am awesome.\n");
                    writer.write("My name is Sue\n");
                    writer.write("How do you do?!\n");
                    writer.write("And I went down down down\n");
                    writer.write("Hit me baby one more time.\n");
//            writer.flush(); //Optional, now (actually overkill)
//            writer.close(); //Optional, now (actually overkill)

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
                }

                try (BufferedReader reader = new BufferedReader(
                        new FileReader("help-me.txt"))) {
                    System.out.println("I have a reader!");
                    int counter = 0;
                    String currentLine;
                    while ((currentLine = reader.readLine()) != null) {
                        counter++;
                        System.out.println(counter + ": " + currentLine);
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FilesAndStuff.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    /**
     * A quick demo on how to use String.format and printf. Some prefer this to
     * the System.out stuff. Others can't stand it. Feel free to use either or 
     * both.
     */
    public static void stringFormatStuff() {
        String usersName = "Bob";
        String output = String.format("%s, Your total today is: $%08.2f\nThanks %1$s",
                usersName, 3.01523423);
        System.out.printf("Hello, %s\n", usersName);
        System.out.println(output);
    }

    /**
     * Shows how to use StringBuilder, and mentions StringBuffer. They're useful
     * for creating large strings without wasting lots of time and memory. And 
     * StringBuffer is thread safe, in case you need to append stuff to a String
     * from multiple threads at once.
     */
    public static void stringBuilderStuff() {
        String s = "This " + "song" + " is " + "six" + " words " + "long.";
        StringBuilder bob = new StringBuilder(); //StringBuffer if threading.
        bob.append("This ");
        bob.append("song ");
        bob.append("is ");
        bob.append("six ");
        bob.append("words ");
        bob.append("long ");
        System.out.println(bob.reverse().toString());
    }

    /**
     * Shows how to use Scanner and the .parse methods for all the base data 
     * types. When using nextInt, nextDouble...anything but nextLine, just be
     * aware that you may need to call scanner.nextLine() to GULP the newline
     * characters from when a user types 13 and hits enter. The 13 goes into the
     * variable, and the newline from the enter button just hangs around.
     */
    public static void scannerStuff() {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Give me 5 numbers, separated by spaces.:");
//        int x = scanner.nextInt();
//        int x2 = scanner.nextInt();
//        int x3 = scanner.nextInt();
//        int x4 = scanner.nextInt();
//        int x5 = scanner.nextInt();
//        scanner.nextLine();
        System.out.println("Say something, dammit!");
        String s = scanner.nextLine();
        char[] rawData = s.toCharArray();
        String[] words = s.split(" ");
        for (String word : words) {
            System.out.println("Word: " + word);
        }

        int favNum = Integer.MIN_VALUE;
        while (favNum == Integer.MIN_VALUE) {
            try {
                System.out.print("What's your favorite number? :");
                favNum = scanner.nextInt();
                scanner.nextLine(); //Gulp the newline character.

            } catch (InputMismatchException e) {
                System.out.println("I said number, dammit.");
                scanner.nextLine(); //Gulp the newline character.
            }
        }
        System.out.println("Your favorite number: " + favNum);

        System.out.println("How old are you?");
        String input = scanner.nextLine();
        try {
            int age = Integer.parseInt(input);
            System.out.println("So you're " + age + "? You don't look it.");
        } catch (NumberFormatException e) {
            System.out.println("I'm tired of you...");
            return;
        }
    }
}
