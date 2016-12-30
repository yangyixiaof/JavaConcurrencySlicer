package account;

import account.Account;



public class account_Account_TestCase46 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    account0.NUM_ACCOUNTS=(-1415);
                    account0.go((String[])null);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
