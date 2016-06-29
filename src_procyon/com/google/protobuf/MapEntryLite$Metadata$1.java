package com.google.protobuf;

class MapEntryLite$Metadata$1 extends AbstractParser
{
    final /* synthetic */ MapEntryLite$Metadata val$finalThis;
    final /* synthetic */ MapEntryLite$Metadata this$0;
    
    MapEntryLite$Metadata$1(final MapEntryLite$Metadata this$0, final MapEntryLite$Metadata val$finalThis) {
        this.this$0 = this$0;
        this.val$finalThis = val$finalThis;
    }
    
    public MapEntryLite parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return new MapEntryLite(this.val$finalThis, codedInputStream, extensionRegistryLite, null);
    }
}
