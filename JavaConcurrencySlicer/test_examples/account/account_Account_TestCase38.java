package account;

import account.Account;



public class account_Account_TestCase38 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(1,1);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
