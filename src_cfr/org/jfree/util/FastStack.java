/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class FastStack
implements Serializable,
Cloneable {
    private Object[] contents;
    private int size;
    private int initialSize;

    public FastStack() {
        this.initialSize = 10;
    }

    public FastStack(int n2) {
        this.initialSize = Math.max(1, n2);
    }

    public boolean isEmpty() {
        if (this.size != 0) return false;
        return true;
    }

    public int size() {
        return this.size;
    }

    public void push(Object object) {
        if (this.contents == null) {
            this.contents = new Object[this.initialSize];
            this.contents[0] = object;
            this.size = 1;
            return;
        }
        int n2 = this.size++;
        if (this.contents.length == this.size) {
            Object[] arrobject = new Object[this.size + this.initialSize];
            System.arraycopy(this.contents, 0, arrobject, 0, this.size);
            this.contents = arrobject;
        }
        this.contents[n2] = object;
    }

    public Object peek() {
        if (this.size != 0) return this.contents[this.size - 1];
        throw new EmptyStackException();
    }

    public Object pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        --this.size;
        Object object = this.contents[this.size];
        this.contents[this.size] = null;
        return object;
    }

    public Object clone() {
        try {
            FastStack fastStack = (FastStack)super.clone();
            if (this.contents == null) return fastStack;
            fastStack.contents = (Object[])this.contents.clone();
            return fastStack;
        }
        catch (CloneNotSupportedException var1_2) {
            throw new IllegalStateException("Clone not supported? Why?");
        }
    }

    public void clear() {
        this.size = 0;
        if (this.contents == null) return;
        Arrays.fill(this.contents, null);
    }

    public Object get(int n2) {
        if (n2 < this.size) return this.contents[n2];
        throw new IndexOutOfBoundsException();
    }
}

