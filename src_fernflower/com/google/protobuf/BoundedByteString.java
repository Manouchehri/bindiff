package com.google.protobuf;

import com.google.protobuf.BoundedByteString$1;
import com.google.protobuf.BoundedByteString$BoundedByteIterator;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.LiteralByteString;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

class BoundedByteString extends LiteralByteString {
   private final int bytesOffset;
   private final int bytesLength;
   private static final long serialVersionUID = 1L;

   BoundedByteString(byte[] var1, int var2, int var3) {
      super(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException((new StringBuilder(29)).append("Offset too small: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IllegalArgumentException((new StringBuilder(29)).append("Length too small: ").append(var2).toString());
      } else if((long)var2 + (long)var3 > (long)var1.length) {
         throw new IllegalArgumentException((new StringBuilder(48)).append("Offset+Length too large: ").append(var2).append("+").append(var3).toString());
      } else {
         this.bytesOffset = var2;
         this.bytesLength = var3;
      }
   }

   public byte byteAt(int var1) {
      if(var1 < 0) {
         throw new ArrayIndexOutOfBoundsException((new StringBuilder(28)).append("Index too small: ").append(var1).toString());
      } else if(var1 >= this.size()) {
         int var3 = this.size();
         throw new ArrayIndexOutOfBoundsException((new StringBuilder(41)).append("Index too large: ").append(var1).append(", ").append(var3).toString());
      } else {
         return this.bytes[this.bytesOffset + var1];
      }
   }

   public int size() {
      return this.bytesLength;
   }

   protected int getOffsetIntoBytes() {
      return this.bytesOffset;
   }

   protected void copyToInternal(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.bytes, this.getOffsetIntoBytes() + var2, var1, var3, var4);
   }

   Object writeReplace() {
      return new LiteralByteString(this.toByteArray());
   }

   private void readObject(ObjectInputStream var1) {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
   }

   public ByteString$ByteIterator iterator() {
      return new BoundedByteString$BoundedByteIterator(this, (BoundedByteString$1)null);
   }
}
