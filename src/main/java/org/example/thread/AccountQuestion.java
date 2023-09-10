package org.example.thread;

public class AccountQuestion {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Thread thread1 = new Thread(new WithdrawTask(account, 800));
        Thread thread2 = new Thread(new WithdrawTask(account, 800));

        thread1.start();
        thread2.start();
    }
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println("Withdraw success. Amount: " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Withdraw failed. Insufficient balance.");
        }
    }
}

class WithdrawTask implements Runnable {
    private Account account;
    private int amount;

    public WithdrawTask(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}