package test.examples;

import account.Account;

import java.util.Random;

import org.evosuite.runtime.mock.java.util.MockRandom;



public class test_examples_Account_TestCase15 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    account0.checkResult((-194));
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
