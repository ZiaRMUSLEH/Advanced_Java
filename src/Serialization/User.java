package Serialization;

import java.io.Serializable;

public class User implements Serializable {

    private long id;

    private String name;

    private String schoolNum;


    /*
    //User.xyz          -->     Without Serialization

    id

    name

    schoolNum

    //User.xyz          -->     With Serialization

    long id

    String name

    String schoolNum


     */
    //constructor
    public User (Long id, String name, String schoolNum) {
        this.id = id;
        this.name = name;
        this.schoolNum = schoolNum;
    }
    //getter-setter
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSchoolNum () {
        return schoolNum;
    }

    public void setSchoolNum (String schoolNum) {
        this.schoolNum = schoolNum;
    }

    //toString
    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolNum='" + schoolNum + '\'' +
                '}';
    }
}
