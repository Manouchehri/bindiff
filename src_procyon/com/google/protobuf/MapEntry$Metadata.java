package com.google.protobuf;

class MapEntry$Metadata
{
    public final Descriptors$Descriptor descriptor;
    public final MapEntry defaultInstance;
    public final AbstractParser parser;
    
    public MapEntry$Metadata(final Descriptors$Descriptor descriptor, final MapEntry defaultInstance) {
        this.descriptor = descriptor;
        this.defaultInstance = defaultInstance;
        this.parser = new MapEntry$Metadata$1(this, defaultInstance, this);
    }
}
