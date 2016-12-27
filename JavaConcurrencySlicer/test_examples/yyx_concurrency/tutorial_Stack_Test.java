import java.util.EmptyStackException;

import tutorial.Stack;

import org.junit.Test;

public class tutorial_Stack_Test {

    @Test
    public void test1() {
        final Stack<Object> stack0=new Stack<Object>();
        final Stack<Object> stack1=new Stack<Object>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack0.isEmpty();
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
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack1.push(".TFa");
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

    @Test
    public void test2() {
        Stack<String> stack0=new Stack<String>();
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

    @Test
    public void test3() {
        final Stack<Object> stack0=new Stack<Object>();
        stack0.push((Object)null);
        assertFalse(stack0.isEmpty());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack0.pop();
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    assertTrue(stack0.isEmpty());
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    @Test
    public void test4() {
        final Stack<String> stack0=new Stack<String>();
        stack0.push(".TFaE");
        final Stack<Object> stack1=new Stack<Object>();
        stack1.push(".TFaE");
        stack1.push(stack0);
        stack1.push(".TFaE");
        stack1.push(stack0);
        final Object[] objectArray0=new Object[9];
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
                    stack0.pop();
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
                    Object object1=new Object();
                    stack1.push(object1);
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

    @Test
    public void test5() {
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

    @Test
    public void test6() {
        final Stack<Object> stack0=new Stack<Object>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stack0.isEmpty();
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

    @Test
    public void test7() {
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
