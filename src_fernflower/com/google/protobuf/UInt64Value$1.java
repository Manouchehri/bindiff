package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UInt64Value;

final class UInt64Value$1 extends AbstractParser {
   public UInt64Value parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new UInt64Value(var1, var2, (UInt64Value$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
