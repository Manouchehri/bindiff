package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageOrBuilderExternalList extends AbstractList implements List {
   RepeatedFieldBuilder builder;

   RepeatedFieldBuilder$MessageOrBuilderExternalList(RepeatedFieldBuilder var1) {
      this.builder = var1;
   }

   public int size() {
      return this.builder.getCount();
   }

   public MessageOrBuilder get(int var1) {
      return this.builder.getMessageOrBuilder(var1);
   }

   void incrementModCount() {
      ++this.modCount;
   }
}
