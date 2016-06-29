package com.google.protos.BinExport;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Callgraph;

final class BinExport$Callgraph$1 extends AbstractParser {
   public BinExport$Callgraph parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      try {
         return new BinExport$Callgraph(var1, var2, (BinExport$1)null);
      } catch (RuntimeException var4) {
         if(var4.getCause() instanceof InvalidProtocolBufferException) {
            throw (InvalidProtocolBufferException)var4.getCause();
         } else {
            throw var4;
         }
      }
   }
}
