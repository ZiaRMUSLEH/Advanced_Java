package SerializationRPT;

import java.io.*;

public class Serialization_Deserialization {

    public static void main (String[] args) {


        User user1 = new User(1L,"zia","4654545445");
        User user2 = new User(2L,"lutfu","46578915445");
        User user3 = new User(3L,"abu","465436971245");
        //writeObject(user1,user2,user3);
        readUserObject("user.RPT");





    }

    private static void writeObject (User user1,User user2,User user3){

        try {
            FileOutputStream fos = new FileOutputStream("User.RPT");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user1);
            oos.writeObject(user2);
            oos.writeObject(user3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readUserObject(String fileName){

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user1 = (User) ois.readObject();
            User user2 = (User) ois.readObject();
            User user3 = (User) ois.readObject();
            System.out.println(user1+"\n"+user2+"\n"+user3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
