package com.google.protobuf;

import java.io.*;

public final class Value extends GeneratedMessage implements ValueOrBuilder
{
    private int kindCase_;
    private Object kind_;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Value DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Value(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Value(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!codedInputStream.skipField(tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 8: {
                        final int enum1 = codedInputStream.readEnum();
                        this.kindCase_ = 1;
                        this.kind_ = enum1;
                        continue;
                    }
                    case 17: {
                        this.kindCase_ = 2;
                        this.kind_ = codedInputStream.readDouble();
                        continue;
                    }
                    case 26: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.kindCase_ = 3;
                        this.kind_ = bytes;
                        continue;
                    }
                    case 32: {
                        this.kindCase_ = 4;
                        this.kind_ = codedInputStream.readBool();
                        continue;
                    }
                    case 42: {
                        Struct$Builder builder = null;
                        if (this.kindCase_ == 5) {
                            builder = ((Struct)this.kind_).toBuilder();
                        }
                        this.kind_ = codedInputStream.readMessage(Struct.PARSER, extensionRegistryLite);
                        if (builder != null) {
                            builder.mergeFrom((Struct)this.kind_);
                            this.kind_ = builder.buildPartial();
                        }
                        this.kindCase_ = 5;
                        continue;
                    }
                    case 50: {
                        ListValue$Builder builder2 = null;
                        if (this.kindCase_ == 6) {
                            builder2 = ((ListValue)this.kind_).toBuilder();
                        }
                        this.kind_ = codedInputStream.readMessage(ListValue.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom((ListValue)this.kind_);
                            this.kind_ = builder2.buildPartial();
                        }
                        this.kindCase_ = 6;
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Value$Builder.class);
    }
    
    public Value$KindCase getKindCase() {
        return Value$KindCase.valueOf(this.kindCase_);
    }
    
    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return (int)this.kind_;
        }
        return 0;
    }
    
    public NullValue getNullValue() {
        if (this.kindCase_ == 1) {
            final NullValue value = NullValue.valueOf((int)this.kind_);
            return (value == null) ? NullValue.UNRECOGNIZED : value;
        }
        return NullValue.NULL_VALUE;
    }
    
    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return (double)this.kind_;
        }
        return 0.0;
    }
    
    public String getStringValue() {
        Object kind_ = "";
        if (this.kindCase_ == 3) {
            kind_ = this.kind_;
        }
        if (kind_ instanceof String) {
            return (String)kind_;
        }
        final ByteString byteString = (ByteString)kind_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8() && this.kindCase_ == 3) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
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
    
    public boolean getBoolValue() {
        return this.kindCase_ == 4 && (boolean)this.kind_;
    }
    
    public Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
    }
    
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5) {
            return (Struct)this.kind_;
        }
        return Struct.getDefaultInstance();
    }
    
    public ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (ListValue)this.kind_;
        }
        return ListValue.getDefaultInstance();
    }
    
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6) {
            return (ListValue)this.kind_;
        }
        return ListValue.getDefaultInstance();
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if (this.kindCase_ == 1) {
            codedOutputStream.writeEnum(1, (int)this.kind_);
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.writeDouble(2, (double)this.kind_);
        }
        if (this.kindCase_ == 3) {
            codedOutputStream.writeBytes(3, this.getStringValueBytes());
        }
        if (this.kindCase_ == 4) {
            codedOutputStream.writeBool(4, (boolean)this.kind_);
        }
        if (this.kindCase_ == 5) {
            codedOutputStream.writeMessage(5, (MessageLite)this.kind_);
        }
        if (this.kindCase_ == 6) {
            codedOutputStream.writeMessage(6, (MessageLite)this.kind_);
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.kindCase_ == 1) {
            memoizedSerializedSize2 += CodedOutputStream.computeEnumSize(1, (int)this.kind_);
        }
        if (this.kindCase_ == 2) {
            memoizedSerializedSize2 += CodedOutputStream.computeDoubleSize(2, (double)this.kind_);
        }
        if (this.kindCase_ == 3) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(3, this.getStringValueBytes());
        }
        if (this.kindCase_ == 4) {
            memoizedSerializedSize2 += CodedOutputStream.computeBoolSize(4, (boolean)this.kind_);
        }
        if (this.kindCase_ == 5) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(5, (MessageLite)this.kind_);
        }
        if (this.kindCase_ == 6) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(6, (MessageLite)this.kind_);
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value)) {
            return super.equals(o);
        }
        final Value value = (Value)o;
        return true && this.getNullValueValue() == value.getNullValueValue() && Double.doubleToLongBits(this.getNumberValue()) == Double.doubleToLongBits(value.getNumberValue()) && this.getStringValue().equals(value.getStringValue()) && this.getBoolValue() == value.getBoolValue() && this.getStructValue().equals(value.getStructValue()) && this.getListValue().equals(value.getListValue());
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        return this.memoizedHashCode = 29 * (53 * (37 * (53 * (37 * (53 * (37 * (53 * (37 * (53 * (37 * (53 * (37 * (19 * 41 + this.getDescriptorForType().hashCode()) + 1) + this.getNullValueValue()) + 2) + Internal.hashLong(Double.doubleToLongBits(this.getNumberValue()))) + 3) + this.getStringValue().hashCode()) + 4) + Internal.hashBoolean(this.getBoolValue())) + 5) + this.getStructValue().hashCode()) + 6) + this.getListValue().hashCode()) + this.unknownFields.hashCode();
    }
    
    public static Value parseFrom(final ByteString byteString) {
        return (Value)Value.PARSER.parseFrom(byteString);
    }
    
    public static Value parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Value)Value.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Value parseFrom(final byte[] array) {
        return (Value)Value.PARSER.parseFrom(array);
    }
    
    public static Value parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Value)Value.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Value parseFrom(final InputStream inputStream) {
        return (Value)Value.PARSER.parseFrom(inputStream);
    }
    
    public static Value parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Value)Value.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Value parseDelimitedFrom(final InputStream inputStream) {
        return (Value)Value.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Value parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Value)Value.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Value parseFrom(final CodedInputStream codedInputStream) {
        return (Value)Value.PARSER.parseFrom(codedInputStream);
    }
    
    public static Value parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Value)Value.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Value$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Value$Builder newBuilder() {
        return Value.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Value$Builder newBuilder(final Value value) {
        return Value.DEFAULT_INSTANCE.toBuilder().mergeFrom(value);
    }
    
    public Value$Builder toBuilder() {
        return (this == Value.DEFAULT_INSTANCE) ? new Value$Builder((Value$1)null) : new Value$Builder((Value$1)null).mergeFrom(this);
    }
    
    protected Value$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Value$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Value getDefaultInstance() {
        return Value.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Value.PARSER;
    }
    
    public Value getDefaultInstanceForType() {
        return Value.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Value();
        PARSER = new Value$1();
    }
}
