package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import java.util.*;

class Multimaps$AsMap$EntrySet extends Maps$EntrySet
{
    final /* synthetic */ Multimaps$AsMap this$0;
    
    Multimaps$AsMap$EntrySet(final Multimaps$AsMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$0.multimap.keySet(), new Multimaps$AsMap$EntrySet$1(this));
    }
    
    @Override
    public boolean remove(final Object o) {
        if (!this.contains(o)) {
            return false;
        }
        this.this$0.removeValuesForKey(((Map.Entry)o).getKey());
        return true;
    }
}
