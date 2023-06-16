package ThreadsRPT;

public class CounterWithThread extends Thread {

    private String name;

    public CounterWithThread (String name) {
        this.name = name;
    }

    @Override
    public void run () {countMe();}

    public void countMe (){
        for(int i= 1; i<11; i++){
            //try {Thread.sleep(100);} catch (InterruptedException e) {throw new RuntimeException(e);}
            System.out.println(name+" counter is in "+i);
        }
    }

}

class Main {
    public static void main (String[] args) {


        CounterWithThread counter1 = new CounterWithThread("counter1");
        CounterWithThread counter2 = new CounterWithThread("counter2");

        counter1.start();
        counter2.start();

        //try {
            //counter1.join();
            //counter2.join();} catch (InterruptedException e) {throw new RuntimeException(e);}
        System.out.println("-------------------");




    }





}