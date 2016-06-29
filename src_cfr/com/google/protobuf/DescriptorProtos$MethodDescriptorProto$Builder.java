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
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
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

public final class DescriptorProtos$MethodDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private Object inputType_ = "";
    private Object outputType_ = "";
    private DescriptorProtos$MethodOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;
    private boolean clientStreaming_;
    private boolean serverStreaming_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$11500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$11600().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
    }

    private DescriptorProtos$MethodDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        this.inputType_ = "";
        this.bitField0_ &= -3;
        this.outputType_ = "";
        this.bitField0_ &= -5;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -9;
        this.clientStreaming_ = false;
        this.bitField0_ &= -17;
        this.serverStreaming_ = false;
        this.bitField0_ &= -33;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$11500();
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto build() {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = this.buildPartial();
        if (descriptorProtos$MethodDescriptorProto.isInitialized()) return descriptorProtos$MethodDescriptorProto;
        throw DescriptorProtos$MethodDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$MethodDescriptorProto);
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto buildPartial() {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = new DescriptorProtos$MethodDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$MethodDescriptorProto.access$12002(descriptorProtos$MethodDescriptorProto, this.name_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$MethodDescriptorProto.access$12102(descriptorProtos$MethodDescriptorProto, this.inputType_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        DescriptorProtos$MethodDescriptorProto.access$12202(descriptorProtos$MethodDescriptorProto, this.outputType_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$MethodDescriptorProto.access$12302(descriptorProtos$MethodDescriptorProto, this.options_);
        } else {
            DescriptorProtos$MethodDescriptorProto.access$12302(descriptorProtos$MethodDescriptorProto, (DescriptorProtos$MethodOptions)this.optionsBuilder_.build());
        }
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        DescriptorProtos$MethodDescriptorProto.access$12402(descriptorProtos$MethodDescriptorProto, this.clientStreaming_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        DescriptorProtos$MethodDescriptorProto.access$12502(descriptorProtos$MethodDescriptorProto, this.serverStreaming_);
        DescriptorProtos$MethodDescriptorProto.access$12602(descriptorProtos$MethodDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$MethodDescriptorProto;
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$MethodDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$MethodDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (descriptorProtos$MethodDescriptorProto == DescriptorProtos$MethodDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$MethodDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$MethodDescriptorProto.access$12000(descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasInputType()) {
            this.bitField0_ |= 2;
            this.inputType_ = DescriptorProtos$MethodDescriptorProto.access$12100(descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasOutputType()) {
            this.bitField0_ |= 4;
            this.outputType_ = DescriptorProtos$MethodDescriptorProto.access$12200(descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$MethodDescriptorProto.getOptions());
        }
        if (descriptorProtos$MethodDescriptorProto.hasClientStreaming()) {
            this.setClientStreaming(descriptorProtos$MethodDescriptorProto.getClientStreaming());
        }
        if (descriptorProtos$MethodDescriptorProto.hasServerStreaming()) {
            this.setServerStreaming(descriptorProtos$MethodDescriptorProto.getServerStreaming());
        }
        this.mergeUnknownFields(descriptorProtos$MethodDescriptorProto.unknownFields);
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
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = null;
        try {
            try {
                descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$MethodDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$MethodDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$MethodDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$MethodDescriptorProto);
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

    public DescriptorProtos$MethodDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasInputType() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getInputType() {
        Object object = this.inputType_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.inputType_ = string;
        return string;
    }

    @Override
    public ByteString getInputTypeBytes() {
        ByteString byteString;
        Object object = this.inputType_;
        if (!(object instanceof String)) return (ByteString)object;
        this.inputType_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setInputType(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.inputType_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearInputType() {
        this.bitField0_ &= -3;
        this.inputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getInputType();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setInputTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.inputType_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOutputType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public String getOutputType() {
        Object object = this.outputType_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.outputType_ = string;
        return string;
    }

    @Override
    public ByteString getOutputTypeBytes() {
        ByteString byteString;
        Object object = this.outputType_;
        if (!(object instanceof String)) return (ByteString)object;
        this.outputType_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOutputType(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.outputType_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearOutputType() {
        this.bitField0_ &= -5;
        this.outputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getOutputType();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOutputTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.outputType_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public DescriptorProtos$MethodOptions getOptions() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$MethodOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
            return descriptorProtos$MethodOptions;
        }
        descriptorProtos$MethodOptions = this.options_;
        return descriptorProtos$MethodOptions;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$MethodOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$MethodOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$MethodOptions);
        }
        this.bitField0_ |= 8;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions$Builder descriptorProtos$MethodOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$MethodOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$MethodOptions$Builder.build());
        }
        this.bitField0_ |= 8;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder mergeOptions(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 8) == 8 && this.options_ != null && this.options_ != DescriptorProtos$MethodOptions.getDefaultInstance() ? DescriptorProtos$MethodOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$MethodOptions).buildPartial() : descriptorProtos$MethodOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$MethodOptions);
        }
        this.bitField0_ |= 8;
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -9;
        return this;
    }

    public DescriptorProtos$MethodOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 8;
        this.onChanged();
        return (DescriptorProtos$MethodOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$MethodOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
            return descriptorProtos$MethodOptions;
        }
        descriptorProtos$MethodOptions = this.options_;
        return descriptorProtos$MethodOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public boolean hasClientStreaming() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setClientStreaming(boolean bl2) {
        this.bitField0_ |= 16;
        this.clientStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearClientStreaming() {
        this.bitField0_ &= -17;
        this.clientStreaming_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasServerStreaming() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder setServerStreaming(boolean bl2) {
        this.bitField0_ |= 32;
        this.serverStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder clearServerStreaming() {
        this.bitField0_ &= -33;
        this.serverStreaming_ = false;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$MethodDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

