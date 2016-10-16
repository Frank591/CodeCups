package fsl.rcc2015;

/**
 * Russian Code Cup(Mail.ru) Qualifying Round 3 task 1
 *
 *
 "A" Покупка велосипеда

 Сегодня Петя убирался в комнате и нашел под кроватью очень много мелочи — рублевых и двухрублевых монет. Внимательно все пересчитав,
 Петя понял, что у него есть a монет номиналом в один рубль и b монет номиналом в два рубля.
 Петя очень давно хотел купить себе велосипед, поэтому сразу же пошел в магазин и узнал, что его заветное средство передвижения стоит с рублей.
 К сожалению, в магазине велосипедов проблемы с мелкими деньгами, а без сдачи Петя уходить не хочет. Поэтому теперь он задался вопросом: можно ли купить велосипед, заплатив при этом ровно с рублей?
 Помогите Пете, скажите, можно ли, имея a рублевых монет и b двухрублевых, купить без сдачи велосипед стоимостью с рублей?


 Формат входных данных
 Первая строка входных данных содержит одно число t (1 ≤ t ≤ 100000) — количество тестов. Следующие t строк содержат по тесту каждая. Каждый тест задается тремя целыми числами: a, b, с (0 ≤ a, b, c ≤ 108) — количество рублевых, двухрублевых монет и стоимость велосипеда соответственно.

 Формат выходных данных
 Для каждого набора данных выведите единственную строку: «YES», если можно купить велосипед без сдачи и «NO» в противном случае.

 Примеры
 Входные данные
 4
 1 2 4
 2 1 4
 1 2 3
 3 1 6

 Выходные данные
 YES
 YES
 YES
 NO

 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QualifyingRound_3_1 {

    public static void run() {
        List<InputPrams_3_1> inputPrams = new ArrayList<InputPrams_3_1>();

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            int inputsCount = Integer.parseInt(bufferRead.readLine());

            for (int i = 0; i < inputsCount; i++) {
                inputPrams.add(readInputs(bufferRead.readLine()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < inputPrams.size(); i++) {

            System.out.println(getResult(inputPrams.get(i)));

        }
    }

    private static String getResult(InputPrams_3_1 input) {
        if (input.getPrice() > input.getFirstCoinCount() + input.getSecondCoinCount() * 2) {
            return "NO";
        }

        int total2CoinCount = input.getPrice() / 2;

        int req1CoinCount = 0;
        if (input.getPrice() % 2 == 1) {
            req1CoinCount = 1;
        }

        if (total2CoinCount > input.getSecondCoinCount()) {
            req1CoinCount = req1CoinCount + (total2CoinCount - input.getSecondCoinCount()) * 2;
        }

        if (req1CoinCount <= input.getFirstCoinCount()) {
            return "YES";
        } else {
            return "NO";
        }
    }


    private static InputPrams_3_1 readInputs(String input) {
        String[] inputPrams = input.split(" ");

        return new InputPrams_3_1(Integer.parseInt(inputPrams[0]), Integer.parseInt(inputPrams[1]), Integer.parseInt(inputPrams[2]));
    }


    private static void writeResult(String filePath, String message) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            boolean success = file.createNewFile();
        }
        BufferedWriter outfile =
                new BufferedWriter(new FileWriter(filePath));
        outfile.write(message);
        outfile.close();
    }

}


class InputPrams_3_1 {

    private int price;
    private int firstCoinCount;
    private int secondCoinCount;


    InputPrams_3_1(int firstCoinCount, int secondCoinCount, int price) {
        this.price = price;
        this.firstCoinCount = firstCoinCount;
        this.secondCoinCount = secondCoinCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFirstCoinCount() {
        return firstCoinCount;
    }

    public void setFirstCoinCount(int firstCoinCount) {
        this.firstCoinCount = firstCoinCount;
    }

    public int getSecondCoinCount() {
        return secondCoinCount;
    }

    public void setSecondCoinCount(int secondCoinCount) {
        this.secondCoinCount = secondCoinCount;
    }


}
