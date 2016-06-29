/*
 * Decompiled with CFR 0_115.
 */
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

    public MapEntryLite$Metadata(MapEntryLite mapEntryLite, WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2) {
        this.defaultInstance = mapEntryLite;
        this.keyType = wireFormat$FieldType;
        this.valueType = wireFormat$FieldType2;
        MapEntryLite$Metadata mapEntryLite$Metadata = this;
        this.parser = new MapEntryLite$Metadata$1(this, mapEntryLite$Metadata);
    }
}

