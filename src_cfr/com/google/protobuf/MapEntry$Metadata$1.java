/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Parser;

class MapEntry$Metadata$1
extends AbstractParser {
    private final Parser dataParser;
    final /* synthetic */ MapEntry val$defaultInstance;
    final /* synthetic */ MapEntry$Metadata val$thisMetadata;
    final /* synthetic */ MapEntry$Metadata this$0;

    MapEntry$Metadata$1(MapEntry$Metadata mapEntry$Metadata, MapEntry mapEntry, MapEntry$Metadata mapEntry$Metadata2) {
        this.this$0 = mapEntry$Metadata;
        this.val$defaultInstance = mapEntry;
        this.val$thisMetadata = mapEntry$Metadata2;
        this.dataParser = MapEntry.access$000(this.val$defaultInstance).getParserForType();
    }

    @Override
    public MapEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        MapEntryLite mapEntryLite = (MapEntryLite)this.dataParser.parsePartialFrom(codedInputStream, extensionRegistryLite);
        return new MapEntry(this.val$thisMetadata, mapEntryLite, null);
    }
}

