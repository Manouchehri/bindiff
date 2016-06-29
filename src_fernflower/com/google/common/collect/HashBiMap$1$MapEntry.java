package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.Hashing;

class HashBiMap$1$MapEntry extends AbstractMapEntry {
   HashBiMap$BiEntry delegate;
   // $FF: synthetic field
   final HashBiMap$1 this$1;

   HashBiMap$1$MapEntry(HashBiMap$1 var1, HashBiMap$BiEntry var2) {
      this.this$1 = var1;
      this.delegate = var2;
   }

   public Object getKey() {
      return this.delegate.key;
   }

   public Object getValue() {
      return this.delegate.value;
   }

   public Object setValue(Object var1) {
      Object var2 = this.delegate.value;
      int var3 = Hashing.smearedHash(var1);
      if(var3 == this.delegate.valueHash && Objects.equal(var1, var2)) {
         return var1;
      } else {
         Preconditions.checkArgument(HashBiMap.access$400(this.this$1.this$0, var1, var3) == null, "value already present: %s", new Object[]{var1});
         HashBiMap.access$200(this.this$1.this$0, this.delegate);
         HashBiMap$BiEntry var4 = new HashBiMap$BiEntry(this.delegate.key, this.delegate.keyHash, var1, var3);
         HashBiMap.access$500(this.this$1.this$0, var4, this.delegate);
         this.delegate.prevInKeyInsertionOrder = null;
         this.delegate.nextInKeyInsertionOrder = null;
         this.this$1.expectedModCount = HashBiMap.access$100(this.this$1.this$0);
         if(this.this$1.toRemove == this.delegate) {
            this.this$1.toRemove = var4;
         }

         this.delegate = var4;
         return var2;
      }
   }
}
