package yyx_concurrency;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase4 {

    public static void main(String[] args) throws Exception {
        Stack<String> stack0=new Stack<String>();
        stack0.push(".TFaE");
        Stack<Object> stack1=new Stack<Object>();
        stack1.push(".TFaE");
        stack1.push(stack0);
        stack1.push(".TFaE");
        stack1.push(stack0);
        Object[] objectArray0=new Object[9];
        objectArray0[0]=(Object)".TFaE";
        objectArray0[1]=(Object)stack1;
        objectArray0[2]=(Object)".TFaE";
        objectArray0[3]=object0;
        objectArray0[4]=(Object)".TFaE";
        objectArray0[5]=(Object)".TFaE";
        objectArray0[6]=(Object)stack0;
        objectArray0[7]=(Object)stack0;
        objectArray0[8]=(Object)stack0;
        stack1.push(stack0);
        stack0.push(".TFaE");
        stack1.push(".TFaE");
        stack1.push(stack1);
        stack1.isEmpty();
        stack1.isEmpty();
        stack1.push(".TFaE");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Object object1=new Object();
                    stack1.push(object1);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.push(".TFZaE");
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack0.pop();
                } catch (Exception e) {
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
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
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}
