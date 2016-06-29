package com.google.common.collect;

public interface Multiset$Entry
{
    Object getElement();
    
    int getCount();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    String toString();
}
