/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$Builder;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$FieldDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$FieldDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 3;
    private int number_;
    public static final int LABEL_FIELD_NUMBER = 4;
    private int label_;
    public static final int TYPE_FIELD_NUMBER = 5;
    private int type_;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private volatile Object typeName_;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    private volatile Object extendee_;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    private volatile Object defaultValue_;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    private int oneofIndex_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos$FieldOptions options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$FieldDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$FieldDescriptorProto$1();

    private DescriptorProtos$FieldDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$FieldDescriptorProto() {
        this.name_ = "";
        this.number_ = 0;
        this.label_ = 1;
        this.type_ = 1;
        this.typeName_ = "";
        this.extendee_ = "";
        this.defaultValue_ = "";
        this.oneofIndex_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            try {
                boolean bl3 = false;
                block17 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        Object object;
                        case 0: {
                            bl3 = true;
                            continue block17;
                        }
                        default: {
                            if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block17;
                            bl3 = true;
                            continue block17;
                        }
                        case 10: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 1;
                            this.name_ = object;
                            continue block17;
                        }
                        case 18: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 32;
                            this.extendee_ = object;
                            continue block17;
                        }
                        case 24: {
                            this.bitField0_ |= 2;
                            this.number_ = codedInputStream.readInt32();
                            continue block17;
                        }
                        case 32: {
                            int n3 = codedInputStream.readEnum();
                            DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.valueOf(n3);
                            if (descriptorProtos$FieldDescriptorProto$Label == null) {
                                unknownFieldSet$Builder.mergeVarintField(4, n3);
                                continue block17;
                            }
                            this.bitField0_ |= 4;
                            this.label_ = n3;
                            continue block17;
                        }
                        case 40: {
                            int n4 = codedInputStream.readEnum();
                            DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.valueOf(n4);
                            if (descriptorProtos$FieldDescriptorProto$Type == null) {
                                unknownFieldSet$Builder.mergeVarintField(5, n4);
                                continue block17;
                            }
                            this.bitField0_ |= 8;
                            this.type_ = n4;
                            continue block17;
                        }
                        case 50: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 16;
                            this.typeName_ = object;
                            continue block17;
                        }
                        case 58: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 64;
                            this.defaultValue_ = object;
                            continue block17;
                        }
                        case 66: {
                            object = null;
                            if ((this.bitField0_ & 256) == 256) {
                                object = this.options_.toBuilder();
                            }
                            this.options_ = (DescriptorProtos$FieldOptions)codedInputStream.readMessage(DescriptorProtos$FieldOptions.PARSER, extensionRegistryLite);
                            if (object != null) {
                                object.mergeFrom(this.options_);
                                this.options_ = object.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            continue block17;
                        }
                        case 72: 
                    }
                    this.bitField0_ |= 128;
                    this.oneofIndex_ = codedInputStream.readInt32();
                }
                Object var10_15 = null;
                this.unknownFields = unknownFieldSet$Builder.build();
            }
            catch (InvalidProtocolBufferException var5_6) {
                throw new RuntimeException(var5_6.setUnfinishedMessage(this));
            }
            catch (IOException var5_7) {
                throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var9_17) {
            Object var10_16 = null;
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var9_17;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$6100();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$6200().ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
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
    public boolean hasNumber() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    @Override
    public boolean hasLabel() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2 = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
        if (descriptorProtos$FieldDescriptorProto$Label2 == null) {
            descriptorProtos$FieldDescriptorProto$Label = DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
            return descriptorProtos$FieldDescriptorProto$Label;
        }
        descriptorProtos$FieldDescriptorProto$Label = descriptorProtos$FieldDescriptorProto$Label2;
        return descriptorProtos$FieldDescriptorProto$Label;
    }

    @Override
    public boolean hasType() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type;
        DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type2 = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
        if (descriptorProtos$FieldDescriptorProto$Type2 == null) {
            descriptorProtos$FieldDescriptorProto$Type = DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE;
            return descriptorProtos$FieldDescriptorProto$Type;
        }
        descriptorProtos$FieldDescriptorProto$Type = descriptorProtos$FieldDescriptorProto$Type2;
        return descriptorProtos$FieldDescriptorProto$Type;
    }

    @Override
    public boolean hasTypeName() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getTypeName() {
        Object object = this.typeName_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeName_ = string;
        return string;
    }

    @Override
    public ByteString getTypeNameBytes() {
        ByteString byteString;
        Object object = this.typeName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasExtendee() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public String getExtendee() {
        Object object = this.extendee_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.extendee_ = string;
        return string;
    }

    @Override
    public ByteString getExtendeeBytes() {
        ByteString byteString;
        Object object = this.extendee_;
        if (!(object instanceof String)) return (ByteString)object;
        this.extendee_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasDefaultValue() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public String getDefaultValue() {
        Object object = this.defaultValue_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.defaultValue_ = string;
        return string;
    }

    @Override
    public ByteString getDefaultValueBytes() {
        ByteString byteString;
        Object object = this.defaultValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.defaultValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasOneofIndex() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions getOptions() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        if (this.options_ == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
            return descriptorProtos$FieldOptions;
        }
        descriptorProtos$FieldOptions = this.options_;
        return descriptorProtos$FieldOptions;
    }

    @Override
    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        if (this.options_ == null) {
            descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.getDefaultInstance();
            return descriptorProtos$FieldOptions;
        }
        descriptorProtos$FieldOptions = this.options_;
        return descriptorProtos$FieldOptions;
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
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBytes(2, this.getExtendeeBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.number_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.label_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(5, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(6, this.getTypeNameBytes());
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeBytes(7, this.getDefaultValueBytes());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(8, this.getOptions());
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeInt32(9, this.oneofIndex_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBytesSize(2, this.getExtendeeBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeInt32Size(3, this.number_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeEnumSize(4, this.label_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeEnumSize(5, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBytesSize(6, this.getTypeNameBytes());
        }
        if ((this.bitField0_ & 64) == 64) {
            n2 += CodedOutputStream.computeBytesSize(7, this.getDefaultValueBytes());
        }
        if ((this.bitField0_ & 256) == 256) {
            n2 += CodedOutputStream.computeMessageSize(8, this.getOptions());
        }
        if ((this.bitField0_ & 128) == 128) {
            n2 += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FieldDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$FieldDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FieldDescriptorProto$Builder newBuilder(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FieldDescriptorProto);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto$Builder toBuilder() {
        DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$FieldDescriptorProto$Builder = new DescriptorProtos$FieldDescriptorProto$Builder(null);
            return descriptorProtos$FieldDescriptorProto$Builder;
        }
        descriptorProtos$FieldDescriptorProto$Builder = new DescriptorProtos$FieldDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$FieldDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$FieldDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FieldDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$FieldDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$FieldDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$6602(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.name_ = object;
        return descriptorProtos$FieldDescriptorProto.name_;
    }

    static /* synthetic */ int access$6702(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n2) {
        descriptorProtos$FieldDescriptorProto.number_ = n2;
        return descriptorProtos$FieldDescriptorProto.number_;
    }

    static /* synthetic */ int access$6802(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n2) {
        descriptorProtos$FieldDescriptorProto.label_ = n2;
        return descriptorProtos$FieldDescriptorProto.label_;
    }

    static /* synthetic */ int access$6902(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n2) {
        descriptorProtos$FieldDescriptorProto.type_ = n2;
        return descriptorProtos$FieldDescriptorProto.type_;
    }

    static /* synthetic */ Object access$7002(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.typeName_ = object;
        return descriptorProtos$FieldDescriptorProto.typeName_;
    }

    static /* synthetic */ Object access$7102(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.extendee_ = object;
        return descriptorProtos$FieldDescriptorProto.extendee_;
    }

    static /* synthetic */ Object access$7202(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, Object object) {
        descriptorProtos$FieldDescriptorProto.defaultValue_ = object;
        return descriptorProtos$FieldDescriptorProto.defaultValue_;
    }

    static /* synthetic */ int access$7302(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n2) {
        descriptorProtos$FieldDescriptorProto.oneofIndex_ = n2;
        return descriptorProtos$FieldDescriptorProto.oneofIndex_;
    }

    static /* synthetic */ DescriptorProtos$FieldOptions access$7402(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        descriptorProtos$FieldDescriptorProto.options_ = descriptorProtos$FieldOptions;
        return descriptorProtos$FieldDescriptorProto.options_;
    }

    static /* synthetic */ int access$7502(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, int n2) {
        descriptorProtos$FieldDescriptorProto.bitField0_ = n2;
        return descriptorProtos$FieldDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$6600(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.name_;
    }

    static /* synthetic */ Object access$7000(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.typeName_;
    }

    static /* synthetic */ Object access$7100(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.extendee_;
    }

    static /* synthetic */ Object access$7200(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return descriptorProtos$FieldDescriptorProto.defaultValue_;
    }

    /* synthetic */ DescriptorProtos$FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

