package fsl.rcc2017.qual1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Девочка Маша смотрит на стену в своей комнате. Стена выложена квадратной плиткой, но вместо некоторых плиток установлены лампы. Таким образом, можно представить, что стена представляет собой клетчатый прямоугольник размером n × m, в некоторых клетках которого находятся лампы.
 * <p>
 * У Маши есть краски k различных цветов. Маша хочет покрасить все плитки на стене так, чтобы на любом вертикальном или горизонтальном отрезке плиток, ограниченном с каждого конца краем стены или лампой, цвета не повторялись. При этом лампы Маша, размуеется, красить не будет. Маше не обязательно требуется использовать все цвета.
 * <p>
 * Маша просит вас придумать, как ей покрасить стену.
 * <p>
 * Формат входных данных
 * <p>
 * Входные данные содержат несколько тестовых наборов. В первой строке задано количество тестов t.
 * <p>
 * Каждый из тестов описывается следующим образом: в первой строке описания теста содержатся три числа n, m, k (1 ≤ n, m ≤ 100, 1 ≤ k ≤ max(n, m)) — размеры стены и количество различных красок у Маши.
 * <p>
 * В следующих n строках содержатся по m чисел aij:
 * <p>
 * aij = 0, если на позиции (i, j) находится лампа;
 * aij = 1, если на позиции (i, j) находится плитка.
 * <p>
 * Суммарное количество плиток и ламп по всем тестам не превосходит 105.
 * Формат выходных данных
 * <p>
 * Для каждого теста в отдельной строке сначала выведите ответ на него:
 * <p>
 * NO, если не существует ни одного способа покрасить стену так, как хочет Маша.
 * YES, если способ перекрасить есть. В этом случае в следующих n строках выведите по m чисел bij — цвет плитки на позиции (i, j) или 0, если на этой позиции лампа. Если подходящих раскрасок несколько, выведите любую из них.
 * <p>
 * Примеры
 * Входные данные
 * <p>
 * 2
 * 4 3 2
 * 0 1 0
 * 1 0 1
 * 1 0 1
 * 0 1 0
 * 3 4 2
 * 0 1 0 1
 * 1 0 1 1
 * 1 1 1 0
 */
public class Qual1_2 {

    public static void run(String[] args) {

        List<WallSettings> settingsList = new ArrayList<>();

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testsCount = Integer.parseInt(bufferRead.readLine());


            for (int i = 0; i < testsCount; i++) {
                String[] settings = bufferRead.readLine().split(" ");

                int n = Integer.parseInt(settings[0]);
                int m = Integer.parseInt(settings[1]);
                int k = Integer.parseInt(settings[2]);

                WallSettings wallSettings = new WallSettings(n, m, k);

                for (int j = 0; j < n; j++) {
                    String[] row = bufferRead.readLine().split(" ");
                    List<Integer> rowVals = new ArrayList<>();
                    for (String val : row) {
                        rowVals.add(Integer.parseInt(val));
                    }

                    wallSettings.applyRow(j, rowVals);

                }
                settingsList.add(wallSettings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (WallSettings wallSettings : settingsList) {
            boolean isAvailableToPaint = true;
            boolean isMaxLineChanged = false;
            int maxLine = 0;
            for (int i = 0; i < wallSettings.n; i++) {
                maxLine = 0;
                for (int j = 0; j < wallSettings.m; j++) {
                    if (wallSettings.wall[i][j] == 0) {
                        maxLine = 0;
                        continue;
                    }
                    maxLine++;
                    isMaxLineChanged = true;
                    if (maxLine > wallSettings.paintCnt) {
                        isAvailableToPaint = false;
                        break;
                    }
                }

            }
            if (maxLine == 0 && !isMaxLineChanged) {
                isAvailableToPaint = false;
            }

            if (isAvailableToPaint) {
                System.out.println("YES");
                LinkedList<Integer> paints = new LinkedList<>();
                for (int i = 1; i <= wallSettings.paintCnt; i++) {
                    paints.add(i);
                }
                for (int i = 0; i < wallSettings.n; i++) {
                    int innerIter = 0;
                    for (int j = 0; j < wallSettings.m; j++) {
                        if (wallSettings.wall[i][j] > 0) {
                            wallSettings.wall[i][j] = paints.get(innerIter);
                        }
                        innerIter++;
                        if (innerIter >= wallSettings.paintCnt) {
                            innerIter = 0;
                        }
                    }
                    System.out.println(getArrayAsString(wallSettings.wall[i]));
                    int last = paints.removeLast();
                    paints.addFirst(last);
                }


            } else {
                System.out.println("NO");
            }
        }


    }

    public static String getArrayAsString(int[] array) {
        StringBuilder printResult = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            printResult.append(array[i]);
            printResult.append(" ");
        }
        return printResult.toString();
    }

    private static class WallSettings {
        public int[][] wall;
        private final int n;
        private final int m;
        private int paintCnt;

        public WallSettings(int n, int m, int paintCnt) {
            this.n = n;
            this.m = m;
            this.paintCnt = paintCnt;
            wall = new int[n][m];
        }

        public void applyRow(int n, List<Integer> row) {
            for (int i = 0; i < m; i++) {
                wall[n][i] = row.get(i);
            }
        }

    }
}
