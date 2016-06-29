package com.google.common.collect;

import java.util.*;

class Multimaps$TransformedEntriesMultimap$1 implements Maps$EntryTransformer
{
    final /* synthetic */ Multimaps$TransformedEntriesMultimap this$0;
    
    Multimaps$TransformedEntriesMultimap$1(final Multimaps$TransformedEntriesMultimap this$0) {
        this.this$0 = this$0;
    }
    
    public Collection transformEntry(final Object o, final Collection collection) {
        return this.this$0.transform(o, collection);
    }
}
