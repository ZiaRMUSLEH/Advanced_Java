package Threads;

public class Thread04_Volatile {

    volatile private static int flag = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    if (flag == 0)
                        System.out.println("Thread1 is working.");
                    if (flag == 1)
                        break;

                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag = 1;
                System.out.println("Flag is now set to 1.");
            }
        });
        thread2.start();

    }


}
