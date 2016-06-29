/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Builder;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Type;
import com.google.protobuf.Type$1;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Type$Builder
extends GeneratedMessage$Builder
implements TypeOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List fields_ = Collections.emptyList();
    private RepeatedFieldBuilder fieldsBuilder_;
    private LazyStringList oneofs_ = LazyStringArrayList.EMPTY;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;
    private SourceContext sourceContext_ = null;
    private SingleFieldBuilder sourceContextBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
    }

    private Type$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Type$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getFieldsFieldBuilder();
        this.getOptionsFieldBuilder();
    }

    @Override
    public Type$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.fieldsBuilder_ == null) {
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.fieldsBuilder_.clear();
        }
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -5;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
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
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    @Override
    public Type getDefaultInstanceForType() {
        return Type.getDefaultInstance();
    }

    @Override
    public Type build() {
        Type type = this.buildPartial();
        if (type.isInitialized()) return type;
        throw Type$Builder.newUninitializedMessageException(type);
    }

    @Override
    public Type buildPartial() {
        Type type = new Type(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        Type.access$302(type, this.name_);
        if (this.fieldsBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.fields_ = Collections.unmodifiableList(this.fields_);
                this.bitField0_ &= -3;
            }
            Type.access$402(type, this.fields_);
        } else {
            Type.access$402(type, this.fieldsBuilder_.build());
        }
        if ((this.bitField0_ & 4) == 4) {
            this.oneofs_ = this.oneofs_.getUnmodifiableView();
            this.bitField0_ &= -5;
        }
        Type.access$502(type, this.oneofs_);
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 8) == 8) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -9;
            }
            Type.access$602(type, this.options_);
        } else {
            Type.access$602(type, this.optionsBuilder_.build());
        }
        if (this.sourceContextBuilder_ == null) {
            Type.access$702(type, this.sourceContext_);
        } else {
            Type.access$702(type, (SourceContext)this.sourceContextBuilder_.build());
        }
        Type.access$802(type, n3);
        this.onBuilt();
        return type;
    }

    @Override
    public Type$Builder mergeFrom(Message message) {
        if (message instanceof Type) {
            return this.mergeFrom((Type)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Type$Builder mergeFrom(Type type) {
        if (type == Type.getDefaultInstance()) {
            return this;
        }
        if (!type.getName().isEmpty()) {
            this.name_ = Type.access$300(type);
            this.onChanged();
        }
        if (this.fieldsBuilder_ == null) {
            if (!Type.access$400(type).isEmpty()) {
                if (this.fields_.isEmpty()) {
                    this.fields_ = Type.access$400(type);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureFieldsIsMutable();
                    this.fields_.addAll(Type.access$400(type));
                }
                this.onChanged();
            }
        } else if (!Type.access$400(type).isEmpty()) {
            if (this.fieldsBuilder_.isEmpty()) {
                this.fieldsBuilder_.dispose();
                this.fieldsBuilder_ = null;
                this.fields_ = Type.access$400(type);
                this.bitField0_ &= -3;
                this.fieldsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getFieldsFieldBuilder() : null;
            } else {
                this.fieldsBuilder_.addAllMessages(Type.access$400(type));
            }
        }
        if (!Type.access$500(type).isEmpty()) {
            if (this.oneofs_.isEmpty()) {
                this.oneofs_ = Type.access$500(type);
                this.bitField0_ &= -5;
            } else {
                this.ensureOneofsIsMutable();
                this.oneofs_.addAll(Type.access$500(type));
            }
            this.onChanged();
        }
        if (this.optionsBuilder_ == null) {
            if (!Type.access$600(type).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = Type.access$600(type);
                    this.bitField0_ &= -9;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(Type.access$600(type));
                }
                this.onChanged();
            }
        } else if (!Type.access$600(type).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = Type.access$600(type);
                this.bitField0_ &= -9;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(Type.access$600(type));
            }
        }
        if (type.hasSourceContext()) {
            this.mergeSourceContext(type.getSourceContext());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Type$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Type type = null;
        try {
            try {
                type = (Type)Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                type = (Type)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (type == null) return this;
            this.mergeFrom(type);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (type == null) throw var5_7;
            this.mergeFrom(type);
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

    public Type$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Type$Builder clearName() {
        this.name_ = Type.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Type$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureFieldsIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.fields_ = new ArrayList(this.fields_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getFieldsList() {
        if (this.fieldsBuilder_ != null) return this.fieldsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.fields_);
    }

    @Override
    public int getFieldsCount() {
        if (this.fieldsBuilder_ != null) return this.fieldsBuilder_.getCount();
        return this.fields_.size();
    }

    @Override
    public Field getFields(int n2) {
        if (this.fieldsBuilder_ != null) return (Field)this.fieldsBuilder_.getMessage(n2);
        return (Field)this.fields_.get(n2);
    }

    public Type$Builder setFields(int n2, Field field) {
        if (this.fieldsBuilder_ != null) {
            this.fieldsBuilder_.setMessage(n2, field);
            return this;
        }
        if (field == null) {
            throw new NullPointerException();
        }
        this.ensureFieldsIsMutable();
        this.fields_.set(n2, field);
        this.onChanged();
        return this;
    }

    public Type$Builder setFields(int n2, Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.set(n2, field$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.setMessage(n2, field$Builder.build());
        return this;
    }

    public Type$Builder addFields(Field field) {
        if (this.fieldsBuilder_ != null) {
            this.fieldsBuilder_.addMessage(field);
            return this;
        }
        if (field == null) {
            throw new NullPointerException();
        }
        this.ensureFieldsIsMutable();
        this.fields_.add(field);
        this.onChanged();
        return this;
    }

    public Type$Builder addFields(int n2, Field field) {
        if (this.fieldsBuilder_ != null) {
            this.fieldsBuilder_.addMessage(n2, field);
            return this;
        }
        if (field == null) {
            throw new NullPointerException();
        }
        this.ensureFieldsIsMutable();
        this.fields_.add(n2, field);
        this.onChanged();
        return this;
    }

    public Type$Builder addFields(Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.add(field$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.addMessage(field$Builder.build());
        return this;
    }

    public Type$Builder addFields(int n2, Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.add(n2, field$Builder.build());
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.addMessage(n2, field$Builder.build());
        return this;
    }

    public Type$Builder addAllFields(Iterable iterable) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.fields_);
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Type$Builder clearFields() {
        if (this.fieldsBuilder_ == null) {
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.clear();
        return this;
    }

    public Type$Builder removeFields(int n2) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.remove(n2);
            this.onChanged();
            return this;
        }
        this.fieldsBuilder_.remove(n2);
        return this;
    }

    public Field$Builder getFieldsBuilder(int n2) {
        return (Field$Builder)this.getFieldsFieldBuilder().getBuilder(n2);
    }

    @Override
    public FieldOrBuilder getFieldsOrBuilder(int n2) {
        if (this.fieldsBuilder_ != null) return (FieldOrBuilder)this.fieldsBuilder_.getMessageOrBuilder(n2);
        return (FieldOrBuilder)this.fields_.get(n2);
    }

    @Override
    public List getFieldsOrBuilderList() {
        if (this.fieldsBuilder_ == null) return Collections.unmodifiableList(this.fields_);
        return this.fieldsBuilder_.getMessageOrBuilderList();
    }

    public Field$Builder addFieldsBuilder() {
        return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
    }

    public Field$Builder addFieldsBuilder(int n2) {
        return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(n2, Field.getDefaultInstance());
    }

    public List getFieldsBuilderList() {
        return this.getFieldsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getFieldsFieldBuilder() {
        if (this.fieldsBuilder_ != null) return this.fieldsBuilder_;
        this.fieldsBuilder_ = new RepeatedFieldBuilder(this.fields_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.fields_ = null;
        return this.fieldsBuilder_;
    }

    private void ensureOneofsIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.oneofs_ = new LazyStringArrayList(this.oneofs_);
        this.bitField0_ |= 4;
    }

    @Override
    public ProtocolStringList getOneofsList() {
        return this.oneofs_.getUnmodifiableView();
    }

    @Override
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override
    public String getOneofs(int n2) {
        return (String)this.oneofs_.get(n2);
    }

    @Override
    public ByteString getOneofsBytes(int n2) {
        return this.oneofs_.getByteString(n2);
    }

    public Type$Builder setOneofs(int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.set(n2, string);
        this.onChanged();
        return this;
    }

    public Type$Builder addOneofs(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.add(string);
        this.onChanged();
        return this;
    }

    public Type$Builder addAllOneofs(Iterable iterable) {
        this.ensureOneofsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.oneofs_);
        this.onChanged();
        return this;
    }

    public Type$Builder clearOneofs() {
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -5;
        this.onChanged();
        return this;
    }

    public Type$Builder addOneofsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.add(byteString);
        this.onChanged();
        return this;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 8) == 8) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 8;
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

    public Type$Builder setOptions(int n2, Option option) {
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

    public Type$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public Type$Builder addOptions(Option option) {
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

    public Type$Builder addOptions(int n2, Option option) {
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

    public Type$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public Type$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public Type$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Type$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -9;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public Type$Builder removeOptions(int n2) {
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
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 8) == 8, this.getParentForChildren(), this.isClean());
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

    public Type$Builder setSourceContext(SourceContext sourceContext) {
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

    public Type$Builder setSourceContext(SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
            return this;
        }
        this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        return this;
    }

    public Type$Builder mergeSourceContext(SourceContext sourceContext) {
        if (this.sourceContextBuilder_ != null) {
            this.sourceContextBuilder_.mergeFrom(sourceContext);
            return this;
        }
        this.sourceContext_ = this.sourceContext_ != null ? SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext).buildPartial() : sourceContext;
        this.onChanged();
        return this;
    }

    public Type$Builder clearSourceContext() {
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
    public final Type$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Type$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Type$Builder(Type$1 type$1) {
        this();
    }

    /* synthetic */ Type$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Type$1 type$1) {
        this(generatedMessage$BuilderParent);
    }
}

