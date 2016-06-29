package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;

final class Lists$StringAsImmutableList extends ImmutableList {
   private final String string;

   Lists$StringAsImmutableList(String var1) {
      this.string = var1;
   }

   public int indexOf(@Nullable Object var1) {
      return var1 instanceof Character?this.string.indexOf(((Character)var1).charValue()):-1;
   }

   public int lastIndexOf(@Nullable Object var1) {
      return var1 instanceof Character?this.string.lastIndexOf(((Character)var1).charValue()):-1;
   }

   public ImmutableList subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.size());
      return Lists.charactersOf(this.string.substring(var1, var2));
   }

   boolean isPartialView() {
      return false;
   }

   public Character get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return Character.valueOf(this.string.charAt(var1));
   }

   public int size() {
      return this.string.length();
   }
}
