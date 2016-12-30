package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase1 {

    public static void main(String[] args) throws Exception {
        final Account account0=new Account();
        final String[] stringArray0=new String[2];
        account0.go((String[])null);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
