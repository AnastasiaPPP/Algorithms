package Sem2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Seminar2 {

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
        public static void inputNumber(){
            while(true){
                try{
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Введите дробное число: ");
                    float number = scanner.nextFloat();
                    System.out.println(number);
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Введите число верно");
                }

            }
        }
        public static void task2(){
            try {
                int d = 0;
                int[] intArray = new int[10];
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Catching exception: " + e);
            }
        }
        public static void task3(){
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            }catch (ArithmeticException ex) {
                System.out.println("");
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            }catch (Exception ex) {
                System.out.println("Что-то пошло не так...");
            }
        }
        public static void task4() {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            if(string.isEmpty()) {
                throw new NullPointerException("Пустые строки вводить нельзя!");
            }
        }

    }
