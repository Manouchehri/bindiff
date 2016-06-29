package org.jfree.util;

import java.io.*;
import java.util.*;

public final class FastStack implements Serializable, Cloneable
{
    private Object[] contents;
    private int size;
    private int initialSize;
    
    public FastStack() {
        this.initialSize = 10;
    }
    
    public FastStack(final int n) {
        this.initialSize = Math.max(1, n);
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public void push(final Object o) {
        if (this.contents == null) {
            (this.contents = new Object[this.initialSize])[0] = o;
            this.size = 1;
            return;
        }
        final int size = this.size;
        ++this.size;
        if (this.contents.length == this.size) {
            final Object[] contents = new Object[this.size + this.initialSize];
            System.arraycopy(this.contents, 0, contents, 0, this.size);
            this.contents = contents;
        }
        this.contents[size] = o;
    }
    
    public Object peek() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return this.contents[this.size - 1];
    }
    
    public Object pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        --this.size;
        final Object o = this.contents[this.size];
        this.contents[this.size] = null;
        return o;
    }
    
    public Object clone() {
        try {
            final FastStack fastStack = (FastStack)super.clone();
            if (this.contents != null) {
                fastStack.contents = this.contents.clone();
            }
            return fastStack;
        }
        catch (CloneNotSupportedException ex) {
            throw new IllegalStateException("Clone not supported? Why?");
        }
    }
    
    public void clear() {
        this.size = 0;
        if (this.contents != null) {
            Arrays.fill(this.contents, null);
        }
    }
    
    public Object get(final int n) {
        if (n >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.contents[n];
    }
}
