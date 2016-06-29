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
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List method_ = Collections.emptyList();
    private RepeatedFieldBuilder methodBuilder_;
    private DescriptorProtos$ServiceOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$10500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$10600().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }

    private DescriptorProtos$ServiceDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getMethodFieldBuilder();
        this.getOptionsFieldBuilder();
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        if (this.methodBuilder_ == null) {
            this.method_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.methodBuilder_.clear();
        }
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
        return DescriptorProtos.access$10500();
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto build() {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = this.buildPartial();
        if (descriptorProtos$ServiceDescriptorProto.isInitialized()) return descriptorProtos$ServiceDescriptorProto;
        throw DescriptorProtos$ServiceDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$ServiceDescriptorProto);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto buildPartial() {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = new DescriptorProtos$ServiceDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$ServiceDescriptorProto.access$11002(descriptorProtos$ServiceDescriptorProto, this.name_);
        if (this.methodBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.method_ = Collections.unmodifiableList(this.method_);
                this.bitField0_ &= -3;
            }
            DescriptorProtos$ServiceDescriptorProto.access$11102(descriptorProtos$ServiceDescriptorProto, this.method_);
        } else {
            DescriptorProtos$ServiceDescriptorProto.access$11102(descriptorProtos$ServiceDescriptorProto, this.methodBuilder_.build());
        }
        if ((n2 & 4) == 4) {
            n3 |= 2;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$ServiceDescriptorProto.access$11202(descriptorProtos$ServiceDescriptorProto, this.options_);
        } else {
            DescriptorProtos$ServiceDescriptorProto.access$11202(descriptorProtos$ServiceDescriptorProto, (DescriptorProtos$ServiceOptions)this.optionsBuilder_.build());
        }
        DescriptorProtos$ServiceDescriptorProto.access$11302(descriptorProtos$ServiceDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$ServiceDescriptorProto;
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$ServiceDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (descriptorProtos$ServiceDescriptorProto == DescriptorProtos$ServiceDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$ServiceDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$ServiceDescriptorProto.access$11000(descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        }
        if (this.methodBuilder_ == null) {
            if (!DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto).isEmpty()) {
                if (this.method_.isEmpty()) {
                    this.method_ = DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureMethodIsMutable();
                    this.method_.addAll(DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto).isEmpty()) {
            if (this.methodBuilder_.isEmpty()) {
                this.methodBuilder_.dispose();
                this.methodBuilder_ = null;
                this.method_ = DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto);
                this.bitField0_ &= -3;
                this.methodBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getMethodFieldBuilder() : null;
            } else {
                this.methodBuilder_.addAllMessages(DescriptorProtos$ServiceDescriptorProto.access$11100(descriptorProtos$ServiceDescriptorProto));
            }
        }
        if (descriptorProtos$ServiceDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$ServiceDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$ServiceDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        do {
            if (n2 >= this.getMethodCount()) {
                if (!this.hasOptions()) return true;
                if (this.getOptions().isInitialized()) return true;
                return false;
            }
            if (!this.getMethod(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = null;
        try {
            try {
                descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$ServiceDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$ServiceDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$ServiceDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$ServiceDescriptorProto);
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

    public DescriptorProtos$ServiceDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureMethodIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.method_ = new ArrayList(this.method_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getMethodList() {
        if (this.methodBuilder_ != null) return this.methodBuilder_.getMessageList();
        return Collections.unmodifiableList(this.method_);
    }

    @Override
    public int getMethodCount() {
        if (this.methodBuilder_ != null) return this.methodBuilder_.getCount();
        return this.method_.size();
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto getMethod(int n2) {
        if (this.methodBuilder_ != null) return (DescriptorProtos$MethodDescriptorProto)this.methodBuilder_.getMessage(n2);
        return (DescriptorProtos$MethodDescriptorProto)this.method_.get(n2);
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int n2, DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ != null) {
            this.methodBuilder_.setMessage(n2, descriptorProtos$MethodDescriptorProto);
            return this;
        }
        if (descriptorProtos$MethodDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMethodIsMutable();
        this.method_.set(n2, descriptorProtos$MethodDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int n2, DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.set(n2, descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodBuilder_.setMessage(n2, descriptorProtos$MethodDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ != null) {
            this.methodBuilder_.addMessage(descriptorProtos$MethodDescriptorProto);
            return this;
        }
        if (descriptorProtos$MethodDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMethodIsMutable();
        this.method_.add(descriptorProtos$MethodDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int n2, DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ != null) {
            this.methodBuilder_.addMessage(n2, descriptorProtos$MethodDescriptorProto);
            return this;
        }
        if (descriptorProtos$MethodDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureMethodIsMutable();
        this.method_.add(n2, descriptorProtos$MethodDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.add(descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodBuilder_.addMessage(descriptorProtos$MethodDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int n2, DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.add(n2, descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodBuilder_.addMessage(n2, descriptorProtos$MethodDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder addAllMethod(Iterable iterable) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.method_);
            this.onChanged();
            return this;
        }
        this.methodBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearMethod() {
        if (this.methodBuilder_ == null) {
            this.method_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.methodBuilder_.clear();
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder removeMethod(int n2) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.remove(n2);
            this.onChanged();
            return this;
        }
        this.methodBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$MethodDescriptorProto$Builder getMethodBuilder(int n2) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int n2) {
        if (this.methodBuilder_ != null) return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.methodBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(n2);
    }

    @Override
    public List getMethodOrBuilderList() {
        if (this.methodBuilder_ == null) return Collections.unmodifiableList(this.method_);
        return this.methodBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder() {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder(int n2) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(n2, DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
    }

    public List getMethodBuilderList() {
        return this.getMethodFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getMethodFieldBuilder() {
        if (this.methodBuilder_ != null) return this.methodBuilder_;
        this.methodBuilder_ = new RepeatedFieldBuilder(this.method_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.method_ = null;
        return this.methodBuilder_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$ServiceOptions getOptions() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$ServiceOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
            return descriptorProtos$ServiceOptions;
        }
        descriptorProtos$ServiceOptions = this.options_;
        return descriptorProtos$ServiceOptions;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$ServiceOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$ServiceOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$ServiceOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions$Builder descriptorProtos$ServiceOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$ServiceOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$ServiceOptions$Builder.build());
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder mergeOptions(DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$ServiceOptions.getDefaultInstance() ? DescriptorProtos$ServiceOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$ServiceOptions).buildPartial() : descriptorProtos$ServiceOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$ServiceOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$ServiceDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -5;
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 4;
        this.onChanged();
        return (DescriptorProtos$ServiceOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$ServiceOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.getDefaultInstance();
            return descriptorProtos$ServiceOptions;
        }
        descriptorProtos$ServiceOptions = this.options_;
        return descriptorProtos$ServiceOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    /* synthetic */ DescriptorProtos$ServiceDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

