package test.examples;

import account.Account;

import java.util.Random;

import org.evosuite.runtime.System;

import org.evosuite.runtime.mock.java.util.MockRandom;



public class test_examples_Account_TestCase11 {

    public static void main(String[] args) throws Exception {
        Account.Service(0,0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(0,0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account account0=new Account();
                    String[] stringArray0=new String[4];
                    account0.go(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Account.Service(481,481);
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
