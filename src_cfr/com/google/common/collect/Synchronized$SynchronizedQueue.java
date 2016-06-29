/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Queue;
import javax.annotation.Nullable;

class Synchronized$SynchronizedQueue
extends Synchronized$SynchronizedCollection
implements Queue {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedQueue(Queue queue, @Nullable Object object) {
        super(queue, object, null);
    }

    @Override
    Queue delegate() {
        return (Queue)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object element() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().element();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean offer(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().offer(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object peek() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().peek();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object poll() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().poll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object remove() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().remove();
        }
    }
}

