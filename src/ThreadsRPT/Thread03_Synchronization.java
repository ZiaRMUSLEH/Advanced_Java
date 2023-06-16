package ThreadsRPT;



public class Thread03_Synchronization {

    public static void main (String[] args) {

        Brackets1 brackets = new Brackets1();
        //brackets.generateBrackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                for(int i = 1; i<3; i++){
                brackets.generateBrackets();}
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                for(int i = 1; i<3; i++){
                    brackets.generateBrackets();}
            }
        });

        thread1.start();
        thread2.start();


    }


}

class Brackets{
    public synchronized void generateBrackets(){
        for(int i=1; i<11; i++){
            if(i<=5){System.out.print("[");}
            else {
            System.out.print("]");}
        }
    }
}

class Brackets1{
    public  void generateBrackets(){

        synchronized (this){
            for (int i = 1; i < 11; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
        }

        for(int i=1; i<11; i++){
            if(i<=5){System.out.print("{");}
            else {
                System.out.print("}");}
        }

    }

}
