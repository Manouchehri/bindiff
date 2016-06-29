/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import java.util.Collection;

class Multimaps$TransformedEntriesMultimap$1
implements Maps$EntryTransformer {
    final /* synthetic */ Multimaps$TransformedEntriesMultimap this$0;

    Multimaps$TransformedEntriesMultimap$1(Multimaps$TransformedEntriesMultimap multimaps$TransformedEntriesMultimap) {
        this.this$0 = multimaps$TransformedEntriesMultimap;
    }

    public Collection transformEntry(Object object, Collection collection) {
        return this.this$0.transform(object, collection);
    }
}

