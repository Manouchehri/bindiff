package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.EnumMap;
import java.util.Map;

final class MultimapBuilder$4 extends MultimapBuilder$MultimapBuilderWithKeys {
   // $FF: synthetic field
   final Class val$keyClass;

   MultimapBuilder$4(Class var1) {
      this.val$keyClass = var1;
   }

   Map createMap() {
      return new EnumMap(this.val$keyClass);
   }
}
