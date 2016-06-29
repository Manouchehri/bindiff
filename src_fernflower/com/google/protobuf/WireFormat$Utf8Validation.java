package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;

enum WireFormat$Utf8Validation {
   LOOSE,
   STRICT,
   LAZY;

   private WireFormat$Utf8Validation() {
   }

   abstract Object readString(CodedInputStream var1);

   // $FF: synthetic method
   WireFormat$Utf8Validation(WireFormat$1 var3) {
      this();
   }
}
