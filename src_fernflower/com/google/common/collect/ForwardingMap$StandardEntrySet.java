package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$EntrySet;
import java.util.Map;

@Beta
public abstract class ForwardingMap$StandardEntrySet extends Maps$EntrySet {
   // $FF: synthetic field
   final ForwardingMap this$0;

   public ForwardingMap$StandardEntrySet(ForwardingMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }
}
