package com.google.common.base;

import java.util.*;

class StringUtil$CodePointSet
{
    boolean[] fastArray;
    Set elements;
    
    private StringUtil$CodePointSet(final Set elements) {
        this.elements = elements;
        this.fastArray = new boolean[256];
        for (int i = 0; i < this.fastArray.length; ++i) {
            this.fastArray[i] = this.elements.contains(i);
        }
    }
    
    boolean contains(final int n) {
        if (n < this.fastArray.length) {
            return this.fastArray[n];
        }
        return this.elements.contains(n);
    }
    
    StringUtil$CodePointSet or(final StringUtil$CodePointSet set) {
        return new StringUtil$CodePointSet$Builder().addSet(this).addSet(set).create();
    }
}
