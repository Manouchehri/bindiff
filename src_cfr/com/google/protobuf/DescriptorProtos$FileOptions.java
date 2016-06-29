/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileOptions$1;
import com.google.protobuf.DescriptorProtos$FileOptions$Builder;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$ExtendableMessage$ExtensionWriter;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions
extends GeneratedMessage$ExtendableMessage
implements DescriptorProtos$FileOptionsOrBuilder {
    private int bitField0_;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    private volatile Object javaPackage_;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    private volatile Object javaOuterClassname_;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    private boolean javaMultipleFiles_;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    private boolean javaGenerateEqualsAndHash_;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    private boolean javaStringCheckUtf8_;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private int optimizeFor_;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    private volatile Object goPackage_;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    private boolean ccGenericServices_;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    private boolean javaGenericServices_;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    private boolean pyGenericServices_;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    private boolean deprecated_;
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
    private boolean ccEnableArenas_;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    private volatile Object objcClassPrefix_;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private volatile Object csharpNamespace_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List uninterpretedOption_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$FileOptions DEFAULT_INSTANCE = new DescriptorProtos$FileOptions();
    public static final Parser PARSER = new DescriptorProtos$FileOptions$1();

    private DescriptorProtos$FileOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
    }

    private DescriptorProtos$FileOptions() {
        this.javaPackage_ = "";
        this.javaOuterClassname_ = "";
        this.javaMultipleFiles_ = false;
        this.javaGenerateEqualsAndHash_ = false;
        this.javaStringCheckUtf8_ = false;
        this.optimizeFor_ = 1;
        this.goPackage_ = "";
        this.ccGenericServices_ = false;
        this.javaGenericServices_ = false;
        this.pyGenericServices_ = false;
        this.deprecated_ = false;
        this.ccEnableArenas_ = false;
        this.objcClassPrefix_ = "";
        this.csharpNamespace_ = "";
        this.uninterpretedOption_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            block27 : {
                try {
                    boolean bl2 = false;
                    block23 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            ByteString byteString;
                            case 0: {
                                bl2 = true;
                                continue block23;
                            }
                            default: {
                                if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block23;
                                bl2 = true;
                                continue block23;
                            }
                            case 10: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 1;
                                this.javaPackage_ = byteString;
                                continue block23;
                            }
                            case 66: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 2;
                                this.javaOuterClassname_ = byteString;
                                continue block23;
                            }
                            case 72: {
                                int n4 = codedInputStream.readEnum();
                                DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode = DescriptorProtos$FileOptions$OptimizeMode.valueOf(n4);
                                if (descriptorProtos$FileOptions$OptimizeMode == null) {
                                    unknownFieldSet$Builder.mergeVarintField(9, n4);
                                    continue block23;
                                }
                                this.bitField0_ |= 32;
                                this.optimizeFor_ = n4;
                                continue block23;
                            }
                            case 80: {
                                this.bitField0_ |= 4;
                                this.javaMultipleFiles_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 90: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 64;
                                this.goPackage_ = byteString;
                                continue block23;
                            }
                            case 128: {
                                this.bitField0_ |= 128;
                                this.ccGenericServices_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 136: {
                                this.bitField0_ |= 256;
                                this.javaGenericServices_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 144: {
                                this.bitField0_ |= 512;
                                this.pyGenericServices_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 160: {
                                this.bitField0_ |= 8;
                                this.javaGenerateEqualsAndHash_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 184: {
                                this.bitField0_ |= 1024;
                                this.deprecated_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 216: {
                                this.bitField0_ |= 16;
                                this.javaStringCheckUtf8_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 248: {
                                this.bitField0_ |= 2048;
                                this.ccEnableArenas_ = codedInputStream.readBool();
                                continue block23;
                            }
                            case 290: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 4096;
                                this.objcClassPrefix_ = byteString;
                                continue block23;
                            }
                            case 298: {
                                byteString = codedInputStream.readBytes();
                                this.bitField0_ |= 8192;
                                this.csharpNamespace_ = byteString;
                                continue block23;
                            }
                            case 7994: 
                        }
                        if ((n2 & 16384) != 16384) {
                            this.uninterpretedOption_ = new ArrayList();
                            n2 |= 16384;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
                    }
                    Object var10_12 = null;
                    if ((n2 & 16384) != 16384) break block27;
                }
                catch (InvalidProtocolBufferException var5_6) {
                    throw new RuntimeException(var5_6.setUnfinishedMessage(this));
                }
                catch (IOException var5_7) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
                }
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var9_14) {
            Object var10_13 = null;
            if ((n2 & 16384) == 16384) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var9_14;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$12800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$12900().ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
    }

    @Override
    public boolean hasJavaPackage() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getJavaPackage() {
        Object object = this.javaPackage_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.javaPackage_ = string;
        return string;
    }

    @Override
    public ByteString getJavaPackageBytes() {
        ByteString byteString;
        Object object = this.javaPackage_;
        if (!(object instanceof String)) return (ByteString)object;
        this.javaPackage_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasJavaOuterClassname() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getJavaOuterClassname() {
        Object object = this.javaOuterClassname_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.javaOuterClassname_ = string;
        return string;
    }

    @Override
    public ByteString getJavaOuterClassnameBytes() {
        ByteString byteString;
        Object object = this.javaOuterClassname_;
        if (!(object instanceof String)) return (ByteString)object;
        this.javaOuterClassname_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasJavaMultipleFiles() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    @Override
    public boolean hasJavaGenerateEqualsAndHash() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    @Override
    public boolean hasJavaStringCheckUtf8() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    @Override
    public boolean hasOptimizeFor() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode;
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode2 = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
        if (descriptorProtos$FileOptions$OptimizeMode2 == null) {
            descriptorProtos$FileOptions$OptimizeMode = DescriptorProtos$FileOptions$OptimizeMode.SPEED;
            return descriptorProtos$FileOptions$OptimizeMode;
        }
        descriptorProtos$FileOptions$OptimizeMode = descriptorProtos$FileOptions$OptimizeMode2;
        return descriptorProtos$FileOptions$OptimizeMode;
    }

    @Override
    public boolean hasGoPackage() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public String getGoPackage() {
        Object object = this.goPackage_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.goPackage_ = string;
        return string;
    }

    @Override
    public ByteString getGoPackageBytes() {
        ByteString byteString;
        Object object = this.goPackage_;
        if (!(object instanceof String)) return (ByteString)object;
        this.goPackage_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasCcGenericServices() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    @Override
    public boolean hasJavaGenericServices() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    @Override
    public boolean hasPyGenericServices() {
        if ((this.bitField0_ & 512) != 512) return false;
        return true;
    }

    @Override
    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 1024) != 1024) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    @Override
    public boolean hasCcEnableArenas() {
        if ((this.bitField0_ & 2048) != 2048) return false;
        return true;
    }

    @Override
    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    @Override
    public boolean hasObjcClassPrefix() {
        if ((this.bitField0_ & 4096) != 4096) return false;
        return true;
    }

    @Override
    public String getObjcClassPrefix() {
        Object object = this.objcClassPrefix_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.objcClassPrefix_ = string;
        return string;
    }

    @Override
    public ByteString getObjcClassPrefixBytes() {
        ByteString byteString;
        Object object = this.objcClassPrefix_;
        if (!(object instanceof String)) return (ByteString)object;
        this.objcClassPrefix_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasCsharpNamespace() {
        if ((this.bitField0_ & 8192) != 8192) return false;
        return true;
    }

    @Override
    public String getCsharpNamespace() {
        Object object = this.csharpNamespace_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.csharpNamespace_ = string;
        return string;
    }

    @Override
    public ByteString getCsharpNamespaceBytes() {
        ByteString byteString;
        Object object = this.csharpNamespace_;
        if (!(object instanceof String)) return (ByteString)object;
        this.csharpNamespace_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    @Override
    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    @Override
    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n2) {
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n2);
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
        for (int i2 = 0; i2 < this.getUninterpretedOptionCount(); ++i2) {
            if (this.getUninterpretedOption(i2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        GeneratedMessage$ExtendableMessage$ExtensionWriter generatedMessage$ExtendableMessage$ExtensionWriter = this.newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getJavaPackageBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(8, this.getJavaOuterClassnameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeEnum(9, this.optimizeFor_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBool(10, this.javaMultipleFiles_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeBytes(11, this.getGoPackageBytes());
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeBool(16, this.ccGenericServices_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeBool(17, this.javaGenericServices_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeBool(18, this.pyGenericServices_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBool(20, this.javaGenerateEqualsAndHash_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeBool(23, this.deprecated_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBool(27, this.javaStringCheckUtf8_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeBool(31, this.ccEnableArenas_);
        }
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.writeBytes(36, this.getObjcClassPrefixBytes());
        }
        if ((this.bitField0_ & 8192) == 8192) {
            codedOutputStream.writeBytes(37, this.getCsharpNamespaceBytes());
        }
        int n2 = 0;
        do {
            if (n2 >= this.uninterpretedOption_.size()) {
                generatedMessage$ExtendableMessage$ExtensionWriter.writeUntil(536870912, codedOutputStream);
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(999, (MessageLite)this.uninterpretedOption_.get(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getJavaPackageBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeBytesSize(8, this.getJavaOuterClassnameBytes());
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
        }
        if ((this.bitField0_ & 64) == 64) {
            n2 += CodedOutputStream.computeBytesSize(11, this.getGoPackageBytes());
        }
        if ((this.bitField0_ & 128) == 128) {
            n2 += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
        }
        if ((this.bitField0_ & 256) == 256) {
            n2 += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
        }
        if ((this.bitField0_ & 512) == 512) {
            n2 += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            n2 += CodedOutputStream.computeBoolSize(23, this.deprecated_);
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            n2 += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
        }
        if ((this.bitField0_ & 4096) == 4096) {
            n2 += CodedOutputStream.computeBytesSize(36, this.getObjcClassPrefixBytes());
        }
        if ((this.bitField0_ & 8192) == 8192) {
            n2 += CodedOutputStream.computeBytesSize(37, this.getCsharpNamespaceBytes());
        }
        int n3 = 0;
        do {
            if (n3 >= this.uninterpretedOption_.size()) {
                n2 += this.extensionsSerializedSize();
                this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(n3));
            ++n3;
        } while (true);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteString byteString) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] arrby) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$FileOptions$Builder newBuilderForType() {
        return DescriptorProtos$FileOptions.newBuilder();
    }

    public static DescriptorProtos$FileOptions$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$FileOptions$Builder newBuilder(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileOptions);
    }

    @Override
    public DescriptorProtos$FileOptions$Builder toBuilder() {
        DescriptorProtos$FileOptions$Builder descriptorProtos$FileOptions$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$FileOptions$Builder = new DescriptorProtos$FileOptions$Builder(null);
            return descriptorProtos$FileOptions$Builder;
        }
        descriptorProtos$FileOptions$Builder = new DescriptorProtos$FileOptions$Builder(null).mergeFrom(this);
        return descriptorProtos$FileOptions$Builder;
    }

    @Override
    protected DescriptorProtos$FileOptions$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileOptions$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$FileOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$FileOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$FileOptions(GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$ExtendableBuilder);
    }

    static /* synthetic */ Object access$13302(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.javaPackage_ = object;
        return descriptorProtos$FileOptions.javaPackage_;
    }

    static /* synthetic */ Object access$13402(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.javaOuterClassname_ = object;
        return descriptorProtos$FileOptions.javaOuterClassname_;
    }

    static /* synthetic */ boolean access$13502(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaMultipleFiles_ = bl2;
        return descriptorProtos$FileOptions.javaMultipleFiles_;
    }

    static /* synthetic */ boolean access$13602(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaGenerateEqualsAndHash_ = bl2;
        return descriptorProtos$FileOptions.javaGenerateEqualsAndHash_;
    }

    static /* synthetic */ boolean access$13702(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaStringCheckUtf8_ = bl2;
        return descriptorProtos$FileOptions.javaStringCheckUtf8_;
    }

    static /* synthetic */ int access$13802(DescriptorProtos$FileOptions descriptorProtos$FileOptions, int n2) {
        descriptorProtos$FileOptions.optimizeFor_ = n2;
        return descriptorProtos$FileOptions.optimizeFor_;
    }

    static /* synthetic */ Object access$13902(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.goPackage_ = object;
        return descriptorProtos$FileOptions.goPackage_;
    }

    static /* synthetic */ boolean access$14002(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.ccGenericServices_ = bl2;
        return descriptorProtos$FileOptions.ccGenericServices_;
    }

    static /* synthetic */ boolean access$14102(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.javaGenericServices_ = bl2;
        return descriptorProtos$FileOptions.javaGenericServices_;
    }

    static /* synthetic */ boolean access$14202(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.pyGenericServices_ = bl2;
        return descriptorProtos$FileOptions.pyGenericServices_;
    }

    static /* synthetic */ boolean access$14302(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.deprecated_ = bl2;
        return descriptorProtos$FileOptions.deprecated_;
    }

    static /* synthetic */ boolean access$14402(DescriptorProtos$FileOptions descriptorProtos$FileOptions, boolean bl2) {
        descriptorProtos$FileOptions.ccEnableArenas_ = bl2;
        return descriptorProtos$FileOptions.ccEnableArenas_;
    }

    static /* synthetic */ Object access$14502(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.objcClassPrefix_ = object;
        return descriptorProtos$FileOptions.objcClassPrefix_;
    }

    static /* synthetic */ Object access$14602(DescriptorProtos$FileOptions descriptorProtos$FileOptions, Object object) {
        descriptorProtos$FileOptions.csharpNamespace_ = object;
        return descriptorProtos$FileOptions.csharpNamespace_;
    }

    static /* synthetic */ List access$14702(DescriptorProtos$FileOptions descriptorProtos$FileOptions, List list) {
        descriptorProtos$FileOptions.uninterpretedOption_ = list;
        return descriptorProtos$FileOptions.uninterpretedOption_;
    }

    static /* synthetic */ int access$14802(DescriptorProtos$FileOptions descriptorProtos$FileOptions, int n2) {
        descriptorProtos$FileOptions.bitField0_ = n2;
        return descriptorProtos$FileOptions.bitField0_;
    }

    static /* synthetic */ Object access$13300(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.javaPackage_;
    }

    static /* synthetic */ Object access$13400(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.javaOuterClassname_;
    }

    static /* synthetic */ Object access$13900(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.goPackage_;
    }

    static /* synthetic */ Object access$14500(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.objcClassPrefix_;
    }

    static /* synthetic */ Object access$14600(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.csharpNamespace_;
    }

    static /* synthetic */ List access$14700(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return descriptorProtos$FileOptions.uninterpretedOption_;
    }

    /* synthetic */ DescriptorProtos$FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

