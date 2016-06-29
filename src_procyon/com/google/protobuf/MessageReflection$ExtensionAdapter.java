package com.google.protobuf;

class MessageReflection$ExtensionAdapter implements MessageReflection$MergeTarget
{
    private final FieldSet extensions;
    
    MessageReflection$ExtensionAdapter(final FieldSet extensions) {
        this.extensions = extensions;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.getField(descriptors$FieldDescriptor);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.extensions.hasField(descriptors$FieldDescriptor);
    }
    
    public MessageReflection$MergeTarget setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.extensions.setField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public MessageReflection$MergeTarget clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.extensions.clearField(descriptors$FieldDescriptor);
        return this;
    }
    
    public MessageReflection$MergeTarget setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        this.extensions.setRepeatedField(descriptors$FieldDescriptor, n, o);
        return this;
    }
    
    public MessageReflection$MergeTarget addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.extensions.addRepeatedField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return false;
    }
    
    public MessageReflection$MergeTarget clearOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this;
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return null;
    }
    
    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.EXTENSION_SET;
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByName(final ExtensionRegistry extensionRegistry, final String s) {
        return extensionRegistry.findImmutableExtensionByName(s);
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(final ExtensionRegistry extensionRegistry, final Descriptors$Descriptor descriptors$Descriptor, final int n) {
        return extensionRegistry.findImmutableExtensionByNumber(descriptors$Descriptor, n);
    }
    
    public Object parseGroup(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        final Message$Builder builderForType = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                builderForType.mergeFrom(message2);
            }
        }
        codedInputStream.readGroup(descriptors$FieldDescriptor.getNumber(), builderForType, extensionRegistryLite);
        return builderForType.buildPartial();
    }
    
    public Object parseMessage(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        final Message$Builder builderForType = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                builderForType.mergeFrom(message2);
            }
        }
        codedInputStream.readMessage(builderForType, extensionRegistryLite);
        return builderForType.buildPartial();
    }
    
    public Object parseMessageFromBytes(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        final Message$Builder builderForType = message.newBuilderForType();
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                builderForType.mergeFrom(message2);
            }
        }
        builderForType.mergeFrom(byteString, extensionRegistryLite);
        return builderForType.buildPartial();
    }
    
    public MessageReflection$MergeTarget newMergeTargetForField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
    }
    
    public WireFormat$Utf8Validation getUtf8Validation(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.needsUtf8Check()) {
            return WireFormat$Utf8Validation.STRICT;
        }
        return WireFormat$Utf8Validation.LOOSE;
    }
    
    public Object finish() {
        throw new UnsupportedOperationException("finish() called on FieldSet object");
    }
}
