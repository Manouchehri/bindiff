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
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
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

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$UninterpretedOption$NamePartOrBuilder {
    private int bitField0_;
    private Object namePart_ = "";
    private boolean isExtension_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$21600().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption$NamePart.class, DescriptorProtos$UninterpretedOption$NamePart$Builder.class);
    }

    private DescriptorProtos$UninterpretedOption$NamePart$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart$Builder clear() {
        super.clear();
        this.namePart_ = "";
        this.bitField0_ &= -2;
        this.isExtension_ = false;
        this.bitField0_ &= -3;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$21500();
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart build() {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = this.buildPartial();
        if (descriptorProtos$UninterpretedOption$NamePart.isInitialized()) return descriptorProtos$UninterpretedOption$NamePart;
        throw DescriptorProtos$UninterpretedOption$NamePart$Builder.newUninitializedMessageException(descriptorProtos$UninterpretedOption$NamePart);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart buildPartial() {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = new DescriptorProtos$UninterpretedOption$NamePart(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$UninterpretedOption$NamePart.access$22002(descriptorProtos$UninterpretedOption$NamePart, this.namePart_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$UninterpretedOption$NamePart.access$22102(descriptorProtos$UninterpretedOption$NamePart, this.isExtension_);
        DescriptorProtos$UninterpretedOption$NamePart.access$22202(descriptorProtos$UninterpretedOption$NamePart, n3);
        this.onBuilt();
        return descriptorProtos$UninterpretedOption$NamePart;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$UninterpretedOption$NamePart) {
            return this.mergeFrom((DescriptorProtos$UninterpretedOption$NamePart)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (descriptorProtos$UninterpretedOption$NamePart == DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$UninterpretedOption$NamePart.hasNamePart()) {
            this.bitField0_ |= 1;
            this.namePart_ = DescriptorProtos$UninterpretedOption$NamePart.access$22000(descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        }
        if (descriptorProtos$UninterpretedOption$NamePart.hasIsExtension()) {
            this.setIsExtension(descriptorProtos$UninterpretedOption$NamePart.getIsExtension());
        }
        this.mergeUnknownFields(descriptorProtos$UninterpretedOption$NamePart.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasNamePart()) {
            return false;
        }
        if (this.hasIsExtension()) return true;
        return false;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart = null;
        try {
            try {
                descriptorProtos$UninterpretedOption$NamePart = (DescriptorProtos$UninterpretedOption$NamePart)DescriptorProtos$UninterpretedOption$NamePart.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$UninterpretedOption$NamePart = (DescriptorProtos$UninterpretedOption$NamePart)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$UninterpretedOption$NamePart == null) return this;
            this.mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$UninterpretedOption$NamePart == null) throw var5_7;
            this.mergeFrom(descriptorProtos$UninterpretedOption$NamePart);
            throw var5_7;
        }
    }

    @Override
    public boolean hasNamePart() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getNamePart() {
        Object object = this.namePart_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.namePart_ = string;
        return string;
    }

    @Override
    public ByteString getNamePartBytes() {
        ByteString byteString;
        Object object = this.namePart_;
        if (!(object instanceof String)) return (ByteString)object;
        this.namePart_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePart(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.namePart_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearNamePart() {
        this.bitField0_ &= -2;
        this.namePart_ = DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance().getNamePart();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setNamePartBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.namePart_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasIsExtension() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getIsExtension() {
        return this.isExtension_;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder setIsExtension(boolean bl2) {
        this.bitField0_ |= 2;
        this.isExtension_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder clearIsExtension() {
        this.bitField0_ &= -3;
        this.isExtension_ = false;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

