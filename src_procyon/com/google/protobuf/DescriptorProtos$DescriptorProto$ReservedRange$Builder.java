package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$DescriptorProto$ReservedRange$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder
{
    private int bitField0_;
    private int start_;
    private int end_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ReservedRange_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ReservedRange_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
    }
    
    private DescriptorProtos$DescriptorProto$ReservedRange$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$DescriptorProto$ReservedRange$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clear() {
        super.clear();
        this.start_ = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.end_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ReservedRange_descriptor;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange build() {
        final DescriptorProtos$DescriptorProto$ReservedRange buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange buildPartial() {
        final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = new DescriptorProtos$DescriptorProto$ReservedRange(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$DescriptorProto$ReservedRange.start_ = this.start_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$DescriptorProto$ReservedRange.end_ = this.end_;
        descriptorProtos$DescriptorProto$ReservedRange.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ReservedRange;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto$ReservedRange) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (descriptorProtos$DescriptorProto$ReservedRange == DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$DescriptorProto$ReservedRange.hasStart()) {
            this.setStart(descriptorProtos$DescriptorProto$ReservedRange.getStart());
        }
        if (descriptorProtos$DescriptorProto$ReservedRange.hasEnd()) {
            this.setEnd(descriptorProtos$DescriptorProto$ReservedRange.getEnd());
        }
        this.mergeUnknownFields(descriptorProtos$DescriptorProto$ReservedRange.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = null;
        try {
            descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$DescriptorProto$ReservedRange != null) {
                this.mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
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
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setStart(final int start_) {
        this.bitField0_ |= 0x1;
        this.start_ = start_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearStart() {
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
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setEnd(final int end_) {
        this.bitField0_ |= 0x2;
        this.end_ = end_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearEnd() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.end_ = 0;
        this.onChanged();
        return this;
    }
}
