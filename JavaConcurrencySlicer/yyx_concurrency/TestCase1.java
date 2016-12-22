package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class TestCase1 {

    public static main(String[] args) throws Exception {
        Stack<Object> stack0=new Stack<Object>();
        PrivateAccess.setVariable((Class<Stack>)Stack.class,(Stack)stack0,"pointer",(Object)(-99));
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stack0.isEmpty();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stack0.pop();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
