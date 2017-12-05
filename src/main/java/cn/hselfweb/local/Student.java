package cn.hselfweb.local;
import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String sex;
    private double hight;
    private Date birthday;
    private String native_place;

   // public Student(){super();}
    public Student(int id, String name, String sex, double hight, Date birthday, String native_place) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hight = hight;
        this.sex = sex;
        this.native_place = native_place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getHight() {
        return hight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNative_place() {
        return native_place;
    }
}
