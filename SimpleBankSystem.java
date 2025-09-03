import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String accountHolder;
    double balance;

    // Constructor
    BankAccount(int accNum, String accHolder, double bal) {
        accountNumber = accNum;
        accountHolder = accHolder;
        balance = bal;
    }

    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account details
    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }
}

public class SimpleBankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[5];
        int count = 0;

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View All Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (count < accounts.length) {
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Account Holder: ");
                    String accHolder = sc.nextLine();
                    System.out.print("Enter Starting Balance: ");
                    double bal = sc.nextDouble();
                    accounts[count] = new BankAccount(accNum, accHolder, bal);
                    count++;
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Account limit reached!");
                }

            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                int accNum = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amt = sc.nextDouble();
                        accounts[i].deposit(amt);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Account not found.");

            } else if (choice == 3) {
                System.out.print("Enter Account Number: ");
                int accNum = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amt = sc.nextDouble();
                        accounts[i].withdraw(amt);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Account not found.");

            } else if (choice == 4) {
                if (count == 0) {
                    System.out.println("No accounts available.");
                } else {
                    for (int i = 0; i < count; i++) {
                        accounts[i].display();
                    }
                }

            } else if (choice == 0) {
                System.out.println("Exiting... Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
