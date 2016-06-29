/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$2$1
extends Splitter$SplittingIterator {
    final /* synthetic */ Splitter$2 this$0;

    Splitter$2$1(Splitter$2 var1_1, Splitter splitter, CharSequence charSequence) {
        this.this$0 = var1_1;
        super(splitter, charSequence);
    }

    @Override
    public int separatorStart(int n2) {
        int n3 = this.this$0.val$separator.length();
        int n4 = n2;
        int n5 = this.toSplit.length() - n3;
        block0 : while (n4 <= n5) {
            int n6 = 0;
            while (n6 < n3) {
                if (this.toSplit.charAt(n6 + n4) != this.this$0.val$separator.charAt(n6)) {
                    ++n4;
                    continue block0;
                }
                ++n6;
            }
            return n4;
            break;
        }
        return -1;
    }

    @Override
    public int separatorEnd(int n2) {
        return n2 + this.this$0.val$separator.length();
    }
}

