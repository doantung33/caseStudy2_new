package model;

import java.io.Serializable;

public class Borrower implements Serializable {
    private String name;
    private int age ;
    private double loan;
    private String loanDay;
    private String payDay;
//    private Living living;

    public Borrower() {

    }

    public Borrower(String name, int age, double loan, String loanDay, String payDay) {
        this.name = name;
        this.age = age;
        this.loan = loan;
        this.loanDay = loanDay;
        this.payDay = payDay;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public void setLoanDay(String loanDay){
        this.loanDay=loanDay;
    }
    public String getLoanDay(){
        return loanDay;
    }
    public void setPayDay(String payDay){
        this.payDay=payDay;
    }
    public String getPayDay() {
        return payDay;
    }



    @Override
    public String toString() {
        return "Borrower [ " +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", loan='" + loan + " USD"+'\'' +
                ", loanDay='" + loanDay + '\'' +
                ", payDay='" + payDay + '\'' +
                " ]";
    }
}