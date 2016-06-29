/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicDouble
extends Number
implements Serializable {
    private static final long serialVersionUID = 0;
    private volatile transient long value;
    private static final AtomicLongFieldUpdater updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "value");

    public AtomicDouble(double d2) {
        this.value = Double.doubleToRawLongBits(d2);
    }

    public AtomicDouble() {
    }

    public final double get() {
        return Double.longBitsToDouble(this.value);
    }

    public final void set(double d2) {
        long l2;
        this.value = l2 = Double.doubleToRawLongBits(d2);
    }

    public final void lazySet(double d2) {
        this.set(d2);
    }

    public final double getAndSet(double d2) {
        long l2 = Double.doubleToRawLongBits(d2);
        return Double.longBitsToDouble(updater.getAndSet(this, l2));
    }

    public final boolean compareAndSet(double d2, double d3) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final boolean weakCompareAndSet(double d2, double d3) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double getAndAdd(double d2) {
        double d3;
        long l2;
        long l3;
        double d4;
        while (!updater.compareAndSet(this, l3 = this.value, l2 = Double.doubleToRawLongBits(d3 = (d4 = Double.longBitsToDouble(l3)) + d2))) {
        }
        return d4;
    }

    public final double addAndGet(double d2) {
        double d3;
        long l2;
        long l3;
        double d4;
        while (!updater.compareAndSet(this, l3 = this.value, l2 = Double.doubleToRawLongBits(d3 = (d4 = Double.longBitsToDouble(l3)) + d2))) {
        }
        return d3;
    }

    public String toString() {
        return Double.toString(this.get());
    }

    @Override
    public int intValue() {
        return (int)this.get();
    }

    @Override
    public long longValue() {
        return (long)this.get();
    }

    @Override
    public float floatValue() {
        return (float)this.get();
    }

    @Override
    public double doubleValue() {
        return this.get();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(this.get());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.set(objectInputStream.readDouble());
    }
}

