package SerializationRPT;

import java.io.Serializable;

public class User implements Serializable {

    private long id;

    private String name;

    private String schoolNum;

    public User (long id, String name, String schoolNum) {
        this.id = id;
        this.name = name;
        this.schoolNum = schoolNum;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
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

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolNum='" + schoolNum + '\'' +
                '}';
    }
}
