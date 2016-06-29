package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;

final class GeneratedMessage$2 extends GeneratedMessage$CachedDescriptorRetriever {
   // $FF: synthetic field
   final Message val$scope;
   // $FF: synthetic field
   final String val$name;

   GeneratedMessage$2(Message var1, String var2) {
      super((GeneratedMessage$1)null);
      this.val$scope = var1;
      this.val$name = var2;
   }

   protected Descriptors$FieldDescriptor loadDescriptor() {
      return this.val$scope.getDescriptorForType().findFieldByName(this.val$name);
   }
}
