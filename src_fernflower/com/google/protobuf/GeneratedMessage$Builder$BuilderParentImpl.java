package com.google.protobuf;

import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;

class GeneratedMessage$Builder$BuilderParentImpl implements GeneratedMessage$BuilderParent {
   // $FF: synthetic field
   final GeneratedMessage$Builder this$0;

   private GeneratedMessage$Builder$BuilderParentImpl(GeneratedMessage$Builder var1) {
      this.this$0 = var1;
   }

   public void markDirty() {
      this.this$0.onChanged();
   }

   // $FF: synthetic method
   GeneratedMessage$Builder$BuilderParentImpl(GeneratedMessage$Builder var1, GeneratedMessage$1 var2) {
      this(var1);
   }
}
