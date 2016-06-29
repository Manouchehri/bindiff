/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

final class Iterators$9
extends TransformedIterator {
    final /* synthetic */ Function val$function;

    Iterators$9(Iterator iterator, Function function) {
        this.val$function = function;
        super(iterator);
    }

    @Override
    Object transform(Object object) {
        return this.val$function.apply(object);
    }
}

