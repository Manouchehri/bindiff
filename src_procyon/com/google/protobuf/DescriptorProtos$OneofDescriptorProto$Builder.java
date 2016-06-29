package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$OneofDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$OneofDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_OneofDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_OneofDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$OneofDescriptorProto$Builder() {
        this.name_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$OneofDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_OneofDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$OneofDescriptorProto build() {
        final DescriptorProtos$OneofDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$OneofDescriptorProto buildPartial() {
        final DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = new DescriptorProtos$OneofDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$OneofDescriptorProto.name_ = this.name_;
        descriptorProtos$OneofDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$OneofDescriptorProto;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$OneofDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$OneofDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(final DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (descriptorProtos$OneofDescriptorProto == DescriptorProtos$OneofDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$OneofDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$OneofDescriptorProto.name_;
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$OneofDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = null;
        try {
            descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto)DescriptorProtos$OneofDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$OneofDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$OneofDescriptorProto);
            }
        }
        return this;
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (!(name_ instanceof String)) {
            final ByteString byteString = (ByteString)name_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)name_;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$OneofDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
}
