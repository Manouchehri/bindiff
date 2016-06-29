/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1
implements Function {
    final /* synthetic */ Collection val$collection;

    Collections2$1(Collection collection) {
        this.val$collection = collection;
    }

    @Override
    public Object apply(Object object) {
        if (object == this.val$collection) {
            return "(this Collection)";
        }
        Object object2 = object;
        return object2;
    }
}

