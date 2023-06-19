package ThreadsRPT;

import java.util.concurrent.Semaphore;

public class Thread11_Semaphore {
    public static void main (String[] args) {
        Semaphore semaphore = new Semaphore(4);
        Car car1 = new Car("toyota",semaphore);
        Car car2 = new Car("honda",semaphore);
        Car car3 = new Car("bmw",semaphore);
        Car car4 = new Car("audi",semaphore);
        Car car5 = new Car("tesla",semaphore);
        Car car6 = new Car("hyundai",semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();




    }



}
class Car extends Thread{
    private String carName;
    private Semaphore semaphore;

    public Car (String carName, Semaphore semaphore) {
        this.carName = carName;
        this.semaphore = semaphore;
    }

    @Override
    public  void run () {

        try {
            System.out.println(carName+" trying to enter the parking");
            semaphore.acquire();
            System.out.println(carName+" parked");
            for (int i = 1; i <=4 ; i++) {
                System.out.println(carName+ " has parked for "+i+" hour(s)");
                Thread.sleep(5000);
            }
            System.out.println(carName+" let the parking");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
