package com.google.protobuf;

import java.io.*;

public final class BytesValue$Builder extends GeneratedMessage$Builder implements BytesValueOrBuilder
{
    private ByteString value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
    }
    
    private BytesValue$Builder() {
        this.value_ = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private BytesValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.value_ = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public BytesValue$Builder clear() {
        super.clear();
        this.value_ = ByteString.EMPTY;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }
    
    public BytesValue getDefaultInstanceForType() {
        return BytesValue.getDefaultInstance();
    }
    
    public BytesValue build() {
        final BytesValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public BytesValue buildPartial() {
        final BytesValue bytesValue = new BytesValue(this, null);
        bytesValue.value_ = this.value_;
        this.onBuilt();
        return bytesValue;
    }
    
    public BytesValue$Builder mergeFrom(final Message message) {
        if (message instanceof BytesValue) {
            return this.mergeFrom((BytesValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BytesValue$Builder mergeFrom(final BytesValue bytesValue) {
        if (bytesValue == BytesValue.getDefaultInstance()) {
            return this;
        }
        if (bytesValue.getValue() != ByteString.EMPTY) {
            this.setValue(bytesValue.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public BytesValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BytesValue bytesValue = null;
        try {
            bytesValue = (BytesValue)BytesValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            bytesValue = (BytesValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (bytesValue != null) {
                this.mergeFrom(bytesValue);
            }
        }
        return this;
    }
    
    public ByteString getValue() {
        return this.value_;
    }
    
    public BytesValue$Builder setValue(final ByteString value_) {
        if (value_ == null) {
            throw new NullPointerException();
        }
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public BytesValue$Builder clearValue() {
        this.value_ = BytesValue.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }
    
    public final BytesValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final BytesValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
