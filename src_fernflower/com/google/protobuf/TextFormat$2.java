package com.google.protobuf;

import com.google.protobuf.TextFormat$ByteSequence;

final class TextFormat$2 implements TextFormat$ByteSequence {
   // $FF: synthetic field
   final byte[] val$input;

   TextFormat$2(byte[] var1) {
      this.val$input = var1;
   }

   public int size() {
      return this.val$input.length;
   }

   public byte byteAt(int var1) {
      return this.val$input[var1];
   }
}
