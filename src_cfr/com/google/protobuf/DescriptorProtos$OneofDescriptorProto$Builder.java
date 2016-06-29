/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$OneofDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$7700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$7800().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
    }

    private DescriptorProtos$OneofDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$7700();
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto build() {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = this.buildPartial();
        if (descriptorProtos$OneofDescriptorProto.isInitialized()) return descriptorProtos$OneofDescriptorProto;
        throw DescriptorProtos$OneofDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$OneofDescriptorProto);
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto buildPartial() {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = new DescriptorProtos$OneofDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$OneofDescriptorProto.access$8202(descriptorProtos$OneofDescriptorProto, this.name_);
        DescriptorProtos$OneofDescriptorProto.access$8302(descriptorProtos$OneofDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$OneofDescriptorProto;
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$OneofDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$OneofDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (descriptorProtos$OneofDescriptorProto == DescriptorProtos$OneofDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$OneofDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$OneofDescriptorProto.access$8200(descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$OneofDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = null;
        try {
            try {
                descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto)DescriptorProtos$OneofDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$OneofDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$OneofDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$OneofDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$OneofDescriptorProto);
            throw var5_7;
        }
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$OneofDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$OneofDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$OneofDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

