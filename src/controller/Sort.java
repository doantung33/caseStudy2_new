package controller;

import model.Borrower;

public  class Sort implements Comparable<Borrower> {
    public Sort(){

    }
    public int compareTo(Borrower o1,Borrower o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public int compareTo(Borrower o) {
        return 0;
    }
}
