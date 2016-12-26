package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase3 {

    public static void main(String[] args) throws Exception {
        Stack<Object> stack0=new Stack<Object>();
        stack0.push((Object)null);
        assertFalse(stack0.isEmpty());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    assertTrue(stack0.isEmpty());
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack0.pop();
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
