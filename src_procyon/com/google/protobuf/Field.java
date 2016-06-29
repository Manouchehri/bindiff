package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Field extends GeneratedMessage implements FieldOrBuilder
{
    private int bitField0_;
    public static final int KIND_FIELD_NUMBER = 1;
    private int kind_;
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private int cardinality_;
    public static final int NUMBER_FIELD_NUMBER = 3;
    private int number_;
    public static final int NAME_FIELD_NUMBER = 4;
    private volatile Object name_;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private volatile Object typeUrl_;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    private int oneofIndex_;
    public static final int PACKED_FIELD_NUMBER = 8;
    private boolean packed_;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    private List options_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Field DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Field(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Field() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.options_ = Collections.emptyList();
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Field(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
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
                        this.kind_ = codedInputStream.readEnum();
                        continue;
                    }
                    case 16: {
                        this.cardinality_ = codedInputStream.readEnum();
                        continue;
                    }
                    case 24: {
                        this.number_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 34: {
                        this.name_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 50: {
                        this.typeUrl_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 56: {
                        this.oneofIndex_ = codedInputStream.readInt32();
                        continue;
                    }
                    case 64: {
                        this.packed_ = codedInputStream.readBool();
                        continue;
                    }
                    case 74: {
                        if ((n & 0x80) != 0x80) {
                            this.options_ = new ArrayList();
                            n |= 0x80;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
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
            if ((n & 0x80) == 0x80) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
            }
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
    }
    
    public int getKindValue() {
        return this.kind_;
    }
    
    public Field$Kind getKind() {
        final Field$Kind value = Field$Kind.valueOf(this.kind_);
        return (value == null) ? Field$Kind.UNRECOGNIZED : value;
    }
    
    public int getCardinalityValue() {
        return this.cardinality_;
    }
    
    public Field$Cardinality getCardinality() {
        final Field$Cardinality value = Field$Cardinality.valueOf(this.cardinality_);
        return (value == null) ? Field$Cardinality.UNRECOGNIZED : value;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (String)name_;
        }
        final ByteString byteString = (ByteString)name_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.name_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public String getTypeUrl() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (String)typeUrl_;
        }
        final ByteString byteString = (ByteString)typeUrl_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.typeUrl_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getTypeUrlBytes() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (ByteString)(this.typeUrl_ = ByteString.copyFromUtf8((String)typeUrl_));
        }
        return (ByteString)typeUrl_;
    }
    
    public int getOneofIndex() {
        return this.oneofIndex_;
    }
    
    public boolean getPacked() {
        return this.packed_;
    }
    
    public List getOptionsList() {
        return this.options_;
    }
    
    public List getOptionsOrBuilderList() {
        return this.options_;
    }
    
    public int getOptionsCount() {
        return this.options_.size();
    }
    
    public Option getOptions(final int n) {
        return this.options_.get(n);
    }
    
    public OptionOrBuilder getOptionsOrBuilder(final int n) {
        return this.options_.get(n);
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
        if (this.kind_ != Field$Kind.TYPE_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(1, this.kind_);
        }
        if (this.cardinality_ != Field$Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(2, this.cardinality_);
        }
        if (this.number_ != 0) {
            codedOutputStream.writeInt32(3, this.number_);
        }
        if (!this.getNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(4, this.getNameBytes());
        }
        if (!this.getTypeUrlBytes().isEmpty()) {
            codedOutputStream.writeBytes(6, this.getTypeUrlBytes());
        }
        if (this.oneofIndex_ != 0) {
            codedOutputStream.writeInt32(7, this.oneofIndex_);
        }
        if (this.packed_) {
            codedOutputStream.writeBool(8, this.packed_);
        }
        for (int i = 0; i < this.options_.size(); ++i) {
            codedOutputStream.writeMessage(9, (MessageLite)this.options_.get(i));
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        if (this.kind_ != Field$Kind.TYPE_UNKNOWN.getNumber()) {
            memoizedSerializedSize2 += CodedOutputStream.computeEnumSize(1, this.kind_);
        }
        if (this.cardinality_ != Field$Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            memoizedSerializedSize2 += CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        if (this.number_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt32Size(3, this.number_);
        }
        if (!this.getNameBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(4, this.getNameBytes());
        }
        if (!this.getTypeUrlBytes().isEmpty()) {
            memoizedSerializedSize2 += CodedOutputStream.computeBytesSize(6, this.getTypeUrlBytes());
        }
        if (this.oneofIndex_ != 0) {
            memoizedSerializedSize2 += CodedOutputStream.computeInt32Size(7, this.oneofIndex_);
        }
        if (this.packed_) {
            memoizedSerializedSize2 += CodedOutputStream.computeBoolSize(8, this.packed_);
        }
        for (int i = 0; i < this.options_.size(); ++i) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(9, (MessageLite)this.options_.get(i));
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public static Field parseFrom(final ByteString byteString) {
        return (Field)Field.PARSER.parseFrom(byteString);
    }
    
    public static Field parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Field)Field.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Field parseFrom(final byte[] array) {
        return (Field)Field.PARSER.parseFrom(array);
    }
    
    public static Field parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Field)Field.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Field parseFrom(final InputStream inputStream) {
        return (Field)Field.PARSER.parseFrom(inputStream);
    }
    
    public static Field parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Field)Field.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Field parseDelimitedFrom(final InputStream inputStream) {
        return (Field)Field.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Field parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Field)Field.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Field parseFrom(final CodedInputStream codedInputStream) {
        return (Field)Field.PARSER.parseFrom(codedInputStream);
    }
    
    public static Field parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Field)Field.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Field$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Field$Builder newBuilder() {
        return Field.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Field$Builder newBuilder(final Field field) {
        return Field.DEFAULT_INSTANCE.toBuilder().mergeFrom(field);
    }
    
    public Field$Builder toBuilder() {
        return (this == Field.DEFAULT_INSTANCE) ? new Field$Builder((Field$1)null) : new Field$Builder((Field$1)null).mergeFrom(this);
    }
    
    protected Field$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Field$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Field getDefaultInstance() {
        return Field.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Field.PARSER;
    }
    
    public Field getDefaultInstanceForType() {
        return Field.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Field();
        PARSER = new Field$1();
    }
}
