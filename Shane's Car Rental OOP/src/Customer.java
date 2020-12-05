/**javaDoc.Customer Class**/

public class Customer {

    private String foreName, surName, gender, status, address, contact;

    public Customer() {

        foreName = "";
        surName = "";
        gender = "";
        status = "";
        address = "";
        contact = "";
    }

    public void setCustomer(String fN, String sN, String g, String s, String a, String c) {

        foreName = fN;
        surName = sN;
        gender = g;
        status = s;
        address = a;
        contact = c;
    }

    public String getForeName() {
        return foreName;
    }

    public String getSurName() {
        return surName;
    }

    public String getFullName(){return getForeName() +" "+ getSurName();}

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}
