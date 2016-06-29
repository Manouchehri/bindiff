package com.google.common.collect;

import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableEnumMap$1;
import java.io.Serializable;
import java.util.EnumMap;

class ImmutableEnumMap$EnumSerializedForm implements Serializable {
   final EnumMap delegate;
   private static final long serialVersionUID = 0L;

   ImmutableEnumMap$EnumSerializedForm(EnumMap var1) {
      this.delegate = var1;
   }

   Object readResolve() {
      return new ImmutableEnumMap(this.delegate, (ImmutableEnumMap$1)null);
   }
}
