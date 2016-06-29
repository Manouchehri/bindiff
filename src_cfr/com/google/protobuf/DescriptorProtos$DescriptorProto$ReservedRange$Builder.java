/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
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

public final class DescriptorProtos$DescriptorProto$ReservedRange$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
    private int bitField0_;
    private int start_;
    private int end_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$3700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$3800().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
    }

    private DescriptorProtos$DescriptorProto$ReservedRange$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clear() {
        super.clear();
        this.start_ = 0;
        this.bitField0_ &= -2;
        this.end_ = 0;
        this.bitField0_ &= -3;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$3700();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange build() {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = this.buildPartial();
        if (descriptorProtos$DescriptorProto$ReservedRange.isInitialized()) return descriptorProtos$DescriptorProto$ReservedRange;
        throw DescriptorProtos$DescriptorProto$ReservedRange$Builder.newUninitializedMessageException(descriptorProtos$DescriptorProto$ReservedRange);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange buildPartial() {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = new DescriptorProtos$DescriptorProto$ReservedRange(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$DescriptorProto$ReservedRange.access$4202(descriptorProtos$DescriptorProto$ReservedRange, this.start_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$DescriptorProto$ReservedRange.access$4302(descriptorProtos$DescriptorProto$ReservedRange, this.end_);
        DescriptorProtos$DescriptorProto$ReservedRange.access$4402(descriptorProtos$DescriptorProto$ReservedRange, n3);
        this.onBuilt();
        return descriptorProtos$DescriptorProto$ReservedRange;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto$ReservedRange) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
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

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = null;
        try {
            try {
                descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$DescriptorProto$ReservedRange == null) return this;
            this.mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$DescriptorProto$ReservedRange == null) throw var5_7;
            this.mergeFrom(descriptorProtos$DescriptorProto$ReservedRange);
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

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setStart(int n2) {
        this.bitField0_ |= 1;
        this.start_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearStart() {
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

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder setEnd(int n2) {
        this.bitField0_ |= 2;
        this.end_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearEnd() {
        this.bitField0_ &= -3;
        this.end_ = 0;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

