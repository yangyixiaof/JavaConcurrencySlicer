package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase14 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Bank_Total=1;
                    Account account0=new Account();
                    String[] stringArray0=new String[4];
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
