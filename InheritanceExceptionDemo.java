// Custom Exception
class WrongAge extends Exception {
    WrongAge(String msg) {
        super(msg);
    }
}

// Base class
class Father {
    int fAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        fAge = age;
    }
}

// Derived class
class Son extends Father {
    int sAge;

    Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // call Father constructor

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age must be less than Father's age");
        }
        sAge = sonAge;
    }
}

// Main class
public class InheritanceExceptionDemo {
    public static void main(String[] args) {
        try {
            Son s = new Son(50, 25);
            System.out.println("Object created successfully");
        }
        catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
