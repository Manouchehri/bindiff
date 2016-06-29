package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Multimaps$AsMap$EntrySet extends Maps$EntrySet {
   // $FF: synthetic field
   final Multimaps$AsMap this$0;

   Multimaps$AsMap$EntrySet(Multimaps$AsMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return Maps.asMapEntryIterator(Multimaps$AsMap.access$200(this.this$0).keySet(), new Multimaps$AsMap$EntrySet$1(this));
   }

   public boolean remove(Object var1) {
      if(!this.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         this.this$0.removeValuesForKey(var2.getKey());
         return true;
      }
   }
}
