package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase24 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[2];
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
