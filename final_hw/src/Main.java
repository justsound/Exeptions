
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в следующем порядке, разделенные пробелом:");
        System.out.println("Фамилия Имя Отчество Дата_рождения(в формате: дд.мм.гггг) Номер_телефона(только цифры) Пол (м/ж/f/m)");

        String input = scanner.nextLine();
        String data[] = input.split(" ");
        try {task1(input);
        } catch (SurnameExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("В фамилии должны быть только буквы");

        } catch(CountExeption e){
            System.out.println(e.getMessage());
            System.out.printf("Введено %d данных вместо 6\n", e.getCount());

        } catch (FirstNameExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("В имени должны быть только буквы");

        } catch (SecondNameExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("В отчестве должны быть только буквы");

        } catch (DateBirthdayExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("Неверный формат даты рождения. (Должна быть: дд.мм.гггг)");

        } catch (PhoneNumberExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("Неверный формат номера телефона. (Должен состоять только из цифр)");

        } catch (GenderExeption e) {
            System.out.println(e.getMessage());
            System.out.printf("Вы ввели: %s\n", e.getText());
            System.out.println("Пол должен быть 'м', 'ж' или 'f', 'm'.");
        }  
        scanner.close();
        
        try (FileWriter fileWriter = new FileWriter(data[0] + ".txt", true)) {
            fileWriter.write("<" + String.join("  ", data) + ">\n");
        } catch (IOException e) {
            System.out.println("Не удалось записать данные в файл");
            e.printStackTrace();
        }
    }

    private static String[] task1(String input) throws CountExeption, FirstNameExeption, SecondNameExeption,
            SurnameExeption, DateBirthdayExeption, PhoneNumberExeption, GenderExeption {

        String[] data = input.split(" ");
        if (data.length != 6) {
            throw new CountExeption("Неверное количество данных. ", "Должно быть 6!", data.length);
        }
        if (!data[2].matches("[a-zA-Zа-яА-Я]+")) {
            throw new FirstNameExeption("Введенное имя неверное", data[2]);
        }
        if (!data[1].matches("[a-zA-Zа-яА-Я]+")) {
            throw new SecondNameExeption("Введенное отчество неверное", data[1]);
        }
        if (!data[0].matches("[a-zA-Zа-яА-Я]+")) {
            throw new SurnameExeption("Введенная фамилия неверна", data[0]);
        }
        if (!data[3].matches("[0-3][0-9]\\.[0-1][0-9]\\.[1-2][0-9][0-9][0-9]")) {
            throw new DateBirthdayExeption("Введенная дата рождения неверна", data[3]);
        }
        if (!data[4].matches("[0-9]+")) {
            throw new PhoneNumberExeption("Введенный номер телефона неверен", data[4]);
        }
        if (!data[5].matches("м|ж|f|m")) {
            throw new GenderExeption("Неверно выбран пол", data[5]);
        }
        return data;
    }

}
