package account;

import account.Account;

import account.BankAccount;



public class account_Account_TestCase12 {

    public static void main(String[] args) throws Exception {
        final Account account0=new Account();
        BankAccount[] bankAccountArray0=new BankAccount[5];
        BankAccount bankAccount0=new BankAccount((-4264));
        bankAccountArray0[2]=bankAccount0;
        account0.accounts=bankAccountArray0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.checkResult(3549);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(2,(-4264));
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.checkResult((-4264));
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
