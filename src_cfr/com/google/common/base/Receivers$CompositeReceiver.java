/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Receiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Receivers$CompositeReceiver
implements Receiver {
    private final List receivers;

    Receivers$CompositeReceiver(Iterable iterable) {
        this.receivers = Receivers$CompositeReceiver.copy(iterable);
    }

    @Override
    public void accept(@Nullable Object object) {
        Iterator iterator = this.receivers.iterator();
        while (iterator.hasNext()) {
            Receiver receiver = (Receiver)iterator.next();
            receiver.accept(object);
        }
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Receivers$CompositeReceiver)) return false;
        Receivers$CompositeReceiver receivers$CompositeReceiver = (Receivers$CompositeReceiver)object;
        return this.receivers.equals(receivers$CompositeReceiver.receivers);
    }

    public int hashCode() {
        return this.receivers.hashCode();
    }

    public String toString() {
        String string = Joiner.on(", ").join(this.receivers);
        return new StringBuilder(19 + String.valueOf(string).length()).append("Receivers.compose(").append(string).append(")").toString();
    }

    private static List copy(Iterable iterable) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            arrayList.add(Preconditions.checkNotNull(t2));
        }
        return arrayList;
    }
}

