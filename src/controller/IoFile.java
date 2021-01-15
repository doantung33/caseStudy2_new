package controller;

import model.Borrower;
import model.Living;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFile {
    private static final String Coma = ",";

    public static void writeItem(String fileName, Living living) {
        File file = new File(fileName);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("Đã tạo file mới");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.append(living.getDay());
            fileWriter.append(Coma);
            fileWriter.append(living.getSpending());
            fileWriter.append(Coma);
            fileWriter.append(String.valueOf(living.getPrice()) + "USD" + "\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Đã được ghi vào file");
                } catch (Exception e) {
                    System.out.println();
                }
            }
        }

    }


    public static void writeBorrower(String fileBorrower, Borrower borrower) {

        File file1 = new File(fileBorrower);
        FileWriter fileWriter1 = null;
        try {
            if (!file1.exists()) {
                System.out.println("Đã tạo file mới");
                file1.createNewFile();
            }
            fileWriter1 = new FileWriter(file1, true);
            fileWriter1.append(borrower.getName());
            fileWriter1.append(Coma);
            fileWriter1.append(String.valueOf(borrower.getAge()));
            fileWriter1.append(Coma);
            fileWriter1.append(String.valueOf(borrower.getLoan()));
            fileWriter1.append(Coma);
            fileWriter1.append(borrower.getLoanDay());
            fileWriter1.append(Coma);
            fileWriter1.append(borrower.getPayDay() + "\n");
            fileWriter1.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter1 != null) {
                try {
                    System.out.println("Đã được ghi vào file");
                } catch (Exception e) {
                    System.out.println();
                }
            }

        }
    }


//    public static void readFile(String fileName) throws FileNotFoundException {
//        BufferedReader bufferedReader =null;
//        try {
//            String line;
//            bufferedReader = new BufferedReader(new FileReader("savefile.txt"));
//            while ((line= bufferedReader.readLine())!=null){
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (bufferedReader!=null){
//                    bufferedReader.close();
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }
//    public static List<String> CSV (String csvLine){
//        List<String> strings =new ArrayList<>();
//        if (csvLine!= null){
//            String[]arr = csvLine.split(Coma);
//            for (int i = 0; i < arr.length; i++) {
//                strings.add(arr[i]);
//            }
//        }
//        return strings;
//    }
//    private static void printSpend(List<String>list){
//        System.out.println(list.toString());
//    }

}