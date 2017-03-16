package fsl.other;

import fsl.common.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by adminuser on 3/16/17.
 */
public class Find2MissedNumbersInArrayTest {
    @Test
    public void getMissedNumbersTest() throws Exception {
        Map.Entry<int[], int[]> entry = Find2MissedNumbersInArray.generateArray(10, 2);
        System.out.println("Initial array: " + CommonUtils.getArrayAsString(entry.getKey()));
        int[] expectedMissedNumbers = entry.getValue();
        Arrays.sort(expectedMissedNumbers);
        System.out.println("Skipped numbers: " + CommonUtils.getArrayAsString(entry.getValue()));
        int[] actualMissedNumbers = Find2MissedNumbersInArray.getMissedNumbers(entry.getKey());
        Arrays.sort(actualMissedNumbers);
        System.out.println("Founded skipped numbers: " + CommonUtils.getArrayAsString(actualMissedNumbers));
        Assert.assertTrue(Arrays.equals(expectedMissedNumbers, actualMissedNumbers));
    }

}
