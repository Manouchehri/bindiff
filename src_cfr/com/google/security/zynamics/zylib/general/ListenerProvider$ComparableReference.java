/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.lang.ref.WeakReference;

public class ListenerProvider$ComparableReference
extends WeakReference {
    final /* synthetic */ ListenerProvider this$0;

    public ListenerProvider$ComparableReference(ListenerProvider listenerProvider, Object object) {
        this.this$0 = listenerProvider;
        super(object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        ListenerProvider$ComparableReference listenerProvider$ComparableReference = (ListenerProvider$ComparableReference)object;
        Object t2 = this.get();
        Object t3 = listenerProvider$ComparableReference.get();
        if (t2 == null && t3 == null) {
            return true;
        }
        if (t2 == null) return false;
        if (t3 != null) return t2.equals(t3);
        return false;
    }

    public int hashCode() {
        Object t2 = this.get();
        if (t2 == null) {
            return 0;
        }
        int n2 = t2.hashCode();
        return n2;
    }
}

