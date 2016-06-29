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
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$EnumDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List value_ = Collections.emptyList();
    private RepeatedFieldBuilder valueBuilder_;
    private DescriptorProtos$EnumOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$8500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$8600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
    }

    private DescriptorProtos$EnumDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getValueFieldBuilder();
        this.getOptionsFieldBuilder();
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        if (this.valueBuilder_ == null) {
            this.value_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.valueBuilder_.clear();
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
        return DescriptorProtos.access$8500();
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto build() {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = this.buildPartial();
        if (descriptorProtos$EnumDescriptorProto.isInitialized()) return descriptorProtos$EnumDescriptorProto;
        throw DescriptorProtos$EnumDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$EnumDescriptorProto);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto buildPartial() {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = new DescriptorProtos$EnumDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$EnumDescriptorProto.access$9002(descriptorProtos$EnumDescriptorProto, this.name_);
        if (this.valueBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.value_ = Collections.unmodifiableList(this.value_);
                this.bitField0_ &= -3;
            }
            DescriptorProtos$EnumDescriptorProto.access$9102(descriptorProtos$EnumDescriptorProto, this.value_);
        } else {
            DescriptorProtos$EnumDescriptorProto.access$9102(descriptorProtos$EnumDescriptorProto, this.valueBuilder_.build());
        }
        if ((n2 & 4) == 4) {
            n3 |= 2;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$EnumDescriptorProto.access$9202(descriptorProtos$EnumDescriptorProto, this.options_);
        } else {
            DescriptorProtos$EnumDescriptorProto.access$9202(descriptorProtos$EnumDescriptorProto, (DescriptorProtos$EnumOptions)this.optionsBuilder_.build());
        }
        DescriptorProtos$EnumDescriptorProto.access$9302(descriptorProtos$EnumDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$EnumDescriptorProto;
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$EnumDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$EnumDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (descriptorProtos$EnumDescriptorProto == DescriptorProtos$EnumDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$EnumDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$EnumDescriptorProto.access$9000(descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        }
        if (this.valueBuilder_ == null) {
            if (!DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto).isEmpty()) {
                if (this.value_.isEmpty()) {
                    this.value_ = DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureValueIsMutable();
                    this.value_.addAll(DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto).isEmpty()) {
            if (this.valueBuilder_.isEmpty()) {
                this.valueBuilder_.dispose();
                this.valueBuilder_ = null;
                this.value_ = DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto);
                this.bitField0_ &= -3;
                this.valueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getValueFieldBuilder() : null;
            } else {
                this.valueBuilder_.addAllMessages(DescriptorProtos$EnumDescriptorProto.access$9100(descriptorProtos$EnumDescriptorProto));
            }
        }
        if (descriptorProtos$EnumDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$EnumDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$EnumDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        do {
            if (n2 >= this.getValueCount()) {
                if (!this.hasOptions()) return true;
                if (this.getOptions().isInitialized()) return true;
                return false;
            }
            if (!this.getValue(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = null;
        try {
            try {
                descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$EnumDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$EnumDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$EnumDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$EnumDescriptorProto);
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

    public DescriptorProtos$EnumDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$EnumDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureValueIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.value_ = new ArrayList(this.value_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getValueList() {
        if (this.valueBuilder_ != null) return this.valueBuilder_.getMessageList();
        return Collections.unmodifiableList(this.value_);
    }

    @Override
    public int getValueCount() {
        if (this.valueBuilder_ != null) return this.valueBuilder_.getCount();
        return this.value_.size();
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto getValue(int n2) {
        if (this.valueBuilder_ != null) return (DescriptorProtos$EnumValueDescriptorProto)this.valueBuilder_.getMessage(n2);
        return (DescriptorProtos$EnumValueDescriptorProto)this.value_.get(n2);
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setValue(int n2, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ != null) {
            this.valueBuilder_.setMessage(n2, descriptorProtos$EnumValueDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumValueDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureValueIsMutable();
        this.value_.set(n2, descriptorProtos$EnumValueDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setValue(int n2, DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.set(n2, descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.valueBuilder_.setMessage(n2, descriptorProtos$EnumValueDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ != null) {
            this.valueBuilder_.addMessage(descriptorProtos$EnumValueDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumValueDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureValueIsMutable();
        this.value_.add(descriptorProtos$EnumValueDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(int n2, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ != null) {
            this.valueBuilder_.addMessage(n2, descriptorProtos$EnumValueDescriptorProto);
            return this;
        }
        if (descriptorProtos$EnumValueDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureValueIsMutable();
        this.value_.add(n2, descriptorProtos$EnumValueDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.add(descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.valueBuilder_.addMessage(descriptorProtos$EnumValueDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addValue(int n2, DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.add(n2, descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.valueBuilder_.addMessage(n2, descriptorProtos$EnumValueDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder addAllValue(Iterable iterable) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.value_);
            this.onChanged();
            return this;
        }
        this.valueBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearValue() {
        if (this.valueBuilder_ == null) {
            this.value_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.valueBuilder_.clear();
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder removeValue(int n2) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.remove(n2);
            this.onChanged();
            return this;
        }
        this.valueBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder getValueBuilder(int n2) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int n2) {
        if (this.valueBuilder_ != null) return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.valueBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(n2);
    }

    @Override
    public List getValueOrBuilderList() {
        if (this.valueBuilder_ == null) return Collections.unmodifiableList(this.value_);
        return this.valueBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder() {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder(int n2) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(n2, DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
    }

    public List getValueBuilderList() {
        return this.getValueFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getValueFieldBuilder() {
        if (this.valueBuilder_ != null) return this.valueBuilder_;
        this.valueBuilder_ = new RepeatedFieldBuilder(this.value_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.value_ = null;
        return this.valueBuilder_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$EnumOptions getOptions() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$EnumOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
            return descriptorProtos$EnumOptions;
        }
        descriptorProtos$EnumOptions = this.options_;
        return descriptorProtos$EnumOptions;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$EnumOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$EnumOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions$Builder descriptorProtos$EnumOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$EnumOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumOptions$Builder.build());
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$EnumOptions.getDefaultInstance() ? DescriptorProtos$EnumOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$EnumOptions).buildPartial() : descriptorProtos$EnumOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$EnumOptions);
        }
        this.bitField0_ |= 4;
        return this;
    }

    public DescriptorProtos$EnumDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -5;
        return this;
    }

    public DescriptorProtos$EnumOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 4;
        this.onChanged();
        return (DescriptorProtos$EnumOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$EnumOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.getDefaultInstance();
            return descriptorProtos$EnumOptions;
        }
        descriptorProtos$EnumOptions = this.options_;
        return descriptorProtos$EnumOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    /* synthetic */ DescriptorProtos$EnumDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

