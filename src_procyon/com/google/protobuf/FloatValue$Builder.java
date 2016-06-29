package com.google.protobuf;

import java.io.*;

public final class FloatValue$Builder extends GeneratedMessage$Builder implements FloatValueOrBuilder
{
    private float value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
    }
    
    private FloatValue$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private FloatValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public FloatValue$Builder clear() {
        super.clear();
        this.value_ = 0.0f;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }
    
    public FloatValue getDefaultInstanceForType() {
        return FloatValue.getDefaultInstance();
    }
    
    public FloatValue build() {
        final FloatValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public FloatValue buildPartial() {
        final FloatValue floatValue = new FloatValue(this, null);
        floatValue.value_ = this.value_;
        this.onBuilt();
        return floatValue;
    }
    
    public FloatValue$Builder mergeFrom(final Message message) {
        if (message instanceof FloatValue) {
            return this.mergeFrom((FloatValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public FloatValue$Builder mergeFrom(final FloatValue floatValue) {
        if (floatValue == FloatValue.getDefaultInstance()) {
            return this;
        }
        if (floatValue.getValue() != 0.0f) {
            this.setValue(floatValue.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public FloatValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        FloatValue floatValue = null;
        try {
            floatValue = (FloatValue)FloatValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            floatValue = (FloatValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (floatValue != null) {
                this.mergeFrom(floatValue);
            }
        }
        return this;
    }
    
    public float getValue() {
        return this.value_;
    }
    
    public FloatValue$Builder setValue(final float value_) {
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public FloatValue$Builder clearValue() {
        this.value_ = 0.0f;
        this.onChanged();
        return this;
    }
    
    public final FloatValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final FloatValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
