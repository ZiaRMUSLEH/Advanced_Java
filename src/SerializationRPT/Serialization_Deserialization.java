package SerializationRPT;

import java.io.*;

public class Serialization_Deserialization  {
    public static void main (String[] args) {

        //writeObjects();
        readObject("users");





    }

    public static void writeObjects()  {
        System.out.println("Objects are creating ....");
        User user1 = new User("ahmad",1,20);
        User user2 = new User("yavuz",2,28);
        User user3 = new User("yusuf",3,35);
        User user4 = new User("bahadir",4,32);

        try {
            FileOutputStream fos = new FileOutputStream("users");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user1);
            oos.writeObject(user2);
            oos.writeObject(user3);
            oos.writeObject(user4);

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObject(String fileName){

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user1 = (User) ois.readObject();
            User user2 = (User) ois.readObject();
            User user3 = (User) ois.readObject();
            User user4 = (User) ois.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
