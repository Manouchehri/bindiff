package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;

final class Int64Value$1 extends AbstractParser {
   public Int64Value parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new Int64Value(var1, var2, (Int64Value$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
