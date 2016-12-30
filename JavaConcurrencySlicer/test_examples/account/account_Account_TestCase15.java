package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase15 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    account0.Bank_random=null;
                    account0.go((String[])null);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
