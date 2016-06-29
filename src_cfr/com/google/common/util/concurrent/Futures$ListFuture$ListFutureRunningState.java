/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.CollectionFuture$CollectionFutureRunningState;
import com.google.common.util.concurrent.Futures$ListFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class Futures$ListFuture$ListFutureRunningState
extends CollectionFuture$CollectionFutureRunningState {
    final /* synthetic */ Futures$ListFuture this$0;

    Futures$ListFuture$ListFutureRunningState(Futures$ListFuture futures$ListFuture, ImmutableCollection immutableCollection, boolean bl2) {
        this.this$0 = futures$ListFuture;
        super(futures$ListFuture, immutableCollection, bl2);
    }

    @Override
    public List combine(List list) {
        ArrayList arrayList = Lists.newArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Optional optional = (Optional)iterator.next();
            arrayList.add(optional != null ? optional.orNull() : null);
        }
        return Collections.unmodifiableList(arrayList);
    }
}

