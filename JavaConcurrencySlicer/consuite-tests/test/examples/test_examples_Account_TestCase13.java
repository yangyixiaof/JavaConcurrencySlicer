package test.examples;

import account.Account;

import java.util.Random;



public class test_examples_Account_TestCase13 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    Random mockRandom0=new Random();
                    account0.Bank_random=(Random)mockRandom0;
                    account0.Bank_random=null;
                    account0.go((String[])null);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
