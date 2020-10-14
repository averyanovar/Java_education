
public class lesson_1 {
    //Задание 1
    public static void main(String[] args) {
        //Задание 2
        int x = 10;
        int y = 20;
        int z = 15;
        int i = 25;
        byte a = 125;
        short b = 32760;
        int c = -10;
        long d = 1234567L;
        float e = 11.25f;
        double f = 121.121;
        char g = '*';
        boolean h = true;
        int x1 = 10;
        int x2 = 5;
        int x3 = 2020;
        System.out.println("Переменные всех типов Java:\n" +a+ "\n" +b+ "\n" +c+ "\n" +d+ "\n" +e+ "\n" +f+ "\n" +g+ "\n" +h+ "\n" );
        System.out.println("Ответ к третьему заданию "  + calculate (x,y,z,i));
        System.out.println("Ответ к четвертому заданию " + task10and20(x1, x2));
        isPositivivOrNegative(x2);
        System.out.println("Ответ к шестому заданию " + isNegative(x2));
        greetings("Алексей");
        calendar(x3);
    }
        //Задание 3
        public static int calculate (int x, int y, int z, int i) {
        return x * (y + (z / i));
    }

        //Задание 4
        public static boolean task10and20 (int x1, int x2){
        if (x1+x2 <= 20 && x1+x2 >= 10){
            return true;
        } else
            return false;
    }

        //Задание 5

        public static void isPositivivOrNegative (int x2){
        if (x2 >= 0){
            System.out.println("Результат к пятому заданию: Положительное");
        }else
            System.out.println("Результат к пятому заданию: Отрицательное");
    }

        //Задание 6

        public static boolean isNegative (int x2){
        if (x2 < 0){
            return true;
        }else {
            return false;
        }
    }

        //Задание 7

        public static void greetings (String name){
            System.out.println("Привет, " +name+ "!");
        }

        //Задание 8*
        public static void calendar (int x3){
            if (x3 %100==0 && x3 %400 ==0 )
                System.out.println("количество дней в году: 366");
            else if (x3 % 4 == 0 && x3 % 100 > 0)
                System.out.println("количество дней в году: 366");
            else if (x3 % 100 == 0)
                System.out.println("количество дней в году: 365");
            else
                System.out.println("количество дней в году: 365");
        }
}
