package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$1 extends AbstractSequentialList
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ LinkedListMultimap this$0;
    
    LinkedListMultimap$1(final LinkedListMultimap this$0, final Object val$key) {
        this.this$0 = this$0;
        this.val$key = val$key;
    }
    
    @Override
    public int size() {
        final LinkedListMultimap$KeyList list = this.this$0.keyToKeyList.get(this.val$key);
        return (list == null) ? 0 : list.count;
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return new LinkedListMultimap$ValueForKeyIterator(this.this$0, this.val$key, n);
    }
}
