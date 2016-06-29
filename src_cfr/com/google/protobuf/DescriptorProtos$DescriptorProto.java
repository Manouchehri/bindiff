/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptions$Builder;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto
extends GeneratedMessage
implements DescriptorProtos$DescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int FIELD_FIELD_NUMBER = 2;
    private List field_;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    private List extension_;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    private List nestedType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    private List enumType_;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    private List extensionRange_;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    private List oneofDecl_;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private DescriptorProtos$MessageOptions options_;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    private List reservedRange_;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    private LazyStringList reservedName_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$DescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$DescriptorProto$1();

    private DescriptorProtos$DescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$DescriptorProto() {
        this.name_ = "";
        this.field_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.nestedType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.extensionRange_ = Collections.emptyList();
        this.oneofDecl_ = Collections.emptyList();
        this.reservedRange_ = Collections.emptyList();
        this.reservedName_ = LazyStringArrayList.EMPTY;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block44 : {
                try {
                    boolean bl2 = false;
                    block18 : while (!bl2) {
                        Object object;
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block18;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block18;
                                bl2 = true;
                                continue block18;
                            }
                            case 10: {
                                object = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.name_ = object;
                                continue block18;
                            }
                            case 18: {
                                if ((n2 & 2) != 2) {
                                    this.field_ = new ArrayList();
                                    n2 |= 2;
                                }
                                this.field_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 26: {
                                if ((n2 & 8) != 8) {
                                    this.nestedType_ = new ArrayList();
                                    n2 |= 8;
                                }
                                this.nestedType_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 34: {
                                if ((n2 & 16) != 16) {
                                    this.enumType_ = new ArrayList();
                                    n2 |= 16;
                                }
                                this.enumType_.add(codedInputStream.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 42: {
                                if ((n2 & 32) != 32) {
                                    this.extensionRange_ = new ArrayList();
                                    n2 |= 32;
                                }
                                this.extensionRange_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto$ExtensionRange.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 50: {
                                if ((n2 & 4) != 4) {
                                    this.extension_ = new ArrayList();
                                    n2 |= 4;
                                }
                                this.extension_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 58: {
                                object = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    object = this.options_.toBuilder();
                                }
                                this.options_ = (DescriptorProtos$MessageOptions)codedInputStream.readMessage(DescriptorProtos$MessageOptions.PARSER, extensionRegistryLite);
                                if (object != null) {
                                    object.mergeFrom(this.options_);
                                    this.options_ = object.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                continue block18;
                            }
                            case 66: {
                                if ((n2 & 64) != 64) {
                                    this.oneofDecl_ = new ArrayList();
                                    n2 |= 64;
                                }
                                this.oneofDecl_.add(codedInputStream.readMessage(DescriptorProtos$OneofDescriptorProto.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 74: {
                                if ((n2 & 256) != 256) {
                                    this.reservedRange_ = new ArrayList();
                                    n2 |= 256;
                                }
                                this.reservedRange_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto$ReservedRange.PARSER, extensionRegistryLite));
                                continue block18;
                            }
                            case 82: 
                        }
                        object = codedInputStream.readBytes();
                        if ((n2 & 512) != 512) {
                            this.reservedName_ = new LazyStringArrayList();
                            n2 |= 512;
                        }
                        this.reservedName_.add((ByteString)object);
                    }
                    Object var9_10 = null;
                    if ((n2 & 2) != 2) break block44;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.field_ = Collections.unmodifiableList(this.field_);
            }
            if ((n2 & 8) == 8) {
                this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
            }
            if ((n2 & 16) == 16) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if ((n2 & 32) == 32) {
                this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
            }
            if ((n2 & 4) == 4) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            if ((n2 & 64) == 64) {
                this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
            }
            if ((n2 & 256) == 256) {
                this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
            }
            if ((n2 & 512) == 512) {
                this.reservedName_ = this.reservedName_.getUnmodifiableView();
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            if ((n2 & 2) == 2) {
                this.field_ = Collections.unmodifiableList(this.field_);
            }
            if ((n2 & 8) == 8) {
                this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
            }
            if ((n2 & 16) == 16) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if ((n2 & 32) == 32) {
                this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
            }
            if ((n2 & 4) == 4) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            if ((n2 & 64) == 64) {
                this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
            }
            if ((n2 & 256) == 256) {
                this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
            }
            if ((n2 & 512) == 512) {
                this.reservedName_ = this.reservedName_.getUnmodifiableView();
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$2600();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$2700().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
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
    public List getFieldList() {
        return this.field_;
    }

    @Override
    public List getFieldOrBuilderList() {
        return this.field_;
    }

    @Override
    public int getFieldCount() {
        return this.field_.size();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getField(int n2) {
        return (DescriptorProtos$FieldDescriptorProto)this.field_.get(n2);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.field_.get(n2);
    }

    @Override
    public List getExtensionList() {
        return this.extension_;
    }

    @Override
    public List getExtensionOrBuilderList() {
        return this.extension_;
    }

    @Override
    public int getExtensionCount() {
        return this.extension_.size();
    }

    @Override
    public DescriptorProtos$FieldDescriptorProto getExtension(int n2) {
        return (DescriptorProtos$FieldDescriptorProto)this.extension_.get(n2);
    }

    @Override
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int n2) {
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extension_.get(n2);
    }

    @Override
    public List getNestedTypeList() {
        return this.nestedType_;
    }

    @Override
    public List getNestedTypeOrBuilderList() {
        return this.nestedType_;
    }

    @Override
    public int getNestedTypeCount() {
        return this.nestedType_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto getNestedType(int n2) {
        return (DescriptorProtos$DescriptorProto)this.nestedType_.get(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int n2) {
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedType_.get(n2);
    }

    @Override
    public List getEnumTypeList() {
        return this.enumType_;
    }

    @Override
    public List getEnumTypeOrBuilderList() {
        return this.enumType_;
    }

    @Override
    public int getEnumTypeCount() {
        return this.enumType_.size();
    }

    @Override
    public DescriptorProtos$EnumDescriptorProto getEnumType(int n2) {
        return (DescriptorProtos$EnumDescriptorProto)this.enumType_.get(n2);
    }

    @Override
    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int n2) {
        return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumType_.get(n2);
    }

    @Override
    public List getExtensionRangeList() {
        return this.extensionRange_;
    }

    @Override
    public List getExtensionRangeOrBuilderList() {
        return this.extensionRange_;
    }

    @Override
    public int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int n2) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRange_.get(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRange_.get(n2);
    }

    @Override
    public List getOneofDeclList() {
        return this.oneofDecl_;
    }

    @Override
    public List getOneofDeclOrBuilderList() {
        return this.oneofDecl_;
    }

    @Override
    public int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }

    @Override
    public DescriptorProtos$OneofDescriptorProto getOneofDecl(int n2) {
        return (DescriptorProtos$OneofDescriptorProto)this.oneofDecl_.get(n2);
    }

    @Override
    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int n2) {
        return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDecl_.get(n2);
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public DescriptorProtos$MessageOptions getOptions() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        if (this.options_ == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
            return descriptorProtos$MessageOptions;
        }
        descriptorProtos$MessageOptions = this.options_;
        return descriptorProtos$MessageOptions;
    }

    @Override
    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        if (this.options_ == null) {
            descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.getDefaultInstance();
            return descriptorProtos$MessageOptions;
        }
        descriptorProtos$MessageOptions = this.options_;
        return descriptorProtos$MessageOptions;
    }

    @Override
    public List getReservedRangeList() {
        return this.reservedRange_;
    }

    @Override
    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    @Override
    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int n2) {
        return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRange_.get(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int n2) {
        return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRange_.get(n2);
    }

    @Override
    public ProtocolStringList getReservedNameList() {
        return this.reservedName_;
    }

    @Override
    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    @Override
    public String getReservedName(int n2) {
        return (String)this.reservedName_.get(n2);
    }

    @Override
    public ByteString getReservedNameBytes(int n2) {
        return this.reservedName_.getByteString(n2);
    }

    @Override
    public final boolean isInitialized() {
        int n2;
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        for (n2 = 0; n2 < this.getFieldCount(); ++n2) {
            if (this.getField(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getExtensionCount(); ++n2) {
            if (this.getExtension(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getNestedTypeCount(); ++n2) {
            if (this.getNestedType(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getEnumTypeCount(); ++n2) {
            if (this.getEnumType(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
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
        int n2;
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        for (n2 = 0; n2 < this.field_.size(); ++n2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.field_.get(n2));
        }
        for (n2 = 0; n2 < this.nestedType_.size(); ++n2) {
            codedOutputStream.writeMessage(3, (MessageLite)this.nestedType_.get(n2));
        }
        for (n2 = 0; n2 < this.enumType_.size(); ++n2) {
            codedOutputStream.writeMessage(4, (MessageLite)this.enumType_.get(n2));
        }
        for (n2 = 0; n2 < this.extensionRange_.size(); ++n2) {
            codedOutputStream.writeMessage(5, (MessageLite)this.extensionRange_.get(n2));
        }
        for (n2 = 0; n2 < this.extension_.size(); ++n2) {
            codedOutputStream.writeMessage(6, (MessageLite)this.extension_.get(n2));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(7, this.getOptions());
        }
        for (n2 = 0; n2 < this.oneofDecl_.size(); ++n2) {
            codedOutputStream.writeMessage(8, (MessageLite)this.oneofDecl_.get(n2));
        }
        for (n2 = 0; n2 < this.reservedRange_.size(); ++n2) {
            codedOutputStream.writeMessage(9, (MessageLite)this.reservedRange_.get(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.reservedName_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeBytes(10, this.reservedName_.getByteString(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2;
        int n3 = this.memoizedSerializedSize;
        if (n3 != -1) {
            return n3;
        }
        n3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n3 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        for (n2 = 0; n2 < this.field_.size(); n3 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.field_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.nestedType_.size(); n3 += CodedOutputStream.computeMessageSize((int)3, (MessageLite)((MessageLite)this.nestedType_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.enumType_.size(); n3 += CodedOutputStream.computeMessageSize((int)4, (MessageLite)((MessageLite)this.enumType_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.extensionRange_.size(); n3 += CodedOutputStream.computeMessageSize((int)5, (MessageLite)((MessageLite)this.extensionRange_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.extension_.size(); n3 += CodedOutputStream.computeMessageSize((int)6, (MessageLite)((MessageLite)this.extension_.get((int)n2))), ++n2) {
        }
        if ((this.bitField0_ & 2) == 2) {
            n3 += CodedOutputStream.computeMessageSize(7, this.getOptions());
        }
        for (n2 = 0; n2 < this.oneofDecl_.size(); n3 += CodedOutputStream.computeMessageSize((int)8, (MessageLite)((MessageLite)this.oneofDecl_.get((int)n2))), ++n2) {
        }
        for (n2 = 0; n2 < this.reservedRange_.size(); n3 += CodedOutputStream.computeMessageSize((int)9, (MessageLite)((MessageLite)this.reservedRange_.get((int)n2))), ++n2) {
        }
        n2 = 0;
        int n4 = 0;
        do {
            if (n4 >= this.reservedName_.size()) {
                n3 += n2;
                n3 += 1 * this.getReservedNameList().size();
                this.memoizedSerializedSize = n3 += this.unknownFields.getSerializedSize();
                return n3;
            }
            n2 += CodedOutputStream.computeBytesSizeNoTag(this.reservedName_.getByteString(n4));
            ++n4;
        } while (true);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$DescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$DescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$DescriptorProto.newBuilder();
    }

    public static DescriptorProtos$DescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$DescriptorProto$Builder newBuilder(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$DescriptorProto);
    }

    @Override
    public DescriptorProtos$DescriptorProto$Builder toBuilder() {
        DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$DescriptorProto$Builder = new DescriptorProtos$DescriptorProto$Builder(null);
            return descriptorProtos$DescriptorProto$Builder;
        }
        descriptorProtos$DescriptorProto$Builder = new DescriptorProtos$DescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$DescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$DescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$DescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$DescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$4902(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, Object object) {
        descriptorProtos$DescriptorProto.name_ = object;
        return descriptorProtos$DescriptorProto.name_;
    }

    static /* synthetic */ List access$5002(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.field_ = list;
        return descriptorProtos$DescriptorProto.field_;
    }

    static /* synthetic */ List access$5102(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.extension_ = list;
        return descriptorProtos$DescriptorProto.extension_;
    }

    static /* synthetic */ List access$5202(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.nestedType_ = list;
        return descriptorProtos$DescriptorProto.nestedType_;
    }

    static /* synthetic */ List access$5302(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.enumType_ = list;
        return descriptorProtos$DescriptorProto.enumType_;
    }

    static /* synthetic */ List access$5402(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.extensionRange_ = list;
        return descriptorProtos$DescriptorProto.extensionRange_;
    }

    static /* synthetic */ List access$5502(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.oneofDecl_ = list;
        return descriptorProtos$DescriptorProto.oneofDecl_;
    }

    static /* synthetic */ DescriptorProtos$MessageOptions access$5602(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        descriptorProtos$DescriptorProto.options_ = descriptorProtos$MessageOptions;
        return descriptorProtos$DescriptorProto.options_;
    }

    static /* synthetic */ List access$5702(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, List list) {
        descriptorProtos$DescriptorProto.reservedRange_ = list;
        return descriptorProtos$DescriptorProto.reservedRange_;
    }

    static /* synthetic */ LazyStringList access$5802(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, LazyStringList lazyStringList) {
        descriptorProtos$DescriptorProto.reservedName_ = lazyStringList;
        return descriptorProtos$DescriptorProto.reservedName_;
    }

    static /* synthetic */ int access$5902(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, int n2) {
        descriptorProtos$DescriptorProto.bitField0_ = n2;
        return descriptorProtos$DescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$4900(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.name_;
    }

    static /* synthetic */ List access$5000(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.field_;
    }

    static /* synthetic */ List access$5100(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.extension_;
    }

    static /* synthetic */ List access$5200(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.nestedType_;
    }

    static /* synthetic */ List access$5300(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.enumType_;
    }

    static /* synthetic */ List access$5400(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.extensionRange_;
    }

    static /* synthetic */ List access$5500(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.oneofDecl_;
    }

    static /* synthetic */ List access$5700(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.reservedRange_;
    }

    static /* synthetic */ LazyStringList access$5800(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        return descriptorProtos$DescriptorProto.reservedName_;
    }

    /* synthetic */ DescriptorProtos$DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

