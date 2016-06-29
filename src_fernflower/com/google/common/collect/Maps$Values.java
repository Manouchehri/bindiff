package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class Maps$Values extends AbstractCollection {
   @Weak
   final Map map;

   Maps$Values(Map var1) {
      this.map = (Map)Preconditions.checkNotNull(var1);
   }

   final Map map() {
      return this.map;
   }

   public Iterator iterator() {
      return Maps.valueIterator(this.map().entrySet().iterator());
   }

   public boolean remove(Object var1) {
      try {
         return super.remove(var1);
      } catch (UnsupportedOperationException var5) {
         Iterator var3 = this.map().entrySet().iterator();

         Entry var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (Entry)var3.next();
         } while(!Objects.equal(var1, var4.getValue()));

         this.map().remove(var4.getKey());
         return true;
      }
   }

   public boolean removeAll(Collection var1) {
      try {
         return super.removeAll((Collection)Preconditions.checkNotNull(var1));
      } catch (UnsupportedOperationException var6) {
         HashSet var3 = Sets.newHashSet();
         Iterator var4 = this.map().entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            if(var1.contains(var5.getValue())) {
               var3.add(var5.getKey());
            }
         }

         return this.map().keySet().removeAll(var3);
      }
   }

   public boolean retainAll(Collection var1) {
      try {
         return super.retainAll((Collection)Preconditions.checkNotNull(var1));
      } catch (UnsupportedOperationException var6) {
         HashSet var3 = Sets.newHashSet();
         Iterator var4 = this.map().entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            if(var1.contains(var5.getValue())) {
               var3.add(var5.getKey());
            }
         }

         return this.map().keySet().retainAll(var3);
      }
   }

   public int size() {
      return this.map().size();
   }

   public boolean isEmpty() {
      return this.map().isEmpty();
   }

   public boolean contains(@Nullable Object var1) {
      return this.map().containsValue(var1);
   }

   public void clear() {
      this.map().clear();
   }
}
