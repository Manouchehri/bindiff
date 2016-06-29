package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Metadata;

class MapEntryLite$Metadata$1 extends AbstractParser {
   // $FF: synthetic field
   final MapEntryLite$Metadata val$finalThis;
   // $FF: synthetic field
   final MapEntryLite$Metadata this$0;

   MapEntryLite$Metadata$1(MapEntryLite$Metadata var1, MapEntryLite$Metadata var2) {
      this.this$0 = var1;
      this.val$finalThis = var2;
   }

   public MapEntryLite parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      return new MapEntryLite(this.val$finalThis, var1, var2, (MapEntryLite$1)null);
   }
}
