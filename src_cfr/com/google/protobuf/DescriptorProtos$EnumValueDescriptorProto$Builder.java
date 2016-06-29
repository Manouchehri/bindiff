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
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

public final class DescriptorProtos$EnumValueDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private int number_;
    private DescriptorProtos$EnumValueOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
    }

    private DescriptorProtos$EnumValueDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        this.number_ = 0;
        this.bitField0_ &= -3;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -5;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$9500();
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto build() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = this.buildPartial();
        if (descriptorProtos$EnumValueDescriptorProto.isInitialized()) return descriptorProtos$EnumValueDescriptorProto;
        throw DescriptorProtos$EnumValueDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$EnumValueDescriptorProto);
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto buildPartial() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = new DescriptorProtos$EnumValueDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$EnumValueDescriptorProto.access$10002(descriptorProtos$EnumValueDescriptorProto, this.name_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$EnumValueDescriptorProto.access$10102(descriptorProtos$EnumValueDescriptorProto, this.number_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$EnumValueDescriptorProto.access$10202(descriptorProtos$EnumValueDescriptorProto, this.options_);
        } else {
            DescriptorProtos$EnumValueDescriptorProto.access$10202(descriptorProtos$EnumValueDescriptorProto, (DescriptorProtos$EnumValueOptions)this.optionsBuilder_.build());
        }
        DescriptorProtos$EnumValueDescriptorProto.access$10302(descriptorProtos$EnumValueDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$EnumValueDescriptorProto;
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$EnumValueDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (descriptorProtos$EnumValueDescriptorProto == DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$EnumValueDescriptorProto.access$10000(descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasNumber()) {
            this.setNumber(descriptorProtos$EnumValueDescriptorProto.getNumber());
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$EnumValueDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$EnumValueDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasOptions()) return true;
        if (this.getOptions().isInitialized()) return true;
        return false;
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = null;
        try {
            try {
                descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$EnumValueDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$EnumValueDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$EnumValueDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$EnumValueDescriptorProto);
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

    public DescriptorProtos$EnumValueDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNumber() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setNumber(int n2) {
        this.bitField0_ |= 2;
        this.number_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$EnumValueOptions getOptions() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$EnumValueOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
            return descriptorProtos$EnumValueOptions;
        }
        descriptorProtos$EnumValueOptions = this.options_;
        return descriptorProtos$EnumValueOptions;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$EnumValueOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$EnumValueOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumValueOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions$Builder descriptorProtos$EnumValueOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$EnumValueOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumValueOptions$Builder.build());
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$EnumValueOptions.getDefaultInstance() ? DescriptorProtos$EnumValueOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$EnumValueOptions).buildPartial() : descriptorProtos$EnumValueOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$EnumValueOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -5;
        return this;
    }

    public DescriptorProtos$EnumValueOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 4;
        this.onChanged();
        return (DescriptorProtos$EnumValueOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$EnumValueOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
            return descriptorProtos$EnumValueOptions;
        }
        descriptorProtos$EnumValueOptions = this.options_;
        return descriptorProtos$EnumValueOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    /* synthetic */ DescriptorProtos$EnumValueDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

