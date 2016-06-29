package com.google.security.zynamics.zylib.general.memmanager;

import java.util.concurrent.locks.*;
import com.google.common.base.*;
import java.util.*;

public class Memory
{
    private final LinkedList m_chunks;
    private final ArrayList m_listeners;
    private final ReadWriteLock m_readWriteLock;
    private final Lock m_readLock;
    private final Lock m_writeLock;
    
    public Memory() {
        this.m_chunks = new LinkedList();
        this.m_listeners = new ArrayList();
        this.m_readWriteLock = new ReentrantReadWriteLock();
        this.m_readLock = this.m_readWriteLock.readLock();
        this.m_writeLock = this.m_readWriteLock.writeLock();
    }
    
    private byte[] concat(final byte[] array, final byte[] array2) {
        final byte[] array3 = new byte[array.length + array2.length];
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array2, 0, array3, array.length, array2.length);
        return array3;
    }
    
    private MemoryChunk connectChunks(final MemoryChunk memoryChunk, final MemoryChunk memoryChunk2) {
        Preconditions.checkNotNull(memoryChunk, (Object)"Error: First memory chunk can't be null");
        Preconditions.checkNotNull(memoryChunk2, (Object)"Error: Second memory chunk can't be null");
        Preconditions.checkArgument(memoryChunk2.getAddress() > memoryChunk.getAddress(), (Object)"Error: Second memory chunk must start after the first memory chunk");
        final long address = memoryChunk.getAddress();
        MemoryChunk memoryChunk3;
        if (memoryChunk.getAddress() + memoryChunk.getLength() == memoryChunk2.getAddress()) {
            memoryChunk3 = new MemoryChunk(address, this.concat(memoryChunk.getBytes(), memoryChunk2.getBytes()));
        }
        else {
            final int n = (int)(memoryChunk2.getAddress() - memoryChunk.getAddress()) - memoryChunk.getLength();
            final byte[] array = new byte[memoryChunk.getLength() + n + memoryChunk2.getLength()];
            if (n > 0) {
                return null;
            }
            if (n < 0) {
                System.arraycopy(memoryChunk.getBytes(), 0, array, 0, memoryChunk.getLength());
                System.arraycopy(memoryChunk2.getBytes(), -n, array, memoryChunk.getLength(), memoryChunk2.getLength() + n);
            }
            memoryChunk3 = new MemoryChunk(address, array);
        }
        this.removeChunk(memoryChunk);
        this.removeChunk(memoryChunk2);
        this.insertChunk(memoryChunk3);
        return memoryChunk3;
    }
    
    private MemoryChunk findChunk(final long n) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        for (final MemoryChunk memoryChunk : this.m_chunks) {
            if (n >= memoryChunk.getAddress() && n < memoryChunk.getAddress() + memoryChunk.getLength()) {
                return memoryChunk;
            }
        }
        return null;
    }
    
    private int findChunkPosition(final MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, (Object)"Error: Memory chunk can't be null");
        final long address = memoryChunk.getAddress();
        for (int i = 0; i < this.getNumberOfChunks(); ++i) {
            if (address < ((MemoryChunk)this.m_chunks.get(i)).getAddress()) {
                return i;
            }
        }
        return this.m_chunks.size();
    }
    
    private MemoryChunk findNextChunk(final long n) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        for (final MemoryChunk memoryChunk : this.m_chunks) {
            if (memoryChunk.getAddress() >= n) {
                return memoryChunk;
            }
        }
        return null;
    }
    
    private void insertChunk(final MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, (Object)"Error: Memory chunk can't be null");
        this.m_chunks.add(this.findChunkPosition(memoryChunk), memoryChunk);
    }
    
    private void notifyListeners(final long n, final int n2) {
        final Iterator<IMemoryListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().memoryChanged(n, n2);
        }
    }
    
    private void removeChunk(final MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk, (Object)"Error: Memory chunk can't be null");
        this.m_chunks.remove(memoryChunk);
    }
    
    private void splitChunk(final MemoryChunk memoryChunk, final long n) {
        final byte[] bytes = memoryChunk.getBytes();
        final byte[] array = new byte[(int)(n - memoryChunk.getAddress())];
        final byte[] array2 = new byte[memoryChunk.getLength() - array.length];
        System.arraycopy(bytes, 0, array, 0, array.length);
        System.arraycopy(bytes, bytes.length - array2.length, array2, 0, array2.length);
        final MemoryChunk memoryChunk2 = new MemoryChunk(memoryChunk.getAddress(), array);
        final MemoryChunk memoryChunk3 = new MemoryChunk(memoryChunk.getAddress() + memoryChunk.getLength() - array2.length, array2);
        this.removeChunk(memoryChunk);
        this.insertChunk(memoryChunk2);
        this.insertChunk(memoryChunk3);
    }
    
    public void addMemoryListener(final IMemoryListener memoryListener) {
        Preconditions.checkNotNull(memoryListener, (Object)"Error: Listener can't be null");
        this.m_listeners.add(memoryListener);
    }
    
    public void clear() {
        this.m_writeLock.lock();
        this.m_chunks.clear();
        this.m_writeLock.unlock();
        final Iterator<IMemoryListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().memoryCleared();
        }
    }
    
    public byte[] getData(final long n, final int n2) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, (Object)"Error: Length must be positive");
        this.m_readLock.lock();
        MemoryChunk memoryChunk = this.findChunk(n);
        int n3 = n2;
        long n4 = n;
        final byte[] array = new byte[n2];
        int n5 = 0;
        try {
            while (memoryChunk != null) {
                if (memoryChunk.getAddress() + memoryChunk.getLength() - n4 >= n3) {
                    System.arraycopy(memoryChunk.getBytes(), (int)(n4 - memoryChunk.getAddress()), array, n5, n3);
                    return array;
                }
                final int n6 = (int)(n4 - memoryChunk.getAddress());
                final int n7 = memoryChunk.getLength() - n6;
                System.arraycopy(memoryChunk.getBytes(), n6, array, n5, n7);
                n5 += n7;
                n3 -= (int)(memoryChunk.getAddress() + memoryChunk.getLength() - n4);
                n4 = memoryChunk.getAddress() + memoryChunk.getLength();
                memoryChunk = this.findChunk(n4);
            }
            throw new IllegalArgumentException("Error: Data is not available");
        }
        finally {
            this.m_readLock.unlock();
        }
    }
    
    public int getMemorySize() {
        this.m_readLock.lock();
        int n = 0;
        final Iterator iterator = this.m_chunks.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().getLength();
        }
        this.m_readLock.unlock();
        return n;
    }
    
    public int getNumberOfChunks() {
        this.m_readLock.lock();
        final int size = this.m_chunks.size();
        this.m_readLock.unlock();
        return size;
    }
    
    public long getSectionSize(final long n) {
        this.m_readLock.lock();
        final long sectionStart = this.getSectionStart(n);
        try {
            if (this.hasData(sectionStart, 1)) {
                MemoryChunk memoryChunk = this.findChunk(sectionStart);
                long n2 = 0L;
                while (this.hasData(memoryChunk.getAddress() + memoryChunk.getLength(), 1)) {
                    n2 += memoryChunk.getLength();
                    memoryChunk = this.findChunk(memoryChunk.getAddress() + memoryChunk.getLength());
                }
                return (int)(n2 + memoryChunk.getLength());
            }
            if (this.m_chunks.size() == 0) {
                return 4294967296L;
            }
            final int chunkPosition = this.findChunkPosition(new MemoryChunk(sectionStart, 1));
            if (chunkPosition == this.m_chunks.size()) {
                final MemoryChunk memoryChunk2 = this.m_chunks.get(chunkPosition - 1);
                return 4294967296L - memoryChunk2.getAddress() - memoryChunk2.getLength();
            }
            return ((MemoryChunk)this.m_chunks.get(chunkPosition)).getAddress() - sectionStart;
        }
        finally {
            this.m_readLock.unlock();
        }
    }
    
    public long getSectionStart(final long n) {
        try {
            this.m_readLock.lock();
            final MemoryChunk chunk = this.findChunk(n);
            if (chunk != null) {
                final long address = chunk.getAddress();
                if (address == 0L) {
                    return 0L;
                }
                if (this.findChunk(address - 1L) != null) {
                    return this.getSectionStart(address - 1L);
                }
                return address;
            }
            else {
                final int chunkPosition = this.findChunkPosition(new MemoryChunk(n, 1));
                if (chunkPosition == 0) {
                    return 0L;
                }
                final MemoryChunk memoryChunk = this.m_chunks.get(chunkPosition - 1);
                return memoryChunk.getAddress() + memoryChunk.getLength();
            }
        }
        finally {
            this.m_readLock.unlock();
        }
    }
    
    public boolean hasData(final long n, final int n2) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, (Object)"Error: Length must be positive");
        try {
            this.m_readLock.lock();
            MemoryChunk memoryChunk = this.findChunk(n);
            int n3 = n2;
            for (long n4 = n; memoryChunk != null; memoryChunk = this.findChunk(n4)) {
                if (memoryChunk.getAddress() + memoryChunk.getLength() - n4 >= n3) {
                    return true;
                }
                n3 -= (int)(memoryChunk.getAddress() + memoryChunk.getLength() - n4);
                n4 = memoryChunk.getAddress() + memoryChunk.getLength();
            }
            return false;
        }
        finally {
            this.m_readLock.unlock();
        }
    }
    
    public void printMemory() {
        this.m_readLock.lock();
        final Iterator iterator = this.m_chunks.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
        this.m_readLock.unlock();
    }
    
    public void remove(final long n, final int n2) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        Preconditions.checkArgument(n2 > 0, (Object)"Error: Length must be positive");
        try {
            this.m_writeLock.lock();
            final MemoryChunk chunk = this.findChunk(n);
            if (chunk == null) {
                final MemoryChunk nextChunk = this.findNextChunk(n);
                if (nextChunk == null) {
                    return;
                }
                if (nextChunk.getAddress() >= n + n2) {
                    return;
                }
                this.remove(nextChunk.getAddress(), (int)(n + n2 - nextChunk.getAddress()));
            }
            else if (chunk.getAddress() == n) {
                if (chunk.getLength() <= n2) {
                    this.removeChunk(chunk);
                    final int n3 = n2 - chunk.getLength();
                    if (n3 > 0) {
                        this.remove(n + chunk.getLength(), n3);
                    }
                }
                else {
                    this.splitChunk(chunk, n + n2);
                    this.removeChunk(this.findChunk(n));
                }
            }
            else if (chunk.getAddress() + chunk.getLength() <= n + n2) {
                this.splitChunk(chunk, n);
                final MemoryChunk chunk2 = this.findChunk(n);
                this.removeChunk(chunk2);
                final int n4 = n2 - chunk2.getLength();
                if (n4 > 0) {
                    this.remove(n + chunk2.getLength(), n4);
                }
            }
            else {
                this.splitChunk(chunk, n);
                this.splitChunk(this.findChunk(n), n + n2);
                this.removeChunk(this.findChunk(n));
            }
        }
        finally {
            this.m_writeLock.unlock();
        }
    }
    
    public void removeMemoryListener(final IMemoryListener memoryListener) {
        this.m_listeners.remove(memoryListener);
    }
    
    public void store(final long n, final byte[] array) {
        Preconditions.checkArgument(n >= 0L, (Object)"Error: Address can't be less than 0");
        Preconditions.checkNotNull(array, (Object)"Error: Data can't be null");
        try {
            this.m_writeLock.lock();
            this.remove(n, array.length);
            final MemoryChunk memoryChunk = new MemoryChunk(n, array);
            this.insertChunk(memoryChunk);
            final MemoryChunk chunk = this.findChunk(n + memoryChunk.getLength());
            if (chunk != null) {
                this.connectChunks(memoryChunk, chunk);
            }
        }
        finally {
            this.m_writeLock.unlock();
        }
        this.notifyListeners(n, array.length);
    }
}
