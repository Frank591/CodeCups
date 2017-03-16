package fsl.other;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Задачка: целые числа от 1 до n в случайном порядке помещены в массив n-2. 2 числа из них пропущено. Найти эти числа за 1 проход и без дополнительной памяти
 */
public class Find2MissedNumbersInArray {


    /**
     * get 2 missed numbers from randomly shuffled array of unique elements from [1,n]
     *
     * @param array - shuffled array of unique elements from [1,n], but 2 random elements was missed. len = n-2
     * @return array with 2 missed elements
     */
    public static int[] getMissedNumbers(int[] array) {

        int sum = 0;
        int fullSum = 0;
        int fullProduct = 1;
        int product = 1;
        for (int i = 0; i < array.length + 2; i++) {
            int currNaturalNumber = i + 1;
            fullSum = fullSum + currNaturalNumber;
            fullProduct = fullProduct * currNaturalNumber;

            if (i < array.length) {
                sum = sum + array[i];
                product = product * array[i];
            }
        }

        int missedSum = fullSum - sum; //firstMissedNum + secondMissedNum
        int missedProduct = fullProduct / product; //firstMissedNum * secondMissedNum

        //ax*x + bx + c = 0
        //x = (-b +- sqrt(b*b - 4*a*c))/2*a
        // -b = missedSum , c = missedProduct, a = 1
        Double firstMissedNum = (missedSum + Math.sqrt(missedSum * missedSum - 4 * missedProduct)) / 2;
        Double secondMissedNum = (missedSum - Math.sqrt(missedSum * missedSum - 4 * missedProduct)) / 2;
        return new int[]{firstMissedNum.intValue(), secondMissedNum.intValue()};
    }


    /**
     * Randomly put in array natural numbers 1..maxN, but randomly skip  missedNumbersCount  numbers
     *
     * @param maxN               max natural number in sequence
     * @param missedNumbersCount count of skipped numbers
     * @return array with length = maxN-missedNumbersCount, randomly filled unique natural numbers in interval [1,maxN]
     */
    public static Map.Entry<int[], int[]> generateArray(int maxN, int missedNumbersCount) {
        int[] initialArr = new int[maxN];
        for (int i = 0; i < maxN; i++) {
            initialArr[i] = i + 1;
        }
        shuffleArray(initialArr);
        int[] skippedNumbers = Arrays.copyOfRange(initialArr, maxN - missedNumbersCount, maxN);
        int[] arrayWithoutSkippedNumbers = Arrays.copyOf(initialArr, maxN - missedNumbersCount);
        return new AbstractMap.SimpleEntry<>(arrayWithoutSkippedNumbers, skippedNumbers);

    }

    private static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


}
