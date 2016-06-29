package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class ListValue$Builder extends GeneratedMessage$Builder implements ListValueOrBuilder
{
    private int bitField0_;
    private List values_;
    private RepeatedFieldBuilder valuesBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, ListValue$Builder.class);
    }
    
    private ListValue$Builder() {
        this.values_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private ListValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.values_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getValuesFieldBuilder();
        }
    }
    
    public ListValue$Builder clear() {
        super.clear();
        if (this.valuesBuilder_ == null) {
            this.values_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        else {
            this.valuesBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }
    
    public ListValue getDefaultInstanceForType() {
        return ListValue.getDefaultInstance();
    }
    
    public ListValue build() {
        final ListValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public ListValue buildPartial() {
        final ListValue listValue = new ListValue(this, null);
        final int bitField0_ = this.bitField0_;
        if (this.valuesBuilder_ == null) {
            if ((this.bitField0_ & 0x1) == 0x1) {
                this.values_ = Collections.unmodifiableList((List<?>)this.values_);
                this.bitField0_ &= 0xFFFFFFFE;
            }
            listValue.values_ = this.values_;
        }
        else {
            listValue.values_ = this.valuesBuilder_.build();
        }
        this.onBuilt();
        return listValue;
    }
    
    public ListValue$Builder mergeFrom(final Message message) {
        if (message instanceof ListValue) {
            return this.mergeFrom((ListValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public ListValue$Builder mergeFrom(final ListValue listValue) {
        if (listValue == ListValue.getDefaultInstance()) {
            return this;
        }
        if (this.valuesBuilder_ == null) {
            if (!listValue.values_.isEmpty()) {
                if (this.values_.isEmpty()) {
                    this.values_ = listValue.values_;
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                else {
                    this.ensureValuesIsMutable();
                    this.values_.addAll(listValue.values_);
                }
                this.onChanged();
            }
        }
        else if (!listValue.values_.isEmpty()) {
            if (this.valuesBuilder_.isEmpty()) {
                this.valuesBuilder_.dispose();
                this.valuesBuilder_ = null;
                this.values_ = listValue.values_;
                this.bitField0_ &= 0xFFFFFFFE;
                this.valuesBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getValuesFieldBuilder() : null);
            }
            else {
                this.valuesBuilder_.addAllMessages(listValue.values_);
            }
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public ListValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        ListValue listValue = null;
        try {
            listValue = (ListValue)ListValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            listValue = (ListValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (listValue != null) {
                this.mergeFrom(listValue);
            }
        }
        return this;
    }
    
    private void ensureValuesIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.values_ = new ArrayList(this.values_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public List getValuesList() {
        if (this.valuesBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.values_);
        }
        return this.valuesBuilder_.getMessageList();
    }
    
    public int getValuesCount() {
        if (this.valuesBuilder_ == null) {
            return this.values_.size();
        }
        return this.valuesBuilder_.getCount();
    }
    
    public Value getValues(final int n) {
        if (this.valuesBuilder_ == null) {
            return this.values_.get(n);
        }
        return (Value)this.valuesBuilder_.getMessage(n);
    }
    
    public ListValue$Builder setValues(final int n, final Value value) {
        if (this.valuesBuilder_ == null) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureValuesIsMutable();
            this.values_.set(n, value);
            this.onChanged();
        }
        else {
            this.valuesBuilder_.setMessage(n, value);
        }
        return this;
    }
    
    public ListValue$Builder setValues(final int n, final Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.set(n, value$Builder.build());
            this.onChanged();
        }
        else {
            this.valuesBuilder_.setMessage(n, value$Builder.build());
        }
        return this;
    }
    
    public ListValue$Builder addValues(final Value value) {
        if (this.valuesBuilder_ == null) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureValuesIsMutable();
            this.values_.add(value);
            this.onChanged();
        }
        else {
            this.valuesBuilder_.addMessage(value);
        }
        return this;
    }
    
    public ListValue$Builder addValues(final int n, final Value value) {
        if (this.valuesBuilder_ == null) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureValuesIsMutable();
            this.values_.add(n, value);
            this.onChanged();
        }
        else {
            this.valuesBuilder_.addMessage(n, value);
        }
        return this;
    }
    
    public ListValue$Builder addValues(final Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.add(value$Builder.build());
            this.onChanged();
        }
        else {
            this.valuesBuilder_.addMessage(value$Builder.build());
        }
        return this;
    }
    
    public ListValue$Builder addValues(final int n, final Value$Builder value$Builder) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.add(n, value$Builder.build());
            this.onChanged();
        }
        else {
            this.valuesBuilder_.addMessage(n, value$Builder.build());
        }
        return this;
    }
    
    public ListValue$Builder addAllValues(final Iterable iterable) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.values_);
            this.onChanged();
        }
        else {
            this.valuesBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public ListValue$Builder clearValues() {
        if (this.valuesBuilder_ == null) {
            this.values_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
        }
        else {
            this.valuesBuilder_.clear();
        }
        return this;
    }
    
    public ListValue$Builder removeValues(final int n) {
        if (this.valuesBuilder_ == null) {
            this.ensureValuesIsMutable();
            this.values_.remove(n);
            this.onChanged();
        }
        else {
            this.valuesBuilder_.remove(n);
        }
        return this;
    }
    
    public Value$Builder getValuesBuilder(final int n) {
        return (Value$Builder)this.getValuesFieldBuilder().getBuilder(n);
    }
    
    public ValueOrBuilder getValuesOrBuilder(final int n) {
        if (this.valuesBuilder_ == null) {
            return this.values_.get(n);
        }
        return (ValueOrBuilder)this.valuesBuilder_.getMessageOrBuilder(n);
    }
    
    public List getValuesOrBuilderList() {
        if (this.valuesBuilder_ != null) {
            return this.valuesBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.values_);
    }
    
    public Value$Builder addValuesBuilder() {
        return (Value$Builder)this.getValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
    }
    
    public Value$Builder addValuesBuilder(final int n) {
        return (Value$Builder)this.getValuesFieldBuilder().addBuilder(n, Value.getDefaultInstance());
    }
    
    public List getValuesBuilderList() {
        return this.getValuesFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getValuesFieldBuilder() {
        if (this.valuesBuilder_ == null) {
            this.valuesBuilder_ = new RepeatedFieldBuilder(this.values_, (this.bitField0_ & 0x1) == 0x1, this.getParentForChildren(), this.isClean());
            this.values_ = null;
        }
        return this.valuesBuilder_;
    }
    
    public final ListValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final ListValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
