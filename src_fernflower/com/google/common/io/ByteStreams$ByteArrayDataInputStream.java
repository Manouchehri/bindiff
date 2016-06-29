package com.google.common.io;

import com.google.common.io.ByteArrayDataInput;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

class ByteStreams$ByteArrayDataInputStream implements ByteArrayDataInput {
   final DataInput input;

   ByteStreams$ByteArrayDataInputStream(ByteArrayInputStream var1) {
      this.input = new DataInputStream(var1);
   }

   public void readFully(byte[] var1) {
      try {
         this.input.readFully(var1);
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public void readFully(byte[] var1, int var2, int var3) {
      try {
         this.input.readFully(var1, var2, var3);
      } catch (IOException var5) {
         throw new IllegalStateException(var5);
      }
   }

   public int skipBytes(int var1) {
      try {
         return this.input.skipBytes(var1);
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public boolean readBoolean() {
      try {
         return this.input.readBoolean();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public byte readByte() {
      try {
         return this.input.readByte();
      } catch (EOFException var2) {
         throw new IllegalStateException(var2);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public int readUnsignedByte() {
      try {
         return this.input.readUnsignedByte();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public short readShort() {
      try {
         return this.input.readShort();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public int readUnsignedShort() {
      try {
         return this.input.readUnsignedShort();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public char readChar() {
      try {
         return this.input.readChar();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public int readInt() {
      try {
         return this.input.readInt();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public long readLong() {
      try {
         return this.input.readLong();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public float readFloat() {
      try {
         return this.input.readFloat();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public double readDouble() {
      try {
         return this.input.readDouble();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public String readLine() {
      try {
         return this.input.readLine();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public String readUTF() {
      try {
         return this.input.readUTF();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }
}
