package com.google.common.collect;

import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedSet extends AbstractMapBasedMultimap$WrappedCollection implements Set
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$WrappedSet(final AbstractMapBasedMultimap this$0, @Nullable final Object o, final Set set) {
        this.this$0 = this$0;
        super(this$0, o, set, null);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        final int size = this.size();
        final boolean removeAllImpl = Sets.removeAllImpl((Set)this.delegate, collection);
        if (removeAllImpl) {
            this.this$0.totalSize += this.delegate.size() - size;
            this.removeIfEmpty();
        }
        return removeAllImpl;
    }
}
