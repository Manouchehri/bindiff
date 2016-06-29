package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$KeySet;

@Beta
public class ForwardingMap$StandardKeySet extends Maps$KeySet {
   // $FF: synthetic field
   final ForwardingMap this$0;

   public ForwardingMap$StandardKeySet(ForwardingMap var1) {
      super(var1);
      this.this$0 = var1;
   }
}
