/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.threads;

import org.jfree.threads.ReaderWriterLock$1;

class ReaderWriterLock$ReaderWriterNode {
    protected static final int READER = 0;
    protected static final int WRITER = 1;
    protected Thread t;
    protected int state;
    protected int nAcquires;

    private ReaderWriterLock$ReaderWriterNode(Thread thread, int n2) {
        this.t = thread;
        this.state = n2;
        this.nAcquires = 0;
    }

    ReaderWriterLock$ReaderWriterNode(Thread thread, int n2, ReaderWriterLock$1 readerWriterLock$1) {
        this(thread, n2);
    }
}

