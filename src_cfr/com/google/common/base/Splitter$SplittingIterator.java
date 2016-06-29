/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

abstract class Splitter$SplittingIterator
extends AbstractIterator {
    final CharSequence toSplit;
    final CharMatcher trimmer;
    final boolean omitEmptyStrings;
    int offset = 0;
    int limit;

    abstract int separatorStart(int var1);

    abstract int separatorEnd(int var1);

    protected Splitter$SplittingIterator(Splitter splitter, CharSequence charSequence) {
        this.trimmer = Splitter.access$200(splitter);
        this.omitEmptyStrings = Splitter.access$300(splitter);
        this.limit = Splitter.access$400(splitter);
        this.toSplit = charSequence;
    }

    @Override
    protected String computeNext() {
        int n2;
        int n3;
        block9 : {
            int n4 = this.offset;
            while (this.offset != -1) {
                n2 = n4;
                int n5 = this.separatorStart(this.offset);
                if (n5 == -1) {
                    n3 = this.toSplit.length();
                    this.offset = -1;
                } else {
                    n3 = n5;
                    this.offset = this.separatorEnd(n5);
                }
                if (this.offset == n4) {
                    ++this.offset;
                    if (this.offset < this.toSplit.length()) continue;
                    this.offset = -1;
                    continue;
                }
                while (n2 < n3 && this.trimmer.matches(this.toSplit.charAt(n2))) {
                    ++n2;
                }
                while (n3 > n2 && this.trimmer.matches(this.toSplit.charAt(n3 - 1))) {
                    --n3;
                }
                if (this.omitEmptyStrings && n2 == n3) {
                    n4 = this.offset;
                    continue;
                }
                break block9;
            }
            return (String)this.endOfData();
        }
        if (this.limit != 1) {
            --this.limit;
            return this.toSplit.subSequence(n2, n3).toString();
        }
        n3 = this.toSplit.length();
        this.offset = -1;
        while (n3 > n2) {
            if (!this.trimmer.matches(this.toSplit.charAt(n3 - 1))) return this.toSplit.subSequence(n2, n3).toString();
            --n3;
        }
        return this.toSplit.subSequence(n2, n3).toString();
    }
}

