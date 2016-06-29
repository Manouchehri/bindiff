/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1
extends AbstractSequentialList {
    final /* synthetic */ Object val$key;
    final /* synthetic */ LinkedListMultimap this$0;

    LinkedListMultimap$1(LinkedListMultimap linkedListMultimap, Object object) {
        this.this$0 = linkedListMultimap;
        this.val$key = object;
    }

    @Override
    public int size() {
        LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(this.this$0).get(this.val$key);
        if (linkedListMultimap$KeyList == null) {
            return 0;
        }
        int n2 = linkedListMultimap$KeyList.count;
        return n2;
    }

    @Override
    public ListIterator listIterator(int n2) {
        return new LinkedListMultimap$ValueForKeyIterator(this.this$0, this.val$key, n2);
    }
}

