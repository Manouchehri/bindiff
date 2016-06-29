/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.ByteArrayDataOutput;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ByteStreams$ByteArrayDataOutputStream
implements ByteArrayDataOutput {
    final DataOutput output;
    final ByteArrayOutputStream byteArrayOutputSteam;

    ByteStreams$ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputSteam = byteArrayOutputStream;
        this.output = new DataOutputStream(byteArrayOutputStream);
    }

    @Override
    public void write(int n2) {
        try {
            this.output.write(n2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void write(byte[] arrby) {
        try {
            this.output.write(arrby);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        try {
            this.output.write(arrby, n2, n3);
            return;
        }
        catch (IOException var4_4) {
            throw new AssertionError(var4_4);
        }
    }

    @Override
    public void writeBoolean(boolean bl2) {
        try {
            this.output.writeBoolean(bl2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeByte(int n2) {
        try {
            this.output.writeByte(n2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeBytes(String string) {
        try {
            this.output.writeBytes(string);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeChar(int n2) {
        try {
            this.output.writeChar(n2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeChars(String string) {
        try {
            this.output.writeChars(string);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeDouble(double d2) {
        try {
            this.output.writeDouble(d2);
            return;
        }
        catch (IOException var3_2) {
            throw new AssertionError(var3_2);
        }
    }

    @Override
    public void writeFloat(float f2) {
        try {
            this.output.writeFloat(f2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeInt(int n2) {
        try {
            this.output.writeInt(n2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeLong(long l2) {
        try {
            this.output.writeLong(l2);
            return;
        }
        catch (IOException var3_2) {
            throw new AssertionError(var3_2);
        }
    }

    @Override
    public void writeShort(int n2) {
        try {
            this.output.writeShort(n2);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public void writeUTF(String string) {
        try {
            this.output.writeUTF(string);
            return;
        }
        catch (IOException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    @Override
    public byte[] toByteArray() {
        return this.byteArrayOutputSteam.toByteArray();
    }
}

