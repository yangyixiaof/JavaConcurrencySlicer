package test.examples;

import account.Account;

import java.util.Random;

import org.evosuite.runtime.System;

import org.evosuite.runtime.mock.java.util.MockRandom;



public class test_examples_Account_TestCase12 {

    public static void main(String[] args) throws Exception {
        final Account account0=new Account();
        final String[] stringArray0=new String[1];
        account0.NUM_ACCOUNTS=4452;
        account0.go(stringArray0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account0.go(stringArray0);
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
