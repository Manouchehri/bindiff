package com.google.common.io;

import java.io.*;

class ByteStreams$ByteArrayDataInputStream implements ByteArrayDataInput
{
    final DataInput input;
    
    ByteStreams$ByteArrayDataInputStream(final ByteArrayInputStream byteArrayInputStream) {
        this.input = new DataInputStream(byteArrayInputStream);
    }
    
    @Override
    public void readFully(final byte[] array) {
        try {
            this.input.readFully(array);
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public void readFully(final byte[] array, final int n, final int n2) {
        try {
            this.input.readFully(array, n, n2);
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public int skipBytes(final int n) {
        try {
            return this.input.skipBytes(n);
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public boolean readBoolean() {
        try {
            return this.input.readBoolean();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public byte readByte() {
        try {
            return this.input.readByte();
        }
        catch (EOFException ex) {
            throw new IllegalStateException(ex);
        }
        catch (IOException ex2) {
            throw new AssertionError((Object)ex2);
        }
    }
    
    @Override
    public int readUnsignedByte() {
        try {
            return this.input.readUnsignedByte();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public short readShort() {
        try {
            return this.input.readShort();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public int readUnsignedShort() {
        try {
            return this.input.readUnsignedShort();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public char readChar() {
        try {
            return this.input.readChar();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public int readInt() {
        try {
            return this.input.readInt();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public long readLong() {
        try {
            return this.input.readLong();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public float readFloat() {
        try {
            return this.input.readFloat();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public double readDouble() {
        try {
            return this.input.readDouble();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public String readLine() {
        try {
            return this.input.readLine();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public String readUTF() {
        try {
            return this.input.readUTF();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
