package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class MultimapBuilder$3 extends MultimapBuilder$MultimapBuilderWithKeys {
   // $FF: synthetic field
   final Comparator val$comparator;

   MultimapBuilder$3(Comparator var1) {
      this.val$comparator = var1;
   }

   Map createMap() {
      return new TreeMap(this.val$comparator);
   }
}
