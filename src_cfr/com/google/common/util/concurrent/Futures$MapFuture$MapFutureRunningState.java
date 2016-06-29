/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.Pair;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.CollectionFuture$CollectionFutureRunningState;
import com.google.common.util.concurrent.Futures$MapFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class Futures$MapFuture$MapFutureRunningState
extends CollectionFuture$CollectionFutureRunningState {
    @Nullable
    ImmutableMap futures;
    final /* synthetic */ Futures$MapFuture this$0;

    Futures$MapFuture$MapFutureRunningState(Futures$MapFuture futures$MapFuture, ImmutableMap immutableMap, boolean bl2) {
        this.this$0 = futures$MapFuture;
        super(futures$MapFuture, immutableMap.values(), bl2);
        this.futures = immutableMap;
    }

    @Override
    public Map combine(List list) {
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        Iterator iterator = Iterables.pairUp(this.futures.keySet(), list).iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            if (pair.second == null) continue;
            linkedHashMap.put(pair.first, ((Optional)pair.second).orNull());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.futures = null;
    }
}

