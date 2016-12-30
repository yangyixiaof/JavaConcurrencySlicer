package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase19 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BankAccount[] bankAccountArray0=new BankAccount[3];
                    Account.accounts=bankAccountArray0;
                    Account.Service((-2),2);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
