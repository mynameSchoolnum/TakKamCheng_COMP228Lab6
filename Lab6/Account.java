public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        }
    }

    public synchronized void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            System.out.printf("Deposited: %.2f, New Balance: %.2f%n", amount, balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0.0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f, New Balance: %.2f%n", amount, balance);
        } else {
            System.out.printf("Insufficient funds for withdrawal of %.2f. Balance: %.2f%n", amount, balance);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public double getBalance() {
        return balance;
    }
}