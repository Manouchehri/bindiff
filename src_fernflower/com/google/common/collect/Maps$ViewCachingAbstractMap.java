package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.Maps$Values;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
abstract class Maps$ViewCachingAbstractMap extends AbstractMap {
   private transient Set entrySet;
   private transient Set keySet;
   private transient Collection values;

   abstract Set createEntrySet();

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 == null?(this.entrySet = this.createEntrySet()):var1;
   }

   public Set keySet() {
      Set var1 = this.keySet;
      return var1 == null?(this.keySet = this.createKeySet()):var1;
   }

   Set createKeySet() {
      return new Maps$KeySet(this);
   }

   public Collection values() {
      Collection var1 = this.values;
      return var1 == null?(this.values = this.createValues()):var1;
   }

   Collection createValues() {
      return new Maps$Values(this);
   }
}
