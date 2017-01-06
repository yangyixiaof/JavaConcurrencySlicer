package test.examples;

import account.Account;

import java.util.Random;

import org.evosuite.runtime.System;

import org.evosuite.runtime.mock.java.util.MockRandom;



public class test_examples_Account_TestCase13 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    MockRandom mockRandom0=new MockRandom();
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
