package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Metadata$1;

class MapEntry$Metadata {
   public final Descriptors$Descriptor descriptor;
   public final MapEntry defaultInstance;
   public final AbstractParser parser;

   public MapEntry$Metadata(Descriptors$Descriptor var1, MapEntry var2) {
      this.descriptor = var1;
      this.defaultInstance = var2;
      this.parser = new MapEntry$Metadata$1(this, var2, this);
   }
}
