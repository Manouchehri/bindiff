/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider$ComparableReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ListenerProvider
implements Iterable {
    private volatile Collection m_listeners;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(Object object) {
        Preconditions.checkNotNull(object, "Internal Error: Listener cannot be null");
        if (this.m_listeners == null) {
            ListenerProvider listenerProvider = this;
            synchronized (listenerProvider) {
                if (this.m_listeners == null) {
                    this.m_listeners = new LinkedHashSet();
                }
            }
        }
        Collection collection = this.m_listeners;
        synchronized (collection) {
            if (this.m_listeners.add(new ListenerProvider$ComparableReference(this, object))) return;
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Iterator iterator() {
        ArrayList arrayList;
        if (this.m_listeners == null) {
            return Collections.emptyIterator();
        }
        ArrayList arrayList2 = this.m_listeners;
        synchronized (arrayList2) {
            arrayList = new ArrayList(this.m_listeners);
        }
        arrayList2 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator.next();
            Object t2 = weakReference.get();
            if (t2 == null) continue;
            arrayList2.add(t2);
        }
        return arrayList2.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(Object object) {
        Preconditions.checkNotNull(object, "Internal Error: Listener cannot be null");
        if (this.m_listeners == null) return;
        Collection collection = this.m_listeners;
        synchronized (collection) {
            if (this.m_listeners.remove(new ListenerProvider$ComparableReference(this, object))) return;
            return;
        }
    }
}

