package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.SourceContextProto$1;

public final class SourceContextProto {
   static Descriptors$Descriptor internal_static_google_protobuf_SourceContext_descriptor;
   static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable;
   private static Descriptors$FileDescriptor descriptor;

   public static void registerAllExtensions(ExtensionRegistry var0) {
   }

   public static Descriptors$FileDescriptor getDescriptor() {
      return descriptor;
   }

   // $FF: synthetic method
   static Descriptors$FileDescriptor access$002(Descriptors$FileDescriptor var0) {
      descriptor = var0;
      return var0;
   }

   static {
      String[] var0 = new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tB1\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001¢\u0002\u0003GPBb\u0006proto3"};
      SourceContextProto$1 var1 = new SourceContextProto$1();
      Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(var0, new Descriptors$FileDescriptor[0], var1);
      internal_static_google_protobuf_SourceContext_descriptor = (Descriptors$Descriptor)getDescriptor().getMessageTypes().get(0);
      internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_SourceContext_descriptor, new String[]{"FileName"});
   }
}
