import java.util.*;
import java.io.*;

public class ATM {
    private HashMap<String, Double> accounts = new HashMap<>();
    public ATM() {}

    public void openAccount(String sUserID, double dAmount) throws Exception {
        if (accounts.containsKey(sUserID))
            throw new Exception("The account you are trying to add already exists.");
        accounts.put(sUserID, dAmount);
    }

    public void closeAccount(String sUserID) throws Exception {
        if (!accounts.containsKey(sUserID))
            throw new Exception("The account you are trying to remove does not exist.");
        if (0 != accounts.get(sUserID))
            throw new Exception("There is still money in the account you are trying to close.");
        accounts.remove(sUserID);
    }

    public double checkBalance(String sUserID) throws Exception {
        if (!accounts.containsKey(sUserID))
            throw new Exception("The account you are trying to access does not exist.");
        return accounts.get(sUserID);
    }

    public double depositMoney(String sUserID, double dAmount) throws Exception {
        if (!accounts.containsKey(sUserID))
            throw new Exception("The account you are trying to access does not exist.");
        accounts.put(sUserID, accounts.get(sUserID) + dAmount);
        return dAmount;
    }

    public double withdrawMoney(String sUserID, double dAmount) throws Exception {
        if (!accounts.containsKey(sUserID))
            throw new Exception("The account you are trying to access does not exist.");
        else if (accounts.get(sUserID) < dAmount)
            throw new Exception("You do not have enough money in your account to withdraw that amount.");
        accounts.put(sUserID, accounts.get(sUserID) - dAmount);
        return dAmount;
    }

    public boolean transferMoney(String sFromAccount, String sToAccount, double dAmount) {
        if (!accounts.containsKey(sFromAccount) || !accounts.containsKey(sToAccount))
            return false;
        try {
            withdrawMoney (sFromAccount, dAmount);
            depositMoney (sToAccount, dAmount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void audit() throws IOException {
        PrintWriter file_writer = new PrintWriter(new BufferedWriter(new FileWriter ("BankingAudit.txt")));
        for (Map.Entry<String, Double> account: accounts.entrySet()) {
            file_writer.println("{ Username: " + account.getKey() + ", Balance: " + account.getValue() + " }");
        }
        file_writer.close();
    }
}
