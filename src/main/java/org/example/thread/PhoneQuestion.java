package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhoneQuestion {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MallActivity mallActivity = new MallActivity();

        for (int i = 1; i <= 30; i++) {
            Customer customer = new Customer(i, mallActivity);
            executorService.execute(customer);
        }

        executorService.shutdown();
    }
}

class MallActivity {
    private int successCount = 0;
    private int totalCapacity = 10;

    public synchronized boolean trySeckill() {
        if (successCount < totalCapacity) {
            successCount++;
            return true;
        } else {
            return false;
        }
    }
}

class Customer implements Runnable {
    private int customerId;
    private MallActivity mallActivity;

    public Customer(int customerId, MallActivity mallActivity) {
        this.customerId = customerId;
        this.mallActivity = mallActivity;
    }

    @Override
    public void run() {
        boolean seckillResult = mallActivity.trySeckill();
        if (seckillResult) {
            System.out.println("Customer " + customerId + " successfully seckilled a phone.");
        } else {
            System.out.println("Customer " + customerId + " failed to seckill a phone.");
        }
    }
}