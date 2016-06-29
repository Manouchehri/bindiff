/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.memmanager;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.memmanager.IMemoryListener;
import com.google.security.zynamics.zylib.general.memmanager.MemoryChunk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Memory {
    private final LinkedList m_chunks = new LinkedList();
    private final ArrayList m_listeners = new ArrayList();
    private final ReadWriteLock m_readWriteLock = new ReentrantReadWriteLock();
    private final Lock m_readLock = this.m_readWriteLock.readLock();
    private final Lock m_writeLock = this.m_readWriteLock.writeLock();

    private byte[] concat(byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = new byte[arrby.length + arrby2.length];
        System.arraycopy(arrby, 0, arrby3, 0, arrby.length);
        System.arraycopy(arrby2, 0, arrby3, arrby.length, arrby2.length);
        return arrby3;
    }

    private MemoryChunk connectChunks(MemoryChunk memoryChunk, MemoryChunk memoryChunk2) {
        MemoryChunk memoryChunk3;
        Preconditions.checkNotNull(memoryChunk, "Error: First memory chunk can't be null");
        Preconditions.checkNotNull(memoryChunk2, "Error: Second memory chunk can't be null");
        Preconditions.checkArgument(memoryChunk2.getAddress() > memoryChunk.getAddress(), "Error: Second memory chunk must start after the first memory chunk");
        long l2 = memoryChunk.getAddress();
        if (memoryChunk.getAddress() + (long)memoryChunk.getLength() == memoryChunk2.getAddress()) {
            byte[] arrby = this.concat(memoryChunk.getBytes(), memoryChunk2.getBytes());
            memoryChunk3 = new MemoryChunk(l2, arrby);
        } else {
            int n2 = (int)(memoryChunk2.getAddress() - memoryChunk.getAddress()) - memoryChunk.getLength();
            byte[] arrby = new byte[memoryChunk.getLength() + n2 + memoryChunk2.getLength()];
            if (n2 > 0) {
                return null;
            }
            if (n2 < 0) {
                System.arraycopy(memoryChunk.getBytes(), 0, arrby, 0, memoryChunk.getLength());
                System.arraycopy(memoryChunk2.getBytes(), - n2, arrby, memoryChunk.getLength(), memoryChunk2.getLength() + n2);
            }
            memoryChunk3 = new MemoryChunk(l2, arrby);
        }
        this.removeChunk(memoryChunk);
        this.removeChunk(memoryChunk2);
        this.insertChunk(memoryChunk3);
        return memoryChunk3;
    }

    private MemoryChunk findChunk(long l2) {
        MemoryChunk memoryChunk;
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Iterator iterator = this.m_chunks.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (l2 < (memoryChunk = (MemoryChunk)iterator.next()).getAddress() || l2 >= memoryChunk.getAddress() + (long)memoryChunk.getLength());
        return memoryChunk;
    }

    private int findChunkPosition(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, "Error: Memory chunk can't be null");
        long l2 = memoryChunk.getAddress();
        int n2 = 0;
        while (n2 < this.getNumberOfChunks()) {
            if (l2 < ((MemoryChunk)this.m_chunks.get(n2)).getAddress()) {
                return n2;
            }
            ++n2;
        }
        return this.m_chunks.size();
    }

    private MemoryChunk findNextChunk(long l2) {
        MemoryChunk memoryChunk;
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Iterator iterator = this.m_chunks.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((memoryChunk = (MemoryChunk)iterator.next()).getAddress() < l2);
        return memoryChunk;
    }

    private void insertChunk(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, "Error: Memory chunk can't be null");
        int n2 = this.findChunkPosition(memoryChunk);
        this.m_chunks.add(n2, memoryChunk);
    }

    private void notifyListeners(long l2, int n2) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IMemoryListener iMemoryListener = (IMemoryListener)iterator.next();
            iMemoryListener.memoryChanged(l2, n2);
        }
    }

    private void removeChunk(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, "Error: Memory chunk can't be null");
        this.m_chunks.remove(memoryChunk);
    }

    private void splitChunk(MemoryChunk memoryChunk, long l2) {
        byte[] arrby = memoryChunk.getBytes();
        byte[] arrby2 = new byte[(int)(l2 - memoryChunk.getAddress())];
        byte[] arrby3 = new byte[memoryChunk.getLength() - arrby2.length];
        System.arraycopy(arrby, 0, arrby2, 0, arrby2.length);
        System.arraycopy(arrby, arrby.length - arrby3.length, arrby3, 0, arrby3.length);
        MemoryChunk memoryChunk2 = new MemoryChunk(memoryChunk.getAddress(), arrby2);
        MemoryChunk memoryChunk3 = new MemoryChunk(memoryChunk.getAddress() + (long)memoryChunk.getLength() - (long)arrby3.length, arrby3);
        this.removeChunk(memoryChunk);
        this.insertChunk(memoryChunk2);
        this.insertChunk(memoryChunk3);
    }

    public void addMemoryListener(IMemoryListener iMemoryListener) {
        Preconditions.checkNotNull(iMemoryListener, "Error: Listener can't be null");
        this.m_listeners.add(iMemoryListener);
    }

    public void clear() {
        this.m_writeLock.lock();
        this.m_chunks.clear();
        this.m_writeLock.unlock();
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IMemoryListener iMemoryListener = (IMemoryListener)iterator.next();
            iMemoryListener.memoryCleared();
        }
    }

    public byte[] getData(long l2, int n2) {
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, "Error: Length must be positive");
        this.m_readLock.lock();
        MemoryChunk memoryChunk = this.findChunk(l2);
        int n3 = n2;
        long l3 = l2;
        byte[] arrby = new byte[n2];
        int n4 = 0;
        try {
            do {
                int n5;
                if (memoryChunk == null) {
                    throw new IllegalArgumentException("Error: Data is not available");
                }
                if (memoryChunk.getAddress() + (long)memoryChunk.getLength() - l3 >= (long)n3) {
                    n5 = (int)(l3 - memoryChunk.getAddress());
                    System.arraycopy(memoryChunk.getBytes(), n5, arrby, n4, n3);
                    byte[] arrby2 = arrby;
                    return arrby2;
                }
                n5 = (int)(l3 - memoryChunk.getAddress());
                int n6 = memoryChunk.getLength() - n5;
                System.arraycopy(memoryChunk.getBytes(), n5, arrby, n4, n6);
                n4 += n6;
                n3 = (int)((long)n3 - (memoryChunk.getAddress() + (long)memoryChunk.getLength() - l3));
                l3 = memoryChunk.getAddress() + (long)memoryChunk.getLength();
                memoryChunk = this.findChunk(l3);
            } while (true);
        }
        finally {
            this.m_readLock.unlock();
        }
    }

    public int getMemorySize() {
        this.m_readLock.lock();
        int n2 = 0;
        Iterator iterator = this.m_chunks.iterator();
        do {
            if (!iterator.hasNext()) {
                this.m_readLock.unlock();
                return n2;
            }
            MemoryChunk memoryChunk = (MemoryChunk)iterator.next();
            n2 += memoryChunk.getLength();
        } while (true);
    }

    public int getNumberOfChunks() {
        this.m_readLock.lock();
        int n2 = this.m_chunks.size();
        this.m_readLock.unlock();
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public long getSectionSize(long var1_1) {
        this.m_readLock.lock();
        var3_2 = this.getSectionStart(var1_1);
        if (!this.hasData(var3_2, 1)) {
            if (this.m_chunks.size() == 0) {
                var5_4 = 0x100000000L;
                return var5_4;
            }
            var5_5 = new MemoryChunk(var3_2, 1);
            var6_7 = this.findChunkPosition(var5_5);
            if (var6_7 == this.m_chunks.size()) {
                var7_10 = (MemoryChunk)this.m_chunks.get(var6_7 - 1);
                var8_9 = 0x100000000L - var7_10.getAddress() - (long)var7_10.getLength();
                return var8_9;
            }
            var7_11 = ((MemoryChunk)this.m_chunks.get(var6_7)).getAddress() - var3_2;
            return var7_11;
        }
        ** GOTO lbl20
        finally {
            this.m_readLock.unlock();
        }
lbl20: // 1 sources:
        var5_3 = this.findChunk(var3_2);
        var6_6 = 0;
        do {
            if (!this.hasData(var5_3.getAddress() + (long)var5_3.getLength(), 1)) {
                var8_8 = (int)(var6_6 + (long)var5_3.getLength());
                return var8_8;
            }
            var6_6 += (long)var5_3.getLength();
            var5_3 = this.findChunk(var5_3.getAddress() + (long)var5_3.getLength());
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long getSectionStart(long l2) {
        try {
            this.m_readLock.lock();
            MemoryChunk memoryChunk = this.findChunk(l2);
            if (memoryChunk != null) {
                long l3 = memoryChunk.getAddress();
                if (l3 == 0) {
                    long l4 = 0;
                    return l4;
                }
                MemoryChunk memoryChunk2 = this.findChunk(l3 - 1);
                if (memoryChunk2 != null) {
                    long l5 = this.getSectionStart(l3 - 1);
                    return l5;
                }
                long l6 = l3;
                return l6;
            }
            MemoryChunk memoryChunk3 = new MemoryChunk(l2, 1);
            int n2 = this.findChunkPosition(memoryChunk3);
            if (n2 == 0) {
                long l7 = 0;
                return l7;
            }
            MemoryChunk memoryChunk4 = (MemoryChunk)this.m_chunks.get(n2 - 1);
            long l8 = memoryChunk4.getAddress() + (long)memoryChunk4.getLength();
            return l8;
        }
        finally {
            this.m_readLock.unlock();
        }
    }

    public boolean hasData(long l2, int n2) {
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, "Error: Length must be positive");
        try {
            this.m_readLock.lock();
            MemoryChunk memoryChunk = this.findChunk(l2);
            int n3 = n2;
            long l3 = l2;
            do {
                if (memoryChunk == null) {
                    boolean bl2 = false;
                    return bl2;
                }
                if (memoryChunk.getAddress() + (long)memoryChunk.getLength() - l3 >= (long)n3) {
                    boolean bl3 = true;
                    return bl3;
                }
                n3 = (int)((long)n3 - (memoryChunk.getAddress() + (long)memoryChunk.getLength() - l3));
                l3 = memoryChunk.getAddress() + (long)memoryChunk.getLength();
                memoryChunk = this.findChunk(l3);
            } while (true);
        }
        finally {
            this.m_readLock.unlock();
        }
    }

    public void printMemory() {
        this.m_readLock.lock();
        Iterator iterator = this.m_chunks.iterator();
        do {
            if (!iterator.hasNext()) {
                this.m_readLock.unlock();
                return;
            }
            MemoryChunk memoryChunk = (MemoryChunk)iterator.next();
            memoryChunk.print();
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(long l2, int n2) {
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, "Error: Length must be positive");
        try {
            this.m_writeLock.lock();
            MemoryChunk memoryChunk = this.findChunk(l2);
            if (memoryChunk == null) {
                MemoryChunk memoryChunk2 = this.findNextChunk(l2);
                if (memoryChunk2 == null) {
                    return;
                }
                if (memoryChunk2.getAddress() >= l2 + (long)n2) return;
                int n3 = (int)(l2 + (long)n2 - memoryChunk2.getAddress());
                this.remove(memoryChunk2.getAddress(), n3);
                return;
            }
            if (memoryChunk.getAddress() == l2) {
                if (memoryChunk.getLength() <= n2) {
                    this.removeChunk(memoryChunk);
                    int n4 = n2 - memoryChunk.getLength();
                    if (n4 <= 0) return;
                    this.remove(l2 + (long)memoryChunk.getLength(), n4);
                    return;
                }
                this.splitChunk(memoryChunk, l2 + (long)n2);
                this.removeChunk(this.findChunk(l2));
                return;
            }
            if (memoryChunk.getAddress() + (long)memoryChunk.getLength() <= l2 + (long)n2) {
                this.splitChunk(memoryChunk, l2);
                MemoryChunk memoryChunk3 = this.findChunk(l2);
                this.removeChunk(memoryChunk3);
                int n5 = n2 - memoryChunk3.getLength();
                if (n5 <= 0) return;
                this.remove(l2 + (long)memoryChunk3.getLength(), n5);
                return;
            }
            this.splitChunk(memoryChunk, l2);
            MemoryChunk memoryChunk4 = this.findChunk(l2);
            this.splitChunk(memoryChunk4, l2 + (long)n2);
            this.removeChunk(this.findChunk(l2));
            return;
        }
        finally {
            this.m_writeLock.unlock();
        }
    }

    public void removeMemoryListener(IMemoryListener iMemoryListener) {
        this.m_listeners.remove(iMemoryListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void store(long l2, byte[] arrby) {
        Preconditions.checkArgument(l2 >= 0, "Error: Address can't be less than 0");
        Preconditions.checkNotNull(arrby, "Error: Data can't be null");
        try {
            this.m_writeLock.lock();
            this.remove(l2, arrby.length);
            MemoryChunk memoryChunk = new MemoryChunk(l2, arrby);
            this.insertChunk(memoryChunk);
            MemoryChunk memoryChunk2 = this.findChunk(l2 + (long)memoryChunk.getLength());
            if (memoryChunk2 != null) {
                this.connectChunks(memoryChunk, memoryChunk2);
            }
        }
        finally {
            this.m_writeLock.unlock();
        }
        this.notifyListeners(l2, arrby.length);
    }
}

