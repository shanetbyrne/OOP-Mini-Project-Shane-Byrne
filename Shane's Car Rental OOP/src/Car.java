/**javaDoc.Car class**/
public class Car {


    private String cType, cModel;
    private double cPrice;

    public Car() {

        cType = "";
        cModel = "";
        cPrice = 0;
    }

    public void setCar(String cT, String cM, double cP) {

        cType = cT;
        cModel = cM;
        cPrice = cP;
    }

    public String getCType() {
        return cType;
    }

    public String getCModel() {
        return cModel;
    }

    public String getC() {
        return getCType() + "-" + getCModel();
    }

    public double getCPrice() {
        return cPrice;
    }
}
