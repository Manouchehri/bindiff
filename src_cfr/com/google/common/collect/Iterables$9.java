/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$9
extends FluentIterable {
    final /* synthetic */ Iterable val$fromIterable;
    final /* synthetic */ Function val$function;

    Iterables$9(Iterable iterable, Function function) {
        this.val$fromIterable = iterable;
        this.val$function = function;
    }

    public Iterator iterator() {
        return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
    }
}

