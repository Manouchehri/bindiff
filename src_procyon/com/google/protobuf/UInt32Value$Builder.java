package com.google.protobuf;

import java.io.*;

public final class UInt32Value$Builder extends GeneratedMessage$Builder implements UInt32ValueOrBuilder
{
    private int value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
    }
    
    private UInt32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private UInt32Value$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public UInt32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }
    
    public UInt32Value getDefaultInstanceForType() {
        return UInt32Value.getDefaultInstance();
    }
    
    public UInt32Value build() {
        final UInt32Value buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public UInt32Value buildPartial() {
        final UInt32Value uInt32Value = new UInt32Value(this, null);
        uInt32Value.value_ = this.value_;
        this.onBuilt();
        return uInt32Value;
    }
    
    public UInt32Value$Builder mergeFrom(final Message message) {
        if (message instanceof UInt32Value) {
            return this.mergeFrom((UInt32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public UInt32Value$Builder mergeFrom(final UInt32Value uInt32Value) {
        if (uInt32Value == UInt32Value.getDefaultInstance()) {
            return this;
        }
        if (uInt32Value.getValue() != 0) {
            this.setValue(uInt32Value.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public UInt32Value$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        UInt32Value uInt32Value = null;
        try {
            uInt32Value = (UInt32Value)UInt32Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            uInt32Value = (UInt32Value)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (uInt32Value != null) {
                this.mergeFrom(uInt32Value);
            }
        }
        return this;
    }
    
    public int getValue() {
        return this.value_;
    }
    
    public UInt32Value$Builder setValue(final int value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public UInt32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }
    
    public final UInt32Value$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final UInt32Value$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
