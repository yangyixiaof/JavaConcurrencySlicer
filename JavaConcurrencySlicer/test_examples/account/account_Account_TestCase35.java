package account;

import account.Account;



public class account_Account_TestCase35 {

    public static void main(String[] args) throws Exception {
        final Account account0=new Account();
        account0.go((String[])null);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[4];
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(0,98);
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.checkResult(98);
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
