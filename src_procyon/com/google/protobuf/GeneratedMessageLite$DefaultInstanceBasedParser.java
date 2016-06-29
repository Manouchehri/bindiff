package com.google.protobuf;

public class GeneratedMessageLite$DefaultInstanceBasedParser extends AbstractParser
{
    private GeneratedMessageLite defaultInstance;
    
    public GeneratedMessageLite$DefaultInstanceBasedParser(final GeneratedMessageLite defaultInstance) {
        this.defaultInstance = defaultInstance;
    }
    
    public GeneratedMessageLite parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
    }
}
