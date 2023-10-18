public interface Account {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
    double viewBalance();
}

public class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public double viewBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

public class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double balance, double overdraftLimit) {
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance + overdraftLimit < amount) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts do not earn interest
    }

    @Override
    public double viewBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.viewBalance();
        }
        return totalBalance;
    }
}

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Insufficient balance");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
        CurrentAccount currentAccount = new CurrentAccount(500, 1000);

        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        // Deposit money into the savings account
        savingsAccount.deposit(500);

        // Withdraw money from the current account
        currentAccount.withdraw(200);

        // Calculate the interest on the savings account
        double interest = savingsAccount.calculateInterest();

        // View the balance of the savings account
        double savingsAccountBalance = savingsAccount.viewBalance();

        // View the balance of the current account
        double currentAccountBalance = currentAccount.viewBalance();

        // Print the results
        System.out.println("Savings account balance: " + savingsAccountBalance);
        System.out.println("Current account balance: " + currentAccountBalance);
        System.out.println("Interest earned on savings account: " + interest);
    }
}
