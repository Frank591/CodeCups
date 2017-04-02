package fsl.other;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;


public class CompareResults {


    /**
     * How to use:
     * 1. Go to folder with Main.java
     * 2. Open terminal and  cd 'out' folder with  Main.class . Example: /home/adminuser/Documents/develop/CodeCups/out/production/CodeCups
     * 3. java Main > test.txt . This command will place output of Main to test.txt file
     * 4. set into etalonAnswerPath path to file with etalon answer
     * 5. set into myAnswerPath path to test.txt from point3
     * 6. run test
     *
     * @throws Exception
     */
    @Test
    public void compareResults() throws Exception {
        String etalonAnswerPath = "/home/adminuser/Documents/develop/CodeCups/resources/rcc2017/qual1/02.a";
        String myAnswerPath = "/home/adminuser/Documents/develop/CodeCups/src/test.txt";

        BufferedReader etalon = new BufferedReader(new FileReader(etalonAnswerPath));
        BufferedReader myAnswer = new BufferedReader(new FileReader(myAnswerPath));

        List<String> etalonLines = etalon.lines().collect(Collectors.toList());
        List<String> myAnswerLines = myAnswer.lines().collect(Collectors.toList());

        for (int i = 0; i < etalonLines.size(); i++) {
            String etalonLine = etalonLines.get(i).trim();
            String answerLine;
            try {
                answerLine = myAnswerLines.get(i).trim();
            } catch (IndexOutOfBoundsException e) {
                throw new Exception(String.format("line with number = %s not exists in my answer, but found in etalon answer", i));
            }
            if (!etalonLine.equalsIgnoreCase(answerLine)) {
                throw new Exception(String.format("etalon=[%s] and answer=[%s] . Etalon line number = %s ", etalonLine, answerLine, i));
            }

        }


    }

}
