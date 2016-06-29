package com.google.protobuf;

import java.util.*;

class MapEntry$Metadata$1 extends AbstractParser
{
    private final Parser dataParser;
    final /* synthetic */ MapEntry val$defaultInstance;
    final /* synthetic */ MapEntry$Metadata val$thisMetadata;
    final /* synthetic */ MapEntry$Metadata this$0;
    
    MapEntry$Metadata$1(final MapEntry$Metadata this$0, final MapEntry val$defaultInstance, final MapEntry$Metadata val$thisMetadata) {
        this.this$0 = this$0;
        this.val$defaultInstance = val$defaultInstance;
        this.val$thisMetadata = val$thisMetadata;
        this.dataParser = this.val$defaultInstance.data.getParserForType();
    }
    
    public MapEntry parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return new MapEntry(this.val$thisMetadata, (MapEntryLite)this.dataParser.parsePartialFrom(codedInputStream, extensionRegistryLite), null);
    }
}
