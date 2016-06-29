/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$1;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Entries;
import java.util.Iterator;

class AbstractMultimap$Entries
extends Multimaps$Entries {
    final /* synthetic */ AbstractMultimap this$0;

    private AbstractMultimap$Entries(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
    }

    @Override
    Multimap multimap() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    /* synthetic */ AbstractMultimap$Entries(AbstractMultimap abstractMultimap, AbstractMultimap$1 abstractMultimap$1) {
        this(abstractMultimap);
    }
}

