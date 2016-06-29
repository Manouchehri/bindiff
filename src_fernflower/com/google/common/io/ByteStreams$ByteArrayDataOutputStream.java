package com.google.common.io;

import com.google.common.io.ByteArrayDataOutput;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

class ByteStreams$ByteArrayDataOutputStream implements ByteArrayDataOutput {
   final DataOutput output;
   final ByteArrayOutputStream byteArrayOutputSteam;

   ByteStreams$ByteArrayDataOutputStream(ByteArrayOutputStream var1) {
      this.byteArrayOutputSteam = var1;
      this.output = new DataOutputStream(var1);
   }

   public void write(int var1) {
      try {
         this.output.write(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void write(byte[] var1) {
      try {
         this.output.write(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void write(byte[] var1, int var2, int var3) {
      try {
         this.output.write(var1, var2, var3);
      } catch (IOException var5) {
         throw new AssertionError(var5);
      }
   }

   public void writeBoolean(boolean var1) {
      try {
         this.output.writeBoolean(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeByte(int var1) {
      try {
         this.output.writeByte(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeBytes(String var1) {
      try {
         this.output.writeBytes(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeChar(int var1) {
      try {
         this.output.writeChar(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeChars(String var1) {
      try {
         this.output.writeChars(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeDouble(double var1) {
      try {
         this.output.writeDouble(var1);
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }
   }

   public void writeFloat(float var1) {
      try {
         this.output.writeFloat(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeInt(int var1) {
      try {
         this.output.writeInt(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeLong(long var1) {
      try {
         this.output.writeLong(var1);
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }
   }

   public void writeShort(int var1) {
      try {
         this.output.writeShort(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public void writeUTF(String var1) {
      try {
         this.output.writeUTF(var1);
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public byte[] toByteArray() {
      return this.byteArrayOutputSteam.toByteArray();
   }
}
