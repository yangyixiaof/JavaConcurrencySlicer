package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase20 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    account0.checkResult((-3114));
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
