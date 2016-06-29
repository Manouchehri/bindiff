package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;

final class GeneratedMessage$1 extends GeneratedMessage$CachedDescriptorRetriever {
   // $FF: synthetic field
   final Message val$scope;
   // $FF: synthetic field
   final int val$descriptorIndex;

   GeneratedMessage$1(Message var1, int var2) {
      super((GeneratedMessage$1)null);
      this.val$scope = var1;
      this.val$descriptorIndex = var2;
   }

   public Descriptors$FieldDescriptor loadDescriptor() {
      return (Descriptors$FieldDescriptor)this.val$scope.getDescriptorForType().getExtensions().get(this.val$descriptorIndex);
   }
}
