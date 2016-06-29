/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.threads;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.jfree.threads.ReaderWriterLock$1;
import org.jfree.threads.ReaderWriterLock$ReaderWriterNode;

public class ReaderWriterLock {
    private ArrayList waiters = new ArrayList();

    public synchronized void lockRead() {
        ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode;
        Thread thread = Thread.currentThread();
        int n2 = this.getIndex(thread);
        if (n2 == -1) {
            readerWriterLock$ReaderWriterNode = new ReaderWriterLock$ReaderWriterNode(thread, 0, null);
            this.waiters.add(readerWriterLock$ReaderWriterNode);
        } else {
            readerWriterLock$ReaderWriterNode = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(n2);
        }
        do {
            if (this.getIndex(thread) <= this.firstWriter()) {
                ++readerWriterLock$ReaderWriterNode.nAcquires;
                return;
            }
            try {
                this.wait();
            }
            catch (Exception var4_4) {
                System.err.println("ReaderWriterLock.lockRead(): exception.");
                System.err.print(var4_4.getMessage());
                continue;
            }
            break;
        } while (true);
    }

    public synchronized void lockWrite() {
        ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode;
        Thread thread = Thread.currentThread();
        int n2 = this.getIndex(thread);
        if (n2 == -1) {
            readerWriterLock$ReaderWriterNode = new ReaderWriterLock$ReaderWriterNode(thread, 1, null);
            this.waiters.add(readerWriterLock$ReaderWriterNode);
        } else {
            readerWriterLock$ReaderWriterNode = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(n2);
            if (readerWriterLock$ReaderWriterNode.state == 0) {
                throw new IllegalArgumentException("Upgrade lock");
            }
            readerWriterLock$ReaderWriterNode.state = 1;
        }
        do {
            if (this.getIndex(thread) == 0) {
                ++readerWriterLock$ReaderWriterNode.nAcquires;
                return;
            }
            try {
                this.wait();
            }
            catch (Exception var4_4) {
                System.err.println("ReaderWriterLock.lockWrite(): exception.");
                System.err.print(var4_4.getMessage());
                continue;
            }
            break;
        } while (true);
    }

    public synchronized void unlock() {
        Thread thread = Thread.currentThread();
        int n2 = this.getIndex(thread);
        if (n2 > this.firstWriter()) {
            throw new IllegalArgumentException("Lock not held");
        }
        ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(n2);
        --readerWriterLock$ReaderWriterNode.nAcquires;
        if (readerWriterLock$ReaderWriterNode.nAcquires == 0) {
            this.waiters.remove(n2);
        }
        this.notifyAll();
    }

    private int firstWriter() {
        Iterator iterator = this.waiters.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode = (ReaderWriterLock$ReaderWriterNode)iterator.next();
            if (readerWriterLock$ReaderWriterNode.state == 1) {
                return n2;
            }
            ++n2;
        }
        return Integer.MAX_VALUE;
    }

    private int getIndex(Thread thread) {
        Iterator iterator = this.waiters.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode = (ReaderWriterLock$ReaderWriterNode)iterator.next();
            if (readerWriterLock$ReaderWriterNode.t == thread) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }
}

