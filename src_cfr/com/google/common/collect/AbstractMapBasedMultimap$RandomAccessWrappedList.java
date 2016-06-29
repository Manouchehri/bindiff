/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$RandomAccessWrappedList
extends AbstractMapBasedMultimap$WrappedList
implements RandomAccess {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, List list, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, list, abstractMapBasedMultimap$WrappedCollection);
    }
}

