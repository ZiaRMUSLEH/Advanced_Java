package ThreadsRPT;

public class Thread05_VolatileKeyword {
    volatile static int  counter = 0;

    public static void main (String[] args) {


        Thread thread1 = new Thread(()->{
            increaseCounter();
        });


        Thread thread2 = new Thread(()->{
            decreaseCounter();
        });

        thread1.start();
        thread2.start();



    }


    public static void increaseCounter(){
        for (int i = 0; i < 10; i++) {
            counter++;
            System.out.println("increased : "+counter);
        }
    }

    public static void decreaseCounter(){
        for (int i = 0; i < 10; i++) {
            counter--;
            System.out.println("decreased : "+counter);
        }
    }

}
