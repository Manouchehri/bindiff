package com.google.common.base;

import javax.annotation.*;
import java.util.regex.*;
import java.util.*;
import com.google.common.annotations.*;

abstract class Splitter$SplittingIterator extends AbstractIterator
{
    final CharSequence toSplit;
    final CharMatcher trimmer;
    final boolean omitEmptyStrings;
    int offset;
    int limit;
    
    abstract int separatorStart(final int p0);
    
    abstract int separatorEnd(final int p0);
    
    protected Splitter$SplittingIterator(final Splitter splitter, final CharSequence toSplit) {
        this.offset = 0;
        this.trimmer = splitter.trimmer;
        this.omitEmptyStrings = splitter.omitEmptyStrings;
        this.limit = splitter.limit;
        this.toSplit = toSplit;
    }
    
    @Override
    protected String computeNext() {
        int n = this.offset;
        while (this.offset != -1) {
            int n2 = n;
            final int separatorStart = this.separatorStart(this.offset);
            int n3;
            if (separatorStart == -1) {
                n3 = this.toSplit.length();
                this.offset = -1;
            }
            else {
                n3 = separatorStart;
                this.offset = this.separatorEnd(separatorStart);
            }
            if (this.offset == n) {
                ++this.offset;
                if (this.offset < this.toSplit.length()) {
                    continue;
                }
                this.offset = -1;
            }
            else {
                while (n2 < n3 && this.trimmer.matches(this.toSplit.charAt(n2))) {
                    ++n2;
                }
                while (n3 > n2 && this.trimmer.matches(this.toSplit.charAt(n3 - 1))) {
                    --n3;
                }
                if (!this.omitEmptyStrings || n2 != n3) {
                    if (this.limit == 1) {
                        n3 = this.toSplit.length();
                        this.offset = -1;
                        while (n3 > n2 && this.trimmer.matches(this.toSplit.charAt(n3 - 1))) {
                            --n3;
                        }
                    }
                    else {
                        --this.limit;
                    }
                    return this.toSplit.subSequence(n2, n3).toString();
                }
                n = this.offset;
            }
        }
        return (String)this.endOfData();
    }
}
