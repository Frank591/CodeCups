/*
Yandex Contest 2015 QualifyingRound 3 Task1

Опечатки
Ограничение времени 	1 секунда
Ограничение памяти 	64Mb
Ввод 	стандартный ввод или input.txt
Вывод 	стандартный вывод или output.txt

Михаил — обычный пользователь интернета. Когда Михаил ищет что-либо в интернете с помощью Яндекса, случается, что он допускает опечатки в
поисковом запросе. Конечно же, в большинстве случаев Яндекс может угадать, что имел в виду Михаил, и исправить запрос. Например, если
Михаил опечатался в слове «дезоксирибонукленовая» (что неудивительно), Яндекс исправит запрос на «дезоксирибонуклеиновая».

Возможно, вы подумали, что в этой задаче вам нужно написать программу, исправляющую опечатки в запросе пользователя. Это не так: кроме этой
задачи вам предложено ещё 5 увлекательнейших задач, а времени до конца соревнования осталось не так уж много. Просто проверьте, содержит ли
очередной запрос Михаила опечатки.

Формат ввода

В первой строке входного файла находится запрос Михаила: от 1 до 5 слов, состоящих из строчных латинских букв и разделённых одиночными
пробелами. Вторая строка содержит целое число N (1 ≤ N ≤ 100): количество слов, содержащихся в словаре Яндекса (не волнуйтесь, в реальности
количество слов, содержащихся в словарях Яндекса, гораздо больше ста). Третья строка содержит слова из словаря. Каждое слово представляет
собой строку, состоящую из строчных латинских букв. Слова разделены одиночными пробелами. Гарантируется, что и слова из запроса, и слова из
словаря содержат не более 20 букв.

Формат вывода

В единственной строке выходного файла выведите «Correct» (без кавычек), если все слова из запроса Михаила содержатся в имеющемся словаре, и
«Misspell» (без кавычек), если хотя бы одного слова в словаре нет.

Пример 1
Ввод

deoxyribonucleic acid
3
deoxyribonucleic acid sequencing

Вывод
Correct

Пример 2
Ввод

yandex algoritm
2
algorithm yandex

Вывод
Misspell

*/

package fsl.yac2015;

import fsl.common.CommonUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class QualifyingRound_1 {

    public static final String INPUT_FILE_NAME = "QualifyingRound_1_input.txt";
    private static final String outputFileName = "output.txt";

    public static void run(String inputFileName) {

        String inputFilePath = QualifyingRound_1.class.getResource(inputFileName).getPath();

        BufferedReader infile = null;
        try {
            infile = new BufferedReader(new FileReader(inputFilePath));
            String userWordsInput = infile.readLine();
            String[] userWords = userWordsInput.split(" ");

            String dictSizeInput = infile.readLine();
            Integer dictSize = Integer.parseInt(dictSizeInput);

            String dictWordsInput = infile.readLine();
            String[] dictWords = dictWordsInput.split(" ");

            HashSet<Integer> dictWordsHashes = new HashSet<Integer>(dictSize);
            for (int i = 0; i < dictWords.length; i++) {
                dictWordsHashes.add(dictWords[i].hashCode());
            }

            for (int i = 0; i < userWords.length; i++) {
                boolean isContains = dictWordsHashes.contains(userWords[i].hashCode());
                if (!isContains) {
                    CommonUtils.writeStingInFile(outputFileName, "Misspell");
                    return;
                }

            }
            CommonUtils.writeStingInFile(outputFileName, "Correct");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (infile != null) {
                try {
                    infile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}