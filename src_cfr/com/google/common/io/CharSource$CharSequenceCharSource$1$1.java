/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.collect.AbstractIterator;
import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1;
import java.util.Iterator;

class CharSource$CharSequenceCharSource$1$1
extends AbstractIterator {
    Iterator lines;
    final /* synthetic */ CharSource$CharSequenceCharSource$1 this$1;

    CharSource$CharSequenceCharSource$1$1(CharSource$CharSequenceCharSource$1 charSource$CharSequenceCharSource$1) {
        this.this$1 = charSource$CharSequenceCharSource$1;
        this.lines = CharSource$CharSequenceCharSource.access$200().split(CharSource$CharSequenceCharSource.access$100(this.this$1.this$0)).iterator();
    }

    @Override
    protected String computeNext() {
        if (!this.lines.hasNext()) return (String)this.endOfData();
        String string = (String)this.lines.next();
        if (this.lines.hasNext()) return string;
        if (string.isEmpty()) return (String)this.endOfData();
        return string;
    }
}

