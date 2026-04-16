package com.baeldung.algorithms.sockmerchant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

import org.junit.Test;

public class SockMerchantUnitTest {
    @Test
    public void givenSockArray_whenUsingArray_thenReturnsCorrectPairCount() {
        SockMerchant merchant = new SockMerchant();
        int[] colorSock = {11, 22, 22, 11, 33, 3, 33, 111111, 222222};
        int expectedPairs = 3;
        int colorMax = Arrays.stream(colorSock).max().getAsInt();
        colorMax += 1;
        int actualPairs = merchant.countPairsWithArray(colorSock.length, colorSock, colorMax);
        assertEquals(expectedPairs, actualPairs);
    }

    @Test
    public void givenSockArray_whenUsingSet_thenReturnsCorrectPairCount() {
        SockMerchant merchant = new SockMerchant();
        int[] colorSock = {11, 22, 22, 11, 33, 3, 33, 111111, 222222};
        int expectedPairs = 3;
        int actualPairs = merchant.countPairsWithSet(colorSock);
        assertEquals(expectedPairs, actualPairs);
    }
}
