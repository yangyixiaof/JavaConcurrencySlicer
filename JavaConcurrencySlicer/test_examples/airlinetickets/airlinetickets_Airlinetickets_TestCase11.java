package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase11 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-1875);
        final Airlinetickets airlinetickets0=new Airlinetickets("V';`W","");
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
                    airlinetickets0.checkResult("]{[Dhv!peo'","'|0]#fvt");
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
