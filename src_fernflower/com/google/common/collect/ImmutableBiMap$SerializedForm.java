package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableMap$SerializedForm;

class ImmutableBiMap$SerializedForm extends ImmutableMap$SerializedForm {
   private static final long serialVersionUID = 0L;

   ImmutableBiMap$SerializedForm(ImmutableBiMap var1) {
      super(var1);
   }

   Object readResolve() {
      ImmutableBiMap$Builder var1 = new ImmutableBiMap$Builder();
      return this.createMap(var1);
   }
}
