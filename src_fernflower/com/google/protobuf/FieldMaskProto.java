package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.FieldMaskProto$1;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;

public final class FieldMaskProto {
   static Descriptors$Descriptor internal_static_google_protobuf_FieldMask_descriptor;
   static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_FieldMask_fieldAccessorTable;
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
      String[] var0 = new String[]{"\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"\u001a\n\tFieldMask\u0012\r\n\u0005paths\u0018\u0001 \u0003(\tBF\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3"};
      FieldMaskProto$1 var1 = new FieldMaskProto$1();
      Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(var0, new Descriptors$FileDescriptor[0], var1);
      internal_static_google_protobuf_FieldMask_descriptor = (Descriptors$Descriptor)getDescriptor().getMessageTypes().get(0);
      internal_static_google_protobuf_FieldMask_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_FieldMask_descriptor, new String[]{"Paths"});
   }
}
