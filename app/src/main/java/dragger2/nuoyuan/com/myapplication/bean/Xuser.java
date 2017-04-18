package dragger2.nuoyuan.com.myapplication.bean;

public class Xuser implements Cloneable {
    private final String firstName;
    private final String lastName;

    public Xuser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public Xuser clone() throws CloneNotSupportedException {
        Xuser mail = (Xuser) super.clone();
        return mail;
    }


}