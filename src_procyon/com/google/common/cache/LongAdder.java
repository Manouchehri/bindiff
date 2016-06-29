package com.google.common.cache;

import com.google.common.annotations.*;
import java.io.*;

@GwtCompatible(emulated = true)
final class LongAdder extends Striped64 implements LongAddable, Serializable
{
    private static final long serialVersionUID = 7249069246863182397L;
    
    @Override
    final long fn(final long n, final long n2) {
        return n + n2;
    }
    
    @Override
    public void add(final long n) {
        final Striped64$Cell[] cells;
        if ((cells = this.cells) == null) {
            final long base = this.base;
            if (this.casBase(base, base + n)) {
                return;
            }
        }
        boolean cas = true;
        final int[] array;
        final int length;
        final Striped64$Cell striped64$Cell;
        if ((array = LongAdder.threadHashCode.get()) != null && cells != null && (length = cells.length) >= 1 && (striped64$Cell = cells[length - 1 & array[0]]) != null) {
            final Striped64$Cell striped64$Cell2 = striped64$Cell;
            final long value = striped64$Cell.value;
            if (cas = striped64$Cell2.cas(value, value + n)) {
                return;
            }
        }
        this.retryUpdate(n, array, cas);
    }
    
    @Override
    public void increment() {
        this.add(1L);
    }
    
    public void decrement() {
        this.add(-1L);
    }
    
    @Override
    public long sum() {
        long base = this.base;
        final Striped64$Cell[] cells = this.cells;
        if (cells != null) {
            for (final Striped64$Cell striped64$Cell : cells) {
                if (striped64$Cell != null) {
                    base += striped64$Cell.value;
                }
            }
        }
        return base;
    }
    
    public void reset() {
        this.internalReset(0L);
    }
    
    public long sumThenReset() {
        long base = this.base;
        final Striped64$Cell[] cells = this.cells;
        this.base = 0L;
        if (cells != null) {
            for (final Striped64$Cell striped64$Cell : cells) {
                if (striped64$Cell != null) {
                    base += striped64$Cell.value;
                    striped64$Cell.value = 0L;
                }
            }
        }
        return base;
    }
    
    @Override
    public String toString() {
        return Long.toString(this.sum());
    }
    
    @Override
    public long longValue() {
        return this.sum();
    }
    
    @Override
    public int intValue() {
        return (int)this.sum();
    }
    
    @Override
    public float floatValue() {
        return this.sum();
    }
    
    @Override
    public double doubleValue() {
        return this.sum();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.sum());
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }
}
