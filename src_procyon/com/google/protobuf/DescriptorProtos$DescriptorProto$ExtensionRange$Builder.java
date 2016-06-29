package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder
{
    private int bitField0_;
    private int start_;
    private int end_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
    }
    
    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clear() {
        super.clear();
        this.start_ = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.end_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange build() {
        final DescriptorProtos$DescriptorProto$ExtensionRange buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange buildPartial() {
        final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = new DescriptorProtos$DescriptorProto$ExtensionRange(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$DescriptorProto$ExtensionRange.start_ = this.start_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$DescriptorProto$ExtensionRange.end_ = this.end_;
        descriptorProtos$DescriptorProto$ExtensionRange.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ExtensionRange;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto$ExtensionRange) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (descriptorProtos$DescriptorProto$ExtensionRange == DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$DescriptorProto$ExtensionRange.hasStart()) {
            this.setStart(descriptorProtos$DescriptorProto$ExtensionRange.getStart());
        }
        if (descriptorProtos$DescriptorProto$ExtensionRange.hasEnd()) {
            this.setEnd(descriptorProtos$DescriptorProto$ExtensionRange.getEnd());
        }
        this.mergeUnknownFields(descriptorProtos$DescriptorProto$ExtensionRange.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = null;
        try {
            descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)DescriptorProtos$DescriptorProto$ExtensionRange.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$DescriptorProto$ExtensionRange != null) {
                this.mergeFrom(descriptorProtos$DescriptorProto$ExtensionRange);
            }
        }
        return this;
    }
    
    public boolean hasStart() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public int getStart() {
        return this.start_;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setStart(final int start_) {
        this.bitField0_ |= 0x1;
        this.start_ = start_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearStart() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.start_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasEnd() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public int getEnd() {
        return this.end_;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setEnd(final int end_) {
        this.bitField0_ |= 0x2;
        this.end_ = end_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearEnd() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.end_ = 0;
        this.onChanged();
        return this;
    }
}
