/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;

@Beta
public final class LittleEndianDataInputStream
extends FilterInputStream
implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        super((InputStream)Preconditions.checkNotNull(inputStream));
    }

    @Override
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override
    public void readFully(byte[] arrby) {
        ByteStreams.readFully(this, arrby);
    }

    @Override
    public void readFully(byte[] arrby, int n2, int n3) {
        ByteStreams.readFully(this, arrby, n2, n3);
    }

    @Override
    public int skipBytes(int n2) {
        return (int)this.in.skip(n2);
    }

    @Override
    public int readUnsignedByte() {
        int n2 = this.in.read();
        if (0 <= n2) return n2;
        throw new EOFException();
    }

    @Override
    public int readUnsignedShort() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        return Ints.fromBytes(0, 0, by3, by2);
    }

    @Override
    public int readInt() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        byte by5 = this.readAndCheckByte();
        return Ints.fromBytes(by5, by4, by3, by2);
    }

    @Override
    public long readLong() {
        byte by2 = this.readAndCheckByte();
        byte by3 = this.readAndCheckByte();
        byte by4 = this.readAndCheckByte();
        byte by5 = this.readAndCheckByte();
        byte by6 = this.readAndCheckByte();
        byte by7 = this.readAndCheckByte();
        byte by8 = this.readAndCheckByte();
        byte by9 = this.readAndCheckByte();
        return Longs.fromBytes(by9, by8, by7, by6, by5, by4, by3, by2);
    }

    @Override
    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public String readUTF() {
        return new DataInputStream(this.in).readUTF();
    }

    @Override
    public short readShort() {
        return (short)this.readUnsignedShort();
    }

    @Override
    public char readChar() {
        return (char)this.readUnsignedShort();
    }

    @Override
    public byte readByte() {
        return (byte)this.readUnsignedByte();
    }

    @Override
    public boolean readBoolean() {
        if (this.readUnsignedByte() == 0) return false;
        return true;
    }

    private byte readAndCheckByte() {
        int n2 = this.in.read();
        if (-1 != n2) return (byte)n2;
        throw new EOFException();
    }
}

