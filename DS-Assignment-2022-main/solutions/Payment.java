import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

class Transaction implements Comparable<Transaction> {

    /* Initialize the main components of the transaction. (Time, Ticket ID, and Tier)
     * Use Long object and not primitive type (long) in order to access the compareTo method
     * in Long as it will then be used to compare Tiers and to prioritize which transaction ticket
     * goes first. */

    String txn_id, transactionTier;
    long startingTime, Time;

    public Transaction(long Time, String txn_id, String transactionTier) {
        this.Time = Time;
        this.txn_id = txn_id;
        this.transactionTier = transactionTier;
        getTierStartingTime();
    }

    public Long getTime() {
        return Time;
    }

    public Long getStartingTime() {
        return startingTime;
    }

    /** To get each transaction ticket time without the starting time which corresponds to
     * the tiers */
    public void getTierStartingTime() {
        if(transactionTier.equals("PLATINUM")) {
            startingTime = Time - 3000;
        }
        else if(transactionTier.equals("GOLD")) {
            startingTime = Time - 2000;
        }
        else if(transactionTier.equals("SILVER")) {
            startingTime = Time - 1000;
        }
        else if(transactionTier.equals("BRONZE")) {
            startingTime = Time;
        }
    }
    /** Used in order to print out the transaction */
    @Override
    public String toString() {
        return txn_id + " ";
    }

    /** compareTo method here is used to compare between 2 transactions,
     the parameters given in the if statement checks whether their starting time (Tier) is the same.
     If it is then it does another comparison with the Time to see which should be prioritized first.
     And if the value equals to 1 it returns the value of whichever transaction ticket is priority.
     */
    @Override
    public int compareTo(Transaction o) {
        if(Objects.equals(o.getStartingTime(), this.getStartingTime())) {
            return Long.compare(o.getTime(),this.getTime());
        }
        else
            return Long.compare(o.getStartingTime(),this.getStartingTime());
    }

}

public class Payment {
    public static void main(String[] args) {

        String txn_id, tier, nextInput;
        String[] transactionInfo;
        long time;

        PriorityQueue<Transaction> transactionsList = new PriorityQueue<>();
        Scanner input = new Scanner(System.in);

        while(true) {
            String answer = " ";
            nextInput = input.nextLine();
            if(nextInput.equals("REBOOT"))
                break;
            else if(nextInput.equals("EXIT")) {
                transactionsList.clear();
                continue;
            }
            transactionInfo = nextInput.split(" ");
            time = Long.parseLong(transactionInfo[0]);
            txn_id = transactionInfo[1];
            tier = transactionInfo[2];
            transactionsList.offer(new Transaction(time,txn_id,tier));

            if(transactionsList.size() < 100) {
                while (!transactionsList.isEmpty()) {
                    if (transactionsList.size() < 100) {
                        Transaction x = transactionsList.poll();
                        answer = answer + x;
                    }
                }
                System.out.println(answer);
            }
        }
    }
}
