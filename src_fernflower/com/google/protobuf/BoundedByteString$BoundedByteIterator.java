package com.google.protobuf;

import com.google.protobuf.BoundedByteString;
import com.google.protobuf.BoundedByteString$1;
import com.google.protobuf.ByteString$ByteIterator;
import java.util.NoSuchElementException;

class BoundedByteString$BoundedByteIterator implements ByteString$ByteIterator {
   private int position;
   private final int limit;
   // $FF: synthetic field
   final BoundedByteString this$0;

   private BoundedByteString$BoundedByteIterator(BoundedByteString var1) {
      this.this$0 = var1;
      this.position = var1.getOffsetIntoBytes();
      this.limit = this.position + var1.size();
   }

   public boolean hasNext() {
      return this.position < this.limit;
   }

   public Byte next() {
      return Byte.valueOf(this.nextByte());
   }

   public byte nextByte() {
      if(this.position >= this.limit) {
         throw new NoSuchElementException();
      } else {
         return this.this$0.bytes[this.position++];
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   BoundedByteString$BoundedByteIterator(BoundedByteString var1, BoundedByteString$1 var2) {
      this(var1);
   }
}
