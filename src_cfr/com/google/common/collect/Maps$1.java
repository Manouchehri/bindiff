/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

final class Maps$1
extends TransformedIterator {
    final /* synthetic */ Function val$function;

    Maps$1(Iterator iterator, Function function) {
        this.val$function = function;
        super(iterator);
    }

    @Override
    Map.Entry transform(Object object) {
        return Maps.immutableEntry(object, this.val$function.apply(object));
    }
}

