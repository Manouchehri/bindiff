package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;

final class Lists$CharSequenceAsList extends AbstractList {
   private final CharSequence sequence;

   Lists$CharSequenceAsList(CharSequence var1) {
      this.sequence = var1;
   }

   public Character get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return Character.valueOf(this.sequence.charAt(var1));
   }

   public int size() {
      return this.sequence.length();
   }
}
