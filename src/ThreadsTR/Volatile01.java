package ThreadsTR;

public class Volatile01 {

    public volatile static int flag=0;

    public static void main (String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                while (flag==0){
                    System.out.println("working with threads is nice");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("flag value has changed to 1");
            }
        });
        thread2.start();



    }
}
