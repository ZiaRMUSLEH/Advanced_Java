package Threads;

import java.util.concurrent.Semaphore;

public class Thread11_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); //four cars (threads) can utilize the shared resource at a time

        Car car1 = new Car("Tesla", semaphore);
        Car car2 = new Car("Toyota", semaphore);
        Car car3 = new Car("Honda", semaphore);
        Car car4 = new Car("Hyundai", semaphore);
        Car car5 = new Car("BMW", semaphore);
        Car car6 = new Car("Audi", semaphore);

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
    //constructor

    public Car(String carName, Semaphore semaphore) {
        this.carName = carName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(carName+ " is trying to park...");
            semaphore.acquire(); //acquire() is to notify for permit
            System.out.println(carName+" parked...");
            //suppose that each car can be parked for 4 hours
            for (int i=1; i<=4;i++){
                System.out.println(carName+ " has been parked for "+i+" hour(s)");
                Thread.sleep(5000);
            }
            System.out.println(carName+ " left the parking...");
            semaphore.release(); //resource is released for other waiting thread


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}