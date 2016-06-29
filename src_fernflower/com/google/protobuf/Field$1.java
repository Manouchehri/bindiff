package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.InvalidProtocolBufferException;

final class Field$1 extends AbstractParser {
   public Field parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new Field(var1, var2, (Field$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
