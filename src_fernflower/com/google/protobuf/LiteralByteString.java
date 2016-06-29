package com.google.protobuf;

import com.google.protobuf.BoundedByteString;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.LiteralByteString$1;
import com.google.protobuf.LiteralByteString$LiteralByteIterator;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.Utf8;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class LiteralByteString extends ByteString {
   private static final long serialVersionUID = 1L;
   protected final byte[] bytes;
   private int hash = 0;

   LiteralByteString(byte[] var1) {
      this.bytes = var1;
   }

   public byte byteAt(int var1) {
      return this.bytes[var1];
   }

   public int size() {
      return this.bytes.length;
   }

   public ByteString substring(int var1, int var2) {
      if(var1 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(32)).append("Beginning index: ").append(var1).append(" < 0").toString());
      } else if(var2 > this.size()) {
         int var6 = this.size();
         throw new IndexOutOfBoundsException((new StringBuilder(36)).append("End index: ").append(var2).append(" > ").append(var6).toString());
      } else {
         int var3 = var2 - var1;
         if(var3 < 0) {
            throw new IndexOutOfBoundsException((new StringBuilder(66)).append("Beginning index larger than ending index: ").append(var1).append(", ").append(var2).toString());
         } else {
            Object var4;
            if(var3 == 0) {
               var4 = ByteString.EMPTY;
            } else {
               var4 = new BoundedByteString(this.bytes, this.getOffsetIntoBytes() + var1, var3);
            }

            return (ByteString)var4;
         }
      }
   }

   protected void copyToInternal(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.bytes, var2, var1, var3, var4);
   }

   public void copyTo(ByteBuffer var1) {
      var1.put(this.bytes, this.getOffsetIntoBytes(), this.size());
   }

   public ByteBuffer asReadOnlyByteBuffer() {
      ByteBuffer var1 = ByteBuffer.wrap(this.bytes, this.getOffsetIntoBytes(), this.size());
      return var1.asReadOnlyBuffer();
   }

   public List asReadOnlyByteBufferList() {
      ArrayList var1 = new ArrayList(1);
      var1.add(this.asReadOnlyByteBuffer());
      return var1;
   }

   public void writeTo(OutputStream var1) {
      var1.write(this.toByteArray());
   }

   void writeToInternal(OutputStream var1, int var2, int var3) {
      var1.write(this.bytes, this.getOffsetIntoBytes() + var2, var3);
   }

   protected String toStringInternal(Charset var1) {
      return new String(this.bytes, this.getOffsetIntoBytes(), this.size(), var1);
   }

   public boolean isValidUtf8() {
      int var1 = this.getOffsetIntoBytes();
      return Utf8.isValidUtf8(this.bytes, var1, var1 + this.size());
   }

   protected int partialIsValidUtf8(int var1, int var2, int var3) {
      int var4 = this.getOffsetIntoBytes() + var2;
      return Utf8.partialIsValidUtf8(var1, this.bytes, var4, var4 + var3);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ByteString)) {
         return false;
      } else if(this.size() != ((ByteString)var1).size()) {
         return false;
      } else if(this.size() == 0) {
         return true;
      } else if(var1 instanceof LiteralByteString) {
         LiteralByteString var3 = (LiteralByteString)var1;
         return this.hash != 0 && var3.hash != 0 && this.hash != var3.hash?false:this.equalsRange((LiteralByteString)var1, 0, this.size());
      } else if(var1 instanceof RopeByteString) {
         return var1.equals(this);
      } else {
         String var2 = String.valueOf(String.valueOf(var1.getClass()));
         throw new IllegalArgumentException((new StringBuilder(49 + var2.length())).append("Has a new type of ByteString been created? Found ").append(var2).toString());
      }
   }

   boolean equalsRange(LiteralByteString var1, int var2, int var3) {
      if(var3 > var1.size()) {
         int var9 = this.size();
         throw new IllegalArgumentException((new StringBuilder(40)).append("Length too large: ").append(var3).append(var9).toString());
      } else {
         int var6;
         if(var2 + var3 > var1.size()) {
            var6 = var1.size();
            throw new IllegalArgumentException((new StringBuilder(59)).append("Ran off end of other: ").append(var2).append(", ").append(var3).append(", ").append(var6).toString());
         } else {
            byte[] var4 = this.bytes;
            byte[] var5 = var1.bytes;
            var6 = this.getOffsetIntoBytes() + var3;
            int var7 = this.getOffsetIntoBytes();

            for(int var8 = var1.getOffsetIntoBytes() + var2; var7 < var6; ++var8) {
               if(var4[var7] != var5[var8]) {
                  return false;
               }

               ++var7;
            }

            return true;
         }
      }
   }

   public int hashCode() {
      int var1 = this.hash;
      if(var1 == 0) {
         int var2 = this.size();
         var1 = this.partialHash(var2, 0, var2);
         if(var1 == 0) {
            var1 = 1;
         }

         this.hash = var1;
      }

      return var1;
   }

   protected int peekCachedHashCode() {
      return this.hash;
   }

   protected int partialHash(int var1, int var2, int var3) {
      return hashCode(var1, this.bytes, this.getOffsetIntoBytes() + var2, var3);
   }

   static int hashCode(int var0, byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var0 = var0 * 31 + var1[var4];
      }

      return var0;
   }

   static int hashCode(byte[] var0) {
      int var1 = hashCode(var0.length, var0, 0, var0.length);
      return var1 == 0?1:var1;
   }

   public InputStream newInput() {
      return new ByteArrayInputStream(this.bytes, this.getOffsetIntoBytes(), this.size());
   }

   public CodedInputStream newCodedInput() {
      return CodedInputStream.newInstance(this);
   }

   public ByteString$ByteIterator iterator() {
      return new LiteralByteString$LiteralByteIterator(this, (LiteralByteString$1)null);
   }

   protected int getTreeDepth() {
      return 0;
   }

   protected boolean isBalanced() {
      return true;
   }

   protected int getOffsetIntoBytes() {
      return 0;
   }
}
