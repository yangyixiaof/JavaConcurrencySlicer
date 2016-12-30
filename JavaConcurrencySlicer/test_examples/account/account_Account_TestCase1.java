package account;

import account.Account;



public class account_Account_TestCase1 {

    public static void main(String[] args) throws Exception {
        final String[] stringArray0=new String[0];
        Account.main(stringArray0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(246,246);
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
