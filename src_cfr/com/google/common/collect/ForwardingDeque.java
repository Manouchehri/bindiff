/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public abstract class ForwardingDeque
extends ForwardingQueue
implements Deque {
    protected ForwardingDeque() {
    }

    @Override
    protected abstract Deque delegate();

    public void addFirst(Object object) {
        this.delegate().addFirst(object);
    }

    public void addLast(Object object) {
        this.delegate().addLast(object);
    }

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    public Object getFirst() {
        return this.delegate().getFirst();
    }

    public Object getLast() {
        return this.delegate().getLast();
    }

    public boolean offerFirst(Object object) {
        return this.delegate().offerFirst(object);
    }

    public boolean offerLast(Object object) {
        return this.delegate().offerLast(object);
    }

    public Object peekFirst() {
        return this.delegate().peekFirst();
    }

    public Object peekLast() {
        return this.delegate().peekLast();
    }

    public Object pollFirst() {
        return this.delegate().pollFirst();
    }

    public Object pollLast() {
        return this.delegate().pollLast();
    }

    public Object pop() {
        return this.delegate().pop();
    }

    public void push(Object object) {
        this.delegate().push(object);
    }

    public Object removeFirst() {
        return this.delegate().removeFirst();
    }

    public Object removeLast() {
        return this.delegate().removeLast();
    }

    @Override
    public boolean removeFirstOccurrence(Object object) {
        return this.delegate().removeFirstOccurrence(object);
    }

    @Override
    public boolean removeLastOccurrence(Object object) {
        return this.delegate().removeLastOccurrence(object);
    }
}

