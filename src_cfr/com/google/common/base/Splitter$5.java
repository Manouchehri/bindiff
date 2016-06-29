/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Iterator;

class Splitter$5
implements Iterable {
    final /* synthetic */ CharSequence val$sequence;
    final /* synthetic */ Splitter this$0;

    Splitter$5(Splitter splitter, CharSequence charSequence) {
        this.this$0 = splitter;
        this.val$sequence = charSequence;
    }

    public Iterator iterator() {
        return Splitter.access$000(this.this$0, this.val$sequence);
    }

    public String toString() {
        return Joiner.on(", ").appendTo(new StringBuilder().append('['), (Iterable)this).append(']').toString();
    }
}

