/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import java.util.Collection;

class Multimaps$AsMap$EntrySet$1
implements Function {
    final /* synthetic */ Multimaps$AsMap$EntrySet this$1;

    Multimaps$AsMap$EntrySet$1(Multimaps$AsMap$EntrySet entrySet) {
        this.this$1 = entrySet;
    }

    @Override
    public Collection apply(Object object) {
        return Multimaps$AsMap.access$200(this.this$1.this$0).get(object);
    }
}

