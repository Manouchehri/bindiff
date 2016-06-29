package com.google.protobuf;

public class GeneratedMessageLite$PrototypeHolder
{
    private final GeneratedMessageLite defaultInstance;
    private final Parser parser;
    
    public GeneratedMessageLite$PrototypeHolder(final GeneratedMessageLite defaultInstance, final Parser parser) {
        this.defaultInstance = defaultInstance;
        this.parser = parser;
    }
    
    public GeneratedMessageLite getDefaultInstanceForType() {
        return this.defaultInstance;
    }
    
    public Parser getParserForType() {
        return this.parser;
    }
    
    public GeneratedMessageLite$Builder newBuilderForType() {
        return this.defaultInstance.toBuilder();
    }
}
