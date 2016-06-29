package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat$ByteSequence;

final class TextFormat$1 implements TextFormat$ByteSequence {
   // $FF: synthetic field
   final ByteString val$input;

   TextFormat$1(ByteString var1) {
      this.val$input = var1;
   }

   public int size() {
      return this.val$input.size();
   }

   public byte byteAt(int var1) {
      return this.val$input.byteAt(var1);
   }
}
