package fsl.rcc2016.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * "A" Секретный код
 * Ограничение по времени 	2 секунды
 * Ограничение по памяти 	256 мегабайт
 * <p>
 * Сейчас Марти находится в прошлом и хочет вернуться домой в 1985 год. Он уже влюбил своих родителей друг в друга и нашёл плутоний. Всё, что осталось сделать, — это включить машину времени и отправиться в путь. Здесь Марти ждёт ещё одно испытание. Чтобы включить машину времени, нужно ввести секретный код. Секретный код знает только Док. Марти известно, что все символы, из которых состоит код, различны, а также он знает количество символов. Пока Марти ждёт приезда Дока, он пытается угадать код и вводит различные комбинации символов.
 * <p>
 * Ваша задача — написать программу, которая для каждого запроса Марти выдает два числа — количество верных символов, которые стоят на своих позициях, и количество символов, которые встречаются в коде, но стоят на неверных позициях.
 * Формат входных данных
 * <p>
 * В первой строке находится строка s — секретный код. Код состоит из латинских заглавных букв и цифр, все символы в коде различные.
 * <p>
 * Во второй строке содержится натуральное число n (1 ≤ n ≤ 105) — количество попыток Марти.
 * <p>
 * В каждой из следующих n строк содержится очередная комбинация, которую вводит Марти. Комбинации также состоят из латинских заглавных букв и цифр. Символы в каждой комбинации различны. Длина каждой комбинации совпадает с длиной секретного кода.
 * Формат выходных данных
 * <p>
 * Для каждого запроса Марти выведите два числа a и b, где a — количество верных, b — количество символов, которые встречаются в коде, но стоят на неверных позициях.
 * Примеры
 * Входные данные
 * <p>
 * BACKTO1985
 * 3
 * BACKTO1958
 * BACKON1985
 * TOYEAR1985
 * <p>
 * Выходные данные
 * <p>
 * 8 2
 * 8 1
 * 4 3
 */
public class Warmup_1 {

    public static void run() {
        String pass = null;
        int tryCount = 0;
        List<String> passRequests = new ArrayList<>();

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            pass = bufferRead.readLine();
            tryCount = Integer.parseInt(bufferRead.readLine());


            for (int i = 0; i < tryCount; i++) {
                passRequests.add(bufferRead.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] passArr = pass.toCharArray();

        List<String> result = new ArrayList<>();
        for (String passRequest : passRequests) {

            int correct = 0;
            int wrongPosition = 0;

            char[] passRequestArr = passRequest.toCharArray();

            for (int i = 0; i < passArr.length; i++) {
                if (passRequestArr[i] == passArr[i]) {
                    correct = correct + 1;
                } else {
                    if (pass.indexOf(passRequestArr[i]) > -1) {
                        wrongPosition = wrongPosition + 1;
                    }
                }
            }
            result.add(correct + " " + wrongPosition);
        }
        for (int i = 0; i < result.size(); i++) {

            System.out.println(result.get(i));
        }
    }

}
