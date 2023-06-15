package Serialization;

import java.io.*;

public class Serialization_Deserialization {
    public static void main (String[] args) {

        User user1 = new User(1L, "Jace", "45454654564");
        User user2 = new User(2L, "John", "45454654564");
        User user3 = new User(3L, "Mark", "454544564664");

        //writeUserObject(user1, user2, user3);
        readUserObject("user.xyz");


}

private static void writeUserObject(User user1, User user2,User user3 ){
    System.out.println("user objects are being written");

    try {
        FileOutputStream fos = new FileOutputStream("user.xyz");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user1);
        oos.writeObject(user2);
        oos.writeObject(user3);

    } catch (FileNotFoundException e)  {e.printStackTrace();}
    catch (IOException e) {throw new RuntimeException(e);}

}

private static void readUserObject(String filename){


    try {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user1 = (User) ois.readObject();
        User user2 = (User) ois.readObject();
        User user3 = (User) ois.readObject();

        System.out.println(user1+"\n"+ user2+"\n"+user3);



    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

}

}