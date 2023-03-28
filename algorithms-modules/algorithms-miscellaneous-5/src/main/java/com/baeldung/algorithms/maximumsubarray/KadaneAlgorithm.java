package com.baeldung.algorithms.maximumsubarray;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KadaneAlgorithm {

    private Logger logger = LoggerFactory.getLogger(BruteForceAlgorithm.class.getName());

    public int maxSubArray(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < size; i++) {

            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        logger.info("{} - Found Maximum Subarray between {} and {} = {}", Arrays.toString(arr), Math.min(start, end), end, maxSoFar);
        return maxSoFar;
    }

    public int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currSum = arr[0];
        int start = 0;
        int end = 0;
        int currStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currSum + arr[i] < arr[i]) {
                currSum = arr[i];
                currStart = i;
            } else {
                currSum += arr[i];
            }

            if (currSum > maxSoFar) {
                maxSoFar = currSum;
                start = currStart;
                end = i;
            }
        }

        logger.info("{} - Found Maximum Subarray between {} and {} = {}", Arrays.toString(arr), start, end, maxSoFar);
        return maxSoFar;
    }
}
