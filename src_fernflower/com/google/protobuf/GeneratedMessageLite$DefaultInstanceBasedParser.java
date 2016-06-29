package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;

public class GeneratedMessageLite$DefaultInstanceBasedParser extends AbstractParser {
   private GeneratedMessageLite defaultInstance;

   public GeneratedMessageLite$DefaultInstanceBasedParser(GeneratedMessageLite var1) {
      this.defaultInstance = var1;
   }

   public GeneratedMessageLite parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, var1, var2);
   }
}
