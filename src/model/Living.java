package model;

import java.io.Serializable;

public class Living implements Serializable {
    private double totalMoney;
    private String day;
    private String spending;
    private double price;
    private static double returnMoney;



    public Living (){

    }

    public Living(double totalMoney, String day, String spending, double price, double returnMoney, double getTotalMoney) {
        this.totalMoney = totalMoney;
        this.day = day;
        this.spending = spending;
        this.price = price;
        this.returnMoney = returnMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getSpending() {
        return spending;
    }

    public void setSpending(String spending) {
        this.spending = spending;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setReturnMoney(double returnMoney) {
        this.returnMoney = returnMoney;
    }
//    public double getReturnMoney(){
//        return getTotalMoney()-getPrice();
//    }


    @Override
    public String toString() {
        return "Living [ " +
//                "money='" + totalMoney + " USD"+'\'' +
                " day='" + day + '\'' +
                ", spending='" + spending + '\'' +
                ", price='" + price +" USD"+ '\'' +
                " ]";
    }
}
