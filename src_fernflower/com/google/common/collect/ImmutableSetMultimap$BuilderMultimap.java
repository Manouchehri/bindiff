package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashMap;

class ImmutableSetMultimap$BuilderMultimap extends AbstractMapBasedMultimap {
   private static final long serialVersionUID = 0L;

   ImmutableSetMultimap$BuilderMultimap() {
      super(new LinkedHashMap());
   }

   Collection createCollection() {
      return Sets.newLinkedHashSet();
   }
}
