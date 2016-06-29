package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$AsMap$AsMapEntries extends Maps$EntrySet
{
    final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;
    
    AbstractMapBasedMultimap$AsMap$AsMapEntries(final AbstractMapBasedMultimap$AsMap this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    Map map() {
        return this.this$1;
    }
    
    @Override
    public Iterator iterator() {
        return new AbstractMapBasedMultimap$AsMap$AsMapIterator(this.this$1);
    }
    
    @Override
    public boolean contains(final Object o) {
        return Collections2.safeContains(this.this$1.submap.entrySet(), o);
    }
    
    @Override
    public boolean remove(final Object o) {
        if (!this.contains(o)) {
            return false;
        }
        this.this$1.this$0.removeValuesForKey(((Map.Entry)o).getKey());
        return true;
    }
}
