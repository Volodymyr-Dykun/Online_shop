package Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
    private String homePhone;
    private String mobilePhone;

    public Phone(){
    }

    public Phone(String homePhone, String mobilePhone) {
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
