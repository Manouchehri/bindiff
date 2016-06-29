package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;

public final class UnknownFieldSet$Parser extends AbstractParser {
   public UnknownFieldSet parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      UnknownFieldSet$Builder var3 = UnknownFieldSet.newBuilder();

      try {
         var3.mergeFrom(var1);
      } catch (InvalidProtocolBufferException var5) {
         throw var5.setUnfinishedMessage(var3.buildPartial());
      } catch (IOException var6) {
         throw (new InvalidProtocolBufferException(var6.getMessage())).setUnfinishedMessage(var3.buildPartial());
      }

      return var3.buildPartial();
   }
}
