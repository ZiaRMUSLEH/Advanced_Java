package ThreadsTR;

public class SynchronizedKeyword02 {
    public static void main (String[] args) {

        Long start = System.currentTimeMillis();

        Brackets2 brackets = new Brackets2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 1; i < 10; i++) {
                    brackets.printBrackets();
                }

            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 1; i < 10; i++) {
                    brackets.printBrackets();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Long finish = System.currentTimeMillis();

        System.out.println("Taken Time: "+(finish-start));
    }

}

class Brackets2 {
    public  void printBrackets (){

        synchronized (this){
            for (int i = 0; i < 10; i++) {
                if (i < 5) {
                    System.out.print(" [ ");
                } else {
                    System.out.print(" ] ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           // System.out.println(i);
        }


    }

}
