package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse$1$1;
import com.google.common.collect.Hashing;

class HashBiMap$Inverse$1$1$InverseEntry extends AbstractMapEntry {
   HashBiMap$BiEntry delegate;
   // $FF: synthetic field
   final HashBiMap$Inverse$1$1 this$3;

   HashBiMap$Inverse$1$1$InverseEntry(HashBiMap$Inverse$1$1 var1, HashBiMap$BiEntry var2) {
      this.this$3 = var1;
      this.delegate = var2;
   }

   public Object getKey() {
      return this.delegate.value;
   }

   public Object getValue() {
      return this.delegate.key;
   }

   public Object setValue(Object var1) {
      Object var2 = this.delegate.key;
      int var3 = Hashing.smearedHash(var1);
      if(var3 == this.delegate.keyHash && Objects.equal(var1, var2)) {
         return var1;
      } else {
         Preconditions.checkArgument(HashBiMap.access$300(this.this$3.this$2.this$1.this$0, var1, var3) == null, "value already present: %s", new Object[]{var1});
         HashBiMap.access$200(this.this$3.this$2.this$1.this$0, this.delegate);
         HashBiMap$BiEntry var4 = new HashBiMap$BiEntry(var1, var3, this.delegate.value, this.delegate.valueHash);
         this.delegate = var4;
         HashBiMap.access$500(this.this$3.this$2.this$1.this$0, var4, (HashBiMap$BiEntry)null);
         this.this$3.expectedModCount = HashBiMap.access$100(this.this$3.this$2.this$1.this$0);
         return var2;
      }
   }
}
