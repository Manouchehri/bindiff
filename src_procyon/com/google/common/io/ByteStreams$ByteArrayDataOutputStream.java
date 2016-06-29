package com.google.common.io;

import java.io.*;

class ByteStreams$ByteArrayDataOutputStream implements ByteArrayDataOutput
{
    final DataOutput output;
    final ByteArrayOutputStream byteArrayOutputSteam;
    
    ByteStreams$ByteArrayDataOutputStream(final ByteArrayOutputStream byteArrayOutputSteam) {
        this.byteArrayOutputSteam = byteArrayOutputSteam;
        this.output = new DataOutputStream(byteArrayOutputSteam);
    }
    
    @Override
    public void write(final int n) {
        try {
            this.output.write(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void write(final byte[] array) {
        try {
            this.output.write(array);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        try {
            this.output.write(array, n, n2);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeBoolean(final boolean b) {
        try {
            this.output.writeBoolean(b);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeByte(final int n) {
        try {
            this.output.writeByte(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeBytes(final String s) {
        try {
            this.output.writeBytes(s);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeChar(final int n) {
        try {
            this.output.writeChar(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeChars(final String s) {
        try {
            this.output.writeChars(s);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeDouble(final double n) {
        try {
            this.output.writeDouble(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeFloat(final float n) {
        try {
            this.output.writeFloat(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeInt(final int n) {
        try {
            this.output.writeInt(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeLong(final long n) {
        try {
            this.output.writeLong(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeShort(final int n) {
        try {
            this.output.writeShort(n);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public void writeUTF(final String s) {
        try {
            this.output.writeUTF(s);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public byte[] toByteArray() {
        return this.byteArrayOutputSteam.toByteArray();
    }
}
