package ThreadsTR;

import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main (String[] args) {

        Semaphore semaphore = new Semaphore(6);

        Car car1 = new Car("Car -1",4000,semaphore);
        Car car2 = new Car("Car -2",3000,semaphore);
        Car car3 = new Car("Car -3",5000,semaphore);
        Car car4 = new Car("Car -4",2000,semaphore);
        Car car5 = new Car("Car -5",1000,semaphore);
        Car car6 = new Car("Car -6",7000,semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();

    }
}

class Car extends Thread {

    private  String carName;
    private int duration;
    private Semaphore semaphore;

    public Car (String name, int duration, Semaphore semaphore) {
        this.carName = name;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run () {

        try {semaphore.acquire();
            System.out.println(carName+" has parked");
            System.out.println(carName+" is in parking");
            Thread.sleep(duration);
            System.out.println(carName+" has left parked");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
