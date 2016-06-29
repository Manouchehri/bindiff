package com.google.common.hash;

import java.io.*;

interface BloomFilter$Strategy extends Serializable
{
    boolean put(final Object p0, final Funnel p1, final int p2, final BloomFilterStrategies$BitArray p3);
    
    boolean mightContain(final Object p0, final Funnel p1, final int p2, final BloomFilterStrategies$BitArray p3);
    
    int ordinal();
}
