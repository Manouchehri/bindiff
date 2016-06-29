/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;

final class Maps$7
implements Maps$EntryTransformer {
    final /* synthetic */ Function val$function;

    Maps$7(Function function) {
        this.val$function = function;
    }

    @Override
    public Object transformEntry(Object object, Object object2) {
        return this.val$function.apply(object2);
    }
}

