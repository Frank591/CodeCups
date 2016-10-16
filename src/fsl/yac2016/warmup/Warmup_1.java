package fsl.yac2016.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Байтазар хочет завести себе Яндекс.Почту. Однако выбранное им имя, составленное из строчных английских букв, уже кем-то используется. Тогда Байтазар решил составить новое имя следующим способом. Сначала он строит слово V, читая первоначально выбранное имя слева направо и выписывая все гласные в порядке их появления. Затем он аналогичным образом строит слово C из согласных. Байтазар считает гласными буквы «a», «e», «i», «o», «u», а также букву «y», а все остальные буквы считает согласными. Новым именем Байтазара будет либо слово V, либо слово C.
 * <p>
 * Чтобы окончательно выбрать между двумя вариантами, Байтазар хочет узнать, какой из них является лексикографически наибольшим. Напомним, что для того, чтобы сравнить два слова лексикографически, нужно найти самую левую позицию, на которой символы в этих словах различаются, после чего сравнить эти символы. То слово, у которого символ на соответствующей позиции идёт в алфавите позже, лексикографически больше. Если такой позиции нет, больше то слово, длина которого больше.
 * Формат ввода
 * <p>
 * Входные данные — непустая строка T, состоящая из строчных английских букв. Длина строки не превосходит 106 букв.
 * Формат вывода
 * <p>
 * Если слово, составленное из гласных, лексикографически больше, выведите «Vowel». В противном случае выведите «Consonant».
 * Пример 1
 * Ввод 	Вывод
 * <p>
 * consonant
 * <p>
 * <p>
 * <p>
 * Vowel
 * <p>
 * Пример 2
 * Ввод 	Вывод
 * <p>
 * vowel
 * <p>
 * <p>
 * <p>
 * Consonant
 */
public class Warmup_1 {


    //«a», «e», «i», «o», «u», а также букву «y»
    private static final char a = (char) 97;
    private static final char e = (char) 101;
    private static final char i = (char) 105;
    private static final char o = (char) 111;
    private static final char u = (char) 117;
    private static final char y = (char) 121;

    public static void run() {

        String busyName = null;
        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {

            busyName = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] busyNameArr = busyName.toCharArray();
        Character firstVowel = null;
        Character firstConsonant = null;

        for (int index = 0; index < busyNameArr.length; index++) {
            char currChar = busyNameArr[index];

            if (firstVowel != null && firstConsonant != null) {
                break;
            }

            boolean isVowel = isVowel(currChar);
            if (isVowel) {
                if (firstVowel == null) {
                    firstVowel = currChar;
                }
            } else {
                if (firstConsonant == null) {
                    firstConsonant = currChar;
                }
            }

        }

        if (firstConsonant == null) {
            System.out.println("Vowel");
            return;
        }

        if (firstVowel == null) {
            System.out.println("Consonant");
            return;
        }


        if (Character.getNumericValue(firstVowel) > Character.getNumericValue(firstConsonant)) {
            System.out.println("Vowel");
        } else {
            System.out.println("Consonant");
        }

    }

    private static boolean isVowel(char character) {
        if ((character == a)
                || (character == e)
                || (character == i)
                || (character == o)
                || (character == u)
                || (character == y)) {
            return true;
        }
        return false;

    }


}
