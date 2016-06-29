package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageExternalList extends AbstractList implements List {
   RepeatedFieldBuilder builder;

   RepeatedFieldBuilder$MessageExternalList(RepeatedFieldBuilder var1) {
      this.builder = var1;
   }

   public int size() {
      return this.builder.getCount();
   }

   public GeneratedMessage get(int var1) {
      return this.builder.getMessage(var1);
   }

   void incrementModCount() {
      ++this.modCount;
   }
}
