package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase5 {

    public static void main(String[] args) throws Exception {
        final Integer integer0=new Integer(0);
        final Stack<Object> stack1=new Stack<Object>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Stack<String> stack2=new Stack<String>();
                    stack2.pop();
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.push(integer0);
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.pop();
                } catch (Exception e) {
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Stack<Integer> stack0=new Stack<Integer>();
                    stack0.push(integer0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}
