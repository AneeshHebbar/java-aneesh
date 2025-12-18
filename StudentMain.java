import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;

    // Method to accept details
    void acceptDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to display details
    void displayDetails() {
        System.out.println("\nStudent Details");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) +
                    " | Credits: " + credits[i] +
                    " | Marks: " + marks[i]);
        }

        System.out.println("SGPA: " + calculateSGPA());
    }

    // Method to calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        int totalCreditPoints = 0;

        for (int i = 0; i < n; i++) {
            int gradePoint = getGradePoint(marks[i]);
            totalCredits += credits[i];
            totalCreditPoints += credits[i] * gradePoint;
        }

        return (double) totalCreditPoints / totalCredits;
    }

    // Method to assign grade point
    int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else return 0;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.displayDetails();
    }
}