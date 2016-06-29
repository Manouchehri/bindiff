package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Multimaps$Keys$KeysEntrySet extends Multisets$EntrySet
{
    final /* synthetic */ Multimaps$Keys this$0;
    
    Multimaps$Keys$KeysEntrySet(final Multimaps$Keys this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Multiset multiset() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }
    
    @Override
    public int size() {
        return this.this$0.distinctElements();
    }
    
    @Override
    public boolean isEmpty() {
        return this.this$0.multimap.isEmpty();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            final Collection collection = this.this$0.multimap.asMap().get(multiset$Entry.getElement());
            return collection != null && collection.size() == multiset$Entry.getCount();
        }
        return false;
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            final Collection collection = this.this$0.multimap.asMap().get(multiset$Entry.getElement());
            if (collection != null && collection.size() == multiset$Entry.getCount()) {
                collection.clear();
                return true;
            }
        }
        return false;
    }
}
