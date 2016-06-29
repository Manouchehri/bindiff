package org.jfree.threads;

class ReaderWriterLock$ReaderWriterNode
{
    protected static final int READER = 0;
    protected static final int WRITER = 1;
    protected Thread t;
    protected int state;
    protected int nAcquires;
    
    private ReaderWriterLock$ReaderWriterNode(final Thread t, final int state) {
        this.t = t;
        this.state = state;
        this.nAcquires = 0;
    }
    
    ReaderWriterLock$ReaderWriterNode(final Thread thread, final int n, final ReaderWriterLock$1 readerWriterLock$1) {
        this(thread, n);
    }
}
