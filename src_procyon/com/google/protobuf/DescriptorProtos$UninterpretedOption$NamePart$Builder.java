package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder extends GeneratedMessage$Builder implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder
{
    private int bitField0_;
    private Object namePart_;
    private boolean isExtension_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
    }
    
    private DescriptorProtos$UninterpretedOption$NamePart$Builder() {
        this.namePart_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$UninterpretedOption$NamePart$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.namePart_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder clear() {
        super.clear();
        this.namePart_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.isExtension_ = false;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart build() {
        final DescriptorProtos$UninterpretedOption$NamePart buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart buildPartial() {
        final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = new DescriptorProtos$UninterpretedOption$NamePart(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$UninterpretedOption$NamePart.namePart_ = this.namePart_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$UninterpretedOption$NamePart.isExtension_ = this.isExtension_;
        descriptorProtos$UninterpretedOption$NamePart.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$UninterpretedOption$NamePart;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$UninterpretedOption$NamePart) {
            return this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (descriptorProtos$UninterpretedOption$NamePart == DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$UninterpretedOption$NamePart.hasNamePart()) {
            this.bitField0_ |= 0x1;
            this.namePart_ = descriptorProtos$UninterpretedOption$NamePart.namePart_;
            this.onChanged();
        }
        if (descriptorProtos$UninterpretedOption$NamePart.hasIsExtension()) {
            this.setIsExtension(descriptorProtos$UninterpretedOption$NamePart.getIsExtension());
        }
        this.mergeUnknownFields(descriptorProtos$UninterpretedOption$NamePart.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return this.hasNamePart() && this.hasIsExtension();
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = null;
        try {
            descriptorProtos$UninterpretedOption$NamePart = (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$UninterpretedOption$NamePart = (DescriptorProtos$UninterpretedOption$NamePart)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$UninterpretedOption$NamePart != null) {
                this.mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
            }
        }
        return this;
    }
    
    public boolean hasNamePart() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getNamePart() {
        final Object namePart_ = this.namePart_;
        if (!(namePart_ instanceof String)) {
            final ByteString byteString = (ByteString)namePart_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.namePart_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)namePart_;
    }
    
    public ByteString getNamePartBytes() {
        final Object namePart_ = this.namePart_;
        if (namePart_ instanceof String) {
            return (ByteString)(this.namePart_ = ByteString.copyFromUtf8((String)namePart_));
        }
        return (ByteString)namePart_;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePart(final String namePart_) {
        if (namePart_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.namePart_ = namePart_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearNamePart() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.namePart_ = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance().getNamePart();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePartBytes(final ByteString namePart_) {
        if (namePart_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.namePart_ = namePart_;
        this.onChanged();
        return this;
    }
    
    public boolean hasIsExtension() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getIsExtension() {
        return this.isExtension_;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder setIsExtension(final boolean isExtension_) {
        this.bitField0_ |= 0x2;
        this.isExtension_ = isExtension_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearIsExtension() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.isExtension_ = false;
        this.onChanged();
        return this;
    }
}
