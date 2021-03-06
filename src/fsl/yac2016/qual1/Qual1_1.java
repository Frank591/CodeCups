package fsl.yac2016.qual1;

/**
 * Сыр
 * Ограничение времени 	1 секунда
 * Ограничение памяти 	512Mb
 * Ввод 	стандартный ввод или input.txt
 * Вывод 	стандартный вывод или output.txt
 * <p>
 * Миша достал из холодильника сыр и варёную картошку. У Миши есть микроволновка, он может класть в неё либо только сыр, либо только картошку, либо картошку и сыр сверху. Миша может неограниченное число раз включать и выключать микроволновку, но при каждом включении её функционал позволяет работать только целое число секунд.
 * <p>
 * Если подержать картошку в микроволновке меньше p секунд — она будет слишком холодной. Если ровно p секунд — возможно, суммарно за несколько заходов, — то она станет тёплой. Если больше p секунд, то картошка будет слишком горячей.
 * <p>
 * Если подержать сыр в микроволновке меньше a секунд, то он будет холодным. Если ровно a секунд, то он станет тёплым. Если больше a секунд, то он начнёт плавиться. Если подержать ровно a + b секунд, то он полностью расплавится. Если подержать больше a + b секунд, то сыр подгорит. Кроме того, если сыр начнёт плавиться, но при этом не будет лежать на картошке, то он прилипнет к тарелке, и его уже нельзя будет переложить на картошку.
 * <p>
 * Изначально картошка и сыр холодные. Миша хочет получить тёплую картошку и сверху на ней полностью расплавленный, но не подгоревший сыр. Определите минимальное число секунд, за которое с помощью микроволновки можно приготовить такое блюдо, или выясните, что это невозможно.
 * <p>
 * В этой задаче можно считать, что вне микроволновки сыр и картошка не нагреваются и не остывают.
 * Формат ввода
 * <p>
 * Единственная строка ввода содержит три целых положительных числа p, a и b, не превосходящих 100.
 * Формат вывода
 * <p>
 * Выведите минимальное число секунд, которое потребуется Мише, чтобы получить тёплую картошку и сверху на ней полностью расплавленный, но не подгоревший сыр. Если приготовить такое блюдо невозможно, выведите число -1.
 * Пример 1
 * Ввод 	Вывод
 * <p>
 * 1 1 1    2
 * <p>
 * Пример 2
 * Ввод 	Вывод
 * <p>
 * 2 2 1    3
 * <p>
 * Пример 3
 * Ввод 	Вывод
 * <p>
 * 1 10 2   -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Qual1_1 {


    public static void run() {

        byte p, a, b;

        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {

            String params = bufferRead.readLine();
            String[] splittedParams = params.split(" ");
            p = Byte.valueOf(splittedParams[0]);
            a = Byte.valueOf(splittedParams[1]);
            b = Byte.valueOf(splittedParams[2]);

            if (b > p) {
                System.out.println(-1);
                return;
            }
            if (p - b > a) {
                System.out.println(b + (p - b));
            } else {
                System.out.println(b + a);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
