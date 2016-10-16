package fsl.rcc2016.qual2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * "A" Петя и учебник
 * Ограничение по времени 	2 секунды
 * Ограничение по памяти 	256 мегабайт
 * <p>
 * Убираясь сегодня в комнате, Петя нашел свой старый учебник русского языка. Так как он с детства недолюбливает этот предмет, он начал вырывать из него страницы.
 * <p>
 * В учебнике n страниц, пронумерованных от 1 до n, которые скреплены переплетом так, что i и n - i + 1 страницы связаны друг с другом — если вырвать одну из них, вторая тоже выпадает из учебника. Пете очень нравится процесс вырывания страниц из учебника, однако он все-таки хочет его контролировать, а именно в некоторые моменты времени ему интересно знать, какой номер у p-й по порядку страницы из оставшихся. Помогите ему с этой задачей.
 * <p>
 * Формат входных данных
 * <p>
 * Входные данные содержат несколько тестовых наборов. В первой строке задано количество тестов t (1 ≤ t ≤ 1000).
 * <p>
 * Каждый из следующих t тестов описывается следующим образом: в первой строке описания теста содержатся два числа n, q (2 ≤ n ≤ 100, n — четное; 1 ≤ q ≤ 100) — количество страниц в учебнике и количество запросов соответственно. В следующих q строках содержатся запросы двух типов:
 * <p>
 * - i — Петя вырывает страницу с номером i;
 * ? p — Петя хочет узнать, какой номер у p-й по порядку из оставшихся страниц.
 * <p>
 * Гарантируется, что в запросе первого типа удаляемая страница существует, а в запросе второго типа текущее количество страниц не меньше p.
 * Формат выходных данных
 * <p>
 * На каждый запрос второго типа в отдельной строке выведите номер искомой страницы.
 * Примеры
 * Входные данные
 * <p>
 * 2
 * 4 4
 * ? 3
 * - 2
 * ? 2
 * ? 1
 * 6 5
 * - 3
 * ? 3
 * - 1
 * ? 2
 * ? 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 2
 * 6 6
 * ? 2
 * - 1
 * ? 4
 * - 3
 * ? 2
 * - 5
 * 8 9
 * ? 8
 * - 6
 * ? 4
 * - 5
 * ? 3
 * ? 1
 * - 7
 */


public class Qual_1 {

    public static void run(String[] args) {

        List<AbstractMap.SimpleEntry<Integer, List<String>>> settingsList = new ArrayList<>();

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testsCount = Integer.parseInt(bufferRead.readLine());


            for (int i = 0; i < testsCount; i++) {

                String[] settings = bufferRead.readLine().split(" ");
                int pageCount = Integer.parseInt(settings[0]);
                int queryCount = Integer.parseInt(settings[1]);
                List<String> queries = new ArrayList<>();
                for (int j = 0; j < queryCount; j++) {
                    queries.add(bufferRead.readLine());
                }
                settingsList.add(new AbstractMap.SimpleEntry<>(pageCount, queries));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (AbstractMap.SimpleEntry<Integer, List<String>> currTestSettings : settingsList) {
            List<Integer> pages = new ArrayList<>();

            Integer totalPagesCount = currTestSettings.getKey();

            for (int i = 1; i <= totalPagesCount; i++) {
                pages.add(i);


                for (String query : currTestSettings.getValue()) {
                    List<Integer> newPages = new ArrayList<>();
                    int numberFromQuery = getNumber(query);
                    int realIndex = numberFromQuery - 1;
                    if (query.contains("-")) {
                        int linkedPageIndex = (totalPagesCount - numberFromQuery + 1);
                        for (Integer page : pages) {
                            if (page != numberFromQuery && page != linkedPageIndex) {
                                newPages.add(new Integer(page));
                            }
                        }
                        pages = newPages;

                    } else {
                        System.out.println(pages.get(realIndex));
                    }
                }

            }

        }
    }


    private static Integer getNumber(String query) {
        return Integer.parseInt(query.split(" ")[1]);
    }
}
