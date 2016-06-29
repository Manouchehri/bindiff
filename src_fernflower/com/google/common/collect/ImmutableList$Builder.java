package com.google.common.collect;

import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public final class ImmutableList$Builder extends ImmutableCollection$ArrayBasedBuilder {
   public ImmutableList$Builder() {
      this(4);
   }

   ImmutableList$Builder(int var1) {
      super(var1);
   }

   public ImmutableList$Builder add(Object var1) {
      super.add(var1);
      return this;
   }

   public ImmutableList$Builder addAll(Iterable var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableList$Builder add(Object... var1) {
      super.add(var1);
      return this;
   }

   public ImmutableList$Builder addAll(Iterator var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableList build() {
      return ImmutableList.asImmutableList(this.contents, this.size);
   }
}
