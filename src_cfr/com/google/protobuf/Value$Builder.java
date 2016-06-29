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
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;

public final class Value$Builder
extends GeneratedMessage$Builder
implements ValueOrBuilder {
    private int kindCase_ = 0;
    private Object kind_;
    private SingleFieldBuilder structValueBuilder_;
    private SingleFieldBuilder listValueBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
    }

    private Value$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public Value$Builder clear() {
        super.clear();
        this.kindCase_ = 0;
        this.kind_ = null;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    @Override
    public Value getDefaultInstanceForType() {
        return Value.getDefaultInstance();
    }

    @Override
    public Value build() {
        Value value = this.buildPartial();
        if (value.isInitialized()) return value;
        throw Value$Builder.newUninitializedMessageException(value);
    }

    @Override
    public Value buildPartial() {
        Value value = new Value(this, null);
        if (this.kindCase_ == 1) {
            Value.access$302(value, this.kind_);
        }
        if (this.kindCase_ == 2) {
            Value.access$302(value, this.kind_);
        }
        if (this.kindCase_ == 3) {
            Value.access$302(value, this.kind_);
        }
        if (this.kindCase_ == 4) {
            Value.access$302(value, this.kind_);
        }
        if (this.kindCase_ == 5) {
            if (this.structValueBuilder_ == null) {
                Value.access$302(value, this.kind_);
            } else {
                Value.access$302(value, this.structValueBuilder_.build());
            }
        }
        if (this.kindCase_ == 6) {
            if (this.listValueBuilder_ == null) {
                Value.access$302(value, this.kind_);
            } else {
                Value.access$302(value, this.listValueBuilder_.build());
            }
        }
        Value.access$402(value, this.kindCase_);
        this.onBuilt();
        return value;
    }

    @Override
    public Value$Builder mergeFrom(Message message) {
        if (message instanceof Value) {
            return this.mergeFrom((Value)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Value$Builder mergeFrom(Value value) {
        if (value == Value.getDefaultInstance()) {
            return this;
        }
        switch (value.getKindCase()) {
            case NULL_VALUE: {
                this.setNullValueValue(value.getNullValueValue());
                break;
            }
            case NUMBER_VALUE: {
                this.setNumberValue(value.getNumberValue());
                break;
            }
            case STRING_VALUE: {
                this.kindCase_ = 3;
                this.kind_ = Value.access$300(value);
                this.onChanged();
                break;
            }
            case BOOL_VALUE: {
                this.setBoolValue(value.getBoolValue());
                break;
            }
            case STRUCT_VALUE: {
                this.mergeStructValue(value.getStructValue());
                break;
            }
            case LIST_VALUE: {
                this.mergeListValue(value.getListValue());
                break;
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
    public Value$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Value value = null;
        try {
            try {
                value = (Value)Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                value = (Value)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (value == null) return this;
            this.mergeFrom(value);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (value == null) throw var5_7;
            this.mergeFrom(value);
            throw var5_7;
        }
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

    @Override
    public int getNullValueValue() {
        if (this.kindCase_ != 1) return 0;
        return (Integer)this.kind_;
    }

    public Value$Builder setNullValueValue(int n2) {
        this.kindCase_ = 1;
        this.kind_ = n2;
        this.onChanged();
        return this;
    }

    @Override
    public NullValue getNullValue() {
        NullValue nullValue;
        if (this.kindCase_ != 1) return NullValue.NULL_VALUE;
        NullValue nullValue2 = NullValue.valueOf((Integer)this.kind_);
        if (nullValue2 == null) {
            nullValue = NullValue.UNRECOGNIZED;
            return nullValue;
        }
        nullValue = nullValue2;
        return nullValue;
    }

    public Value$Builder setNullValue(NullValue nullValue) {
        if (nullValue == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 1;
        this.kind_ = nullValue.getNumber();
        this.onChanged();
        return this;
    }

    public Value$Builder clearNullValue() {
        if (this.kindCase_ != 1) return this;
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }

    @Override
    public double getNumberValue() {
        if (this.kindCase_ != 2) return 0.0;
        return (Double)this.kind_;
    }

    public Value$Builder setNumberValue(double d2) {
        this.kindCase_ = 2;
        this.kind_ = d2;
        this.onChanged();
        return this;
    }

    public Value$Builder clearNumberValue() {
        if (this.kindCase_ != 2) return this;
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }

    @Override
    public String getStringValue() {
        Object object = "";
        if (this.kindCase_ == 3) {
            object = this.kind_;
        }
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (this.kindCase_ != 3) return string;
        if (!byteString.isValidUtf8()) return string;
        this.kind_ = string;
        return string;
    }

    @Override
    public ByteString getStringValueBytes() {
        Object object = "";
        if (this.kindCase_ == 3) {
            object = this.kind_;
        }
        if (!(object instanceof String)) return (ByteString)object;
        ByteString byteString = ByteString.copyFromUtf8((String)object);
        if (this.kindCase_ != 3) return byteString;
        this.kind_ = byteString;
        return byteString;
    }

    public Value$Builder setStringValue(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 3;
        this.kind_ = string;
        this.onChanged();
        return this;
    }

    public Value$Builder clearStringValue() {
        if (this.kindCase_ != 3) return this;
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }

    public Value$Builder setStringValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.kindCase_ = 3;
        this.kind_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean getBoolValue() {
        if (this.kindCase_ != 4) return false;
        return (Boolean)this.kind_;
    }

    public Value$Builder setBoolValue(boolean bl2) {
        this.kindCase_ = 4;
        this.kind_ = bl2;
        this.onChanged();
        return this;
    }

    public Value$Builder clearBoolValue() {
        if (this.kindCase_ != 4) return this;
        this.kindCase_ = 0;
        this.kind_ = null;
        this.onChanged();
        return this;
    }

    @Override
    public Struct getStructValue() {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ != 5) return Struct.getDefaultInstance();
            return (Struct)this.kind_;
        }
        if (this.kindCase_ != 5) return Struct.getDefaultInstance();
        return (Struct)this.structValueBuilder_.getMessage();
    }

    public Value$Builder setStructValue(Struct struct) {
        if (this.structValueBuilder_ == null) {
            if (struct == null) {
                throw new NullPointerException();
            }
            this.kind_ = struct;
            this.onChanged();
        } else {
            this.structValueBuilder_.setMessage(struct);
        }
        this.kindCase_ = 5;
        return this;
    }

    public Value$Builder setStructValue(Struct$Builder struct$Builder) {
        if (this.structValueBuilder_ == null) {
            this.kind_ = struct$Builder.build();
            this.onChanged();
        } else {
            this.structValueBuilder_.setMessage(struct$Builder.build());
        }
        this.kindCase_ = 5;
        return this;
    }

    public Value$Builder mergeStructValue(Struct struct) {
        if (this.structValueBuilder_ == null) {
            this.kind_ = this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance() ? Struct.newBuilder((Struct)this.kind_).mergeFrom(struct).buildPartial() : struct;
            this.onChanged();
        } else {
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
            if (this.kindCase_ != 5) return this;
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
            return this;
        }
        if (this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
        this.structValueBuilder_.clear();
        return this;
    }

    public Struct$Builder getStructValueBuilder() {
        return (Struct$Builder)this.getStructValueFieldBuilder().getBuilder();
    }

    @Override
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5 && this.structValueBuilder_ != null) {
            return (StructOrBuilder)this.structValueBuilder_.getMessageOrBuilder();
        }
        if (this.kindCase_ != 5) return Struct.getDefaultInstance();
        return (Struct)this.kind_;
    }

    private SingleFieldBuilder getStructValueFieldBuilder() {
        if (this.structValueBuilder_ == null) {
            if (this.kindCase_ != 5) {
                this.kind_ = Struct.getDefaultInstance();
            }
            this.structValueBuilder_ = new SingleFieldBuilder((Struct)this.kind_, this.getParentForChildren(), this.isClean());
            this.kind_ = null;
        }
        this.kindCase_ = 5;
        this.onChanged();
        return this.structValueBuilder_;
    }

    @Override
    public ListValue getListValue() {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ != 6) return ListValue.getDefaultInstance();
            return (ListValue)this.kind_;
        }
        if (this.kindCase_ != 6) return ListValue.getDefaultInstance();
        return (ListValue)this.listValueBuilder_.getMessage();
    }

    public Value$Builder setListValue(ListValue listValue) {
        if (this.listValueBuilder_ == null) {
            if (listValue == null) {
                throw new NullPointerException();
            }
            this.kind_ = listValue;
            this.onChanged();
        } else {
            this.listValueBuilder_.setMessage(listValue);
        }
        this.kindCase_ = 6;
        return this;
    }

    public Value$Builder setListValue(ListValue$Builder listValue$Builder) {
        if (this.listValueBuilder_ == null) {
            this.kind_ = listValue$Builder.build();
            this.onChanged();
        } else {
            this.listValueBuilder_.setMessage(listValue$Builder.build());
        }
        this.kindCase_ = 6;
        return this;
    }

    public Value$Builder mergeListValue(ListValue listValue) {
        if (this.listValueBuilder_ == null) {
            this.kind_ = this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance() ? ListValue.newBuilder((ListValue)this.kind_).mergeFrom(listValue).buildPartial() : listValue;
            this.onChanged();
        } else {
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
            if (this.kindCase_ != 6) return this;
            this.kindCase_ = 0;
            this.kind_ = null;
            this.onChanged();
            return this;
        }
        if (this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
        this.listValueBuilder_.clear();
        return this;
    }

    public ListValue$Builder getListValueBuilder() {
        return (ListValue$Builder)this.getListValueFieldBuilder().getBuilder();
    }

    @Override
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6 && this.listValueBuilder_ != null) {
            return (ListValueOrBuilder)this.listValueBuilder_.getMessageOrBuilder();
        }
        if (this.kindCase_ != 6) return ListValue.getDefaultInstance();
        return (ListValue)this.kind_;
    }

    private SingleFieldBuilder getListValueFieldBuilder() {
        if (this.listValueBuilder_ == null) {
            if (this.kindCase_ != 6) {
                this.kind_ = ListValue.getDefaultInstance();
            }
            this.listValueBuilder_ = new SingleFieldBuilder((ListValue)this.kind_, this.getParentForChildren(), this.isClean());
            this.kind_ = null;
        }
        this.kindCase_ = 6;
        this.onChanged();
        return this.listValueBuilder_;
    }

    @Override
    public final Value$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Value$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Value$Builder(Value$1 value$1) {
        this();
    }

    /* synthetic */ Value$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Value$1 value$1) {
        this(generatedMessage$BuilderParent);
    }
}

