package controller;

import model.Borrower;
import model.Living;
import model.Money;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IoSpending  {
    static ArrayList<Money>arrayList0 = new ArrayList<>();
    static ArrayList<Living> arrayList = new ArrayList<>();
    static ArrayList<Borrower> arrayList1 = new ArrayList<>();
    private static final String DATE ="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//   public static void setArrayList(ArrayList<Living>list){
//        IoSpending.arrayList= list;
//    }

    Money money = new Money();
    int n=0;
    boolean exit= false;
    public void addPrice(){
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Mời nhập số tiền thêm vào tài khoản");
                double addMoney = scanner.nextDouble();
                money.setMoney(addMoney);
                break;
            }catch (NumberFormatException e){
                System.out.println("Mời bạn nhập lại số tiền");
            }
        }
        arrayList0.add(money);
    }
    public void money(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Sửa tiền");
            System.out.println("2. Tiền hiện có");
            System.out.println("0. Menu");
            n= scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("Nhập số tiền muốn sửa");
                    double money = scanner.nextDouble();
                    boolean checkMoney = false;
                    int size = arrayList0.size();
                    for (int i = 0; i < size; i++) {
                        if (money==arrayList0.get(i).getMoney()){
                            while (true)
                                try {
                                    System.out.println("Mời bạn nhập số tiền");
                                    double eidtMoney= scanner.nextDouble();
                                    arrayList0.get(i).setMoney(eidtMoney);
                                    checkMoney=true;
                                    break;
                                }catch (NumberFormatException e){
                                    System.out.println("tiền là số");
                                }
                        }
                    }
                    break;
                case 2:
                    int totalMoney=0;
                    for (int i = 0; i < arrayList0.size(); i++) {
                        totalMoney+=arrayList0.get(i).getMoney();
                    }
                    System.out.println("Tổng tiền bạn có là: "+totalMoney);
                    break;
                case 0:
                    exit=true;
            }
        }while (!exit);
    }
    public void Spending(){
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("1. Thêm khoản chi");
                System.out.println("2. Hiển thị khoản chi");
                System.out.println("3. Xóa khoản chi");
                System.out.println("4. Sửa khoản chi");
                System.out.println("5. Tìm kiếm khoản chi");
                System.out.println("0. Menu");
                n= scanner.nextInt();
            }catch (NumberFormatException e){
                System.out.println("Mời nhập lại");
            }
            switch (n) {
                case 1:
                    try {
                        addSpending();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    showLiving();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    editItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 0:
                    n=0;
            }
        }while (n!=0);

    }
    public void Borrower(){
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("1. Thêm người vay tiền");
                System.out.println("2. Hiển thị người vay tiền");
                System.out.println("3. Xóa người vay tiền");
                System.out.println("4. Sửa người vay tiền");
                System.out.println("5. Tìm kiếm người vay tiền");
                System.out.println("0. Menu");
                n= scanner.nextInt();
            }catch (NumberFormatException e){
                System.out.println("Mời nhập lại");
            }
            switch (n){
                case 1:
                    try {
                        addBorrower();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    showBorrower();
                    break;
                case 3:
                    deleteLoan();
                    break;
                case 4:
                    editBorrower();
                    break;
                case 5:
                    searchBorrower();
                    break;
                case 0:
                    n=0;
            }
        }while (n!=0);
    }

    public void addSpending() throws IOException {
        double totalMoney =0;
        Living living = new Living();
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Mời bạn nhập ngày chi tiêu: dd/MM/yyyy");
            String day = scanner.nextLine();
            String regex = DATE;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(day);
            if (matcher.find()) {
                living.setDay(day);
                check = true;
            } else {
                System.out.println("Mời nhập lại");
            }

        } while (!check);

        boolean check1 = false;
        do {
            System.out.print("Khoản chi tiêu ");
            String spend = scanner.nextLine();
            String regex = "[a-zA-Z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(spend);
            if (matcher.find()) {
                living.setSpending(spend);
                check1 = true;
            } else {
                System.out.println("Mời nhập lại");
            }
        } while (!check1);


        while (true)
            try {
                System.out.println("Số tiền chi tiêu ");
                double price = Double.parseDouble(scanner.nextLine());
                if (totalMoney==price){
                    totalMoney+=price;
                    System.out.println("tổng tiền là: "+ totalMoney);
                }
                living.setPrice(price);
                break;
            }catch (NumberFormatException e){
                System.out.println("Mời nhập lại");
            }
        arrayList.add(living);
        IoFile.writeItem("spendfile.txt",living);


    }


    public void addBorrower() throws IOException {
        Borrower borrower = new Borrower();
        boolean check3 = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập tên người vay ");
            String name = scanner.nextLine();
            String regex = "[a-zA-Z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                borrower.setName(name);
                check3 = true;
            } else {
                System.out.println("Mời nhập lại");
            }
        } while (!check3);

        while (true){
            try {

                System.out.println("Nhập tuổi người vay ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age<=0 || age>100){
                    System.out.println("Tuổi phải lớn hơn 0 và bé hơn 100");
                    continue;
                }
                borrower.setAge(age);
                break;
            }catch (NumberFormatException e){
                System.out.println("Mời nhập lại");
            }
        }
        while (true)
            try {
                System.out.println("Nhập số tiền vay");
                double loan = Double.parseDouble(scanner.nextLine());
                borrower.setLoan(loan);
                break;
            }catch (NumberFormatException e){
                System.out.println("Mời nhập lại");
            }

        boolean check9 = false;
        do {
            System.out.println("Nhập ngày vay: dd/MM/yyyy");
            String loanDay = scanner.nextLine();
            String regex = DATE;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(loanDay);
            if (matcher.find()) {
                borrower.setLoanDay(loanDay);
                check9 = true;
            } else {
                System.out.println("Mời nhập lại");
            }
        } while (!check9);

        boolean check10 = true;
        do {
            System.out.println("Nhập ngày trả: dd/MM/yyyy");
            String payDay = scanner.nextLine();
            String regex = DATE;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(payDay);
            if (matcher.find()) {
                borrower.setPayDay(payDay);
                check10 = true;
            } else {
                System.out.println("Mời nhập lại");
            }
        } while (!check10);

        arrayList1.add(borrower);
        IoFile.writeBorrower("borrowerfile.txt",borrower);

    }

    public void showLiving() {
        int total=0;
        for (Living living : arrayList) {
            if (arrayList!=null){
                if (living instanceof Living) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        total+=arrayList.get(i).getPrice();

                    }
                    System.out.println(living.toString());
                    System.out.println("Tổng tiền đã chi tiêu: "+total);
                }
            }else {
                System.out.println("Bạn chưa chi tiêu gì");
            }

        }
    }

    public void showBorrower() {
        int total=0;
        for (Borrower borrower : arrayList1) {
            if (arrayList1!=null){
                if (borrower instanceof Borrower) {
                    for (int i = 0; i < arrayList1.size(); i++) {
                        total+=arrayList1.get(i).getLoan();
                    }
                    System.out.println(borrower.toString());
                }
            }else {
                System.out.println("Bạn chưa cho ai vay");
            }
        }
    }

    public void deleteItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập khoản muốn sóa: ");
        String item = scanner.nextLine();
        Living living = null;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())) {
                living = arrayList.get(i);
            }
        }
        if (living != null) {
            System.out.println("Khoản đã được xóa:  " + living.getSpending());
            arrayList.remove(living);
        } else {
            System.out.println("Không có khoản xóa khớp ");
        }
    }
    public void deleteLoan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên người vay muốn xóa: ");
        String name = scanner.nextLine();
        Borrower borrower = null;
        int size1 = arrayList1.size();
        for (int i = 0; i < size1; i++) {
            if (name.equals(arrayList1.get(i).getName())) {
                borrower = arrayList1.get(i);
            }
        }
        if (borrower != null) {
            System.out.println("Người vay đã được xóa: " + borrower.getName());
            arrayList1.remove(borrower);
        } else {
            System.out.println("Không có tên người vay khớp ");
        }

    }
    public void editItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập khoản muốn sửa ");
        String item = scanner.nextLine();
        boolean check = false;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())){
//                System.out.println("Enter USD");
//                double editUSD = Double.parseDouble(scanner.nextLine());

                boolean check0 = false;
                do {
                    System.out.println("Nhập lại ngày");
                    String editDay= scanner.nextLine();
                    String regex = DATE;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editDay);
                    if (matcher.find()) {
                        arrayList.get(i).setDay(editDay);
                        check0 = true;
                    } else {
                        System.out.println("Mời nhập lại");
                    }

                } while (!check0);

                boolean check3 = false;
                do {
                    System.out.println("Nhập lại khoản chi tiêu");
                    String editItem= scanner.nextLine();
                    String regex = "[a-zA-Z]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editItem);
                    if (matcher.find()) {
                        arrayList.get(i).setSpending(editItem);
                        check3 = true;
                    } else {
                        System.out.println("Mời nhập lại");
                    }
                } while (!check3);


                while (true)
                    try {
                        System.out.println("Nhập lại số tiền chi");
                        double editPrice = scanner.nextDouble();
                        check=true;
                        arrayList.get(i).setPrice(editPrice);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Mời nhập lại");

                    }
            }

        }if (!check){
            System.out.println("Không có tên khoản muốn sửa ");
        }

    }
    public void editBorrower(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên người vay muốn sửa");
        String name = scanner.nextLine();
        boolean check = false;
        int size = arrayList1.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(arrayList1.get(i).getName())){

                boolean check3 = false;
                do {
                    System.out.println("Nhập lại tên");
                    String editName = (scanner.nextLine());
                    String regex = "[a-zA-Z]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editName);
                    if (matcher.find()) {
                        arrayList1.get(i).setName(editName);
                        check3 = true;
                    } else {
                        System.out.println("Mời nhập lại");
                    }
                } while (!check3);


                while (true){
                    try {

                        System.out.println("Nhập lại tuổi người vay");
                        int editAge= Integer.parseInt(scanner.nextLine());
                        if (editAge<=0 || editAge>100){
                            System.out.println("Tuổi phải lớn hơn 0 và nhỏ hơn 100");
                            continue;
                        }
                        arrayList1.get(i).setAge(editAge);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Mời nhập lại");
                    }
                }
                while (true)
                    try {
                        System.out.println("Nhập lại số tiền vay");
                        double editLoan =Double.parseDouble(scanner.nextLine());
                        arrayList1.get(i).setLoan(editLoan);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Mời nhập lại");
                    }

                boolean check9 = false;
                do {
                    System.out.println("Nhập lại ngày vay");
                    String editLoanDay = scanner.nextLine();
                    String regex = DATE;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editLoanDay);
                    if (matcher.find()) {
                        arrayList1.get(i).setLoanDay(editLoanDay);
                        check9 = true;
                    } else {
                        System.out.println("Mời nhập lại");
                    }
                } while (!check9);

                boolean check10 = true;
                do {
                    System.out.println("Nhập lại ngày trả");
                    String editPayDay = scanner.nextLine();
                    String regex = DATE;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editPayDay);
                    if (matcher.find()) {
                        arrayList1.get(i).setPayDay(editPayDay);
                        check10 = true;
                    } else {
                        System.out.println("Mời nhập lại");
                    }
                } while (!check10);

            }
        }if (!check){
            System.out.println("Không có tên người vay khớp ");
        }

    }
    public void searchItem(){
        Scanner scanner = new Scanner(System.in);
        boolean check =false;
        System.out.println("Nhập tên khoản muốn tìm ");
        String item = scanner.nextLine();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())){
                System.out.println("Khoản vừa đươc tìm thấy : "+ arrayList.get(i));
            }
            break;
        }
        if (!check){
            System.out.println("Mời nhập lại");
        }


    }public void searchBorrower(){
        Scanner scanner = new Scanner(System.in);
        boolean check =false;
        System.out.println("Nhập tên người vay muốn tìm kiếm ");
        String name = scanner.nextLine();
        int size = arrayList1.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(arrayList1.get(i).getName())){
                System.out.println("Người vay được tìm thấy: "+ arrayList1.get(i));
            }
            break;
        }
        if (!check){
            System.out.println("Không có tên người vay khớp");
        }
    }
}