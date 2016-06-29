package com.google.protobuf;

import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$BuilderExternalList extends AbstractList implements List {
   RepeatedFieldBuilder builder;

   RepeatedFieldBuilder$BuilderExternalList(RepeatedFieldBuilder var1) {
      this.builder = var1;
   }

   public int size() {
      return this.builder.getCount();
   }

   public GeneratedMessage$Builder get(int var1) {
      return this.builder.getBuilder(var1);
   }

   void incrementModCount() {
      ++this.modCount;
   }
}
