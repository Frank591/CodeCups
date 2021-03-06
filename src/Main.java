import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


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


