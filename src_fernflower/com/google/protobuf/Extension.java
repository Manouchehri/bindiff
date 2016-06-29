package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.Extension$MessageType;
import com.google.protobuf.ExtensionLite;

public abstract class Extension extends ExtensionLite {
   public abstract Descriptors$FieldDescriptor getDescriptor();

   final boolean isLite() {
      return false;
   }

   protected Extension$ExtensionType getExtensionType() {
      return Extension$ExtensionType.IMMUTABLE;
   }

   public Extension$MessageType getMessageType() {
      return Extension$MessageType.PROTO2;
   }

   protected abstract Object fromReflectionType(Object var1);

   protected abstract Object singularFromReflectionType(Object var1);

   protected abstract Object toReflectionType(Object var1);

   protected abstract Object singularToReflectionType(Object var1);
}
