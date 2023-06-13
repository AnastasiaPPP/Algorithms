package Seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EnterNames {
    public static void main(String[] args) {
        DataCheck check = new DataCheck();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите ФИО, дату рождения, номер телефона и пол через пробел в формате:" +
                    " Иванов Иван Иванович dd.mm.yyyy 89876543210 m");
            System.out.println("Чтобы выйти введите exit");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            String[] inputArray = input.split(" ");
            if (check.checkInput(inputArray) == -1) {
                System.out.println("Введите корректное количество данных!");
            } else {
                try {
                    check.checkData(inputArray);
                }catch (DataFormatException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                String fileName = inputArray[0] + ".txt";
                try (FileWriter writer = new FileWriter(fileName, true)) {
                    writer.write(input + "\n");
                    writer.flush();
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
            }
        }
    }


}