package com.google.protobuf;

import java.io.*;

public final class Int64Value$Builder extends GeneratedMessage$Builder implements Int64ValueOrBuilder
{
    private long value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
    }
    
    private Int64Value$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private Int64Value$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Int64Value$Builder clear() {
        super.clear();
        this.value_ = 0L;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }
    
    public Int64Value getDefaultInstanceForType() {
        return Int64Value.getDefaultInstance();
    }
    
    public Int64Value build() {
        final Int64Value buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Int64Value buildPartial() {
        final Int64Value int64Value = new Int64Value(this, null);
        int64Value.value_ = this.value_;
        this.onBuilt();
        return int64Value;
    }
    
    public Int64Value$Builder mergeFrom(final Message message) {
        if (message instanceof Int64Value) {
            return this.mergeFrom((Int64Value)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Int64Value$Builder mergeFrom(final Int64Value int64Value) {
        if (int64Value == Int64Value.getDefaultInstance()) {
            return this;
        }
        if (int64Value.getValue() != 0L) {
            this.setValue(int64Value.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Int64Value$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Int64Value int64Value = null;
        try {
            int64Value = (Int64Value)Int64Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            int64Value = (Int64Value)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (int64Value != null) {
                this.mergeFrom(int64Value);
            }
        }
        return this;
    }
    
    public long getValue() {
        return this.value_;
    }
    
    public Int64Value$Builder setValue(final long value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public Int64Value$Builder clearValue() {
        this.value_ = 0L;
        this.onChanged();
        return this;
    }
    
    public final Int64Value$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Int64Value$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
