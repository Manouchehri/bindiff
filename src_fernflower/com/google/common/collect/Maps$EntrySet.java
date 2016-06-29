package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

abstract class Maps$EntrySet extends Sets$ImprovedAbstractSet {
   abstract Map map();

   public int size() {
      return this.map().size();
   }

   public void clear() {
      this.map().clear();
   }

   public boolean contains(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         Object var4 = Maps.safeGet(this.map(), var3);
         return Objects.equal(var4, var2.getValue()) && (var4 != null || this.map().containsKey(var3));
      }
   }

   public boolean isEmpty() {
      return this.map().isEmpty();
   }

   public boolean remove(Object var1) {
      if(this.contains(var1)) {
         Entry var2 = (Entry)var1;
         return this.map().keySet().remove(var2.getKey());
      } else {
         return false;
      }
   }

   public boolean removeAll(Collection var1) {
      try {
         return super.removeAll((Collection)Preconditions.checkNotNull(var1));
      } catch (UnsupportedOperationException var3) {
         return Sets.removeAllImpl(this, (Iterator)var1.iterator());
      }
   }

   public boolean retainAll(Collection var1) {
      try {
         return super.retainAll((Collection)Preconditions.checkNotNull(var1));
      } catch (UnsupportedOperationException var7) {
         HashSet var3 = Sets.newHashSetWithExpectedSize(var1.size());
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            if(this.contains(var5)) {
               Entry var6 = (Entry)var5;
               var3.add(var6.getKey());
            }
         }

         return this.map().keySet().retainAll(var3);
      }
   }
}
