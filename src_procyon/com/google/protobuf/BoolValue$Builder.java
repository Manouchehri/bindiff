package com.google.protobuf;

import java.io.*;

public final class BoolValue$Builder extends GeneratedMessage$Builder implements BoolValueOrBuilder
{
    private boolean value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
    }
    
    private BoolValue$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private BoolValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public BoolValue$Builder clear() {
        super.clear();
        this.value_ = false;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }
    
    public BoolValue getDefaultInstanceForType() {
        return BoolValue.getDefaultInstance();
    }
    
    public BoolValue build() {
        final BoolValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public BoolValue buildPartial() {
        final BoolValue boolValue = new BoolValue(this, null);
        boolValue.value_ = this.value_;
        this.onBuilt();
        return boolValue;
    }
    
    public BoolValue$Builder mergeFrom(final Message message) {
        if (message instanceof BoolValue) {
            return this.mergeFrom((BoolValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BoolValue$Builder mergeFrom(final BoolValue boolValue) {
        if (boolValue == BoolValue.getDefaultInstance()) {
            return this;
        }
        if (boolValue.getValue()) {
            this.setValue(boolValue.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public BoolValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BoolValue boolValue = null;
        try {
            boolValue = (BoolValue)BoolValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            boolValue = (BoolValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (boolValue != null) {
                this.mergeFrom(boolValue);
            }
        }
        return this;
    }
    
    public boolean getValue() {
        return this.value_;
    }
    
    public BoolValue$Builder setValue(final boolean value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public BoolValue$Builder clearValue() {
        this.value_ = false;
        this.onChanged();
        return this;
    }
    
    public final BoolValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final BoolValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
