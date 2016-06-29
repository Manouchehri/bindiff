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
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
   public LittleEndianDataInputStream(InputStream var1) {
      super((InputStream)Preconditions.checkNotNull(var1));
   }

   public String readLine() {
      throw new UnsupportedOperationException("readLine is not supported");
   }

   public void readFully(byte[] var1) {
      ByteStreams.readFully(this, var1);
   }

   public void readFully(byte[] var1, int var2, int var3) {
      ByteStreams.readFully(this, var1, var2, var3);
   }

   public int skipBytes(int var1) {
      return (int)this.in.skip((long)var1);
   }

   public int readUnsignedByte() {
      int var1 = this.in.read();
      if(0 > var1) {
         throw new EOFException();
      } else {
         return var1;
      }
   }

   public int readUnsignedShort() {
      byte var1 = this.readAndCheckByte();
      byte var2 = this.readAndCheckByte();
      return Ints.fromBytes((byte)0, (byte)0, var2, var1);
   }

   public int readInt() {
      byte var1 = this.readAndCheckByte();
      byte var2 = this.readAndCheckByte();
      byte var3 = this.readAndCheckByte();
      byte var4 = this.readAndCheckByte();
      return Ints.fromBytes(var4, var3, var2, var1);
   }

   public long readLong() {
      byte var1 = this.readAndCheckByte();
      byte var2 = this.readAndCheckByte();
      byte var3 = this.readAndCheckByte();
      byte var4 = this.readAndCheckByte();
      byte var5 = this.readAndCheckByte();
      byte var6 = this.readAndCheckByte();
      byte var7 = this.readAndCheckByte();
      byte var8 = this.readAndCheckByte();
      return Longs.fromBytes(var8, var7, var6, var5, var4, var3, var2, var1);
   }

   public float readFloat() {
      return Float.intBitsToFloat(this.readInt());
   }

   public double readDouble() {
      return Double.longBitsToDouble(this.readLong());
   }

   public String readUTF() {
      return (new DataInputStream(this.in)).readUTF();
   }

   public short readShort() {
      return (short)this.readUnsignedShort();
   }

   public char readChar() {
      return (char)this.readUnsignedShort();
   }

   public byte readByte() {
      return (byte)this.readUnsignedByte();
   }

   public boolean readBoolean() {
      return this.readUnsignedByte() != 0;
   }

   private byte readAndCheckByte() {
      int var1 = this.in.read();
      if(-1 == var1) {
         throw new EOFException();
      } else {
         return (byte)var1;
      }
   }
}
