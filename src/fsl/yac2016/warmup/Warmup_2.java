package fsl.yac2016.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Байтландский талер
 * Ограничение времени 	1 секунда
 * Ограничение памяти 	512Mb
 * Ввод 	стандартный ввод или input.txt
 * Вывод 	стандартный вывод или output.txt
 * <p>
 * Вася следит за курсом обмена байтландского талера к рублю на Яндекс.Новостях. Приложение позволяет видеть колебания курса на заданном промежутке времени. По имеющимся данным Вася хочет выяснить максимальный разброс между значениями курса за N дней.
 * <p>
 * Напишите программу, которая по N значениям курса за подряд идущие N дней определяет максимальную разность между значениями курса на этом промежутке времени.
 * Формат ввода
 * <p>
 * В первой строке задано одно целое число N (1 ≤ N ≤ 106) — количество дней, интересующих Васю. Следующая строка содержит N целых чисел ai (1 ≤ ai ≤ 109), i-е из этих чисел задаёт курс обмена байтландского талера к рублю на i-й день.
 * Формат вывода
 * <p>
 * Выведите одно целое неотрицательное число — значение максимальной разности курса байтландского талера на заданном интервале.
 * Пример 1
 * Ввод 	Вывод
 * <p>
 * 3
 * 1 2 4
 * <p>
 * <p>
 * <p>
 * 3
 * <p>
 * Пример 2
 * Ввод 	Вывод
 * <p>
 * 4
 * 98 76 543 210
 * <p>
 * <p>
 * <p>
 * <p>
 * 467
 */
public class Warmup_2 {

    static final char whitespace = " ".toCharArray()[0];

    public static void run() {


        String daysCountAsStr = null;
        String valuesAsStr = null;

        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {

            daysCountAsStr = bufferRead.readLine();
            valuesAsStr = bufferRead.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Long min = Long.MAX_VALUE;
        Long max = new Long(0);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valuesAsStr.length(); i++) {

            char currChar = valuesAsStr.charAt(i);
            if (valuesAsStr.charAt(i) != whitespace) {
                sb.append(currChar);
            } else {
                Long currValue = Long.valueOf(sb.toString());
                if (currValue > max) {
                    max = currValue;
                }
                if (currValue < min) {
                    min = currValue;
                }
                sb.setLength(0);
            }
        }

        Long currValue = Long.valueOf(sb.toString());
        if (currValue > max) {
            max = currValue;
        }
        if (currValue < min) {
            min = currValue;
        }

        System.out.println(max - min);

    }

}
