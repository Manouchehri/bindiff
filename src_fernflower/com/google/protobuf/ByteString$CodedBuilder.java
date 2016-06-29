package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$1;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.LiteralByteString;

final class ByteString$CodedBuilder {
   private final CodedOutputStream output;
   private final byte[] buffer;

   private ByteString$CodedBuilder(int var1) {
      this.buffer = new byte[var1];
      this.output = CodedOutputStream.newInstance(this.buffer);
   }

   public ByteString build() {
      this.output.checkNoSpaceLeft();
      return new LiteralByteString(this.buffer);
   }

   public CodedOutputStream getCodedOutput() {
      return this.output;
   }

   // $FF: synthetic method
   ByteString$CodedBuilder(int var1, ByteString$1 var2) {
      this(var1);
   }
}
