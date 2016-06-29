package com.google.security.zynamics.zylib.general.memmanager;

import com.google.common.base.*;

public class MemoryChunk implements Comparable
{
    private final long m_address;
    private byte[] m_data;
    
    public MemoryChunk(final long address, final byte[] data) {
        Preconditions.checkArgument(address >= 0L, (Object)"Error: Chunk addresses can't be less than 0");
        Preconditions.checkNotNull(data, (Object)"Error: Initial data can't be null");
        Preconditions.checkArgument(data.length != 0, (Object)"Error: Initial data can't be empty");
        this.m_address = address;
        this.m_data = data;
    }
    
    public MemoryChunk(final long n, final int n2) {
        this(n, new byte[n2]);
    }
    
    public int compareTo(final MemoryChunk memoryChunk) {
        return (int)(this.m_address - memoryChunk.m_address);
    }
    
    public void extend(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"Error: The number of bytes to add must be positive");
        final byte[] data = new byte[this.m_data.length + n];
        System.arraycopy(this.m_data, 0, data, 0, this.m_data.length);
        this.m_data = data;
    }
    
    public long getAddress() {
        return this.m_address;
    }
    
    public byte[] getBytes() {
        return this.m_data;
    }
    
    public int getLength() {
        return this.m_data.length;
    }
    
    public byte loadByte(final long n) {
        return this.m_data[(int)(n - this.m_address)];
    }
    
    public void print() {
        System.out.printf("%08X: ", this.m_address);
        final byte[] data = this.m_data;
        for (int length = data.length, i = 0; i < length; ++i) {
            System.out.printf("%02X ", data[i]);
        }
        System.out.println();
    }
    
    public void store(final long n, final byte[] array) {
        System.arraycopy(array, 0, this.m_data, (int)(n - this.m_address), array.length);
    }
    
    public void storeByte(final long n, final byte b) {
        this.m_data[(int)(n - this.m_address)] = b;
    }
}
