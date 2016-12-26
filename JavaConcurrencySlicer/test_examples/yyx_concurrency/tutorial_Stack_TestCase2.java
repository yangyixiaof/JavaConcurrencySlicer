package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase2 {

    public static void main(String[] args) throws Exception {
        Stack<String> stack0=new Stack<String>();
        Stack<Object> stack1=new Stack<Object>();
        final Stack<Object> stack1=new Stack<Object>();
        stack1.push(".TFa");
        stack1.push(stack0);
        stack1.push(".TFa");
        stack1.push(stack0);
        stack1.push(stack0);
        stack1.push(".TFa");
        stack1.push(".TFa");
        stack1.push(stack1);
        stack1.push(".TFa");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object object0=new Object();
                    stack1.push(object0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.push(".TFa");
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
