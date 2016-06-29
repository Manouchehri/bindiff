/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
    private int bitField0_;
    private int start_;
    private int end_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
    }

    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clear() {
        super.clear();
        this.start_ = 0;
        this.bitField0_ &= -2;
        this.end_ = 0;
        this.bitField0_ &= -3;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$2800();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange build() {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = this.buildPartial();
        if (descriptorProtos$DescriptorProto$ExtensionRange.isInitialized()) return descriptorProtos$DescriptorProto$ExtensionRange;
        throw DescriptorProtos$DescriptorProto$ExtensionRange$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto$ExtensionRange);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange buildPartial() {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = new DescriptorProtos$DescriptorProto$ExtensionRange(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$DescriptorProto$ExtensionRange.access$3302(descriptorProtos$DescriptorProto$ExtensionRange, this.start_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$DescriptorProto$ExtensionRange.access$3402(descriptorProtos$DescriptorProto$ExtensionRange, this.end_);
        DescriptorProtos$DescriptorProto$ExtensionRange.access$3502(descriptorProtos$DescriptorProto$ExtensionRange, n3);
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ExtensionRange;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto$ExtensionRange) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
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

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = null;
        try {
            try {
                descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)DescriptorProtos$DescriptorProto$ExtensionRange.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$DescriptorProto$ExtensionRange == null) return this;
            this.mergeFrom(descriptorProtos$DescriptorProto$ExtensionRange);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$DescriptorProto$ExtensionRange == null) throw var5_7;
            this.mergeFrom(descriptorProtos$DescriptorProto$ExtensionRange);
            throw var5_7;
        }
    }

    @Override
    public boolean hasStart() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public int getStart() {
        return this.start_;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setStart(int n2) {
        this.bitField0_ |= 1;
        this.start_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearStart() {
        this.bitField0_ &= -2;
        this.start_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasEnd() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getEnd() {
        return this.end_;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setEnd(int n2) {
        this.bitField0_ |= 2;
        this.end_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearEnd() {
        this.bitField0_ &= -3;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

