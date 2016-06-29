package com.google.common.collect;

import java.util.*;

public enum SortedLists$KeyPresentBehavior
{
    ANY_PRESENT("ANY_PRESENT", 0), 
    LAST_PRESENT("LAST_PRESENT", 1), 
    FIRST_PRESENT("FIRST_PRESENT", 2), 
    FIRST_AFTER("FIRST_AFTER", 3), 
    LAST_BEFORE("LAST_BEFORE", 4);
    
    private SortedLists$KeyPresentBehavior(final String s, final int n) {
    }
    
    abstract int resultIndex(final Comparator p0, final Object p1, final List p2, final int p3);
}
