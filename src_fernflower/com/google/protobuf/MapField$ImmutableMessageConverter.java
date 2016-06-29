package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.Message;
import java.util.Map;

class MapField$ImmutableMessageConverter implements MapField$Converter {
   private final MapEntry defaultEntry;

   public MapField$ImmutableMessageConverter(MapEntry var1) {
      this.defaultEntry = var1;
   }

   public Message convertKeyAndValueToMessage(Object var1, Object var2) {
      return this.defaultEntry.newBuilderForType().setKey(var1).setValue(var2).buildPartial();
   }

   public void convertMessageToKeyAndValue(Message var1, Map var2) {
      MapEntry var3 = (MapEntry)var1;
      var2.put(var3.getKey(), var3.getValue());
   }

   public Message getMessageDefaultInstance() {
      return this.defaultEntry;
   }
}
