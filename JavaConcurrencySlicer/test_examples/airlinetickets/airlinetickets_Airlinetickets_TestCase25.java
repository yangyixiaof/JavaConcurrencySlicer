package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase25 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets airlinetickets0=null;
                    airlinetickets0=new Airlinetickets("average","average");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
