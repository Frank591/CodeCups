package fsl.rcc2017.qual1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Волейбольный матч на Марсе играется двумя командами до k очков, при этом для победы отрыв должен быть хотя бы на 2 очка. За каждый розыгрыш мяча одна из команд получает ровно 1 очко.
 * <p>
 * На текущий момент матча счет первой команды равен x, а счет второй команды равен y. Какое минимальное количество мячей будут разыграны до окончания матча?
 * <p>
 * Формат входных данных
 * <p>
 * Входные данные содержат несколько тестовых наборов. В первой строке задано количество тестов t (1 ≤ t ≤ 5000).
 * <p>
 * Каждый тестовый пример описывается одной строкой, содержащей три целых числа, разделенных пробелами: k, x и y (1 ≤ k ≤ 100; 0 ≤ x, y ≤ 100).
 * <p>
 * Гарантируется, что счет мог быть получен при корректной незавершенной игре.
 * Формат выходных данных
 * <p>
 * Для каждого теста в отдельной строке выведите ответ на него — минимальное количество мячей, которые будут разыграны до окончания матча.
 * Примеры
 * Входные данные
 * <p>
 * 3
 * 2 1 0
 * 3 4 3
 * 5 0 0
 * <p>
 * Выходные данные
 * <p>
 * 1
 * 1
 * 5
 */


public class Qual1_1 {

    public static void run(String[] args) {


        List<int[]> settingsList = new ArrayList<>();

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testsCount = Integer.parseInt(bufferRead.readLine());


            for (int i = 0; i < testsCount; i++) {

                String[] settings = bufferRead.readLine().split(" ");
                int k = Integer.parseInt(settings[0]);
                int x = Integer.parseInt(settings[1]);
                int y = Integer.parseInt(settings[2]);
                int[] params = new int[3];
                params[0] = k;
                params[1] = x;
                params[2] = y;
                settingsList.add(params);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int[] params : settingsList) {
            //System.out.println(params[0] + " " + params[1] + " " + params[2]);
            int k = params[0];
            int x = params[1];
            int y = params[2];
            int reqDelta = 2;

            int max = Math.max(x, y);
            int min = Math.min(x, y);
            int currDelta = max - min;

            int res = reqDelta;

            if (k > max) {
                res = k - max;
                if (res > 1) {
                    System.out.println(res);
                } else {
                    if ((max - min) == 0) {
                        System.out.println(2);
                    } else {
                        System.out.println(1);
                    }
                }
            } else {
                if ((max - min) == 0) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            }


        }
    }
}
