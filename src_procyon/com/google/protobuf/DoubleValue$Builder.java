package com.google.protobuf;

import java.io.*;

public final class DoubleValue$Builder extends GeneratedMessage$Builder implements DoubleValueOrBuilder
{
    private double value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
    }
    
    private DoubleValue$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private DoubleValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DoubleValue$Builder clear() {
        super.clear();
        this.value_ = 0.0;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }
    
    public DoubleValue getDefaultInstanceForType() {
        return DoubleValue.getDefaultInstance();
    }
    
    public DoubleValue build() {
        final DoubleValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DoubleValue buildPartial() {
        final DoubleValue doubleValue = new DoubleValue(this, null);
        doubleValue.value_ = this.value_;
        this.onBuilt();
        return doubleValue;
    }
    
    public DoubleValue$Builder mergeFrom(final Message message) {
        if (message instanceof DoubleValue) {
            return this.mergeFrom((DoubleValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DoubleValue$Builder mergeFrom(final DoubleValue doubleValue) {
        if (doubleValue == DoubleValue.getDefaultInstance()) {
            return this;
        }
        if (doubleValue.getValue() != 0.0) {
            this.setValue(doubleValue.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DoubleValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DoubleValue doubleValue = null;
        try {
            doubleValue = (DoubleValue)DoubleValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            doubleValue = (DoubleValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (doubleValue != null) {
                this.mergeFrom(doubleValue);
            }
        }
        return this;
    }
    
    public double getValue() {
        return this.value_;
    }
    
    public DoubleValue$Builder setValue(final double value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public DoubleValue$Builder clearValue() {
        this.value_ = 0.0;
        this.onChanged();
        return this;
    }
    
    public final DoubleValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final DoubleValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
