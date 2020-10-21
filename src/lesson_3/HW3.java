package lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW3 {
    static Random random = new Random();
    static Scanner w = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Поиграем в игру 'Угадай число'");
        do {
            System.out.println("Ваша задача угадать число от 0 до 9.");
            System.out.println("У Вас три попытки!");
            guess(9);
            System.out.println("Вы проиграли! Повторить игру еще раз? 1 – да / 0 – нет");
        } while (scanner.nextInt() == 1);
        scanner.close();
    }

    public static void guess(int range) {
        Random random = new Random();
        int x = random.nextInt(range);
        int k;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число");
            k = scanner.nextInt();
            if (k == x) {
                System.out.println("Вы угадали!");
                break;
            } else if (k < x) {
                System.out.println("Загаданное число больше.");
            } else if (k > x) {
                System.out.println("Загаданное число меньше.");
            }
        }
    }
    static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String guess = null;
        String word = words[random.nextInt(words.length)];
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Угадай слово из списка!");
            guess = w.next();
            for (int i = 0; i < 15; i++)
                if (i < word.length() && i < guess.length() &&
                        word.charAt(i) == guess.charAt(i))
                    System.out.print(word.charAt(i));
                else
                    System.out.print((word.equals(guess))? "" : "#");
            System.out.println();
        } while (!word.equals(guess));
        System.out.println("Вы угадали!");
    }
}