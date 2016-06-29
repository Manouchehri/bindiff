/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Enum;
import com.google.protobuf.Enum$1;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$Builder;
import com.google.protobuf.EnumValueOrBuilder;
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
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Enum$Builder
extends GeneratedMessage$Builder
implements EnumOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List enumvalue_ = Collections.emptyList();
    private RepeatedFieldBuilder enumvalueBuilder_;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;
    private SourceContext sourceContext_ = null;
    private SingleFieldBuilder sourceContextBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
    }

    private Enum$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Enum$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getEnumvalueFieldBuilder();
        this.getOptionsFieldBuilder();
    }

    @Override
    public Enum$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.enumvalueBuilder_ == null) {
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.enumvalueBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        } else {
            this.optionsBuilder_.clear();
        }
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            return this;
        }
        this.sourceContext_ = null;
        this.sourceContextBuilder_ = null;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override
    public Enum getDefaultInstanceForType() {
        return Enum.getDefaultInstance();
    }

    @Override
    public Enum build() {
        Enum enum_ = this.buildPartial();
        if (enum_.isInitialized()) return enum_;
        throw Enum$Builder.newUninitializedMessageException(enum_);
    }

    @Override
    public Enum buildPartial() {
        Enum enum_ = new Enum(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        Enum.access$302(enum_, this.name_);
        if (this.enumvalueBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
                this.bitField0_ &= -3;
            }
            Enum.access$402(enum_, this.enumvalue_);
        } else {
            Enum.access$402(enum_, this.enumvalueBuilder_.build());
        }
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -5;
            }
            Enum.access$502(enum_, this.options_);
        } else {
            Enum.access$502(enum_, this.optionsBuilder_.build());
        }
        if (this.sourceContextBuilder_ == null) {
            Enum.access$602(enum_, this.sourceContext_);
        } else {
            Enum.access$602(enum_, (SourceContext)this.sourceContextBuilder_.build());
        }
        Enum.access$702(enum_, n3);
        this.onBuilt();
        return enum_;
    }

    @Override
    public Enum$Builder mergeFrom(Message message) {
        if (message instanceof Enum) {
            return this.mergeFrom((Enum)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Enum$Builder mergeFrom(Enum enum_) {
        if (enum_ == Enum.getDefaultInstance()) {
            return this;
        }
        if (!enum_.getName().isEmpty()) {
            this.name_ = Enum.access$300(enum_);
            this.onChanged();
        }
        if (this.enumvalueBuilder_ == null) {
            if (!Enum.access$400(enum_).isEmpty()) {
                if (this.enumvalue_.isEmpty()) {
                    this.enumvalue_ = Enum.access$400(enum_);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureEnumvalueIsMutable();
                    this.enumvalue_.addAll(Enum.access$400(enum_));
                }
                this.onChanged();
            }
        } else if (!Enum.access$400(enum_).isEmpty()) {
            if (this.enumvalueBuilder_.isEmpty()) {
                this.enumvalueBuilder_.dispose();
                this.enumvalueBuilder_ = null;
                this.enumvalue_ = Enum.access$400(enum_);
                this.bitField0_ &= -3;
                this.enumvalueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumvalueFieldBuilder() : null;
            } else {
                this.enumvalueBuilder_.addAllMessages(Enum.access$400(enum_));
            }
        }
        if (this.optionsBuilder_ == null) {
            if (!Enum.access$500(enum_).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = Enum.access$500(enum_);
                    this.bitField0_ &= -5;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(Enum.access$500(enum_));
                }
                this.onChanged();
            }
        } else if (!Enum.access$500(enum_).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = Enum.access$500(enum_);
                this.bitField0_ &= -5;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(Enum.access$500(enum_));
            }
        }
        if (enum_.hasSourceContext()) {
            this.mergeSourceContext(enum_.getSourceContext());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Enum$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Enum enum_ = null;
        try {
            try {
                enum_ = (Enum)Enum.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                enum_ = (Enum)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (enum_ == null) return this;
            this.mergeFrom(enum_);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (enum_ == null) throw var5_7;
            this.mergeFrom(enum_);
            throw var5_7;
        }
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

    public Enum$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Enum$Builder clearName() {
        this.name_ = Enum.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Enum$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureEnumvalueIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.enumvalue_ = new ArrayList(this.enumvalue_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getEnumvalueList() {
        if (this.enumvalueBuilder_ != null) return this.enumvalueBuilder_.getMessageList();
        return Collections.unmodifiableList(this.enumvalue_);
    }

    @Override
    public int getEnumvalueCount() {
        if (this.enumvalueBuilder_ != null) return this.enumvalueBuilder_.getCount();
        return this.enumvalue_.size();
    }

    @Override
    public EnumValue getEnumvalue(int n2) {
        if (this.enumvalueBuilder_ != null) return (EnumValue)this.enumvalueBuilder_.getMessage(n2);
        return (EnumValue)this.enumvalue_.get(n2);
    }

    public Enum$Builder setEnumvalue(int n2, EnumValue enumValue) {
        if (this.enumvalueBuilder_ != null) {
            this.enumvalueBuilder_.setMessage(n2, enumValue);
            return this;
        }
        if (enumValue == null) {
            throw new NullPointerException();
        }
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.set(n2, enumValue);
        this.onChanged();
        return this;
    }

    public Enum$Builder setEnumvalue(int n2, EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.set(n2, enumValue$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.setMessage(n2, enumValue$Builder.build());
        return this;
    }

    public Enum$Builder addEnumvalue(EnumValue enumValue) {
        if (this.enumvalueBuilder_ != null) {
            this.enumvalueBuilder_.addMessage(enumValue);
            return this;
        }
        if (enumValue == null) {
            throw new NullPointerException();
        }
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.add(enumValue);
        this.onChanged();
        return this;
    }

    public Enum$Builder addEnumvalue(int n2, EnumValue enumValue) {
        if (this.enumvalueBuilder_ != null) {
            this.enumvalueBuilder_.addMessage(n2, enumValue);
            return this;
        }
        if (enumValue == null) {
            throw new NullPointerException();
        }
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.add(n2, enumValue);
        this.onChanged();
        return this;
    }

    public Enum$Builder addEnumvalue(EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(enumValue$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.addMessage(enumValue$Builder.build());
        return this;
    }

    public Enum$Builder addEnumvalue(int n2, EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(n2, enumValue$Builder.build());
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.addMessage(n2, enumValue$Builder.build());
        return this;
    }

    public Enum$Builder addAllEnumvalue(Iterable iterable) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.enumvalue_);
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.addAllMessages(iterable);
        return this;
    }

    public Enum$Builder clearEnumvalue() {
        if (this.enumvalueBuilder_ == null) {
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.clear();
        return this;
    }

    public Enum$Builder removeEnumvalue(int n2) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.remove(n2);
            this.onChanged();
            return this;
        }
        this.enumvalueBuilder_.remove(n2);
        return this;
    }

    public EnumValue$Builder getEnumvalueBuilder(int n2) {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().getBuilder(n2);
    }

    @Override
    public EnumValueOrBuilder getEnumvalueOrBuilder(int n2) {
        if (this.enumvalueBuilder_ != null) return (EnumValueOrBuilder)this.enumvalueBuilder_.getMessageOrBuilder(n2);
        return (EnumValueOrBuilder)this.enumvalue_.get(n2);
    }

    @Override
    public List getEnumvalueOrBuilderList() {
        if (this.enumvalueBuilder_ == null) return Collections.unmodifiableList(this.enumvalue_);
        return this.enumvalueBuilder_.getMessageOrBuilderList();
    }

    public EnumValue$Builder addEnumvalueBuilder() {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
    }

    public EnumValue$Builder addEnumvalueBuilder(int n2) {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(n2, EnumValue.getDefaultInstance());
    }

    public List getEnumvalueBuilderList() {
        return this.getEnumvalueFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getEnumvalueFieldBuilder() {
        if (this.enumvalueBuilder_ != null) return this.enumvalueBuilder_;
        this.enumvalueBuilder_ = new RepeatedFieldBuilder(this.enumvalue_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.enumvalue_ = null;
        return this.enumvalueBuilder_;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 4;
    }

    @Override
    public List getOptionsList() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.options_);
    }

    @Override
    public int getOptionsCount() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getCount();
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        if (this.optionsBuilder_ != null) return (Option)this.optionsBuilder_.getMessage(n2);
        return (Option)this.options_.get(n2);
    }

    public Enum$Builder setOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.setMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.set(n2, option);
        this.onChanged();
        return this;
    }

    public Enum$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public Enum$Builder addOptions(Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(option);
        this.onChanged();
        return this;
    }

    public Enum$Builder addOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(n2, option);
        this.onChanged();
        return this;
    }

    public Enum$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public Enum$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public Enum$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Enum$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public Enum$Builder removeOptions(int n2) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.remove(n2);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.remove(n2);
        return this;
    }

    public Option$Builder getOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        if (this.optionsBuilder_ != null) return (OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(n2);
        return (OptionOrBuilder)this.options_.get(n2);
    }

    @Override
    public List getOptionsOrBuilderList() {
        if (this.optionsBuilder_ == null) return Collections.unmodifiableList(this.options_);
        return this.optionsBuilder_.getMessageOrBuilderList();
    }

    public Option$Builder addOptionsBuilder() {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }

    public Option$Builder addOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(n2, Option.getDefaultInstance());
    }

    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public boolean hasSourceContext() {
        if (this.sourceContextBuilder_ != null) return true;
        if (this.sourceContext_ != null) return true;
        return false;
    }

    @Override
    public SourceContext getSourceContext() {
        SourceContext sourceContext;
        if (this.sourceContextBuilder_ != null) return (SourceContext)this.sourceContextBuilder_.getMessage();
        if (this.sourceContext_ == null) {
            sourceContext = SourceContext.getDefaultInstance();
            return sourceContext;
        }
        sourceContext = this.sourceContext_;
        return sourceContext;
    }

    public Enum$Builder setSourceContext(SourceContext sourceContext) {
        if (this.sourceContextBuilder_ != null) {
            this.sourceContextBuilder_.setMessage(sourceContext);
            return this;
        }
        if (sourceContext == null) {
            throw new NullPointerException();
        }
        this.sourceContext_ = sourceContext;
        this.onChanged();
        return this;
    }

    public Enum$Builder setSourceContext(SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
            return this;
        }
        this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        return this;
    }

    public Enum$Builder mergeSourceContext(SourceContext sourceContext) {
        if (this.sourceContextBuilder_ != null) {
            this.sourceContextBuilder_.mergeFrom(sourceContext);
            return this;
        }
        this.sourceContext_ = this.sourceContext_ != null ? SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext).buildPartial() : sourceContext;
        this.onChanged();
        return this;
    }

    public Enum$Builder clearSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            this.onChanged();
            return this;
        }
        this.sourceContext_ = null;
        this.sourceContextBuilder_ = null;
        return this;
    }

    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }

    @Override
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext sourceContext;
        if (this.sourceContextBuilder_ != null) {
            return (SourceContextOrBuilder)this.sourceContextBuilder_.getMessageOrBuilder();
        }
        if (this.sourceContext_ == null) {
            sourceContext = SourceContext.getDefaultInstance();
            return sourceContext;
        }
        sourceContext = this.sourceContext_;
        return sourceContext;
    }

    private SingleFieldBuilder getSourceContextFieldBuilder() {
        if (this.sourceContextBuilder_ != null) return this.sourceContextBuilder_;
        this.sourceContextBuilder_ = new SingleFieldBuilder(this.getSourceContext(), this.getParentForChildren(), this.isClean());
        this.sourceContext_ = null;
        return this.sourceContextBuilder_;
    }

    @Override
    public final Enum$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Enum$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Enum$Builder(Enum$1 enum$1) {
        this();
    }

    /* synthetic */ Enum$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Enum$1 enum$1) {
        this(generatedMessage$BuilderParent);
    }
}

