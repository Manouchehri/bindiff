/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$1;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.ValueOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class ListValue$Builder
extends GeneratedMessage$Builder
implements ListValueOrBuilder {
    private int bitField0_;
    private List values_ = Collections.emptyList();
    private RepeatedFieldBuilder valuesBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
    }

    private ListValue$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private ListValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getValuesFieldBuilder();
    }

    @Override
    public ListValue$Builder clear() {
        super.clear();
        if (this.valuesBuilder_ == null) {
            this.values_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }
        this.valuesBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    @Override
    public ListValue getDefaultInstanceForType() {
        return ListValue.getDefaultInstance();
    }

    @Override
    public ListValue build() {
        ListValue listValue = this.buildPartial();
        if (listValue.isInitialized()) return listValue;
        throw ListValue$Builder.newUninitializedMessageException(listValue);
    }

    @Override
    public ListValue buildPartial() {
        ListValue listValue = new ListValue(this, null);
        int n2 = this.bitField0_;
        if (this.valuesBuilder_ == null) {
            if ((this.bitField0_ & 1) == 1) {
                this.values_ = Collections.unmodifiableList(this.values_);
                this.bitField0_ &= -2;
            }
            ListValue.access$302(listValue, this.values_);
        } else {
            ListValue.access$302(listValue, this.valuesBuilder_.build());
        }
        this.onBuilt();
        return listValue;
    }

    @Override
    public ListValue$Builder mergeFrom(Message message) {
        if (message instanceof ListValue) {
            return this.mergeFrom((ListValue)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public ListValue$Builder mergeFrom(ListValue listValue) {
        if (listValue == ListValue.getDefaultInstance()) {
            return this;
        }
        if (this.valuesBuilder_ == null) {
            if (!ListValue.access$300(listValue).isEmpty()) {
                if (this.values_.isEmpty()) {
                    this.values_ = ListValue.access$300(listValue);
                    this.bitField0_ &= -2;
                } else {
                    this.ensureValuesIsMutable();
                    this.values_.addAll(ListValue.access$300(listValue));
                }
                this.onChanged();
            }
        } else if (!ListValue.access$300(listValue).isEmpty()) {
            if (this.valuesBuilder_.isEmpty()) {
                this.valuesBuilder_.dispose();
                this.valuesBuilder_ = null;
                this.values_ = ListValue.access$300(listValue);
                this.bitField0_ &= -2;
                this.valuesBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getValuesFieldBuilder() : null;
            } else {
                this.valuesBuilder_.addAllMessages(ListValue.access$300(listValue));
            }
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public ListValue$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ListValue listValue = null;
        try {
            try {
                listValue = (ListValue)ListValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                listValue = (ListValue)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (listValue == null) return this;
            this.mergeFrom(listValue);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (listValue == null) throw var5_7;
            this.mergeFrom(listValue);
            throw var5_7;
        }
    }

    private void ensureValuesIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.values_ = new ArrayList(this.values_);
        this.bitField0_ |= 1;
    }

    @Override
    public List getValuesList() {
        if (this.valuesBuilder_ != null) return this.valuesBuilder_.getMessageList();
        return Collections.unmodifiableList(this.values_);
    }

    @Override
    public int getValuesCount() {
        if (this.valuesBuilder_ != null) return this.valuesBuilder_.getCount();
        return this.values_.size();
    }

    @Override
    public Value getValues(int n2) {
        if (this.valuesBuilder_ != null) return (Value)this.valuesBuilder_.getMessage(n2);
        return (Value)this.values_.get(n2);
    }

    public ListValue$Builder setValues(int n2, Value value) {
        if (this.valuesBuilder_ != null) {
            this.valuesBuilder_.setMessage(n2, value);
            return this;
        }
        if (value == null) {
            throw new NullPointerException();
        }
        this.ensureValuesIsMutable();
        this.values_.set(n2, value);
        this.onChanged();
        return this;
    }

    public ListValue$Builder setValues(int n2, Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.set(n2, value$Builder.build());
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.setMessage(n2, value$Builder.build());
        return this;
    }

    public ListValue$Builder addValues(Value value) {
        if (this.valuesBuilder_ != null) {
            this.valuesBuilder_.addMessage(value);
            return this;
        }
        if (value == null) {
            throw new NullPointerException();
        }
        this.ensureValuesIsMutable();
        this.values_.add(value);
        this.onChanged();
        return this;
    }

    public ListValue$Builder addValues(int n2, Value value) {
        if (this.valuesBuilder_ != null) {
            this.valuesBuilder_.addMessage(n2, value);
            return this;
        }
        if (value == null) {
            throw new NullPointerException();
        }
        this.ensureValuesIsMutable();
        this.values_.add(n2, value);
        this.onChanged();
        return this;
    }

    public ListValue$Builder addValues(Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.add(value$Builder.build());
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.addMessage(value$Builder.build());
        return this;
    }

    public ListValue$Builder addValues(int n2, Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.add(n2, value$Builder.build());
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.addMessage(n2, value$Builder.build());
        return this;
    }

    public ListValue$Builder addAllValues(Iterable iterable) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.values_);
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.addAllMessages(iterable);
        return this;
    }

    public ListValue$Builder clearValues() {
        if (this.valuesBuilder_ == null) {
            this.values_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.clear();
        return this;
    }

    public ListValue$Builder removeValues(int n2) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.remove(n2);
            this.onChanged();
            return this;
        }
        this.valuesBuilder_.remove(n2);
        return this;
    }

    public Value$Builder getValuesBuilder(int n2) {
        return (Value$Builder)this.getValuesFieldBuilder().getBuilder(n2);
    }

    @Override
    public ValueOrBuilder getValuesOrBuilder(int n2) {
        if (this.valuesBuilder_ != null) return (ValueOrBuilder)this.valuesBuilder_.getMessageOrBuilder(n2);
        return (ValueOrBuilder)this.values_.get(n2);
    }

    @Override
    public List getValuesOrBuilderList() {
        if (this.valuesBuilder_ == null) return Collections.unmodifiableList(this.values_);
        return this.valuesBuilder_.getMessageOrBuilderList();
    }

    public Value$Builder addValuesBuilder() {
        return (Value$Builder)this.getValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
    }

    public Value$Builder addValuesBuilder(int n2) {
        return (Value$Builder)this.getValuesFieldBuilder().addBuilder(n2, Value.getDefaultInstance());
    }

    public List getValuesBuilderList() {
        return this.getValuesFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getValuesFieldBuilder() {
        if (this.valuesBuilder_ != null) return this.valuesBuilder_;
        this.valuesBuilder_ = new RepeatedFieldBuilder(this.values_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
        this.values_ = null;
        return this.valuesBuilder_;
    }

    @Override
    public final ListValue$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final ListValue$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ ListValue$Builder(ListValue$1 listValue$1) {
        this();
    }

    /* synthetic */ ListValue$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, ListValue$1 listValue$1) {
        this(generatedMessage$BuilderParent);
    }
}

