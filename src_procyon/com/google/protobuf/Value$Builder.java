package com.google.protobuf;

import java.io.*;

public final class Value$Builder extends GeneratedMessage$Builder implements ValueOrBuilder
{
    private int kindCase_;
    private Object kind_;
    private SingleFieldBuilder structValueBuilder_;
    private SingleFieldBuilder listValueBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
    }
    
    private Value$Builder() {
        this.kindCase_ = 0;
        this.maybeForceBuilderInitialization();
    }
    
    private Value$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.kindCase_ = 0;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Value$Builder clear() {
        super.clear();
        this.kindCase_ = 0;
        this.kind_ = null;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }
    
    public Value getDefaultInstanceForType() {
        return Value.getDefaultInstance();
    }
    
    public Value build() {
        final Value buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Value buildPartial() {
        final Value value = new Value(this, null);
        if (this.kindCase_ == 1) {
            value.kind_ = this.kind_;
        }
        if (this.kindCase_ == 2) {
            value.kind_ = this.kind_;
        }
        if (this.kindCase_ == 3) {
            value.kind_ = this.kind_;
        }
        if (this.kindCase_ == 4) {
            value.kind_ = this.kind_;
        }
        if (this.kindCase_ == 5) {
            if (this.structValueBuilder_ == null) {
                value.kind_ = this.kind_;
            }
            else {
                value.kind_ = this.structValueBuilder_.build();
            }
        }
        if (this.kindCase_ == 6) {
            if (this.listValueBuilder_ == null) {
                value.kind_ = this.kind_;
            }
            else {
                value.kind_ = this.listValueBuilder_.build();
            }
        }
        value.kindCase_ = this.kindCase_;
        this.onBuilt();
        return value;
    }
    
    public Value$Builder mergeFrom(final Message message) {
        if (message instanceof Value) {
            return this.mergeFrom((Value)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Value$Builder mergeFrom(final Value value) {
        if (value == Value.getDefaultInstance()) {
            return this;
        }
        switch (Value$2.$SwitchMap$com$google$protobuf$Value$KindCase[value.getKindCase().ordinal()]) {
            case 1: {
                this.setNullValueValue(value.getNullValueValue());
                break;
            }
            case 2: {
                this.setNumberValue(value.getNumberValue());
                break;
            }
            case 3: {
                this.kindCase_ = 3;
                this.kind_ = value.kind_;
                this.onChanged();
                break;
            }
            case 4: {
                this.setBoolValue(value.getBoolValue());
                break;
            }
            case 5: {
                this.mergeStructValue(value.getStructValue());
                break;
            }
            case 6: {
                this.mergeListValue(value.getListValue());
                break;
            }
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Value$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Value value = null;
        try {
            value = (Value)Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            value = (Value)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (value != null) {
                this.mergeFrom(value);
            }
        }
        return this;
    }
    
    public Value$KindCase getKindCase() {
        return Value$KindCase.valueOf(this.kindCase_);
    }
    
    public Value$Builder clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }
    
    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return (int)this.kind_;
        }
        return 0;
    }
    
    public Value$Builder setNullValueValue(final int n) {
        this.kindCase_ = 1;
        this.kind_ = n;
        this.onChanged();
        return this;
    }
    
    public NullValue getNullValue() {
        if (this.kindCase_ == 1) {
            final NullValue value = NullValue.valueOf((int)this.kind_);
            return (value == null) ? NullValue.UNRECOGNIZED : value;
        }
        return NullValue.NULL_VALUE;
    }
    
    public Value$Builder setNullValue(final NullValue nullValue) {
        if (nullValue == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 1;
        this.kind_ = nullValue.getNumber();
        this.onChanged();
        return this;
    }
    
    public Value$Builder clearNullValue() {
        if (this.kindCase_ == 1) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }
    
    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return (double)this.kind_;
        }
        return 0.0;
    }
    
    public Value$Builder setNumberValue(final double n) {
        this.kindCase_ = 2;
        this.kind_ = n;
        this.onChanged();
        return this;
    }
    
    public Value$Builder clearNumberValue() {
        if (this.kindCase_ == 2) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }
    
    public String getStringValue() {
        Object kind_ = "";
        if (this.kindCase_ == 3) {
            kind_ = this.kind_;
        }
        if (!(kind_ instanceof String)) {
            final ByteString byteString = (ByteString)kind_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (this.kindCase_ == 3 && byteString.isValidUtf8()) {
                this.kind_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)kind_;
    }
    
    public ByteString getStringValueBytes() {
        Object kind_ = "";
        if (this.kindCase_ == 3) {
            kind_ = this.kind_;
        }
        if (kind_ instanceof String) {
            final ByteString copyFromUtf8 = ByteString.copyFromUtf8((String)kind_);
            if (this.kindCase_ == 3) {
                this.kind_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString)kind_;
    }
    
    public Value$Builder setStringValue(final String kind_) {
        if (kind_ == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 3;
        this.kind_ = kind_;
        this.onChanged();
        return this;
    }
    
    public Value$Builder clearStringValue() {
        if (this.kindCase_ == 3) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }
    
    public Value$Builder setStringValueBytes(final ByteString kind_) {
        if (kind_ == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 3;
        this.kind_ = kind_;
        this.onChanged();
        return this;
    }
    
    public boolean getBoolValue() {
        return this.kindCase_ == 4 && (boolean)this.kind_;
    }
    
    public Value$Builder setBoolValue(final boolean b) {
        this.kindCase_ = 4;
        this.kind_ = b;
        this.onChanged();
        return this;
    }
    
    public Value$Builder clearBoolValue() {
        if (this.kindCase_ == 4) {
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
        }
        return this;
    }
    
    public Struct getStructValue() {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ == 5) {
                return (Struct)this.kind_;
            }
            return Struct.getDefaultInstance();
        }
        else {
            if (this.kindCase_ == 5) {
                return (Struct)this.structValueBuilder_.getMessage();
            }
            return Struct.getDefaultInstance();
        }
    }
    
    public Value$Builder setStructValue(final Struct struct) {
        if (this.structValueBuilder_ == null) {
            if (struct == null) {
                throw new NullPointerException();
            }
            this.kind_ = struct;
            this.onChanged();
        }
        else {
            this.structValueBuilder_.setMessage(struct);
        }
        this.kindCase_ = 5;
        return this;
    }
    
    public Value$Builder setStructValue(final Struct$Builder struct$Builder) {
        if (this.structValueBuilder_ == null) {
            this.kind_ = struct$Builder.build();
            this.onChanged();
        }
        else {
            this.structValueBuilder_.setMessage(struct$Builder.build());
        }
        this.kindCase_ = 5;
        return this;
    }
    
    public Value$Builder mergeStructValue(final Struct struct) {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance()) {
                this.kind_ = Struct.newBuilder((Struct)this.kind_).mergeFrom(struct).buildPartial();
            }
            else {
                this.kind_ = struct;
            }
            this.onChanged();
        }
        else {
            if (this.kindCase_ == 5) {
                this.structValueBuilder_.mergeFrom(struct);
            }
            this.structValueBuilder_.setMessage(struct);
        }
        this.kindCase_ = 5;
        return this;
    }
    
    public Value$Builder clearStructValue() {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ == 5) {
                this.kindCase_ = 0;
                this.kind_ = null;
                this.onChanged();
            }
        }
        else {
            if (this.kindCase_ == 5) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            this.structValueBuilder_.clear();
        }
        return this;
    }
    
    public Struct$Builder getStructValueBuilder() {
        return (Struct$Builder)this.getStructValueFieldBuilder().getBuilder();
    }
    
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5 && this.structValueBuilder_ != null) {
            return (StructOrBuilder)this.structValueBuilder_.getMessageOrBuilder();
        }
        if (this.kindCase_ == 5) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
    }
    
    private SingleFieldBuilder getStructValueFieldBuilder() {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ != 5) {
                this.kind_ = Struct.getDefaultInstance();
            }
            this.structValueBuilder_ = new SingleFieldBuilder((GeneratedMessage)this.kind_, this.getParentForChildren(), this.isClean());
            this.kind_ = null;
        }
        this.kindCase_ = 5;
        this.onChanged();
        return this.structValueBuilder_;
    }
    
    public ListValue getListValue() {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ == 6) {
                return (ListValue)this.kind_;
            }
            return ListValue.getDefaultInstance();
        }
        else {
            if (this.kindCase_ == 6) {
                return (ListValue)this.listValueBuilder_.getMessage();
            }
            return ListValue.getDefaultInstance();
        }
    }
    
    public Value$Builder setListValue(final ListValue listValue) {
        if (this.listValueBuilder_ == null) {
            if (listValue == null) {
                throw new NullPointerException();
            }
            this.kind_ = listValue;
            this.onChanged();
        }
        else {
            this.listValueBuilder_.setMessage(listValue);
        }
        this.kindCase_ = 6;
        return this;
    }
    
    public Value$Builder setListValue(final ListValue$Builder listValue$Builder) {
        if (this.listValueBuilder_ == null) {
            this.kind_ = listValue$Builder.build();
            this.onChanged();
        }
        else {
            this.listValueBuilder_.setMessage(listValue$Builder.build());
        }
        this.kindCase_ = 6;
        return this;
    }
    
    public Value$Builder mergeListValue(final ListValue listValue) {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance()) {
                this.kind_ = ListValue.newBuilder((ListValue)this.kind_).mergeFrom(listValue).buildPartial();
            }
            else {
                this.kind_ = listValue;
            }
            this.onChanged();
        }
        else {
            if (this.kindCase_ == 6) {
                this.listValueBuilder_.mergeFrom(listValue);
            }
            this.listValueBuilder_.setMessage(listValue);
        }
        this.kindCase_ = 6;
        return this;
    }
    
    public Value$Builder clearListValue() {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ == 6) {
                this.kindCase_ = 0;
                this.kind_ = null;
                this.onChanged();
            }
        }
        else {
            if (this.kindCase_ == 6) {
                this.kindCase_ = 0;
                this.kind_ = null;
            }
            this.listValueBuilder_.clear();
        }
        return this;
    }
    
    public ListValue$Builder getListValueBuilder() {
        return (ListValue$Builder)this.getListValueFieldBuilder().getBuilder();
    }
    
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6 && this.listValueBuilder_ != null) {
            return (ListValueOrBuilder)this.listValueBuilder_.getMessageOrBuilder();
        }
        if (this.kindCase_ == 6) {
            return (ListValue)this.kind_;
        }
        return ListValue.getDefaultInstance();
    }
    
    private SingleFieldBuilder getListValueFieldBuilder() {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ != 6) {
                this.kind_ = ListValue.getDefaultInstance();
            }
            this.listValueBuilder_ = new SingleFieldBuilder((GeneratedMessage)this.kind_, this.getParentForChildren(), this.isClean());
            this.kind_ = null;
        }
        this.kindCase_ = 6;
        this.onChanged();
        return this.listValueBuilder_;
    }
    
    public final Value$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Value$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
