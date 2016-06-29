/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Metadata$1;

class MapEntry$Metadata {
    public final Descriptors$Descriptor descriptor;
    public final MapEntry defaultInstance;
    public final AbstractParser parser;

    public MapEntry$Metadata(Descriptors$Descriptor descriptors$Descriptor, MapEntry mapEntry) {
        this.descriptor = descriptors$Descriptor;
        this.defaultInstance = mapEntry;
        MapEntry$Metadata mapEntry$Metadata = this;
        this.parser = new MapEntry$Metadata$1(this, mapEntry, mapEntry$Metadata);
    }
}

