/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.memmanager;

import com.google.common.base.Preconditions;
import java.io.PrintStream;

public class MemoryChunk
implements Comparable {
    private final long m_address;
    private byte[] m_data;

    public MemoryChunk(long l2, byte[] arrby) {
        Preconditions.checkArgument(l2 >= 0, "Error: Chunk addresses can't be less than 0");
        Preconditions.checkNotNull(arrby, "Error: Initial data can't be null");
        Preconditions.checkArgument(arrby.length != 0, "Error: Initial data can't be empty");
        this.m_address = l2;
        this.m_data = arrby;
    }

    public MemoryChunk(long l2, int n2) {
        this(l2, new byte[n2]);
    }

    public int compareTo(MemoryChunk memoryChunk) {
        return (int)(this.m_address - memoryChunk.m_address);
    }

    public void extend(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: The number of bytes to add must be positive");
        byte[] arrby = new byte[this.m_data.length + n2];
        System.arraycopy(this.m_data, 0, arrby, 0, this.m_data.length);
        this.m_data = arrby;
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

    public byte loadByte(long l2) {
        return this.m_data[(int)(l2 - this.m_address)];
    }

    public void print() {
        System.out.printf("%08X: ", this.m_address);
        byte[] arrby = this.m_data;
        int n2 = arrby.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                System.out.println();
                return;
            }
            byte by2 = arrby[n3];
            System.out.printf("%02X ", Byte.valueOf(by2));
            ++n3;
        } while (true);
    }

    public void store(long l2, byte[] arrby) {
        System.arraycopy(arrby, 0, this.m_data, (int)(l2 - this.m_address), arrby.length);
    }

    public void storeByte(long l2, byte by2) {
        this.m_data[(int)(l2 - this.m_address)] = by2;
    }
}

