/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@Beta
public class LittleEndianDataOutputStream
extends FilterOutputStream
implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream)Preconditions.checkNotNull(outputStream)));
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        this.out.write(arrby, n2, n3);
    }

    @Override
    public void writeBoolean(boolean bl2) {
        ((DataOutputStream)this.out).writeBoolean(bl2);
    }

    @Override
    public void writeByte(int n2) {
        ((DataOutputStream)this.out).writeByte(n2);
    }

    @Deprecated
    @Override
    public void writeBytes(String string) {
        ((DataOutputStream)this.out).writeBytes(string);
    }

    @Override
    public void writeChar(int n2) {
        this.writeShort(n2);
    }

    @Override
    public void writeChars(String string) {
        int n2 = 0;
        while (n2 < string.length()) {
            this.writeChar(string.charAt(n2));
            ++n2;
        }
    }

    @Override
    public void writeDouble(double d2) {
        this.writeLong(Double.doubleToLongBits(d2));
    }

    @Override
    public void writeFloat(float f2) {
        this.writeInt(Float.floatToIntBits(f2));
    }

    @Override
    public void writeInt(int n2) {
        this.out.write(255 & n2);
        this.out.write(255 & n2 >> 8);
        this.out.write(255 & n2 >> 16);
        this.out.write(255 & n2 >> 24);
    }

    @Override
    public void writeLong(long l2) {
        byte[] arrby = Longs.toByteArray(Long.reverseBytes(l2));
        this.write(arrby, 0, arrby.length);
    }

    @Override
    public void writeShort(int n2) {
        this.out.write(255 & n2);
        this.out.write(255 & n2 >> 8);
    }

    @Override
    public void writeUTF(String string) {
        ((DataOutputStream)this.out).writeUTF(string);
    }

    @Override
    public void close() {
        this.out.close();
    }
}

