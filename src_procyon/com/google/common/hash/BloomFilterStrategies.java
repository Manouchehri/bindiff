package com.google.common.hash;

enum BloomFilterStrategies implements BloomFilter$Strategy
{
    MURMUR128_MITZ_32("MURMUR128_MITZ_32", 0), 
    MURMUR128_MITZ_64("MURMUR128_MITZ_64", 1);
    
    private BloomFilterStrategies(final String s, final int n) {
    }
}
