package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;

final class DescriptorProtos$ServiceDescriptorProto$1 extends AbstractParser {
   public DescriptorProtos$ServiceDescriptorProto parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new DescriptorProtos$ServiceDescriptorProto(var1, var2, (DescriptorProtos$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
