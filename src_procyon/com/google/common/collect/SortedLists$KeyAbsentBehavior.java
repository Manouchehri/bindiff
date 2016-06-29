package com.google.common.collect;

public enum SortedLists$KeyAbsentBehavior
{
    NEXT_LOWER("NEXT_LOWER", 0), 
    NEXT_HIGHER("NEXT_HIGHER", 1), 
    INVERTED_INSERTION_INDEX("INVERTED_INSERTION_INDEX", 2);
    
    private SortedLists$KeyAbsentBehavior(final String s, final int n) {
    }
    
    abstract int resultIndex(final int p0);
}
