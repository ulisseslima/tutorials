package com.baeldung.algorithms.sockmerchant;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;

public class SockMerchant {
    public int countPairsWithArray(int n, @Nonnull int[] colorSock, int k) {
        int[] freqSock = new int[k];
        int pairCount = 0;
        for (int i = 0; i < n; i++) {
            freqSock[colorSock[i]]++;
        }
        for (int count : freqSock) {
            pairCount += count / 2;
        }
        return pairCount;
    }

    public int countPairsWithSet(@Nonnull int[] colorSock) {
        Set<Integer> unmatchedSocks = new HashSet<>();
        int pairCount = 0;
        for (int sock : colorSock) {
            if (unmatchedSocks.contains(sock)) {
                pairCount++;
                unmatchedSocks.remove(sock);
            } else {
                unmatchedSocks.add(sock);
            }
        }
        return pairCount;
    }
}
