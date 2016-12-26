package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class TestCase7 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Stack<Object> stack0=new Stack<Object>();
                    PrivateAccess.setVariable((Class<Stack>)Stack.class,(Stack)stack0,"pointer",(Object)2155);
                    stack0.push(stack0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
