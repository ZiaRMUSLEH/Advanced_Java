package Threads;

public class Thread06_VolatileKeyword {

    //the role of volatile keyword is to force threads to get value of
    // counter from main memory(RAM) instead of cache memory of threads
    private volatile static int counter = 0;
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            int local_counter = counter;
            //when there is no volatile keyword, it gets value of counter from its cache memory
            // so it will not see the changes being done in thread 2
            while (local_counter<10){
                if(local_counter!=counter){
                    System.out.println("[T1] Local counter is changed..");
                    local_counter=counter;
                }
            }
        });
        Thread thread2 = new Thread(()->{
            int local_counter = counter;
            while (local_counter<10){
                System.out.println("[T2] incremented counter to "+(local_counter+1));
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