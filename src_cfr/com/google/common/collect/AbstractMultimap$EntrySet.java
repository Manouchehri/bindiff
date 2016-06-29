/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$1;
import com.google.common.collect.AbstractMultimap$Entries;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$EntrySet
extends AbstractMultimap$Entries
implements Set {
    final /* synthetic */ AbstractMultimap this$0;

    private AbstractMultimap$EntrySet(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
        super(abstractMultimap, null);
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Sets.equalsImpl(this, object);
    }

    /* synthetic */ AbstractMultimap$EntrySet(AbstractMultimap abstractMultimap, AbstractMultimap$1 abstractMultimap$1) {
        this(abstractMultimap);
    }
}

