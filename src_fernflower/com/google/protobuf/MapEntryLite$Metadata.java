package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata$1;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat$FieldType;

class MapEntryLite$Metadata {
   public final MapEntryLite defaultInstance;
   public final WireFormat$FieldType keyType;
   public final WireFormat$FieldType valueType;
   public final Parser parser;

   public MapEntryLite$Metadata(MapEntryLite var1, WireFormat$FieldType var2, WireFormat$FieldType var3) {
      this.defaultInstance = var1;
      this.keyType = var2;
      this.valueType = var3;
      this.parser = new MapEntryLite$Metadata$1(this, this);
   }
}
