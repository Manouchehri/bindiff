package com.google.common.collect;

import java.io.*;

class Range$RangeLexOrdering extends Ordering implements Serializable
{
    private static final long serialVersionUID = 0L;
    
    public int compare(final Range range, final Range range2) {
        return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
    }
}
