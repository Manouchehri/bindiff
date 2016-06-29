package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

class DynamicMessage$1 extends AbstractParser {
   // $FF: synthetic field
   final DynamicMessage this$0;

   DynamicMessage$1(DynamicMessage var1) {
      this.this$0 = var1;
   }

   public DynamicMessage parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DynamicMessage$Builder var3 = DynamicMessage.newBuilder(DynamicMessage.access$200(this.this$0));

      try {
         var3.mergeFrom(var1, var2);
      } catch (InvalidProtocolBufferException var5) {
         throw var5.setUnfinishedMessage(var3.buildPartial());
      } catch (IOException var6) {
         throw (new InvalidProtocolBufferException(var6.getMessage())).setUnfinishedMessage(var3.buildPartial());
      }

      return var3.buildPartial();
   }
}
