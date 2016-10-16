package fsl.rcc2016.warmup;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * "C" Новое приключение Марти и Дока
 * Ограничение по времени 	2 секунды
 * Ограничение по памяти 	256 мегабайт
 * <p>
 * После возвращения Дока на поезде из 1885, он воодушевился идеей перевоплощения разных видов транспорта в машины времени, поэтому, недолго думая, переместился в 2015 и сделал машину времени-самолет. Однако во время испытаний у самолета отказали двигатели, и Доку пришлось катапультироваться, а самолет упал в огромное поле и разбился.
 * <p>
 * Теперь части разбившегося самолета надо собрать и утилизировать. Марти вызвался помочь Доку и нарисовал схему поля. У него получился прямоугольник n × m, в каждой клетке которого лежало несколько частей самолета. Марти решил, что удобнее будет утилизировать все части в одном месте, для этого он предложил построить утилизатор в одной из клеток поля. Собирать части самолета будет робот Дока, он умеет делать три действия:
 * <p>
 * Находясь в клетке поля, переехать в клетку, соседнюю по стороне;
 * Если в текущей клетке поля есть хотя бы одна часть самолета, робот может взять ее с собой (однако, детали слишком тяжелые и больше одной роботу с собой не унести);
 * Если робот находится в одной клетке с утилизатором и у него с собой есть часть самолета, он может тут же ее утилизировать.
 * <p>
 * Исходно робот находится в одной клетке с утилизатором.
 * <p>
 * Теперь главная задача Марти — понять, где надо построить утилизатор, чтобы минимизирновать число действий, которые понадобятся роботу, чтобы утилизировать все части разбитого самолета. Помогите ему с этой задачей.
 * <p>
 * Формат входных данных
 * <p>
 * В первой строке даны числа n, m (1 ≤ n·m ≤ 106) — размеры поля.
 * <p>
 * В i-й из следующих n строк дано описание i-й строки поля — m чисел ai, j (0 ≤ ai, j ≤ 106) — количество частей самолета, расположенных в данной клетке поля.
 * Формат выходных данных
 * <p>
 * Выведите три числа: r, c и x (1 ≤ r ≤ n, 1 ≤ c ≤ m) — координаты местоположения утилизатора и количество действий, которое придется сделать роботу. Если опитмальных положений утилизатора несколько, выведите любое из них.
 * Примеры
 * Входные данные
 * <p>
 * 3 3
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * Выходные данные
 * <p>
 * 2 2 2
 * <p>
 * <p>
 * Входные данные
 * <p>
 * 3 3
 * 2 0 0
 * 0 0 0
 * 0 2 0
 */
public class Warmup_3 {


    public static void run() {

        int numberCount;
        long result = 0;

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String areaSizeAsStr = bufferRead.readLine();
            String[] splittedAreaSize = areaSizeAsStr.split(" ");
            int n = Integer.parseInt(splittedAreaSize[0]);
            int m = Integer.parseInt(splittedAreaSize[1]);


            int[][] area = new int[n][m];

            ArrayList<Map.Entry<Point, Integer>> pointsWithDetail = new ArrayList<Map.Entry<Point, Integer>>();

            for (int i = 0; i < n; i++) {
                String row = bufferRead.readLine();
                String[] splittedRow = row.split(" ");
                for (int j = 0; j < splittedRow.length; j++) {
                    int detailsCount = Integer.parseInt(splittedRow[j]);
                    if (detailsCount > 0) {
                        pointsWithDetail.add(new AbstractMap.SimpleEntry<Point, Integer>(new Point(i, j), detailsCount));
                    }
                }
            }


            int minActionCount = Integer.MAX_VALUE;
            int xBase = 0;
            int yBase = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    int currActionCount = 0;

                    for (Map.Entry<Point, Integer> point : pointsWithDetail) {

                        currActionCount = currActionCount + calcActionCount(i, j, point.getKey().x, point.getKey().y, point.getValue());
                    }

                    if (minActionCount > currActionCount) {
                        xBase = i;
                        yBase = j;
                        minActionCount = currActionCount;
                    }

                }
            }

            xBase = xBase + 1;
            yBase = yBase + 1;

            System.out.println(xBase + " " + yBase + " " + minActionCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calcActionCount(int xBase, int yBase, int x, int y, int detailsCount) {
        return ((Math.abs(xBase - x) + Math.abs(yBase - y)) * 2 + 2) * detailsCount;

    }
}
