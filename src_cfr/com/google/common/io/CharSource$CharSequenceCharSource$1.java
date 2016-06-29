/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1$1;
import java.util.Iterator;

class CharSource$CharSequenceCharSource$1
implements Iterable {
    final /* synthetic */ CharSource$CharSequenceCharSource this$0;

    CharSource$CharSequenceCharSource$1(CharSource$CharSequenceCharSource charSource$CharSequenceCharSource) {
        this.this$0 = charSource$CharSequenceCharSource;
    }

    public Iterator iterator() {
        return new CharSource$CharSequenceCharSource$1$1(this);
    }
}

