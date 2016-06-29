package com.google.protobuf;

import java.io.*;

public final class UInt64Value$Builder extends GeneratedMessage$Builder implements UInt64ValueOrBuilder
{
    private long value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
    }
    
    private UInt64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private UInt64Value$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public UInt64Value$Builder clear() {
        super.clear();
        this.value_ = 0L;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }
    
    public UInt64Value getDefaultInstanceForType() {
        return UInt64Value.getDefaultInstance();
    }
    
    public UInt64Value build() {
        final UInt64Value buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public UInt64Value buildPartial() {
        final UInt64Value uInt64Value = new UInt64Value(this, null);
        uInt64Value.value_ = this.value_;
        this.onBuilt();
        return uInt64Value;
    }
    
    public UInt64Value$Builder mergeFrom(final Message message) {
        if (message instanceof UInt64Value) {
            return this.mergeFrom((UInt64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public UInt64Value$Builder mergeFrom(final UInt64Value uInt64Value) {
        if (uInt64Value == UInt64Value.getDefaultInstance()) {
            return this;
        }
        if (uInt64Value.getValue() != 0L) {
            this.setValue(uInt64Value.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public UInt64Value$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        UInt64Value uInt64Value = null;
        try {
            uInt64Value = (UInt64Value)UInt64Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            uInt64Value = (UInt64Value)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (uInt64Value != null) {
                this.mergeFrom(uInt64Value);
            }
        }
        return this;
    }
    
    public long getValue() {
        return this.value_;
    }
    
    public UInt64Value$Builder setValue(final long value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public UInt64Value$Builder clearValue() {
        this.value_ = 0L;
        this.onChanged();
        return this;
    }
    
    public final UInt64Value$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final UInt64Value$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
