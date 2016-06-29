package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.EmptyProto$1;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;

public final class EmptyProto {
   static Descriptors$Descriptor internal_static_google_protobuf_Empty_descriptor;
   static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Empty_fieldAccessorTable;
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
      String[] var0 = new String[]{"\n\u001bgoogle/protobuf/empty.proto\u0012\u000fgoogle.protobuf\"\u0007\n\u0005EmptyB)\n\u0013com.google.protobufB\nEmptyProtoP\u0001¢\u0002\u0003GPBb\u0006proto3"};
      EmptyProto$1 var1 = new EmptyProto$1();
      Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(var0, new Descriptors$FileDescriptor[0], var1);
      internal_static_google_protobuf_Empty_descriptor = (Descriptors$Descriptor)getDescriptor().getMessageTypes().get(0);
      internal_static_google_protobuf_Empty_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Empty_descriptor, new String[0]);
   }
}
