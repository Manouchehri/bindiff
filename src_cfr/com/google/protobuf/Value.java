/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValue$Builder;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value$1;
import com.google.protobuf.Value$Builder;
import com.google.protobuf.Value$KindCase;
import com.google.protobuf.ValueOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class Value
extends GeneratedMessage
implements ValueOrBuilder {
    private int kindCase_ = 0;
    private Object kind_;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Value DEFAULT_INSTANCE = new Value();
    public static final Parser PARSER = new Value$1();

    private Value(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Value() {
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block14 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block14;
                        }
                        default: {
                            if (codedInputStream.skipField(n2)) continue block14;
                            bl3 = true;
                            continue block14;
                        }
                        case 8: {
                            int n3 = codedInputStream.readEnum();
                            this.kindCase_ = 1;
                            this.kind_ = n3;
                            continue block14;
                        }
                        case 17: {
                            this.kindCase_ = 2;
                            this.kind_ = codedInputStream.readDouble();
                            continue block14;
                        }
                        case 26: {
                            ByteString byteString = codedInputStream.readBytes();
                            this.kindCase_ = 3;
                            this.kind_ = byteString;
                            continue block14;
                        }
                        case 32: {
                            this.kindCase_ = 4;
                            this.kind_ = codedInputStream.readBool();
                            continue block14;
                        }
                        case 42: {
                            Struct$Builder struct$Builder = null;
                            if (this.kindCase_ == 5) {
                                struct$Builder = ((Struct)this.kind_).toBuilder();
                            }
                            this.kind_ = codedInputStream.readMessage(Struct.PARSER, extensionRegistryLite);
                            if (struct$Builder != null) {
                                struct$Builder.mergeFrom((Struct)this.kind_);
                                this.kind_ = struct$Builder.buildPartial();
                            }
                            this.kindCase_ = 5;
                            continue block14;
                        }
                        case 50: 
                    }
                    ListValue$Builder listValue$Builder = null;
                    if (this.kindCase_ == 6) {
                        listValue$Builder = ((ListValue)this.kind_).toBuilder();
                    }
                    this.kind_ = codedInputStream.readMessage(ListValue.PARSER, extensionRegistryLite);
                    if (listValue$Builder != null) {
                        listValue$Builder.mergeFrom((ListValue)this.kind_);
                        this.kind_ = listValue$Builder.buildPartial();
                    }
                    this.kindCase_ = 6;
                }
                Object var8_12 = null;
            }
            catch (InvalidProtocolBufferException var4_5) {
                throw new RuntimeException(var4_5.setUnfinishedMessage(this));
            }
            catch (IOException var4_6) {
                throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_14) {
            Object var8_13 = null;
            this.makeExtensionsImmutable();
            throw var7_14;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
    }

    public Value$KindCase getKindCase() {
        return Value$KindCase.valueOf(this.kindCase_);
    }

    @Override
    public int getNullValueValue() {
        if (this.kindCase_ != 1) return 0;
        return (Integer)this.kind_;
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

    @Override
    public double getNumberValue() {
        if (this.kindCase_ != 2) return 0.0;
        return (Double)this.kind_;
    }

    @Override
    public String getStringValue() {
        Object object = "";
        if (this.kindCase_ == 3) {
            object = this.kind_;
        }
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        if (this.kindCase_ != 3) return string;
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

    @Override
    public boolean getBoolValue() {
        if (this.kindCase_ != 4) return false;
        return (Boolean)this.kind_;
    }

    @Override
    public Struct getStructValue() {
        if (this.kindCase_ != 5) return Struct.getDefaultInstance();
        return (Struct)this.kind_;
    }

    @Override
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ != 5) return Struct.getDefaultInstance();
        return (Struct)this.kind_;
    }

    @Override
    public ListValue getListValue() {
        if (this.kindCase_ != 6) return ListValue.getDefaultInstance();
        return (ListValue)this.kind_;
    }

    @Override
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ != 6) return ListValue.getDefaultInstance();
        return (ListValue)this.kind_;
    }

    @Override
    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.kindCase_ == 1) {
            codedOutputStream.writeEnum(1, (Integer)this.kind_);
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.writeDouble(2, (Double)this.kind_);
        }
        if (this.kindCase_ == 3) {
            codedOutputStream.writeBytes(3, this.getStringValueBytes());
        }
        if (this.kindCase_ == 4) {
            codedOutputStream.writeBool(4, (Boolean)this.kind_);
        }
        if (this.kindCase_ == 5) {
            codedOutputStream.writeMessage(5, (Struct)this.kind_);
        }
        if (this.kindCase_ != 6) return;
        codedOutputStream.writeMessage(6, (ListValue)this.kind_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.kindCase_ == 1) {
            n2 += CodedOutputStream.computeEnumSize(1, (Integer)this.kind_);
        }
        if (this.kindCase_ == 2) {
            n2 += CodedOutputStream.computeDoubleSize(2, (Double)this.kind_);
        }
        if (this.kindCase_ == 3) {
            n2 += CodedOutputStream.computeBytesSize(3, this.getStringValueBytes());
        }
        if (this.kindCase_ == 4) {
            n2 += CodedOutputStream.computeBoolSize(4, (Boolean)this.kind_);
        }
        if (this.kindCase_ == 5) {
            n2 += CodedOutputStream.computeMessageSize(5, (Struct)this.kind_);
        }
        if (this.kindCase_ == 6) {
            n2 += CodedOutputStream.computeMessageSize(6, (ListValue)this.kind_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Value)) {
            return super.equals(object);
        }
        Value value = (Value)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (this.getNullValueValue() != value.getNullValueValue()) return false;
        boolean bl3 = true;
        bl2 = bl3;
        if (!bl2) return false;
        if (Double.doubleToLongBits(this.getNumberValue()) != Double.doubleToLongBits(value.getNumberValue())) return false;
        boolean bl4 = true;
        bl2 = bl4;
        if (!bl2) return false;
        if (!this.getStringValue().equals(value.getStringValue())) return false;
        boolean bl5 = true;
        bl2 = bl5;
        if (!bl2) return false;
        if (this.getBoolValue() != value.getBoolValue()) return false;
        boolean bl6 = true;
        bl2 = bl6;
        if (!bl2) return false;
        if (!this.getStructValue().equals(value.getStructValue())) return false;
        boolean bl7 = true;
        bl2 = bl7;
        if (!bl2) return false;
        if (!this.getListValue().equals(value.getListValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        n2 = 37 * n2 + 1;
        n2 = 53 * n2 + this.getNullValueValue();
        n2 = 37 * n2 + 2;
        n2 = 53 * n2 + Internal.hashLong(Double.doubleToLongBits(this.getNumberValue()));
        n2 = 37 * n2 + 3;
        n2 = 53 * n2 + this.getStringValue().hashCode();
        n2 = 37 * n2 + 4;
        n2 = 53 * n2 + Internal.hashBoolean(this.getBoolValue());
        n2 = 37 * n2 + 5;
        n2 = 53 * n2 + this.getStructValue().hashCode();
        n2 = 37 * n2 + 6;
        n2 = 53 * n2 + this.getListValue().hashCode();
        this.memoizedHashCode = n2 = 29 * n2 + this.unknownFields.hashCode();
        return n2;
    }

    public static Value parseFrom(ByteString byteString) {
        return (Value)PARSER.parseFrom(byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] arrby) {
        return (Value)PARSER.parseFrom(arrby);
    }

    public static Value parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) {
        return (Value)PARSER.parseFrom(inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Value parseDelimitedFrom(InputStream inputStream) {
        return (Value)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) {
        return (Value)PARSER.parseFrom(codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Value$Builder newBuilderForType() {
        return Value.newBuilder();
    }

    public static Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Value$Builder newBuilder(Value value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(value);
    }

    @Override
    public Value$Builder toBuilder() {
        Value$Builder value$Builder;
        if (this == DEFAULT_INSTANCE) {
            value$Builder = new Value$Builder(null);
            return value$Builder;
        }
        value$Builder = new Value$Builder(null).mergeFrom(this);
        return value$Builder;
    }

    @Override
    protected Value$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Value$Builder(generatedMessage$BuilderParent, null);
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Value(GeneratedMessage$Builder generatedMessage$Builder, Value$1 value$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Value value, Object object) {
        value.kind_ = object;
        return value.kind_;
    }

    static /* synthetic */ int access$402(Value value, int n2) {
        value.kindCase_ = n2;
        return value.kindCase_;
    }

    static /* synthetic */ Object access$300(Value value) {
        return value.kind_;
    }

    /* synthetic */ Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Value$1 value$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

