package ThreadsRPT;

public class Thread06_VolatileKeyword {

    private volatile static int counter =0;

    public static void main (String[] args) {


        Thread thread1 = new Thread(()->{
          int local_counter= counter;
          while (local_counter<10){
              if(local_counter!=counter) {
                  System.out.println("[T1] Local counter has changed");
                  local_counter=counter;
              }
          }
        });

        Thread thread2 = new Thread(()->{
            int local_counter=counter;
            while (local_counter<10){
                System.out.println("[T2] incremented to "+(local_counter+1));
                counter=++local_counter;

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        thread1.start();
        thread2.start();


    }

}
