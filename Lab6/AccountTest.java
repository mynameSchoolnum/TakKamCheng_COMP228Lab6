import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account sharedAccount = new Account(100.0);

        ArrayList<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction(sharedAccount, "deposit", 50.0));
        transactionList.add(new Transaction(sharedAccount, "withdraw", 30.0));
        transactionList.add(new Transaction(sharedAccount, "withdraw", 200.0));
        transactionList.add(new Transaction(sharedAccount, "deposit", 100.0));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Transaction transaction : transactionList) {
            executorService.execute(transaction);
        }

        executorService.shutdown();
    }
}
