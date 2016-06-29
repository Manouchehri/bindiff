package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.InvalidProtocolBufferException;

final class FloatValue$1 extends AbstractParser {
   public FloatValue parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new FloatValue(var1, var2, (FloatValue$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
