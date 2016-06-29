package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;

final class DoubleValue$1 extends AbstractParser {
   public DoubleValue parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new DoubleValue(var1, var2, (DoubleValue$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
