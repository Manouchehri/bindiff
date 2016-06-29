/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;
import javax.annotation.Nullable;

final class Maps$8
implements Function {
    final /* synthetic */ Maps$EntryTransformer val$transformer;
    final /* synthetic */ Object val$key;

    Maps$8(Maps$EntryTransformer maps$EntryTransformer, Object object) {
        this.val$transformer = maps$EntryTransformer;
        this.val$key = object;
    }

    @Override
    public Object apply(@Nullable Object object) {
        return this.val$transformer.transformEntry(this.val$key, object);
    }
}

