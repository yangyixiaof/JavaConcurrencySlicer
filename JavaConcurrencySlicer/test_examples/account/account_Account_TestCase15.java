package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase15 {

    public static void main(String[] args) throws Exception {
        Account.Service(0,0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    String[] stringArray0=new String[7];
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(0,0);
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(0,0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

}
