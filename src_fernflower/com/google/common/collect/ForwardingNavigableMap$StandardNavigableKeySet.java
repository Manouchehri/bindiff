package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;

@Beta
public class ForwardingNavigableMap$StandardNavigableKeySet extends Maps$NavigableKeySet {
   // $FF: synthetic field
   final ForwardingNavigableMap this$0;

   public ForwardingNavigableMap$StandardNavigableKeySet(ForwardingNavigableMap var1) {
      super(var1);
      this.this$0 = var1;
   }
}
