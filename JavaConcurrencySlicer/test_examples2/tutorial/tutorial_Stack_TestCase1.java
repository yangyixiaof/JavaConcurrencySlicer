package tutorial;

import java.util.EmptyStackException;

import tutorial.Stack;



public class tutorial_Stack_TestCase1 {

    public static void main(String[] args) throws Exception {
        final Stack<Object> stack1=new Stack<Object>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.push(".TFa");
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
