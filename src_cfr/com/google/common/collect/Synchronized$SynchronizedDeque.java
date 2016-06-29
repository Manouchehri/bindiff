/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Synchronized$SynchronizedQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtIncompatible(value="Deque")
final class Synchronized$SynchronizedDeque
extends Synchronized$SynchronizedQueue
implements Deque {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedDeque(Deque deque, @Nullable Object object) {
        super(deque, object);
    }

    @Override
    Deque delegate() {
        return (Deque)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addFirst(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.delegate().addFirst(object);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addLast(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.delegate().addLast(object);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offerFirst(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().offerFirst(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offerLast(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().offerLast(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object removeFirst() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().removeFirst();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object removeLast() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().removeLast();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object pollFirst() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().pollFirst();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object pollLast() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().pollLast();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getFirst() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().getFirst();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getLast() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().getLast();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object peekFirst() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().peekFirst();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object peekLast() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().peekLast();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeFirstOccurrence(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeFirstOccurrence(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeLastOccurrence(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeLastOccurrence(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void push(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.delegate().push(object);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object pop() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().pop();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Iterator descendingIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().descendingIterator();
        }
    }
}

