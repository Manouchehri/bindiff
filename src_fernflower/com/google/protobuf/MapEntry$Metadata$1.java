package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Parser;

class MapEntry$Metadata$1 extends AbstractParser {
   private final Parser dataParser;
   // $FF: synthetic field
   final MapEntry val$defaultInstance;
   // $FF: synthetic field
   final MapEntry$Metadata val$thisMetadata;
   // $FF: synthetic field
   final MapEntry$Metadata this$0;

   MapEntry$Metadata$1(MapEntry$Metadata var1, MapEntry var2, MapEntry$Metadata var3) {
      this.this$0 = var1;
      this.val$defaultInstance = var2;
      this.val$thisMetadata = var3;
      this.dataParser = MapEntry.access$000(this.val$defaultInstance).getParserForType();
   }

   public MapEntry parsePartialFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      MapEntryLite var3 = (MapEntryLite)this.dataParser.parsePartialFrom(var1, var2);
      return new MapEntry(this.val$thisMetadata, var3, (MapEntry$1)null);
   }
}
