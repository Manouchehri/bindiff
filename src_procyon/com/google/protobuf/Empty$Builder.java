package com.google.protobuf;

public final class Empty$Builder extends GeneratedMessage$Builder implements EmptyOrBuilder
{
    public static final Descriptors$Descriptor getDescriptor() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
    }
    
    private Empty$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Empty$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Empty$Builder clear() {
        super.clear();
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }
    
    public Empty getDefaultInstanceForType() {
        return Empty.getDefaultInstance();
    }
    
    public Empty build() {
        final Empty buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Empty buildPartial() {
        final Empty empty = new Empty(this, null);
        this.onBuilt();
        return empty;
    }
    
    public Empty$Builder mergeFrom(final Message message) {
        if (message instanceof Empty) {
            return this.mergeFrom((Empty)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Empty$Builder mergeFrom(final Empty empty) {
        if (empty == Empty.getDefaultInstance()) {
            return this;
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Empty$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Empty empty = null;
        try {
            empty = (Empty)Empty.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            empty = (Empty)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (empty != null) {
                this.mergeFrom(empty);
            }
        }
        return this;
    }
    
    public final Empty$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Empty$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
