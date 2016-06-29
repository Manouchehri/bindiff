/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
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

public final class DescriptorProtos$FileDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$FileDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private volatile Object package_;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    private LazyStringList dependency_;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    private List publicDependency_;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private List weakDependency_;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    private List messageType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    private List enumType_;
    public static final int SERVICE_FIELD_NUMBER = 6;
    private List service_;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    private List extension_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos$FileOptions options_;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    private volatile Object syntax_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$FileDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$FileDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$FileDescriptorProto$1();

    private DescriptorProtos$FileDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$FileDescriptorProto() {
        this.name_ = "";
        this.package_ = "";
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.publicDependency_ = Collections.emptyList();
        this.weakDependency_ = Collections.emptyList();
        this.messageType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.service_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.syntax_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$FileDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block51 : {
                try {
                    boolean bl2 = false;
                    block22 : while (!bl2) {
                        Object object;
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            int n4;
                            case 0: {
                                bl2 = true;
                                continue block22;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block22;
                                bl2 = true;
                                continue block22;
                            }
                            case 10: {
                                object = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.name_ = object;
                                continue block22;
                            }
                            case 18: {
                                object = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.package_ = object;
                                continue block22;
                            }
                            case 26: {
                                object = codedInputStream.readBytes();
                                if ((n2 & 4) != 4) {
                                    this.dependency_ = new LazyStringArrayList();
                                    n2 |= 4;
                                }
                                this.dependency_.add((ByteString)object);
                                continue block22;
                            }
                            case 34: {
                                if ((n2 & 32) != 32) {
                                    this.messageType_ = new ArrayList();
                                    n2 |= 32;
                                }
                                this.messageType_.add(codedInputStream.readMessage(DescriptorProtos$DescriptorProto.PARSER, extensionRegistryLite));
                                continue block22;
                            }
                            case 42: {
                                if ((n2 & 64) != 64) {
                                    this.enumType_ = new ArrayList();
                                    n2 |= 64;
                                }
                                this.enumType_.add(codedInputStream.readMessage(DescriptorProtos$EnumDescriptorProto.PARSER, extensionRegistryLite));
                                continue block22;
                            }
                            case 50: {
                                if ((n2 & 128) != 128) {
                                    this.service_ = new ArrayList();
                                    n2 |= 128;
                                }
                                this.service_.add(codedInputStream.readMessage(DescriptorProtos$ServiceDescriptorProto.PARSER, extensionRegistryLite));
                                continue block22;
                            }
                            case 58: {
                                if ((n2 & 256) != 256) {
                                    this.extension_ = new ArrayList();
                                    n2 |= 256;
                                }
                                this.extension_.add(codedInputStream.readMessage(DescriptorProtos$FieldDescriptorProto.PARSER, extensionRegistryLite));
                                continue block22;
                            }
                            case 66: {
                                object = null;
                                if ((this.bitField0_ & 4) == 4) {
                                    object = this.options_.toBuilder();
                                }
                                this.options_ = (DescriptorProtos$FileOptions)codedInputStream.readMessage(DescriptorProtos$FileOptions.PARSER, extensionRegistryLite);
                                if (object != null) {
                                    object.mergeFrom(this.options_);
                                    this.options_ = object.buildPartial();
                                }
                                this.bitField0_ |= 4;
                                continue block22;
                            }
                            case 74: {
                                object = null;
                                if ((this.bitField0_ & 8) == 8) {
                                    object = this.sourceCodeInfo_.toBuilder();
                                }
                                this.sourceCodeInfo_ = (DescriptorProtos$SourceCodeInfo)codedInputStream.readMessage(DescriptorProtos$SourceCodeInfo.PARSER, extensionRegistryLite);
                                if (object != null) {
                                    object.mergeFrom(this.sourceCodeInfo_);
                                    this.sourceCodeInfo_ = object.buildPartial();
                                }
                                this.bitField0_ |= 8;
                                continue block22;
                            }
                            case 80: {
                                if ((n2 & 8) != 8) {
                                    this.publicDependency_ = new ArrayList();
                                    n2 |= 8;
                                }
                                this.publicDependency_.add(codedInputStream.readInt32());
                                continue block22;
                            }
                            case 82: {
                                int n5 = codedInputStream.readRawVarint32();
                                n4 = codedInputStream.pushLimit(n5);
                                if ((n2 & 8) != 8 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.publicDependency_ = new ArrayList();
                                    n2 |= 8;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.publicDependency_.add(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(n4);
                                continue block22;
                            }
                            case 88: {
                                if ((n2 & 16) != 16) {
                                    this.weakDependency_ = new ArrayList();
                                    n2 |= 16;
                                }
                                this.weakDependency_.add(codedInputStream.readInt32());
                                continue block22;
                            }
                            case 90: {
                                int n6 = codedInputStream.readRawVarint32();
                                n4 = codedInputStream.pushLimit(n6);
                                if ((n2 & 16) != 16 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.weakDependency_ = new ArrayList();
                                    n2 |= 16;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.weakDependency_.add(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(n4);
                                continue block22;
                            }
                            case 98: 
                        }
                        object = codedInputStream.readBytes();
                        this.bitField0_ |= 16;
                        this.syntax_ = object;
                    }
                    Object var10_13 = null;
                    if ((n2 & 4) == 4) {
                        this.dependency_ = this.dependency_.getUnmodifiableView();
                    }
                    if ((n2 & 32) != 32) break block51;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.messageType_ = Collections.unmodifiableList(this.messageType_);
            }
            if ((n2 & 64) == 64) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if ((n2 & 128) == 128) {
                this.service_ = Collections.unmodifiableList(this.service_);
            }
            if ((n2 & 256) == 256) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            if ((n2 & 8) == 8) {
                this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
            }
            if ((n2 & 16) == 16) {
                this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var9_15) {
            Object var10_14 = null;
            if ((n2 & 4) == 4) {
                this.dependency_ = this.dependency_.getUnmodifiableView();
            }
            if ((n2 & 32) == 32) {
                this.messageType_ = Collections.unmodifiableList(this.messageType_);
            }
            if ((n2 & 64) == 64) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if ((n2 & 128) == 128) {
                this.service_ = Collections.unmodifiableList(this.service_);
            }
            if ((n2 & 256) == 256) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            if ((n2 & 8) == 8) {
                this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
            }
            if ((n2 & 16) == 16) {
                this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var9_15;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$800().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
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
    public boolean hasPackage() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getPackage() {
        Object object = this.package_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.package_ = string;
        return string;
    }

    @Override
    public ByteString getPackageBytes() {
        ByteString byteString;
        Object object = this.package_;
        if (!(object instanceof String)) return (ByteString)object;
        this.package_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public ProtocolStringList getDependencyList() {
        return this.dependency_;
    }

    @Override
    public int getDependencyCount() {
        return this.dependency_.size();
    }

    @Override
    public String getDependency(int n2) {
        return (String)this.dependency_.get(n2);
    }

    @Override
    public ByteString getDependencyBytes(int n2) {
        return this.dependency_.getByteString(n2);
    }

    @Override
    public List getPublicDependencyList() {
        return this.publicDependency_;
    }

    @Override
    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    @Override
    public int getPublicDependency(int n2) {
        return (Integer)this.publicDependency_.get(n2);
    }

    @Override
    public List getWeakDependencyList() {
        return this.weakDependency_;
    }

    @Override
    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    @Override
    public int getWeakDependency(int n2) {
        return (Integer)this.weakDependency_.get(n2);
    }

    @Override
    public List getMessageTypeList() {
        return this.messageType_;
    }

    @Override
    public List getMessageTypeOrBuilderList() {
        return this.messageType_;
    }

    @Override
    public int getMessageTypeCount() {
        return this.messageType_.size();
    }

    @Override
    public DescriptorProtos$DescriptorProto getMessageType(int n2) {
        return (DescriptorProtos$DescriptorProto)this.messageType_.get(n2);
    }

    @Override
    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int n2) {
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageType_.get(n2);
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
    public List getServiceList() {
        return this.service_;
    }

    @Override
    public List getServiceOrBuilderList() {
        return this.service_;
    }

    @Override
    public int getServiceCount() {
        return this.service_.size();
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProto getService(int n2) {
        return (DescriptorProtos$ServiceDescriptorProto)this.service_.get(n2);
    }

    @Override
    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int n2) {
        return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.service_.get(n2);
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
    public boolean hasOptions() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FileOptions getOptions() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        if (this.options_ == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
            return descriptorProtos$FileOptions;
        }
        descriptorProtos$FileOptions = this.options_;
        return descriptorProtos$FileOptions;
    }

    @Override
    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        if (this.options_ == null) {
            descriptorProtos$FileOptions = DescriptorProtos$FileOptions.getDefaultInstance();
            return descriptorProtos$FileOptions;
        }
        descriptorProtos$FileOptions = this.options_;
        return descriptorProtos$FileOptions;
    }

    @Override
    public boolean hasSourceCodeInfo() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        if (this.sourceCodeInfo_ == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
            return descriptorProtos$SourceCodeInfo;
        }
        descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        return descriptorProtos$SourceCodeInfo;
    }

    @Override
    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        if (this.sourceCodeInfo_ == null) {
            descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.getDefaultInstance();
            return descriptorProtos$SourceCodeInfo;
        }
        descriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        return descriptorProtos$SourceCodeInfo;
    }

    @Override
    public boolean hasSyntax() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getSyntax() {
        Object object = this.syntax_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.syntax_ = string;
        return string;
    }

    @Override
    public ByteString getSyntaxBytes() {
        ByteString byteString;
        Object object = this.syntax_;
        if (!(object instanceof String)) return (ByteString)object;
        this.syntax_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
        for (n2 = 0; n2 < this.getMessageTypeCount(); ++n2) {
            if (this.getMessageType(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getEnumTypeCount(); ++n2) {
            if (this.getEnumType(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getServiceCount(); ++n2) {
            if (this.getService(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getExtensionCount(); ++n2) {
            if (this.getExtension(n2).isInitialized()) continue;
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
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.getPackageBytes());
        }
        for (n2 = 0; n2 < this.dependency_.size(); ++n2) {
            codedOutputStream.writeBytes(3, this.dependency_.getByteString(n2));
        }
        for (n2 = 0; n2 < this.messageType_.size(); ++n2) {
            codedOutputStream.writeMessage(4, (MessageLite)this.messageType_.get(n2));
        }
        for (n2 = 0; n2 < this.enumType_.size(); ++n2) {
            codedOutputStream.writeMessage(5, (MessageLite)this.enumType_.get(n2));
        }
        for (n2 = 0; n2 < this.service_.size(); ++n2) {
            codedOutputStream.writeMessage(6, (MessageLite)this.service_.get(n2));
        }
        for (n2 = 0; n2 < this.extension_.size(); ++n2) {
            codedOutputStream.writeMessage(7, (MessageLite)this.extension_.get(n2));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(8, this.getOptions());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(9, this.getSourceCodeInfo());
        }
        for (n2 = 0; n2 < this.publicDependency_.size(); ++n2) {
            codedOutputStream.writeInt32(10, (Integer)this.publicDependency_.get(n2));
        }
        for (n2 = 0; n2 < this.weakDependency_.size(); ++n2) {
            codedOutputStream.writeInt32(11, (Integer)this.weakDependency_.get(n2));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBytes(12, this.getSyntaxBytes());
        }
        this.unknownFields.writeTo(codedOutputStream);
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
        if ((this.bitField0_ & 2) == 2) {
            n3 += CodedOutputStream.computeBytesSize(2, this.getPackageBytes());
        }
        int n4 = 0;
        for (n2 = 0; n2 < this.dependency_.size(); n4 += CodedOutputStream.computeBytesSizeNoTag((ByteString)this.dependency_.getByteString((int)n2)), ++n2) {
        }
        n3 += n4;
        n3 += 1 * this.getDependencyList().size();
        for (n4 = 0; n4 < this.messageType_.size(); n3 += CodedOutputStream.computeMessageSize((int)4, (MessageLite)((MessageLite)this.messageType_.get((int)n4))), ++n4) {
        }
        for (n4 = 0; n4 < this.enumType_.size(); n3 += CodedOutputStream.computeMessageSize((int)5, (MessageLite)((MessageLite)this.enumType_.get((int)n4))), ++n4) {
        }
        for (n4 = 0; n4 < this.service_.size(); n3 += CodedOutputStream.computeMessageSize((int)6, (MessageLite)((MessageLite)this.service_.get((int)n4))), ++n4) {
        }
        for (n4 = 0; n4 < this.extension_.size(); n3 += CodedOutputStream.computeMessageSize((int)7, (MessageLite)((MessageLite)this.extension_.get((int)n4))), ++n4) {
        }
        if ((this.bitField0_ & 4) == 4) {
            n3 += CodedOutputStream.computeMessageSize(8, this.getOptions());
        }
        if ((this.bitField0_ & 8) == 8) {
            n3 += CodedOutputStream.computeMessageSize(9, this.getSourceCodeInfo());
        }
        n4 = 0;
        for (n2 = 0; n2 < this.publicDependency_.size(); n4 += CodedOutputStream.computeInt32SizeNoTag((int)((Integer)this.publicDependency_.get((int)n2)).intValue()), ++n2) {
        }
        n3 += n4;
        n3 += 1 * this.getPublicDependencyList().size();
        n4 = 0;
        for (n2 = 0; n2 < this.weakDependency_.size(); n4 += CodedOutputStream.computeInt32SizeNoTag((int)((Integer)this.weakDependency_.get((int)n2)).intValue()), ++n2) {
        }
        n3 += n4;
        n3 += 1 * this.getWeakDependencyList().size();
        if ((this.bitField0_ & 16) == 16) {
            n3 += CodedOutputStream.computeBytesSize(12, this.getSyntaxBytes());
        }
        this.memoizedSerializedSize = n3 += this.unknownFields.getSerializedSize();
        return n3;
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$FileDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$FileDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileDescriptorProto$Builder newBuilder(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileDescriptorProto);
    }

    @Override
    public DescriptorProtos$FileDescriptorProto$Builder toBuilder() {
        DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$FileDescriptorProto$Builder = new DescriptorProtos$FileDescriptorProto$Builder(null);
            return descriptorProtos$FileDescriptorProto$Builder;
        }
        descriptorProtos$FileDescriptorProto$Builder = new DescriptorProtos$FileDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$FileDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$FileDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$FileDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$1202(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.name_ = object;
        return descriptorProtos$FileDescriptorProto.name_;
    }

    static /* synthetic */ Object access$1302(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.package_ = object;
        return descriptorProtos$FileDescriptorProto.package_;
    }

    static /* synthetic */ LazyStringList access$1402(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, LazyStringList lazyStringList) {
        descriptorProtos$FileDescriptorProto.dependency_ = lazyStringList;
        return descriptorProtos$FileDescriptorProto.dependency_;
    }

    static /* synthetic */ List access$1502(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.publicDependency_ = list;
        return descriptorProtos$FileDescriptorProto.publicDependency_;
    }

    static /* synthetic */ List access$1602(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.weakDependency_ = list;
        return descriptorProtos$FileDescriptorProto.weakDependency_;
    }

    static /* synthetic */ List access$1702(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.messageType_ = list;
        return descriptorProtos$FileDescriptorProto.messageType_;
    }

    static /* synthetic */ List access$1802(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.enumType_ = list;
        return descriptorProtos$FileDescriptorProto.enumType_;
    }

    static /* synthetic */ List access$1902(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.service_ = list;
        return descriptorProtos$FileDescriptorProto.service_;
    }

    static /* synthetic */ List access$2002(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, List list) {
        descriptorProtos$FileDescriptorProto.extension_ = list;
        return descriptorProtos$FileDescriptorProto.extension_;
    }

    static /* synthetic */ DescriptorProtos$FileOptions access$2102(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        descriptorProtos$FileDescriptorProto.options_ = descriptorProtos$FileOptions;
        return descriptorProtos$FileDescriptorProto.options_;
    }

    static /* synthetic */ DescriptorProtos$SourceCodeInfo access$2202(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        descriptorProtos$FileDescriptorProto.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
        return descriptorProtos$FileDescriptorProto.sourceCodeInfo_;
    }

    static /* synthetic */ Object access$2302(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Object object) {
        descriptorProtos$FileDescriptorProto.syntax_ = object;
        return descriptorProtos$FileDescriptorProto.syntax_;
    }

    static /* synthetic */ int access$2402(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, int n2) {
        descriptorProtos$FileDescriptorProto.bitField0_ = n2;
        return descriptorProtos$FileDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$1200(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.name_;
    }

    static /* synthetic */ Object access$1300(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.package_;
    }

    static /* synthetic */ LazyStringList access$1400(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.dependency_;
    }

    static /* synthetic */ List access$1500(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.publicDependency_;
    }

    static /* synthetic */ List access$1600(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.weakDependency_;
    }

    static /* synthetic */ List access$1700(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.messageType_;
    }

    static /* synthetic */ List access$1800(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.enumType_;
    }

    static /* synthetic */ List access$1900(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.service_;
    }

    static /* synthetic */ List access$2000(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.extension_;
    }

    static /* synthetic */ Object access$2300(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        return descriptorProtos$FileDescriptorProto.syntax_;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

