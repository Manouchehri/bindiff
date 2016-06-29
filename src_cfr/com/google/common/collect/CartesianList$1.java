/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.ImmutableList;
import java.util.List;

class CartesianList$1
extends ImmutableList {
    final /* synthetic */ int val$index;
    final /* synthetic */ CartesianList this$0;

    CartesianList$1(CartesianList cartesianList, int n2) {
        this.this$0 = cartesianList;
        this.val$index = n2;
    }

    @Override
    public int size() {
        return CartesianList.access$000(this.this$0).size();
    }

    public Object get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        int n3 = CartesianList.access$100(this.this$0, this.val$index, n2);
        return ((List)CartesianList.access$000(this.this$0).get(n2)).get(n3);
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

