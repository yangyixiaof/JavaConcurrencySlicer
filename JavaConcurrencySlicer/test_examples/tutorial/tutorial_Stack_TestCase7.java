package tutorial;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase7 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Stack<Object> stack0=new Stack<Object>();
                    stack0.push(stack0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
