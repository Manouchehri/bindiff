/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSet
extends AbstractMapBasedMultimap$WrappedCollection
implements Set {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$WrappedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, Set set) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, set, null);
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int n2 = this.size();
        boolean bl2 = Sets.removeAllImpl((Set)this.delegate, collection);
        if (!bl2) return bl2;
        int n3 = this.delegate.size();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (n3 - n2));
        this.removeIfEmpty();
        return bl2;
    }
}

