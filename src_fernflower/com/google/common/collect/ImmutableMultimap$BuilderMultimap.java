package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.LinkedHashMap;

class ImmutableMultimap$BuilderMultimap extends AbstractMapBasedMultimap {
   private static final long serialVersionUID = 0L;

   ImmutableMultimap$BuilderMultimap() {
      super(new LinkedHashMap());
   }

   Collection createCollection() {
      return Lists.newArrayList();
   }
}
