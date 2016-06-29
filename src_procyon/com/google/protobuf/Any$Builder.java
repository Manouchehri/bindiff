package com.google.protobuf;

import java.io.*;

public final class Any$Builder extends GeneratedMessage$Builder implements AnyOrBuilder
{
    private Object typeUrl_;
    private ByteString value_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }
    
    private Any$Builder() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private Any$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Any$Builder clear() {
        super.clear();
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }
    
    public Any getDefaultInstanceForType() {
        return Any.getDefaultInstance();
    }
    
    public Any build() {
        final Any buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Any buildPartial() {
        final Any any = new Any(this, null);
        any.typeUrl_ = this.typeUrl_;
        any.value_ = this.value_;
        this.onBuilt();
        return any;
    }
    
    public Any$Builder mergeFrom(final Message message) {
        if (message instanceof Any) {
            return this.mergeFrom((Any)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Any$Builder mergeFrom(final Any any) {
        if (any == Any.getDefaultInstance()) {
            return this;
        }
        if (!any.getTypeUrl().isEmpty()) {
            this.typeUrl_ = any.typeUrl_;
            this.onChanged();
        }
        if (any.getValue() != ByteString.EMPTY) {
            this.setValue(any.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Any$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Any any = null;
        try {
            any = (Any)Any.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            any = (Any)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (any != null) {
                this.mergeFrom(any);
            }
        }
        return this;
    }
    
    public String getTypeUrl() {
        final Object typeUrl_ = this.typeUrl_;
        if (!(typeUrl_ instanceof String)) {
            final ByteString byteString = (ByteString)typeUrl_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.typeUrl_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)typeUrl_;
    }
    
    public ByteString getTypeUrlBytes() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (ByteString)(this.typeUrl_ = ByteString.copyFromUtf8((String)typeUrl_));
        }
        return (ByteString)typeUrl_;
    }
    
    public Any$Builder setTypeUrl(final String typeUrl_) {
        if (typeUrl_ == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = typeUrl_;
        this.onChanged();
        return this;
    }
    
    public Any$Builder clearTypeUrl() {
        this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
        this.onChanged();
        return this;
    }
    
    public Any$Builder setTypeUrlBytes(final ByteString typeUrl_) {
        if (typeUrl_ == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = typeUrl_;
        this.onChanged();
        return this;
    }
    
    public ByteString getValue() {
        return this.value_;
    }
    
    public Any$Builder setValue(final ByteString value_) {
        if (value_ == null) {
            throw new NullPointerException();
        }
        this.value_ = value_;
        this.onChanged();
        return this;
    }
    
    public Any$Builder clearValue() {
        this.value_ = Any.getDefaultInstance().getValue();
        this.onChanged();
        return this;
    }
    
    public final Any$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Any$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
