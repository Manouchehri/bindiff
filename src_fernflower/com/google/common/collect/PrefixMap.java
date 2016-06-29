package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;

@GoogleInternal
public interface PrefixMap {
   Object put(CharSequence var1, Object var2);

   Object get(CharSequence var1);

   Object remove(CharSequence var1);
}
