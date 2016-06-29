/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map;

final class Maps$9
implements Function {
    final /* synthetic */ Maps$EntryTransformer val$transformer;

    Maps$9(Maps$EntryTransformer maps$EntryTransformer) {
        this.val$transformer = maps$EntryTransformer;
    }

    public Object apply(Map.Entry entry) {
        return this.val$transformer.transformEntry(entry.getKey(), entry.getValue());
    }
}

