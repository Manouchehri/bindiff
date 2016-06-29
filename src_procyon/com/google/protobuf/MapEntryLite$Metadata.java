package com.google.protobuf;

class MapEntryLite$Metadata
{
    public final MapEntryLite defaultInstance;
    public final WireFormat$FieldType keyType;
    public final WireFormat$FieldType valueType;
    public final Parser parser;
    
    public MapEntryLite$Metadata(final MapEntryLite defaultInstance, final WireFormat$FieldType keyType, final WireFormat$FieldType valueType) {
        this.defaultInstance = defaultInstance;
        this.keyType = keyType;
        this.valueType = valueType;
        this.parser = new MapEntryLite$Metadata$1(this, this);
    }
}
