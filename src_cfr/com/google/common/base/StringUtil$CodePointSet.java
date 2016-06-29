/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CodePointSet$Builder;
import java.util.Set;

class StringUtil$CodePointSet {
    boolean[] fastArray;
    Set elements;

    private StringUtil$CodePointSet(Set set) {
        this.elements = set;
        this.fastArray = new boolean[256];
        int n2 = 0;
        while (n2 < this.fastArray.length) {
            this.fastArray[n2] = this.elements.contains(n2);
            ++n2;
        }
    }

    boolean contains(int n2) {
        if (n2 >= this.fastArray.length) return this.elements.contains(n2);
        return this.fastArray[n2];
    }

    StringUtil$CodePointSet or(StringUtil$CodePointSet stringUtil$CodePointSet) {
        return new StringUtil$CodePointSet$Builder().addSet(this).addSet(stringUtil$CodePointSet).create();
    }

    /* synthetic */ StringUtil$CodePointSet(Set set, StringUtil$1 stringUtil$1) {
        this(set);
    }
}

