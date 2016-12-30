package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase4 {

    public static void main(String[] args) throws Exception {
        final Account account0=new Account();
        account0.checkResult(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[6];
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.checkResult(0);
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
