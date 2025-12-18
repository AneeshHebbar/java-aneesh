import java.util.Scanner;

import SEE.*;
import CIE.*;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Personal details
        System.out.print("Enter USN: ");
        String usn = sc.next();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();

        // Internal marks
        int[] internal = new int[5];
        System.out.println("Enter Internal Marks (5 subjects):");
        for (int i = 0; i < 5; i++) {
            internal[i] = sc.nextInt();
        }

        // SEE marks
        int[] see = new int[5];
        System.out.println("Enter SEE Marks (5 subjects):");
        for (int i = 0; i < 5; i++) {
            see[i] = sc.nextInt();
        }

        // Object creation
        Internals in = new Internals(internal);
        External ex = new External(usn, name, sem, see);

        // Display final marks
        System.out.println("\nFINAL MARKS:");
        for (int i = 0; i < 5; i++) {
            int finalMarks = in.internalMarks[i] + ex.seeMarks[i];
            System.out.println("Subject " + (i + 1) + ": " + finalMarks);
        }
    }
}
