// Base class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Account(String n, int a, String t, double b) {
        name = n;
        accNo = a;
        accType = t;
        balance = b;
    }

    // Deposit amount
    void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited: " + amt);
    }

    // Display balance
    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

// Savings Account
class SavAcct extends Account {
    double rate = 5; // interest rate

    SavAcct(String n, int a, double b) {
        super(n, a, "Savings", b);
    }

    // Compute and deposit interest
    void computeInterest() {
        double interest = balance * rate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    // Withdrawal
    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

// Current Account
class CurAcct extends Account {
    double minBalance = 1000;
    double penalty = 100;

    CurAcct(String n, int a, double b) {
        super(n, a, "Current", b);
    }

    // Withdrawal with minimum balance check
    void withdraw(double amt) {
        balance -= amt;

        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Penalty imposed: " + penalty);
        }

        System.out.println("Withdrawn: " + amt);
    }
}

// Main class
public class BankMain {
    public static void main(String[] args) {

        // Savings Account
        SavAcct sa = new SavAcct("Aneesh", 101, 5000);
        sa.deposit(1000);
        sa.computeInterest();
        sa.withdraw(2000);
        sa.displayBalance();

        System.out.println("---------------------");

        // Current Account
        CurAcct ca = new CurAcct("Rahul", 201, 3000);
        ca.deposit(500);
        ca.withdraw(3000);
        ca.displayBalance();
    }
}

