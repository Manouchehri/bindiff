package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.SmallSortedMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class SmallSortedMap$1 extends SmallSortedMap {
   SmallSortedMap$1(int var1) {
      super(var1, (SmallSortedMap$1)null);
   }

   public void makeImmutable() {
      if(!this.isImmutable()) {
         Entry var2;
         List var3;
         for(int var1 = 0; var1 < this.getNumArrayEntries(); ++var1) {
            var2 = this.getArrayEntryAt(var1);
            if(((FieldSet$FieldDescriptorLite)var2.getKey()).isRepeated()) {
               var3 = (List)var2.getValue();
               var2.setValue(Collections.unmodifiableList(var3));
            }
         }

         Iterator var4 = this.getOverflowEntries().iterator();

         while(var4.hasNext()) {
            var2 = (Entry)var4.next();
            if(((FieldSet$FieldDescriptorLite)var2.getKey()).isRepeated()) {
               var3 = (List)var2.getValue();
               var2.setValue(Collections.unmodifiableList(var3));
            }
         }
      }

      super.makeImmutable();
   }
}
