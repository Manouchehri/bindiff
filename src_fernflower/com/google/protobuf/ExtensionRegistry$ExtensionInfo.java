package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.ExtensionRegistry$1;
import com.google.protobuf.Message;

public final class ExtensionRegistry$ExtensionInfo {
   public final Descriptors$FieldDescriptor descriptor;
   public final Message defaultInstance;

   private ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor var1) {
      this.descriptor = var1;
      this.defaultInstance = null;
   }

   private ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor var1, Message var2) {
      this.descriptor = var1;
      this.defaultInstance = var2;
   }

   // $FF: synthetic method
   ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor var1, Message var2, ExtensionRegistry$1 var3) {
      this(var1, var2);
   }
}
