package com.google.common.collect;

import com.google.common.collect.Multimap;
import java.util.AbstractCollection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class Multimaps$Entries extends AbstractCollection {
   abstract Multimap multimap();

   public int size() {
      return this.multimap().size();
   }

   public boolean contains(@Nullable Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return this.multimap().containsEntry(var2.getKey(), var2.getValue());
      } else {
         return false;
      }
   }

   public boolean remove(@Nullable Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return this.multimap().remove(var2.getKey(), var2.getValue());
      } else {
         return false;
      }
   }

   public void clear() {
      this.multimap().clear();
   }
}
