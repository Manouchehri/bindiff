package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.Map;

final class MultimapBuilder$2 extends MultimapBuilder$MultimapBuilderWithKeys {
   // $FF: synthetic field
   final int val$expectedKeys;

   MultimapBuilder$2(int var1) {
      this.val$expectedKeys = var1;
   }

   Map createMap() {
      return Maps.newLinkedHashMapWithExpectedSize(this.val$expectedKeys);
   }
}
