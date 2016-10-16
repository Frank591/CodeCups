package fsl.common;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CommonUtils {

    /**
     * Write {@code message} into file with path {@code filePath}.
     *
     * @param message  message for writing
     * @param filePath target file path
     * @throws IOException
     */
    public static void writeStingInFile(String filePath, String message) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            boolean success = file.createNewFile();
        }
        BufferedWriter outfile =
                new BufferedWriter(new FileWriter(filePath));
        outfile.write(message);
        outfile.close();
    }

    /**
     * Example by reading first line from file width file path = {@code filePath}
     *
     * @param filePath target file path
     * @throws IOException
     */
    public static void readFromFileExample(String filePath) throws IOException {

        try (BufferedReader infile = new BufferedReader(new FileReader(filePath))) {
            String firstLine = infile.readLine();
            String[] firstLineValues = firstLine.split(" ");
        }
    }

    public static final Comparator<Integer> INTEGER_ASK_COMPARATOR = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    public static final Comparator<Integer> INTEGER_DESK_COMPARATOR = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };


    public static void sortPrimitiveArrayExample(Integer[] array, boolean asc) {
        if (asc) {
            Arrays.sort(array);
        } else {
            Arrays.sort(array, Collections.<Integer>reverseOrder());
        }
    }

      /*
    Java 8 sort object collection
    See http://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
    Example:
    Collections.sort(list, (ActiveAlarm a1, ActiveAlarm a2) -> a1.timeStarted-a2.timeStarted);

     */


    //------------------------------byte mask operations---------------
    //See https://ru.wikipedia.org/wiki/%D0%91%D0%B8%D1%82%D0%BE%D0%B2%D1%8B%D0%B5_%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B8#.D0.9F.D0.BE.D0.B1.D0.B8.D1.82.D0.BE.D0.B2.D0.BE.D0.B5_.D0.98_.28AND.29

    public static boolean isEvenNumber(int number) {
        return ((number & 1) == 0);
    }

    /**
     * Как проверить, является ли число степенью двойки?
     */
    public static boolean isPowerOf2(int x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }

    public static boolean isContainsBitMask(int target, int bitMask) {

        return (bitMask & target) == bitMask;
    }
}


