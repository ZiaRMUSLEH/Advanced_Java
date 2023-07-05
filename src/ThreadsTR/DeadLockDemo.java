package ThreadsTR;

public class DeadLockDemo {
    public static void main (String[] args) {
        String coffee = "coffee";
        String sugar = "sugar";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName()+" is using  "+coffee);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" wants "+sugar);
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+" is using  "+sugar);
                    }
                }
                System.out.println(Thread.currentThread().getName()+" is drinking coffee");
            }
        });
        thread1.setName("Ahmad");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                synchronized (sugar){
                    System.out.println(Thread.currentThread().getName()+" is using  "+sugar);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" wants "+coffee);
                    synchronized (coffee){
                        System.out.println(Thread.currentThread().getName()+" is using  "+coffee);
                    }
                }    System.out.println(Thread.currentThread().getName()+" is drinking coffee");
            }
        });
        thread2.setName("vehbi");
        thread2.start();




    }
}
