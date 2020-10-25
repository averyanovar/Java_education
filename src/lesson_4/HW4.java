package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class HW4 {
    final int SIZE = 5;
    final int WIN_SIZE = 5;
    final char DOT_X = 'X';
    final char DOT_O = 'O';
    final char DOT_EMPTY = '_';
    final String MSG_FOR_HUMAN = "Введите столбец и строку (от 1 до 5):";
    final String MSG_YOU_WON = "Вы выиграли!";
    final String MSG_AI_WON = "Компьютер выиграл!";
    final String MSG_DRAW = "Ничья!";
    final String MSG_GAME_OVER = "Игра окончена";
    char[][] map;
    Scanner sc;
    Random rand;

    public static void main(String[] args) {
        new HW4().game();
    }

    HW4() {
        map = new char[SIZE][SIZE];
        sc = new Scanner(System.in);
        rand = new Random();
    }

    void game() {
        initMap();
        while (true) {
            printMap();
            turnHuman(DOT_X);
            if (checkWin(DOT_X)) {
                System.out.println(MSG_YOU_WON);
                break;
            }
            if (isMapFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
            turnAI(DOT_O, DOT_X);
            if (checkWin(DOT_O)) {
                System.out.println(MSG_AI_WON);
                break;
            }
            if (isMapFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
        }
        System.out.println(MSG_GAME_OVER);
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void turnHuman(char dot) {
        int x, y;
        do {
            System.out.println(MSG_FOR_HUMAN);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = dot;
    }

    void turnAI(char dot, char enemyDot) {
        int x, y;
        for (x = 0; x < SIZE; x++)
            for (y = 0; y < SIZE; y++)
                if (isCellValid(x, y)) {
                    map[y][x] = enemyDot;
                    if (checkWin(enemyDot)) {
                        map[y][x] = dot;
                        return;
                    }
                    map[y][x] = DOT_EMPTY;
                }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = dot;
    }

    boolean checkWin(char dot) {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                for (int dy = -1; dy < 2; dy++)
                    for (int dx = -1; dx < 2; dx++)
                        if (checkLine(x, y, dx, dy, dot) == WIN_SIZE)
                            return true;
                            return false;
    }

    int checkLine(int x, int y, int dx, int dy, char dot) {
        int count = 0;
        if (dx == 0 && dy == 0)
            return 0;
        for (int i = 0, xi = x, yi = y;
             i < WIN_SIZE; i++, xi += dx, yi += dy)
            if (xi >= 0 && yi >= 0 && xi < SIZE &&
                    yi < SIZE && map[yi][xi] == dot)
                count++;
        return count;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }
}
