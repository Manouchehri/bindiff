package com.google.security.zynamics.zylib.general;

import com.google.common.base.*;
import java.util.*;
import java.lang.ref.*;

public class ListenerProvider implements Iterable
{
    private volatile Collection m_listeners;
    
    public void addListener(final Object o) {
        Preconditions.checkNotNull(o, (Object)"Internal Error: Listener cannot be null");
        if (this.m_listeners == null) {
            synchronized (this) {
                if (this.m_listeners == null) {
                    this.m_listeners = new LinkedHashSet();
                }
            }
        }
        synchronized (this.m_listeners) {
            if (!this.m_listeners.add(new ListenerProvider$ComparableReference(this, o))) {}
        }
    }
    
    @Override
    public Iterator iterator() {
        if (this.m_listeners == null) {
            return Collections.emptyIterator();
        }
        final ArrayList<WeakReference<Object>> list;
        synchronized (this.m_listeners) {
            list = new ArrayList<WeakReference<Object>>(this.m_listeners);
        }
        final ArrayList<Object> list2 = new ArrayList<Object>();
        final Iterator<WeakReference<Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            final Object value = iterator.next().get();
            if (value != null) {
                list2.add(value);
            }
        }
        return list2.iterator();
    }
    
    public void removeListener(final Object o) {
        Preconditions.checkNotNull(o, (Object)"Internal Error: Listener cannot be null");
        if (this.m_listeners != null) {
            synchronized (this.m_listeners) {
                if (!this.m_listeners.remove(new ListenerProvider$ComparableReference(this, o))) {}
            }
        }
    }
}
