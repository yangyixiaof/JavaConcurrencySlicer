package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase21 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-1875);
        Airlinetickets.main(stringArray0);
        final Airlinetickets airlinetickets0=new Airlinetickets("V';`W","");
        airlinetickets0.Maximum_Capacity=(-1915801992);
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
                    airlinetickets0.run();
                    airlinetickets0.go(" Seats !!!");
                } catch (Exception e) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[9];
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

}
