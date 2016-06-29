package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import com.google.protobuf.Internal$MapAdapter$IteratorAdapter;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class Internal$MapAdapter$SetAdapter extends AbstractSet {
   private final Set realSet;
   // $FF: synthetic field
   final Internal$MapAdapter this$0;

   public Internal$MapAdapter$SetAdapter(Internal$MapAdapter var1, Set var2) {
      this.this$0 = var1;
      this.realSet = var2;
   }

   public Iterator iterator() {
      return new Internal$MapAdapter$IteratorAdapter(this.this$0, this.realSet.iterator());
   }

   public int size() {
      return this.realSet.size();
   }
}
