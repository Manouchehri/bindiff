package org.jfree.threads;

import java.util.*;

public class ReaderWriterLock
{
    private ArrayList waiters;
    
    public ReaderWriterLock() {
        this.waiters = new ArrayList();
    }
    
    public synchronized void lockRead() {
        final Thread currentThread = Thread.currentThread();
        final int index = this.getIndex(currentThread);
        ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode;
        if (index == -1) {
            readerWriterLock$ReaderWriterNode = new ReaderWriterLock$ReaderWriterNode(currentThread, 0, null);
            this.waiters.add(readerWriterLock$ReaderWriterNode);
        }
        else {
            readerWriterLock$ReaderWriterNode = this.waiters.get(index);
        }
        while (this.getIndex(currentThread) > this.firstWriter()) {
            try {
                this.wait();
            }
            catch (Exception ex) {
                System.err.println("ReaderWriterLock.lockRead(): exception.");
                System.err.print(ex.getMessage());
            }
        }
        final ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode2 = readerWriterLock$ReaderWriterNode;
        ++readerWriterLock$ReaderWriterNode2.nAcquires;
    }
    
    public synchronized void lockWrite() {
        final Thread currentThread = Thread.currentThread();
        final int index = this.getIndex(currentThread);
        ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode;
        if (index == -1) {
            readerWriterLock$ReaderWriterNode = new ReaderWriterLock$ReaderWriterNode(currentThread, 1, null);
            this.waiters.add(readerWriterLock$ReaderWriterNode);
        }
        else {
            readerWriterLock$ReaderWriterNode = this.waiters.get(index);
            if (readerWriterLock$ReaderWriterNode.state == 0) {
                throw new IllegalArgumentException("Upgrade lock");
            }
            readerWriterLock$ReaderWriterNode.state = 1;
        }
        while (this.getIndex(currentThread) != 0) {
            try {
                this.wait();
            }
            catch (Exception ex) {
                System.err.println("ReaderWriterLock.lockWrite(): exception.");
                System.err.print(ex.getMessage());
            }
        }
        final ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode2 = readerWriterLock$ReaderWriterNode;
        ++readerWriterLock$ReaderWriterNode2.nAcquires;
    }
    
    public synchronized void unlock() {
        final int index = this.getIndex(Thread.currentThread());
        if (index > this.firstWriter()) {
            throw new IllegalArgumentException("Lock not held");
        }
        final ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode2;
        final ReaderWriterLock$ReaderWriterNode readerWriterLock$ReaderWriterNode = readerWriterLock$ReaderWriterNode2 = this.waiters.get(index);
        --readerWriterLock$ReaderWriterNode2.nAcquires;
        if (readerWriterLock$ReaderWriterNode.nAcquires == 0) {
            this.waiters.remove(index);
        }
        this.notifyAll();
    }
    
    private int firstWriter() {
        final Iterator<ReaderWriterLock$ReaderWriterNode> iterator = (Iterator<ReaderWriterLock$ReaderWriterNode>)this.waiters.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (iterator.next().state == 1) {
                return n;
            }
            ++n;
        }
        return Integer.MAX_VALUE;
    }
    
    private int getIndex(final Thread thread) {
        final Iterator<ReaderWriterLock$ReaderWriterNode> iterator = (Iterator<ReaderWriterLock$ReaderWriterNode>)this.waiters.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (iterator.next().t == thread) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
