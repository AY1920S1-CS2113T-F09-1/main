import executor.command.CommandMajorExpense;
import org.junit.jupiter.api.Test;
import storage.StorageManager;
import ui.Receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class CommandMajorExpenseTest {
    @Test
    void execute() {
        StorageManager storageManager = new StorageManager();

        Receipt receiptOne = new Receipt(40.0);
        receiptOne.addTag("transport");
        receiptOne.setDate(LocalDate.parse("2019-02-01"));
        storageManager.getWallet().addReceipt(receiptOne);

        Receipt receiptTwo = new Receipt(4.0);
        receiptTwo.addTag("food");
        receiptTwo.setDate(LocalDate.parse("2019-02-02"));
        storageManager.getWallet().addReceipt(receiptTwo);


        CommandMajorExpense m1 = new CommandMajorExpense("majorexpense 40");
        m1.execute(storageManager);
        String output = m1.getInfoCapsule().getOutputStr();
        assertEquals("These are your expenditures above/equal to" + " " + "$" + 40 + "\n"
                + "1. [transport] 40.0 2019-02-01\n", output);
        CommandMajorExpense m2 = new CommandMajorExpense("majorexpense -5.0");
        m2.execute(storageManager);
        String result = m2.getInfoCapsule().getOutputStr();
        assertEquals("Input integer must be positive", result);
    }
}