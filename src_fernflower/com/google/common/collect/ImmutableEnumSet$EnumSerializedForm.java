package com.google.common.collect;

import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableEnumSet$1;
import java.io.Serializable;
import java.util.EnumSet;

class ImmutableEnumSet$EnumSerializedForm implements Serializable {
   final EnumSet delegate;
   private static final long serialVersionUID = 0L;

   ImmutableEnumSet$EnumSerializedForm(EnumSet var1) {
      this.delegate = var1;
   }

   Object readResolve() {
      return new ImmutableEnumSet(this.delegate.clone(), (ImmutableEnumSet$1)null);
   }
}
