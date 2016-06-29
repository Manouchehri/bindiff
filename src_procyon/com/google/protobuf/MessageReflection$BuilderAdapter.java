package com.google.protobuf;

class MessageReflection$BuilderAdapter implements MessageReflection$MergeTarget
{
    private final Message$Builder builder;
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.builder.getDescriptorForType();
    }
    
    public MessageReflection$BuilderAdapter(final Message$Builder builder) {
        this.builder = builder;
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.getField(descriptors$FieldDescriptor);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.builder.hasField(descriptors$FieldDescriptor);
    }
    
    public MessageReflection$MergeTarget setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.builder.setField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public MessageReflection$MergeTarget clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.builder.clearField(descriptors$FieldDescriptor);
        return this;
    }
    
    public MessageReflection$MergeTarget setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        this.builder.setRepeatedField(descriptors$FieldDescriptor, n, o);
        return this;
    }
    
    public MessageReflection$MergeTarget addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        this.builder.addRepeatedField(descriptors$FieldDescriptor, o);
        return this;
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.hasOneof(descriptors$OneofDescriptor);
    }
    
    public MessageReflection$MergeTarget clearOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.builder.clearOneof(descriptors$OneofDescriptor);
        return this;
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.builder.getOneofFieldDescriptor(descriptors$OneofDescriptor);
    }
    
    public MessageReflection$MergeTarget$ContainerType getContainerType() {
        return MessageReflection$MergeTarget$ContainerType.MESSAGE;
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByName(final ExtensionRegistry extensionRegistry, final String s) {
        return extensionRegistry.findImmutableExtensionByName(s);
    }
    
    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(final ExtensionRegistry extensionRegistry, final Descriptors$Descriptor descriptors$Descriptor, final int n) {
        return extensionRegistry.findImmutableExtensionByNumber(descriptors$Descriptor, n);
    }
    
    public Object parseGroup(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        Message$Builder message$Builder;
        if (message != null) {
            message$Builder = message.newBuilderForType();
        }
        else {
            message$Builder = this.builder.newBuilderForField(descriptors$FieldDescriptor);
        }
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                message$Builder.mergeFrom(message2);
            }
        }
        codedInputStream.readGroup(descriptors$FieldDescriptor.getNumber(), message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }
    
    public Object parseMessage(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        Message$Builder message$Builder;
        if (message != null) {
            message$Builder = message.newBuilderForType();
        }
        else {
            message$Builder = this.builder.newBuilderForField(descriptors$FieldDescriptor);
        }
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                message$Builder.mergeFrom(message2);
            }
        }
        codedInputStream.readMessage(message$Builder, extensionRegistryLite);
        return message$Builder.buildPartial();
    }
    
    public Object parseMessageFromBytes(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        Message$Builder message$Builder;
        if (message != null) {
            message$Builder = message.newBuilderForType();
        }
        else {
            message$Builder = this.builder.newBuilderForField(descriptors$FieldDescriptor);
        }
        if (!descriptors$FieldDescriptor.isRepeated()) {
            final Message message2 = (Message)this.getField(descriptors$FieldDescriptor);
            if (message2 != null) {
                message$Builder.mergeFrom(message2);
            }
        }
        message$Builder.mergeFrom(byteString, extensionRegistryLite);
        return message$Builder.buildPartial();
    }
    
    public MessageReflection$MergeTarget newMergeTargetForField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Message message) {
        if (message != null) {
            return new MessageReflection$BuilderAdapter(message.newBuilderForType());
        }
        return new MessageReflection$BuilderAdapter(this.builder.newBuilderForField(descriptors$FieldDescriptor));
    }
    
    public WireFormat$Utf8Validation getUtf8Validation(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.needsUtf8Check()) {
            return WireFormat$Utf8Validation.STRICT;
        }
        if (!descriptors$FieldDescriptor.isRepeated() && this.builder instanceof GeneratedMessage$Builder) {
            return WireFormat$Utf8Validation.LAZY;
        }
        return WireFormat$Utf8Validation.LOOSE;
    }
    
    public Object finish() {
        return this.builder.buildPartial();
    }
}
