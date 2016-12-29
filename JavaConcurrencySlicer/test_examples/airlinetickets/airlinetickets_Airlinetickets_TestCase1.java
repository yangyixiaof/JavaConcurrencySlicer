package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase1 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=(-1862);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets airlinetickets0=new Airlinetickets("V';`W","");
                    airlinetickets0.checkResult("","No Bug");
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[9];
                    airlinetickets0.checkResult("","No Bug");
                    Airlinetickets.main(stringArray0);
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
