public class hw1_1 {
    class Answer {
        public static void arrayOutOfBoundsException() {
             int[] arr = new int[1];
             for (int i = 0; i < arr.length; i ++){
                 System.out.println(arr[i+1]);
               }
    
          
    }
    
        public static void divisionByZero(){
              int a = 5;
              int b = 0;
              System.out.println(a/b);
              // Напишите свое решение ниже
          
    }
    
        public static void numberFormatException() {
          String str = "ghf";
          int a = Integer.parseInt(str);
          System.out.println(str);
           
     }
    }
    
    public class Printer {
        public static void main(String[] args) {
            Answer ans = new Answer();
            try {
                ans.arrayOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выход за пределы массива");
            }
    
            try {
                ans.divisionByZero();
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль");
            }
    
            try {
                ans.numberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования строки в число");
            }
        }
    }
}
