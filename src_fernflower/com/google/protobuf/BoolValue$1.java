package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.BoolValue;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;

final class BoolValue$1 extends AbstractParser {
   public BoolValue parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new BoolValue(var1, var2, (BoolValue$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
