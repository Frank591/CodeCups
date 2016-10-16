package fsl.rcc2015;

/**
 * Russian Code Cup(Mail.ru) Qualifying Round 3 task 2
 *
 "B" Цифровые корни

 Недавно Гриша придумал новую забаву: он выписывает по порядку все числа от a до b.
 Дима, заметив это, предложил выписывать не числа, а их цифровые корни, чтобы сэкономить место на доске.
 Грише очень понравилась эта идея, поэтому он решил как можно скорее узнать, что же такое цифровой корень числа.
 Цифровой корень числа вычисляется следующим способом: берется сумма цифр данного числа, если она записывается одной цифрой,
 то она является цифровым корнем, иначе от этой суммы вычисляется сумма цифр до тех пор, пока не получится единственная цифра.
 Так цифровой корень 16 равен 7 (1+6=7), а цифровой корень 9991 равен 1 (9+9+9+1=28; 2+8=10; 1+0=1).
 Пока Гриша начал выписывать цифровые корни на доску, Дима задался вопросом: какие цифры на доске будут написаны чаще всего.
 Ваша задача состоит в том, чтобы по числам a и b, найти все цифровые корни, которые будут записаны на доске наибольшее количество раз.

 Формат входных данных
 Первая строка содержит целое положительное число t (1 ≤ t ≤ 104) — число тестовых примеров во входных данных. Далее следуют описания тестовых примеров.
 Каждый тестовый пример содержит в себе два натуральных числа a и b (1 ≤ a ≤ b ≤ 1015) — границы отрезка, который выписывает Гриша.

 Формат выходных данных
 Выведите t строк. Для каждого тестового примера выведите число n — количество различных цифр, которые встретятся на доске наибольшее количество раз.
 Затем через пробел выведите n чисел в возрастающем порядке — цифры, которые встретятся на доске наибольшее количество раз.

 Примеры

 Входные данные
 4
 1 5
 7 7
 9 12
 12 22

 Выходные данные
 5 1 2 3 4 5
 1 7
 4 1 2 3 9
 2 3 4

 */

import fsl.common.CommonUtils;
import fsl.yac2015.HashMapSorter;

import java.io.*;
import java.util.*;

public class QualifyingRound_3_2 {

    public static void run() {
        List<InputPrams_3_2> inputPrams = new ArrayList<InputPrams_3_2>();
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            int inputsCount = Integer.parseInt(bufferRead.readLine());

            for (int i = 0; i < inputsCount; i++) {
                inputPrams.add(readInputs(bufferRead.readLine()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<Integer, Integer> numberRoots = new HashMap<Integer, Integer>();
        for (int i = 0; i < inputPrams.size(); i++) {
            System.out.println(getResult(inputPrams.get(i), numberRoots));
        }
    }

    private static String getResult(InputPrams_3_2 input, HashMap<Integer, Integer> numberRoots) {

        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (Integer i = input.getAasInt(); i <= input.getBasInt(); i++) {
            if (!numberRoots.containsKey(i)) {
                numberRoots.put(i, getRoot(i.toString()));
            }
            Integer root = numberRoots.get(i);
            if (!result.containsKey(root)) {
                result.put(root, 1);
            } else {
                result.put(root, result.get(root) + 1);
            }
        }

        HashMapSorter<Integer, Integer> hashMapSorter = new HashMapSorter<Integer, Integer>();
        result = hashMapSorter.sortByValues(result, hashMapSorter.INTEGER_VALUE_DESC_COMPARATOR);


        List<Integer> mostPopularDigits = new ArrayList<Integer>();
        Integer max = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (max == 0) {
                max = entry.getValue();
            }
            if (entry.getValue() == max) {
                mostPopularDigits.add(entry.getKey());
            } else {
                break;
            }
        }

        Collections.sort(mostPopularDigits, CommonUtils.INTEGER_ASK_COMPARATOR);

        String resultStr = Integer.toString(mostPopularDigits.size());

        for (int i = 0; i < mostPopularDigits.size(); i++) {

            resultStr = resultStr + " " + mostPopularDigits.get(i);
        }
        return resultStr;
    }

    private static Integer getRoot(String number) {
        Integer result = 0;
        for (int i = 0; i < number.length(); i++) {
            Integer digit = Character.getNumericValue(number.charAt(i));
            result = result + digit;
        }
        if (result > 9) {
            result = getRoot(result.toString());
        }
        return result;
    }


    private static InputPrams_3_2 readInputs(String input) {
        String[] inputPrams = input.split(" ");
        return new InputPrams_3_2(inputPrams[0], inputPrams[1]);
    }
}


class InputPrams_3_2 {

    private String a;
    private String b;
    private int aAsInt;
    private int bAsInt;


    InputPrams_3_2(String a, String b) {
        this.a = a;
        this.b = b;
        aAsInt = Integer.parseInt(a);
        bAsInt = Integer.parseInt(b);

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getAasInt() {
        return aAsInt;
    }

    public int getBasInt() {
        return bAsInt;
    }


}
