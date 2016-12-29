package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase22 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-1862);
        final Airlinetickets airlinetickets0=new Airlinetickets("V';`W","");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    airlinetickets0.go("s");
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    airlinetickets0.go("s");
                    airlinetickets0.checkResult("sxO&&p|","");
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
