package com.google.protobuf;

import com.google.protobuf.CodedInputStream;

enum WireFormat$Utf8Validation$2 {
   Object readString(CodedInputStream var1) {
      return var1.readStringRequireUtf8();
   }
}
