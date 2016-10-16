package fsl.yac2016.qual1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Путешествие по квадрату
 * Ограничение времени 	1 секунда
 * Ограничение памяти 	512Mb
 * Ввод 	стандартный ввод или input.txt
 * Вывод 	стандартный вывод или output.txt
 * <p>
 * Есть девять точек на плоскости и отрезки между ними.
 * <p>
 * Известно, что некто проделал маршрут, начав в центральной точке, при этом он двигался только по отрезкам и посетил все девять точек ровно по одному разу. Каждой точке был присвоен номер от 1 до 9 — которой по счёту она оказалась в маршруте. Ровно для трёх точек — центральной и двух других — вам известен этот номер. Восстановите все остальные номера. Гарантируется, что это можно сделать единственным способом.
 * Формат ввода
 * <p>
 * На вход подаётся три строки: описания верхнего, среднего и нижнего рядов точек. Каждая строка состоит из трёх символов: описаний левой, средней и правой точек ряда. Каждый символ — это либо цифра от 1 до 9, либо знак вопроса. Эти символы задают номера точек в маршруте. Знак вопроса означает, что номер неизвестен. Гарантируется, что цифры не повторяются, что центральный символ — единица, а также что среди заданных символов ровно шесть знаков вопроса. Также гарантируется, что существует ровно один способ заменить знаки вопроса цифрами так, чтоб цифры задавали маршрут, посещающий все точки по одному разу и проходящий только по отрезкам между ними.
 * Формат вывода
 * <p>
 * Выведите заданные строки, заменив в них все знаки вопроса на цифры. Получившийся квадрат 3 × 3 должен задавать маршрут, посещающий все точки по одному разу и проходящий только по отрезкам между ними.
 * Пример
 * Ввод
 * <p>
 * 32?
 * ?1?
 * ???
 * <p>
 * <p>
 * Вывод
 * 329
 * 418
 * 567
 */

public class Qual1_2 {

    public static void run() {

        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {

            char questionMark = "?".toCharArray()[0];
            byte[][] inputData = new byte[3][3];


            String row1 = bufferRead.readLine();
            String row2 = bufferRead.readLine();
            String row3 = bufferRead.readLine();
            for (int i = 0; i < 3; i++) {
                char ch = row1.charAt(i);
                if (ch != questionMark) {
                    inputData[0][i] = Byte.parseByte(String.valueOf(ch));
                } else {
                    inputData[0][i] = 0;
                }

            }

            for (int i = 0; i < 3; i++) {
                char ch = row2.charAt(i);
                if (ch != questionMark) {
                    inputData[1][i] = Byte.parseByte(String.valueOf(ch));
                } else {
                    inputData[1][i] = 0;
                }
            }

            for (int i = 0; i < 3; i++) {
                char ch = row3.charAt(i);
                if (ch != questionMark) {
                    inputData[2][i] = Byte.parseByte(String.valueOf(ch));
                } else {
                    inputData[2][i] = 0;
                }
            }


            List<Action[]> startParams = new ArrayList<>();

            startParams.add(new Action[]{Action.IncrX, Action.IncrY});
            startParams.add(new Action[]{Action.IncrX, Action.DecrY});

            startParams.add(new Action[]{Action.DecrX, Action.IncrY});
            startParams.add(new Action[]{Action.DecrX, Action.DecrY});

            startParams.add(new Action[]{Action.IncrY, Action.IncrX});
            startParams.add(new Action[]{Action.IncrY, Action.DecrX});

            startParams.add(new Action[]{Action.DecrY, Action.IncrX});
            startParams.add(new Action[]{Action.DecrY, Action.DecrX});


            for (Action[] param : startParams) {
                byte[][] result = getFilledField(param);

                if (compareArrs(inputData, result)) {
                    print(result);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[][] getFilledField(Action[] steps) {

        byte[][] result = new byte[3][3];

        Action firstStep = steps[0];
        Action secondStep = steps[1];


        int currX = 1;
        int currY = 1;

        result[currY][currX] = 1;

        currX = getX(currX, firstStep);
        currY = getY(currY, firstStep);
        result[currY][currX] = 2;

        currX = getX(currX, secondStep);
        currY = getY(currY, secondStep);
        result[currY][currX] = 3;


        for (byte i = 4; i <= 9; i++) {
            Action action = getNextAction(currY, currX, result);
            currX = getX(currX, action);
            currY = getY(currY, action);
            result[currY][currX] = i;
        }
        return result;
    }


    private enum Action {
        IncrX, DecrX, IncrY, DecrY;


        public static int getDiff(Action action) {
            if (action == Action.IncrY || action == Action.IncrX) {
                return 1;
            }
            if (action == Action.DecrX || action == Action.DecrY) {
                return -1;
            }
            throw new IllegalArgumentException("wrong action value " + action);
        }

        public static int getNext(int curr, Action action) {
            return curr + getDiff(action);
        }
    }

    private static int getX(int currX, Action action) {
        if (action == Action.DecrX) {
            currX = currX - 1;
        } else if (action == action.IncrX) {
            currX = currX + 1;
        }
        if (currX < 0 || currX > 2) {
            throw new RuntimeException(" wrong x index value=" + currX);
        }
        return currX;
    }

    private static int getY(int curr, Action action) {
        if (action == Action.DecrY) {
            curr = curr - 1;
        } else if (action == action.IncrY) {
            curr = curr + 1;
        }
        if (curr < 0 || curr > 2) {
            throw new RuntimeException(" wrong Y index value=" + curr);
        }
        return curr;
    }


    private static Action getNextAction(int currY, int currX, byte[][] field) {

        Action[] xChange = {Action.DecrX, Action.IncrX};
        Action[] yChange = {Action.DecrY, Action.IncrY};

        for (Action action : xChange) {
            if (checkValid(currY, Action.getNext(currX, action), field)) {
                return action;
            }
        }
        for (Action action : yChange) {
            if (checkValid(Action.getNext(currY, action), currX, field)) {
                return action;
            }
        }
        throw new RuntimeException();

    }

    private static boolean checkValid(int currY, int currX, byte[][] field) {
        int min = 0;
        int max = 2;

        if (currX < min || currX > max) {
            return false;
        }
        if (currY < min || currY > max) {
            return false;
        }

        if (field[currY][currX] > 0) {
            return false;
        }
        return true;

    }


    private static boolean compareArrs(byte[][] input, byte[][] generated) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                byte currInput = input[i][j];
                if (currInput == 0) {
                    continue;
                }

                if (currInput != generated[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }

    private static void print(byte[][] arr) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

