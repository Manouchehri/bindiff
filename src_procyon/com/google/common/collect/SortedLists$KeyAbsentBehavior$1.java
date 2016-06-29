package com.google.common.collect;

enum SortedLists$KeyAbsentBehavior$1
{
    SortedLists$KeyAbsentBehavior$1(final String s, final int n) {
    }
    
    @Override
    int resultIndex(final int n) {
        return n - 1;
    }
}
