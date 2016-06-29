package com.google.protobuf;

import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.LiteralByteString$1;
import java.util.NoSuchElementException;

class LiteralByteString$LiteralByteIterator implements ByteString$ByteIterator {
   private int position;
   private final int limit;
   // $FF: synthetic field
   final LiteralByteString this$0;

   private LiteralByteString$LiteralByteIterator(LiteralByteString var1) {
      this.this$0 = var1;
      this.position = 0;
      this.limit = var1.size();
   }

   public boolean hasNext() {
      return this.position < this.limit;
   }

   public Byte next() {
      return Byte.valueOf(this.nextByte());
   }

   public byte nextByte() {
      try {
         return this.this$0.bytes[this.position++];
      } catch (ArrayIndexOutOfBoundsException var2) {
         throw new NoSuchElementException(var2.getMessage());
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   LiteralByteString$LiteralByteIterator(LiteralByteString var1, LiteralByteString$1 var2) {
      this(var1);
   }
}
