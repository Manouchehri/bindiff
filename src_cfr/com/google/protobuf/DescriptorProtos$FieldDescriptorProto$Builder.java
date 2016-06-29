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
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldDescriptorProto$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private int number_;
    private int label_ = 1;
    private int type_ = 1;
    private Object typeName_ = "";
    private Object extendee_ = "";
    private Object defaultValue_ = "";
    private int oneofIndex_;
    private DescriptorProtos$FieldOptions options_ = null;
    private SingleFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$6100();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$6200().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
    }

    private DescriptorProtos$FieldDescriptorProto$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= -2;
        this.number_ = 0;
        this.bitField0_ &= -3;
        this.label_ = 1;
        this.bitField0_ &= -5;
        this.type_ = 1;
        this.bitField0_ &= -9;
        this.typeName_ = "";
        this.bitField0_ &= -17;
        this.extendee_ = "";
        this.bitField0_ &= -33;
        this.defaultValue_ = "";
        this.bitField0_ &= -65;
        this.oneofIndex_ = 0;
        this.bitField0_ &= -129;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -257;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$6100();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto build() {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = this.buildPartial();
        if (descriptorProtos$FieldDescriptorProto.isInitialized()) return descriptorProtos$FieldDescriptorProto;
        throw DescriptorProtos$FieldDescriptorProto$Builder.newUninitializedMessageException(descriptorProtos$FieldDescriptorProto);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto buildPartial() {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = new DescriptorProtos$FieldDescriptorProto(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$FieldDescriptorProto.access$6602(descriptorProtos$FieldDescriptorProto, this.name_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$FieldDescriptorProto.access$6702(descriptorProtos$FieldDescriptorProto, this.number_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        DescriptorProtos$FieldDescriptorProto.access$6802(descriptorProtos$FieldDescriptorProto, this.label_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        DescriptorProtos$FieldDescriptorProto.access$6902(descriptorProtos$FieldDescriptorProto, this.type_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        DescriptorProtos$FieldDescriptorProto.access$7002(descriptorProtos$FieldDescriptorProto, this.typeName_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        DescriptorProtos$FieldDescriptorProto.access$7102(descriptorProtos$FieldDescriptorProto, this.extendee_);
        if ((n2 & 64) == 64) {
            n3 |= 64;
        }
        DescriptorProtos$FieldDescriptorProto.access$7202(descriptorProtos$FieldDescriptorProto, this.defaultValue_);
        if ((n2 & 128) == 128) {
            n3 |= 128;
        }
        DescriptorProtos$FieldDescriptorProto.access$7302(descriptorProtos$FieldDescriptorProto, this.oneofIndex_);
        if ((n2 & 256) == 256) {
            n3 |= 256;
        }
        if (this.optionsBuilder_ == null) {
            DescriptorProtos$FieldDescriptorProto.access$7402(descriptorProtos$FieldDescriptorProto, this.options_);
        } else {
            DescriptorProtos$FieldDescriptorProto.access$7402(descriptorProtos$FieldDescriptorProto, (DescriptorProtos$FieldOptions)this.optionsBuilder_.build());
        }
        DescriptorProtos$FieldDescriptorProto.access$7502(descriptorProtos$FieldDescriptorProto, n3);
        this.onBuilt();
        return descriptorProtos$FieldDescriptorProto;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$FieldDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$FieldDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (descriptorProtos$FieldDescriptorProto == DescriptorProtos$FieldDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$FieldDescriptorProto.access$6600(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasNumber()) {
            this.setNumber(descriptorProtos$FieldDescriptorProto.getNumber());
        }
        if (descriptorProtos$FieldDescriptorProto.hasLabel()) {
            this.setLabel(descriptorProtos$FieldDescriptorProto.getLabel());
        }
        if (descriptorProtos$FieldDescriptorProto.hasType()) {
            this.setType(descriptorProtos$FieldDescriptorProto.getType());
        }
        if (descriptorProtos$FieldDescriptorProto.hasTypeName()) {
            this.bitField0_ |= 16;
            this.typeName_ = DescriptorProtos$FieldDescriptorProto.access$7000(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasExtendee()) {
            this.bitField0_ |= 32;
            this.extendee_ = DescriptorProtos$FieldDescriptorProto.access$7100(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasDefaultValue()) {
            this.bitField0_ |= 64;
            this.defaultValue_ = DescriptorProtos$FieldDescriptorProto.access$7200(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasOneofIndex()) {
            this.setOneofIndex(descriptorProtos$FieldDescriptorProto.getOneofIndex());
        }
        if (descriptorProtos$FieldDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$FieldDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$FieldDescriptorProto.unknownFields);
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
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = null;
        try {
            try {
                descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$FieldDescriptorProto == null) return this;
            this.mergeFrom(descriptorProtos$FieldDescriptorProto);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$FieldDescriptorProto == null) throw var5_7;
            this.mergeFrom(descriptorProtos$FieldDescriptorProto);
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

    public DescriptorProtos$FieldDescriptorProto$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearName() {
        this.bitField0_ &= -2;
        this.name_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setNameBytes(ByteString byteString) {
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

    public DescriptorProtos$FieldDescriptorProto$Builder setNumber(int n2) {
        this.bitField0_ |= 2;
        this.number_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasLabel() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2 = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
        if (descriptorProtos$FieldDescriptorProto$Label2 == null) {
            descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
            return descriptorProtos$FieldDescriptorProto$Label;
        }
        descriptorProtos$FieldDescriptorProto$Label = descriptorProtos$FieldDescriptorProto$Label2;
        return descriptorProtos$FieldDescriptorProto$Label;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setLabel(DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label) {
        if (descriptorProtos$FieldDescriptorProto$Label == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.label_ = descriptorProtos$FieldDescriptorProto$Label.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearLabel() {
        this.bitField0_ &= -5;
        this.label_ = 1;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasType() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type;
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type2 = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
        if (descriptorProtos$FieldDescriptorProto$Type2 == null) {
            descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE;
            return descriptorProtos$FieldDescriptorProto$Type;
        }
        descriptorProtos$FieldDescriptorProto$Type = descriptorProtos$FieldDescriptorProto$Type2;
        return descriptorProtos$FieldDescriptorProto$Type;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setType(DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        if (descriptorProtos$FieldDescriptorProto$Type == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.type_ = descriptorProtos$FieldDescriptorProto$Type.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearType() {
        this.bitField0_ &= -9;
        this.type_ = 1;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasTypeName() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getTypeName() {
        Object object = this.typeName_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeName_ = string;
        return string;
    }

    @Override
    public ByteString getTypeNameBytes() {
        ByteString byteString;
        Object object = this.typeName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setTypeName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.typeName_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearTypeName() {
        this.bitField0_ &= -17;
        this.typeName_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getTypeName();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setTypeNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.typeName_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasExtendee() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public String getExtendee() {
        Object object = this.extendee_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.extendee_ = string;
        return string;
    }

    @Override
    public ByteString getExtendeeBytes() {
        ByteString byteString;
        Object object = this.extendee_;
        if (!(object instanceof String)) return (ByteString)object;
        this.extendee_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setExtendee(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.extendee_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearExtendee() {
        this.bitField0_ &= -33;
        this.extendee_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getExtendee();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setExtendeeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.extendee_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDefaultValue() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public String getDefaultValue() {
        Object object = this.defaultValue_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.defaultValue_ = string;
        return string;
    }

    @Override
    public ByteString getDefaultValueBytes() {
        ByteString byteString;
        Object object = this.defaultValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.defaultValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValue(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.defaultValue_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearDefaultValue() {
        this.bitField0_ &= -65;
        this.defaultValue_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getDefaultValue();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.defaultValue_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOneofIndex() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOneofIndex(int n2) {
        this.bitField0_ |= 128;
        this.oneofIndex_ = n2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearOneofIndex() {
        this.bitField0_ &= -129;
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions getOptions() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        if (this.optionsBuilder_ != null) return (DescriptorProtos$FieldOptions)this.optionsBuilder_.getMessage();
        if (this.options_ == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
            return descriptorProtos$FieldOptions;
        }
        descriptorProtos$FieldOptions = this.options_;
        return descriptorProtos$FieldOptions;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$FieldOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$FieldOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$FieldOptions);
        }
        this.bitField0_ |= 256;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(DescriptorProtos$FieldOptions$Builder descriptorProtos$FieldOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$FieldOptions$Builder.build();
            this.onChanged();
        } else {
            this.optionsBuilder_.setMessage(descriptorProtos$FieldOptions$Builder.build());
        }
        this.bitField0_ |= 256;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder mergeOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        if (this.optionsBuilder_ == null) {
            this.options_ = (this.bitField0_ & 256) == 256 && this.options_ != null && this.options_ != DescriptorProtos$FieldOptions.getDefaultInstance() ? DescriptorProtos$FieldOptions.newBuilder(this.options_).mergeFrom(descriptorProtos$FieldOptions).buildPartial() : descriptorProtos$FieldOptions;
            this.onChanged();
        } else {
            this.optionsBuilder_.mergeFrom(descriptorProtos$FieldOptions);
        }
        this.bitField0_ |= 256;
        return this;
    }

    public DescriptorProtos$FieldDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        } else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= -257;
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 256;
        this.onChanged();
        return (DescriptorProtos$FieldOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }

    @Override
    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$FieldOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        if (this.options_ == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
            return descriptorProtos$FieldOptions;
        }
        descriptorProtos$FieldOptions = this.options_;
        return descriptorProtos$FieldOptions;
    }

    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    /* synthetic */ DescriptorProtos$FieldDescriptorProto$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$FieldDescriptorProto$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

