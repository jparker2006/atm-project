import java.util.*;
import java.io.*;

public class ATM {
    private HashMap<String, Double> accounts = new HashMap<>();

    public ATM() {}

    public void openAccount(String sUserID, double dAmount) throws Exception {
        if (accounts.containsKey(sUserID))
            throw new Exception ("The account you are trying to add already exists.");
        accounts.put(sUserID, dAmount);
    }

    public void closeAccount(String sUserID) {
    }

    public double checkBalance(String sUserID) {
        return 0.0;
    }

    public double depositMoney(String sUserID, double dAmount) {
        return 0.0;
    }

    public double withdrawMoney(String sUserID, double dAmount) {
        return 0.0;
    }

    public boolean transferMoney(String sFromAccount, String sToAccount, double dAmount) {
        return false;
    }

    public void audit() {
    }
}
