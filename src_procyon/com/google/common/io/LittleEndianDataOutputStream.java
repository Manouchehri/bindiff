package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import com.google.common.primitives.*;

@Beta
public class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput
{
    public LittleEndianDataOutputStream(final OutputStream outputStream) {
        super(new DataOutputStream((OutputStream)Preconditions.checkNotNull(outputStream)));
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        this.out.write(array, n, n2);
    }
    
    @Override
    public void writeBoolean(final boolean b) {
        ((DataOutputStream)this.out).writeBoolean(b);
    }
    
    @Override
    public void writeByte(final int n) {
        ((DataOutputStream)this.out).writeByte(n);
    }
    
    @Deprecated
    @Override
    public void writeBytes(final String s) {
        ((DataOutputStream)this.out).writeBytes(s);
    }
    
    @Override
    public void writeChar(final int n) {
        this.writeShort(n);
    }
    
    @Override
    public void writeChars(final String s) {
        for (int i = 0; i < s.length(); ++i) {
            this.writeChar(s.charAt(i));
        }
    }
    
    @Override
    public void writeDouble(final double n) {
        this.writeLong(Double.doubleToLongBits(n));
    }
    
    @Override
    public void writeFloat(final float n) {
        this.writeInt(Float.floatToIntBits(n));
    }
    
    @Override
    public void writeInt(final int n) {
        this.out.write(0xFF & n);
        this.out.write(0xFF & n >> 8);
        this.out.write(0xFF & n >> 16);
        this.out.write(0xFF & n >> 24);
    }
    
    @Override
    public void writeLong(final long n) {
        final byte[] byteArray = Longs.toByteArray(Long.reverseBytes(n));
        this.write(byteArray, 0, byteArray.length);
    }
    
    @Override
    public void writeShort(final int n) {
        this.out.write(0xFF & n);
        this.out.write(0xFF & n >> 8);
    }
    
    @Override
    public void writeUTF(final String s) {
        ((DataOutputStream)this.out).writeUTF(s);
    }
    
    @Override
    public void close() {
        this.out.close();
    }
}
