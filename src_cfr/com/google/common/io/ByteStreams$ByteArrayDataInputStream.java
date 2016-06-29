/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.ByteArrayDataInput;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class ByteStreams$ByteArrayDataInputStream
implements ByteArrayDataInput {
    final DataInput input;

    ByteStreams$ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
        this.input = new DataInputStream(byteArrayInputStream);
    }

    @Override
    public void readFully(byte[] arrby) {
        try {
            this.input.readFully(arrby);
            return;
        }
        catch (IOException var2_2) {
            throw new IllegalStateException(var2_2);
        }
    }

    @Override
    public void readFully(byte[] arrby, int n2, int n3) {
        try {
            this.input.readFully(arrby, n2, n3);
            return;
        }
        catch (IOException var4_4) {
            throw new IllegalStateException(var4_4);
        }
    }

    @Override
    public int skipBytes(int n2) {
        try {
            return this.input.skipBytes(n2);
        }
        catch (IOException var2_2) {
            throw new IllegalStateException(var2_2);
        }
    }

    @Override
    public boolean readBoolean() {
        try {
            return this.input.readBoolean();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public byte readByte() {
        try {
            return this.input.readByte();
        }
        catch (EOFException var1_1) {
            throw new IllegalStateException(var1_1);
        }
        catch (IOException var1_2) {
            throw new AssertionError(var1_2);
        }
    }

    @Override
    public int readUnsignedByte() {
        try {
            return this.input.readUnsignedByte();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public short readShort() {
        try {
            return this.input.readShort();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public int readUnsignedShort() {
        try {
            return this.input.readUnsignedShort();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public char readChar() {
        try {
            return this.input.readChar();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public int readInt() {
        try {
            return this.input.readInt();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public long readLong() {
        try {
            return this.input.readLong();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public float readFloat() {
        try {
            return this.input.readFloat();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public double readDouble() {
        try {
            return this.input.readDouble();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public String readLine() {
        try {
            return this.input.readLine();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }

    @Override
    public String readUTF() {
        try {
            return this.input.readUTF();
        }
        catch (IOException var1_1) {
            throw new IllegalStateException(var1_1);
        }
    }
}

