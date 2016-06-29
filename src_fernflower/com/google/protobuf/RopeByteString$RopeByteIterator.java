package com.google.protobuf;

import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$PieceIterator;

class RopeByteString$RopeByteIterator implements ByteString$ByteIterator {
   private final RopeByteString$PieceIterator pieces;
   private ByteString$ByteIterator bytes;
   int bytesRemaining;
   // $FF: synthetic field
   final RopeByteString this$0;

   private RopeByteString$RopeByteIterator(RopeByteString var1) {
      this.this$0 = var1;
      this.pieces = new RopeByteString$PieceIterator(var1, (RopeByteString$1)null);
      this.bytes = this.pieces.next().iterator();
      this.bytesRemaining = var1.size();
   }

   public boolean hasNext() {
      return this.bytesRemaining > 0;
   }

   public Byte next() {
      return Byte.valueOf(this.nextByte());
   }

   public byte nextByte() {
      if(!this.bytes.hasNext()) {
         this.bytes = this.pieces.next().iterator();
      }

      --this.bytesRemaining;
      return this.bytes.nextByte();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   RopeByteString$RopeByteIterator(RopeByteString var1, RopeByteString$1 var2) {
      this(var1);
   }
}
