package com.google.protobuf;

public class LazyField extends LazyFieldLite
{
    private final MessageLite defaultInstance;
    
    public LazyField(final MessageLite defaultInstance, final ExtensionRegistryLite extensionRegistryLite, final ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.defaultInstance = defaultInstance;
    }
    
    public boolean containsDefaultInstance() {
        return super.containsDefaultInstance() || this.value == this.defaultInstance;
    }
    
    public MessageLite getValue() {
        return this.getValue(this.defaultInstance);
    }
    
    public int hashCode() {
        return this.getValue().hashCode();
    }
    
    public boolean equals(final Object o) {
        return this.getValue().equals(o);
    }
    
    public String toString() {
        return this.getValue().toString();
    }
}
