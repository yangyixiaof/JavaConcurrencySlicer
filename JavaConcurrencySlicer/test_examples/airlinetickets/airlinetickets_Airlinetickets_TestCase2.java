package airlinetickets;

import airlinetickets.Airlinetickets;



public class airlinetickets_Airlinetickets_TestCase2 {

    public static void main(String[] args) throws Exception {
        Airlinetickets.Num_Of_Seats_Sold=0;
        Airlinetickets.Num_Of_Seats_Sold=(-295);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String[] stringArray0=new String[2];
                    stringArray0[0]="XY@}8X}t*UEVm+zVF1";
                    stringArray0[1]="XY@}8X}t*UEVm+zVF1";
                    Airlinetickets.main(stringArray0);
                } catch (Exception e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Airlinetickets airlinetickets0=new Airlinetickets("XY@}8X}t*UEVm+zVF1","XY@}8X}t*UEVm+zVF1");
                    airlinetickets0.Maximum_Capacity=(-195);
                    airlinetickets0.checkResult("XY@}8X}t*UEVm+zVF1","+o,Kk");
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