/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Metadata;

class MapEntryLite$Metadata$1
extends AbstractParser {
    final /* synthetic */ MapEntryLite$Metadata val$finalThis;
    final /* synthetic */ MapEntryLite$Metadata this$0;

    MapEntryLite$Metadata$1(MapEntryLite$Metadata mapEntryLite$Metadata, MapEntryLite$Metadata mapEntryLite$Metadata2) {
        this.this$0 = mapEntryLite$Metadata;
        this.val$finalThis = mapEntryLite$Metadata2;
    }

    @Override
    public MapEntryLite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new MapEntryLite(this.val$finalThis, codedInputStream, extensionRegistryLite, null);
    }
}

