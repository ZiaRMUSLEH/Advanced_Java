package ThreadsTR;

public class MultiTreading01 {
    public static void main (String[] args) {


        Long start = System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread("Ziya");
        counter1.countMe();
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread("Yavuz");
        counter2.countMe();
        Long end = System.currentTimeMillis();

        Long takenTime = end-start;
        System.out.println("takenTime = " + takenTime);

        Long start1 = System.currentTimeMillis();
        CounterWithThread counter3 = new CounterWithThread("Yusra");
        counter3.start();

        CounterWithThread counter4 = new CounterWithThread("Abu");
        counter4.start();
        Long end1 = System.currentTimeMillis();

        try {
            counter3.join();
            counter4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Long takenTime1 = end1-start1;
        System.out.println("takenTime = " + takenTime1);




    }
}
class CounterWithoutMultiThread{

    public String name;

    public CounterWithoutMultiThread (String name) {
        this.name = name;
    }

    public void countMe (){
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);

        }
    }

}

class CounterWithThread extends Thread{

    public String name;

    public CounterWithThread (String name) {
        this.name = name;
    }

    @Override
    public void run () {
        countMe();
    }

    public void countMe (){
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+this.name);

        }

    }
}