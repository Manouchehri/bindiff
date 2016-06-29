/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Receiver;
import java.util.Collection;
import javax.annotation.Nullable;

final class Receivers$CollectingReceiver
implements Receiver {
    private final Collection collection;

    Receivers$CollectingReceiver(Collection collection) {
        this.collection = (Collection)Preconditions.checkNotNull(collection);
    }

    @Override
    public void accept(@Nullable Object object) {
        this.collection.add(object);
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Receivers$CollectingReceiver)) return false;
        Receivers$CollectingReceiver receivers$CollectingReceiver = (Receivers$CollectingReceiver)object;
        if (this.collection != receivers$CollectingReceiver.collection) return false;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.collection);
    }
}

