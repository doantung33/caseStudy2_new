package view;
import controller.IoSpending;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        IoSpending ioSpending = new IoSpending();
//       IoSpending.setArrayList(IoFile.dataLiving());
        boolean exit = false;
        int n = 0;
        ioSpending.addPrice();
        do {
            try {
                System.out.println("Menu");
                System.out.println("1. Tài khoản");
                System.out.println("2. Khoản chi tiêu.");
                System.out.println("3. Vay nợ.");
                System.out.println("0. Thoát");
                n = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Mời chọn menu");
                continue;
            }
            switch (n) {
                case 1:
                    ioSpending.money();
                    break;
                case 2:
                    ioSpending.Spending();
                    break;
                case 3:
                    ioSpending.Borrower();
                    break;
//                case 4:
//                    ioSpending.total();
//                    break;
                case 0:
                    exit = true;
            }
        }
        while (!exit);


    }
}

