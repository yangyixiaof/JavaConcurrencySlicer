package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase4 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-177);
        final Airlinetickets airlinetickets0=new Airlinetickets("","< ");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    airlinetickets0.run();
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    airlinetickets0.checkResult("The airline issued ",(String)null);
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
