/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Field$1;
import com.google.protobuf.Field$Builder;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Field
extends GeneratedMessage
implements FieldOrBuilder {
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
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Field DEFAULT_INSTANCE = new Field();
    public static final Parser PARSER = new Field$1();

    private Field(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Field() {
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.options_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Field(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block19 : {
                try {
                    boolean bl2 = false;
                    block16 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            int n4;
                            case 0: {
                                bl2 = true;
                                continue block16;
                            }
                            default: {
                                if (codedInputStream.skipField(n3)) continue block16;
                                bl2 = true;
                                continue block16;
                            }
                            case 8: {
                                this.kind_ = n4 = codedInputStream.readEnum();
                                continue block16;
                            }
                            case 16: {
                                this.cardinality_ = n4 = codedInputStream.readEnum();
                                continue block16;
                            }
                            case 24: {
                                this.number_ = codedInputStream.readInt32();
                                continue block16;
                            }
                            case 34: {
                                ByteString byteString;
                                this.name_ = byteString = codedInputStream.readBytes();
                                continue block16;
                            }
                            case 50: {
                                ByteString byteString;
                                this.typeUrl_ = byteString = codedInputStream.readBytes();
                                continue block16;
                            }
                            case 56: {
                                this.oneofIndex_ = codedInputStream.readInt32();
                                continue block16;
                            }
                            case 64: {
                                this.packed_ = codedInputStream.readBool();
                                continue block16;
                            }
                            case 74: 
                        }
                        if ((n2 & 128) != 128) {
                            this.options_ = new ArrayList();
                            n2 |= 128;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                    }
                    Object var8_11 = null;
                    if ((n2 & 128) != 128) break block19;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_13) {
            Object var8_12 = null;
            if ((n2 & 128) == 128) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_13;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
    }

    @Override
    public int getKindValue() {
        return this.kind_;
    }

    @Override
    public Field$Kind getKind() {
        Field$Kind field$Kind;
        Field$Kind field$Kind2 = Field$Kind.valueOf(this.kind_);
        if (field$Kind2 == null) {
            field$Kind = Field$Kind.UNRECOGNIZED;
            return field$Kind;
        }
        field$Kind = field$Kind2;
        return field$Kind;
    }

    @Override
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override
    public Field$Cardinality getCardinality() {
        Field$Cardinality field$Cardinality;
        Field$Cardinality field$Cardinality2 = Field$Cardinality.valueOf(this.cardinality_);
        if (field$Cardinality2 == null) {
            field$Cardinality = Field$Cardinality.UNRECOGNIZED;
            return field$Cardinality;
        }
        field$Cardinality = field$Cardinality2;
        return field$Cardinality;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) {
            return (String)object;
        }
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

    @Override
    public String getTypeUrl() {
        Object object = this.typeUrl_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getTypeUrlBytes() {
        ByteString byteString;
        Object object = this.typeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override
    public boolean getPacked() {
        return this.packed_;
    }

    @Override
    public List getOptionsList() {
        return this.options_;
    }

    @Override
    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        return (Option)this.options_.get(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        return (OptionOrBuilder)this.options_.get(n2);
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
        int n2 = 0;
        while (n2 < this.options_.size()) {
            codedOutputStream.writeMessage(9, (MessageLite)this.options_.get(n2));
            ++n2;
        }
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.kind_ != Field$Kind.TYPE_UNKNOWN.getNumber()) {
            n2 += CodedOutputStream.computeEnumSize(1, this.kind_);
        }
        if (this.cardinality_ != Field$Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            n2 += CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        if (this.number_ != 0) {
            n2 += CodedOutputStream.computeInt32Size(3, this.number_);
        }
        if (!this.getNameBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(4, this.getNameBytes());
        }
        if (!this.getTypeUrlBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(6, this.getTypeUrlBytes());
        }
        if (this.oneofIndex_ != 0) {
            n2 += CodedOutputStream.computeInt32Size(7, this.oneofIndex_);
        }
        if (this.packed_) {
            n2 += CodedOutputStream.computeBoolSize(8, this.packed_);
        }
        int n3 = 0;
        do {
            if (n3 >= this.options_.size()) {
                this.memoizedSerializedSize = n2;
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(9, (MessageLite)this.options_.get(n3));
            ++n3;
        } while (true);
    }

    public static Field parseFrom(ByteString byteString) {
        return (Field)PARSER.parseFrom(byteString);
    }

    public static Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Field parseFrom(byte[] arrby) {
        return (Field)PARSER.parseFrom(arrby);
    }

    public static Field parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Field parseFrom(InputStream inputStream) {
        return (Field)PARSER.parseFrom(inputStream);
    }

    public static Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Field parseDelimitedFrom(InputStream inputStream) {
        return (Field)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(CodedInputStream codedInputStream) {
        return (Field)PARSER.parseFrom(codedInputStream);
    }

    public static Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Field$Builder newBuilderForType() {
        return Field.newBuilder();
    }

    public static Field$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Field$Builder newBuilder(Field field) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(field);
    }

    @Override
    public Field$Builder toBuilder() {
        Field$Builder field$Builder;
        if (this == DEFAULT_INSTANCE) {
            field$Builder = new Field$Builder(null);
            return field$Builder;
        }
        field$Builder = new Field$Builder(null).mergeFrom(this);
        return field$Builder;
    }

    @Override
    protected Field$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Field$Builder(generatedMessage$BuilderParent, null);
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Field(GeneratedMessage$Builder generatedMessage$Builder, Field$1 field$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ int access$302(Field field, int n2) {
        field.kind_ = n2;
        return field.kind_;
    }

    static /* synthetic */ int access$402(Field field, int n2) {
        field.cardinality_ = n2;
        return field.cardinality_;
    }

    static /* synthetic */ int access$502(Field field, int n2) {
        field.number_ = n2;
        return field.number_;
    }

    static /* synthetic */ Object access$602(Field field, Object object) {
        field.name_ = object;
        return field.name_;
    }

    static /* synthetic */ Object access$702(Field field, Object object) {
        field.typeUrl_ = object;
        return field.typeUrl_;
    }

    static /* synthetic */ int access$802(Field field, int n2) {
        field.oneofIndex_ = n2;
        return field.oneofIndex_;
    }

    static /* synthetic */ boolean access$902(Field field, boolean bl2) {
        field.packed_ = bl2;
        return field.packed_;
    }

    static /* synthetic */ List access$1002(Field field, List list) {
        field.options_ = list;
        return field.options_;
    }

    static /* synthetic */ int access$1102(Field field, int n2) {
        field.bitField0_ = n2;
        return field.bitField0_;
    }

    static /* synthetic */ int access$300(Field field) {
        return field.kind_;
    }

    static /* synthetic */ int access$400(Field field) {
        return field.cardinality_;
    }

    static /* synthetic */ Object access$600(Field field) {
        return field.name_;
    }

    static /* synthetic */ Object access$700(Field field) {
        return field.typeUrl_;
    }

    static /* synthetic */ List access$1000(Field field) {
        return field.options_;
    }

    /* synthetic */ Field(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Field$1 field$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

