package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$AsMap$AsMapEntries extends Maps$EntrySet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap$AsMap this$1;

   AbstractMapBasedMultimap$AsMap$AsMapEntries(AbstractMapBasedMultimap$AsMap var1) {
      this.this$1 = var1;
   }

   Map map() {
      return this.this$1;
   }

   public Iterator iterator() {
      return new AbstractMapBasedMultimap$AsMap$AsMapIterator(this.this$1);
   }

   public boolean contains(Object var1) {
      return Collections2.safeContains(this.this$1.submap.entrySet(), var1);
   }

   public boolean remove(Object var1) {
      if(!this.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         AbstractMapBasedMultimap.access$400(this.this$1.this$0, var2.getKey());
         return true;
      }
   }
}
