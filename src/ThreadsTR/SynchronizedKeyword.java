package ThreadsTR;

public class SynchronizedKeyword {
    public static void main (String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 1; i < 10; i++) {
                    Brackets.printBrackets();
                }

                }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 1; i < 10; i++) {
                    Brackets.printBrackets();
                }
                }
        });
        thread2.start();

    }

}

class Brackets {
    public synchronized static void printBrackets(){
        for (int i = 0; i < 10; i++) {
            if(i<5){System.out.print(" [ ");}else {
                System.out.print(" ] ");
            }
        }
        System.out.println();
    }


}
