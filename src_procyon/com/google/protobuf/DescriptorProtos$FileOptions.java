package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileOptions extends GeneratedMessage$ExtendableMessage implements DescriptorProtos$FileOptionsOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$FileOptions DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$FileOptions(final GeneratedMessage$ExtendableBuilder generatedMessage$ExtendableBuilder) {
        super(generatedMessage$ExtendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$FileOptions() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
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
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$FileOptions(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
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
                        if (!this.parseUnknownField(codedInputStream, builder, extensionRegistryLite, tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.javaPackage_ = bytes;
                        continue;
                    }
                    case 66: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x2;
                        this.javaOuterClassname_ = bytes2;
                        continue;
                    }
                    case 72: {
                        final int enum1 = codedInputStream.readEnum();
                        if (DescriptorProtos$FileOptions$OptimizeMode.valueOf(enum1) == null) {
                            builder.mergeVarintField(9, enum1);
                            continue;
                        }
                        this.bitField0_ |= 0x20;
                        this.optimizeFor_ = enum1;
                        continue;
                    }
                    case 80: {
                        this.bitField0_ |= 0x4;
                        this.javaMultipleFiles_ = codedInputStream.readBool();
                        continue;
                    }
                    case 90: {
                        final ByteString bytes3 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x40;
                        this.goPackage_ = bytes3;
                        continue;
                    }
                    case 128: {
                        this.bitField0_ |= 0x80;
                        this.ccGenericServices_ = codedInputStream.readBool();
                        continue;
                    }
                    case 136: {
                        this.bitField0_ |= 0x100;
                        this.javaGenericServices_ = codedInputStream.readBool();
                        continue;
                    }
                    case 144: {
                        this.bitField0_ |= 0x200;
                        this.pyGenericServices_ = codedInputStream.readBool();
                        continue;
                    }
                    case 160: {
                        this.bitField0_ |= 0x8;
                        this.javaGenerateEqualsAndHash_ = codedInputStream.readBool();
                        continue;
                    }
                    case 184: {
                        this.bitField0_ |= 0x400;
                        this.deprecated_ = codedInputStream.readBool();
                        continue;
                    }
                    case 216: {
                        this.bitField0_ |= 0x10;
                        this.javaStringCheckUtf8_ = codedInputStream.readBool();
                        continue;
                    }
                    case 248: {
                        this.bitField0_ |= 0x800;
                        this.ccEnableArenas_ = codedInputStream.readBool();
                        continue;
                    }
                    case 290: {
                        final ByteString bytes4 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1000;
                        this.objcClassPrefix_ = bytes4;
                        continue;
                    }
                    case 298: {
                        final ByteString bytes5 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x2000;
                        this.csharpNamespace_ = bytes5;
                        continue;
                    }
                    case 7994: {
                        if ((n & 0x4000) != 0x4000) {
                            this.uninterpretedOption_ = new ArrayList();
                            n |= 0x4000;
                        }
                        this.uninterpretedOption_.add(codedInputStream.readMessage(DescriptorProtos$UninterpretedOption.PARSER, extensionRegistryLite));
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
            if ((n & 0x4000) == 0x4000) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
    }
    
    public boolean hasJavaPackage() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getJavaPackage() {
        final Object javaPackage_ = this.javaPackage_;
        if (javaPackage_ instanceof String) {
            return (String)javaPackage_;
        }
        final ByteString byteString = (ByteString)javaPackage_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.javaPackage_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getJavaPackageBytes() {
        final Object javaPackage_ = this.javaPackage_;
        if (javaPackage_ instanceof String) {
            return (ByteString)(this.javaPackage_ = ByteString.copyFromUtf8((String)javaPackage_));
        }
        return (ByteString)javaPackage_;
    }
    
    public boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getJavaOuterClassname() {
        final Object javaOuterClassname_ = this.javaOuterClassname_;
        if (javaOuterClassname_ instanceof String) {
            return (String)javaOuterClassname_;
        }
        final ByteString byteString = (ByteString)javaOuterClassname_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.javaOuterClassname_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getJavaOuterClassnameBytes() {
        final Object javaOuterClassname_ = this.javaOuterClassname_;
        if (javaOuterClassname_ instanceof String) {
            return (ByteString)(this.javaOuterClassname_ = ByteString.copyFromUtf8((String)javaOuterClassname_));
        }
        return (ByteString)javaOuterClassname_;
    }
    
    public boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }
    
    public boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }
    
    public boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }
    
    public boolean hasOptimizeFor() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
        final DescriptorProtos$FileOptions$OptimizeMode value = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
        return (value == null) ? DescriptorProtos$FileOptions$OptimizeMode.SPEED : value;
    }
    
    public boolean hasGoPackage() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    public String getGoPackage() {
        final Object goPackage_ = this.goPackage_;
        if (goPackage_ instanceof String) {
            return (String)goPackage_;
        }
        final ByteString byteString = (ByteString)goPackage_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.goPackage_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getGoPackageBytes() {
        final Object goPackage_ = this.goPackage_;
        if (goPackage_ instanceof String) {
            return (ByteString)(this.goPackage_ = ByteString.copyFromUtf8((String)goPackage_));
        }
        return (ByteString)goPackage_;
    }
    
    public boolean hasCcGenericServices() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }
    
    public boolean hasJavaGenericServices() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }
    
    public boolean hasPyGenericServices() {
        return (this.bitField0_ & 0x200) == 0x200;
    }
    
    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x400) == 0x400;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public boolean hasCcEnableArenas() {
        return (this.bitField0_ & 0x800) == 0x800;
    }
    
    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }
    
    public boolean hasObjcClassPrefix() {
        return (this.bitField0_ & 0x1000) == 0x1000;
    }
    
    public String getObjcClassPrefix() {
        final Object objcClassPrefix_ = this.objcClassPrefix_;
        if (objcClassPrefix_ instanceof String) {
            return (String)objcClassPrefix_;
        }
        final ByteString byteString = (ByteString)objcClassPrefix_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.objcClassPrefix_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getObjcClassPrefixBytes() {
        final Object objcClassPrefix_ = this.objcClassPrefix_;
        if (objcClassPrefix_ instanceof String) {
            return (ByteString)(this.objcClassPrefix_ = ByteString.copyFromUtf8((String)objcClassPrefix_));
        }
        return (ByteString)objcClassPrefix_;
    }
    
    public boolean hasCsharpNamespace() {
        return (this.bitField0_ & 0x2000) == 0x2000;
    }
    
    public String getCsharpNamespace() {
        final Object csharpNamespace_ = this.csharpNamespace_;
        if (csharpNamespace_ instanceof String) {
            return (String)csharpNamespace_;
        }
        final ByteString byteString = (ByteString)csharpNamespace_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.csharpNamespace_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getCsharpNamespaceBytes() {
        final Object csharpNamespace_ = this.csharpNamespace_;
        if (csharpNamespace_ instanceof String) {
            return (ByteString)(this.csharpNamespace_ = ByteString.copyFromUtf8((String)csharpNamespace_));
        }
        return (ByteString)csharpNamespace_;
    }
    
    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }
    
    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }
    
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(final int n) {
        return this.uninterpretedOption_.get(n);
    }
    
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int n) {
        return this.uninterpretedOption_.get(n);
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        for (int i = 0; i < this.getUninterpretedOptionCount(); ++i) {
            if (!this.getUninterpretedOption(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (!this.extensionsAreInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        final GeneratedMessage$ExtendableMessage$ExtensionWriter extensionWriter = this.newExtensionWriter();
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getJavaPackageBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBytes(8, this.getJavaOuterClassnameBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeEnum(9, this.optimizeFor_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeBool(10, this.javaMultipleFiles_);
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            codedOutputStream.writeBytes(11, this.getGoPackageBytes());
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            codedOutputStream.writeBool(16, this.ccGenericServices_);
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            codedOutputStream.writeBool(17, this.javaGenericServices_);
        }
        if ((this.bitField0_ & 0x200) == 0x200) {
            codedOutputStream.writeBool(18, this.pyGenericServices_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBool(20, this.javaGenerateEqualsAndHash_);
        }
        if ((this.bitField0_ & 0x400) == 0x400) {
            codedOutputStream.writeBool(23, this.deprecated_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBool(27, this.javaStringCheckUtf8_);
        }
        if ((this.bitField0_ & 0x800) == 0x800) {
            codedOutputStream.writeBool(31, this.ccEnableArenas_);
        }
        if ((this.bitField0_ & 0x1000) == 0x1000) {
            codedOutputStream.writeBytes(36, this.getObjcClassPrefixBytes());
        }
        if ((this.bitField0_ & 0x2000) == 0x2000) {
            codedOutputStream.writeBytes(37, this.getCsharpNamespaceBytes());
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            codedOutputStream.writeMessage(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        extensionWriter.writeUntil(536870912, codedOutputStream);
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(1, this.getJavaPackageBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBytesSize(8, this.getJavaOuterClassnameBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            n += CodedOutputStream.computeBytesSize(11, this.getGoPackageBytes());
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            n += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            n += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
        }
        if ((this.bitField0_ & 0x200) == 0x200) {
            n += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
        }
        if ((this.bitField0_ & 0x400) == 0x400) {
            n += CodedOutputStream.computeBoolSize(23, this.deprecated_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
        }
        if ((this.bitField0_ & 0x800) == 0x800) {
            n += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
        }
        if ((this.bitField0_ & 0x1000) == 0x1000) {
            n += CodedOutputStream.computeBytesSize(36, this.getObjcClassPrefixBytes());
        }
        if ((this.bitField0_ & 0x2000) == 0x2000) {
            n += CodedOutputStream.computeBytesSize(37, this.getCsharpNamespaceBytes());
        }
        for (int i = 0; i < this.uninterpretedOption_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(999, (MessageLite)this.uninterpretedOption_.get(i));
        }
        return this.memoizedSerializedSize = n + this.extensionsSerializedSize() + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final ByteString byteString) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final byte[] array) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileOptions parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$FileOptions parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$FileOptions parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$FileOptions$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$FileOptions$Builder newBuilder() {
        return DescriptorProtos$FileOptions.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$FileOptions$Builder newBuilder(final DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return DescriptorProtos$FileOptions.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$FileOptions);
    }
    
    public DescriptorProtos$FileOptions$Builder toBuilder() {
        return (this == DescriptorProtos$FileOptions.DEFAULT_INSTANCE) ? new DescriptorProtos$FileOptions$Builder((DescriptorProtos$1)null) : new DescriptorProtos$FileOptions$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$FileOptions$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$FileOptions$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$FileOptions getDefaultInstance() {
        return DescriptorProtos$FileOptions.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$FileOptions.PARSER;
    }
    
    public DescriptorProtos$FileOptions getDefaultInstanceForType() {
        return DescriptorProtos$FileOptions.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$FileOptions();
        PARSER = new DescriptorProtos$FileOptions$1();
    }
}
