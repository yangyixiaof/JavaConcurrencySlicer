package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase16 {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets.Num_Of_Seats_Sold=(-1720705875);
                    Airlinetickets airlinetickets0=new Airlinetickets("","");
                    airlinetickets0.Maximum_Capacity=(-1720705875);
                    airlinetickets0.checkResult("","x[d#Qw^BoRX[");
                } catch (Exception e) {
                }
            }
        });
        t1.start();
        t1.join();
    }

}
