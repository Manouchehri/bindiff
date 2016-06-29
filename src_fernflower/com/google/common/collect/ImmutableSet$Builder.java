package com.google.common.collect;

import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

public class ImmutableSet$Builder extends ImmutableCollection$ArrayBasedBuilder {
   public ImmutableSet$Builder() {
      this(4);
   }

   ImmutableSet$Builder(int var1) {
      super(var1);
   }

   public ImmutableSet$Builder add(Object var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSet$Builder add(Object... var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSet$Builder addAll(Iterable var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSet$Builder addAll(Iterator var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSet build() {
      ImmutableSet var1 = ImmutableSet.access$000(this.size, this.contents);
      this.size = var1.size();
      return var1;
   }
}
