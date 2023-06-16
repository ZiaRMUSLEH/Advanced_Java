package ThreadsRPT;

public class CounterWithoutThread {
    private String name;

    public CounterWithoutThread (String name) {
        this.name = name;
    }

    public void countMe(){
        for(int i=1; i<11; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+" counter is: "+i);
        }
    }

    public static void main (String[] args) {

        CounterWithoutThread counter1 = new CounterWithoutThread("Counter1");
        CounterWithoutThread counter2 = new CounterWithoutThread("Counter2");

        long startTime = System.currentTimeMillis();
        counter1.countMe();
        System.out.println("---------------------------");
        counter2.countMe();
        long endTime = System.currentTimeMillis();
        System.out.println("Duration without MultiThread: "+(endTime-startTime));

    }

}
