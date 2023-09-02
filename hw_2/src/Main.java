import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();
    }

    // Задание 1.
//    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    static void task1() {
        Float num;
        while (true) {
            System.out.println("Введите дробное число: ");
            try {
                num = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Попробуйте еще раз!");
                scanner.next();
            }
        }
        System.out.printf("Вы ввели число %f", num);
    }

    //Задание 2
    public static void task2() {
        try {
            int d = 0;
            int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            double catchedRes1 = (intArray[8] / d);
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    //Задание 3
    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { // переместрил в конец, иначе осталные исключения никогда не обработаются
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    //    Задание 4.
//    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static void task4() {
        try {
            System.out.println("Введите строку: ");
            System.out.printf("Вы ввели строку: %s", getString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getString() {
        String s = scanner.nextLine();
        if (s.isEmpty()) {
            throw new NullPointerException("Пустые строки вводить нельзя!");
        }
        return s;
    }
}
