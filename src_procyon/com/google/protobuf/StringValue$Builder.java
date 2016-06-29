package com.google.protobuf;

import java.io.*;

public final class StringValue$Builder extends GeneratedMessage$Builder implements StringValueOrBuilder
{
    private Object value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
    }
    
    private StringValue$Builder() {
        this.value_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private StringValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.value_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public StringValue$Builder clear() {
        super.clear();
        this.value_ = "";
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }
    
    public StringValue getDefaultInstanceForType() {
        return StringValue.getDefaultInstance();
    }
    
    public StringValue build() {
        final StringValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public StringValue buildPartial() {
        final StringValue stringValue = new StringValue(this, null);
        stringValue.value_ = this.value_;
        this.onBuilt();
        return stringValue;
    }
    
    public StringValue$Builder mergeFrom(final Message message) {
        if (message instanceof StringValue) {
            return this.mergeFrom((StringValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public StringValue$Builder mergeFrom(final StringValue stringValue) {
        if (stringValue == StringValue.getDefaultInstance()) {
            return this;
        }
        if (!stringValue.getValue().isEmpty()) {
            this.value_ = stringValue.value_;
            this.onChanged();
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public StringValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        StringValue stringValue = null;
        try {
            stringValue = (StringValue)StringValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            stringValue = (StringValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (stringValue != null) {
                this.mergeFrom(stringValue);
            }
        }
        return this;
    }
    
    public String getValue() {
        final Object value_ = this.value_;
        if (!(value_ instanceof String)) {
            final ByteString byteString = (ByteString)value_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.value_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)value_;
    }
    
    public ByteString getValueBytes() {
        final Object value_ = this.value_;
        if (value_ instanceof String) {
            return (ByteString)(this.value_ = ByteString.copyFromUtf8((String)value_));
        }
        return (ByteString)value_;
    }
    
    public StringValue$Builder setValue(final String value_) {
        if (value_ == null) {
            throw new NullPointerException();
        }
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public StringValue$Builder clearValue() {
        this.value_ = StringValue.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }
    
    public StringValue$Builder setValueBytes(final ByteString value_) {
        if (value_ == null) {
            throw new NullPointerException();
        }
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public final StringValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final StringValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
