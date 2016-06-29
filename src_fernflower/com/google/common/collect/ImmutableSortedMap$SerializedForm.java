package com.google.common.collect;

import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$Builder;
import java.util.Comparator;

class ImmutableSortedMap$SerializedForm extends ImmutableMap$SerializedForm {
   private final Comparator comparator;
   private static final long serialVersionUID = 0L;

   ImmutableSortedMap$SerializedForm(ImmutableSortedMap var1) {
      super(var1);
      this.comparator = var1.comparator();
   }

   Object readResolve() {
      ImmutableSortedMap$Builder var1 = new ImmutableSortedMap$Builder(this.comparator);
      return this.createMap(var1);
   }
}
