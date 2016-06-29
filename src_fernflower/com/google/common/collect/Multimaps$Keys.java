package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Keys$1;
import com.google.common.collect.Multimaps$Keys$KeysEntrySet;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class Multimaps$Keys extends AbstractMultiset {
   @Weak
   final Multimap multimap;

   Multimaps$Keys(Multimap var1) {
      this.multimap = var1;
   }

   Iterator entryIterator() {
      return new Multimaps$Keys$1(this, this.multimap.asMap().entrySet().iterator());
   }

   int distinctElements() {
      return this.multimap.asMap().size();
   }

   Set createEntrySet() {
      return new Multimaps$Keys$KeysEntrySet(this);
   }

   public boolean contains(@Nullable Object var1) {
      return this.multimap.containsKey(var1);
   }

   public Iterator iterator() {
      return Maps.keyIterator(this.multimap.entries().iterator());
   }

   public int count(@Nullable Object var1) {
      Collection var2 = (Collection)Maps.safeGet(this.multimap.asMap(), var1);
      return var2 == null?0:var2.size();
   }

   public int remove(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "occurrences");
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Collection var3 = (Collection)Maps.safeGet(this.multimap.asMap(), var1);
         if(var3 == null) {
            return 0;
         } else {
            int var4 = var3.size();
            if(var2 >= var4) {
               var3.clear();
            } else {
               Iterator var5 = var3.iterator();

               for(int var6 = 0; var6 < var2; ++var6) {
                  var5.next();
                  var5.remove();
               }
            }

            return var4;
         }
      }
   }

   public void clear() {
      this.multimap.clear();
   }

   public Set elementSet() {
      return this.multimap.keySet();
   }
}
