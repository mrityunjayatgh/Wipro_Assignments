package Day_1;

import java.util.Scanner;

public class BankAccount {
    private String accountHolderName;
    private int balance;

    public BankAccount(String accountHolderName, int initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if(amount > 0){
            balance += amount;
            System.out.println(amount + " deposited successfully.");
            System.out.println("Current balance: " + balance);
        }else{
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
            System.out.println("Current balance: " + balance);
        }else if(amount > balance) {
            System.out.println("Insufficient balance.");
        }else{
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        int initialBalance = scanner.nextInt();

        BankAccount account = new BankAccount(name, initialBalance);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
