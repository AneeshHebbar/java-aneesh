package cie;

public class Internals {
    public int[] internalMarks = new int[5];

    public void setMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = marks[i];
        }
    }

    public int[] getMarks() {
        return internalMarks;
    }
    
}
package cie;

public class Personal {
    public String usn;
    public String name;
    public int sem;

    public Personal(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

    public void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + sem);
    }
    
}
package SEE;
import cie.Personal;

public class External extends Personal {
    public int[] seeMarks = new int[5];

    public External(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void setSEE(int[] marks) {
        for (int i = 0; i < 5; i++) {
            seeMarks[i] = marks[i];
        }
    }

    public int[] getSEE() {
        return seeMarks;
    }
}
import cie.*;
import SEE.*;
import java.util.*;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        External[] students = new External[n];
        Internals[] internals = new Internals[n]; // Using Internals from CIE

        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("USN: ");
            String usn = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            students[i] = new External(usn, name, sem);
            internals[i] = new Internals();

            int[] internalMarks = new int[5];
            System.out.println("Enter 5 Internal Marks:");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }
            internals[i].setMarks(internalMarks);

            int[] seeMarks = new int[5];
            System.out.println("Enter 5 SEE Marks:");                                                                                                                                                                                                                                                                                                                                                                                                           
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }
            students[i].setSEE(seeMarks);
        }

        System.out.println("\n===== FINAL MARKS =====");
        for (int i = 0; i < n; i++) {
            students[i].display();
            int[] internal = internals[i].getMarks();
            int[] see = students[i].getSEE();

            System.out.println("Course-wise Final Marks:");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internal[j] + (see[j] / 2); // SEE out of 100, internal out of 50
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
            System.out.println("-------------------------");
        }

        sc.close();
    }
}
