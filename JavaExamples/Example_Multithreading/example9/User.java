package example9;

import java.util.Random;

public class User implements Runnable {
    private BankAccount account;
    private Random random = new Random();

    public User(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                account.deposit(random.nextInt(200));
            } else {
                account.withdraw(random.nextInt(200));
            }

            // Sleep for a random time to simulate real-world usage
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
