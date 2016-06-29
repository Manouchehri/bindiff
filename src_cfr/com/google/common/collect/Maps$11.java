/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map;

final class Maps$11
implements Function {
    final /* synthetic */ Maps$EntryTransformer val$transformer;

    Maps$11(Maps$EntryTransformer maps$EntryTransformer) {
        this.val$transformer = maps$EntryTransformer;
    }

    public Map.Entry apply(Map.Entry entry) {
        return Maps.transformEntry(this.val$transformer, entry);
    }
}

