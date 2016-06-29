package com.google.protobuf;

import java.io.*;

public final class Int32Value$Builder extends GeneratedMessage$Builder implements Int32ValueOrBuilder
{
    private int value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
    }
    
    private Int32Value$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Int32Value$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Int32Value$Builder clear() {
        super.clear();
        this.value_ = 0;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }
    
    public Int32Value getDefaultInstanceForType() {
        return Int32Value.getDefaultInstance();
    }
    
    public Int32Value build() {
        final Int32Value buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Int32Value buildPartial() {
        final Int32Value int32Value = new Int32Value(this, null);
        int32Value.value_ = this.value_;
        this.onBuilt();
        return int32Value;
    }
    
    public Int32Value$Builder mergeFrom(final Message message) {
        if (message instanceof Int32Value) {
            return this.mergeFrom((Int32Value)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Int32Value$Builder mergeFrom(final Int32Value int32Value) {
        if (int32Value == Int32Value.getDefaultInstance()) {
            return this;
        }
        if (int32Value.getValue() != 0) {
            this.setValue(int32Value.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Int32Value$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Int32Value int32Value = null;
        try {
            int32Value = (Int32Value)Int32Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            int32Value = (Int32Value)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (int32Value != null) {
                this.mergeFrom(int32Value);
            }
        }
        return this;
    }
    
    public int getValue() {
        return this.value_;
    }
    
    public Int32Value$Builder setValue(final int value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public Int32Value$Builder clearValue() {
        this.value_ = 0;
        this.onChanged();
        return this;
    }
    
    public final Int32Value$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Int32Value$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
