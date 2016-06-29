package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.Parser;

public class GeneratedMessageLite$PrototypeHolder {
   private final GeneratedMessageLite defaultInstance;
   private final Parser parser;

   public GeneratedMessageLite$PrototypeHolder(GeneratedMessageLite var1, Parser var2) {
      this.defaultInstance = var1;
      this.parser = var2;
   }

   public GeneratedMessageLite getDefaultInstanceForType() {
      return this.defaultInstance;
   }

   public Parser getParserForType() {
      return this.parser;
   }

   public GeneratedMessageLite$Builder newBuilderForType() {
      return this.defaultInstance.toBuilder();
   }
}
