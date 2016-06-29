package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$FileOptionsOrBuilder
{
    private int bitField0_;
    private Object javaPackage_;
    private Object javaOuterClassname_;
    private boolean javaMultipleFiles_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaStringCheckUtf8_;
    private int optimizeFor_;
    private Object goPackage_;
    private boolean ccGenericServices_;
    private boolean javaGenericServices_;
    private boolean pyGenericServices_;
    private boolean deprecated_;
    private boolean ccEnableArenas_;
    private Object objcClassPrefix_;
    private Object csharpNamespace_;
    private List uninterpretedOption_;
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileOptions.class, DescriptorProtos$FileOptions$Builder.class);
    }
    
    private DescriptorProtos$FileOptions$Builder() {
        this.javaPackage_ = "";
        this.javaOuterClassname_ = "";
        this.optimizeFor_ = 1;
        this.goPackage_ = "";
        this.objcClassPrefix_ = "";
        this.csharpNamespace_ = "";
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$FileOptions$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.javaPackage_ = "";
        this.javaOuterClassname_ = "";
        this.optimizeFor_ = 1;
        this.goPackage_ = "";
        this.objcClassPrefix_ = "";
        this.csharpNamespace_ = "";
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }
    
    public DescriptorProtos$FileOptions$Builder clear() {
        super.clear();
        this.javaPackage_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.javaOuterClassname_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.javaMultipleFiles_ = false;
        this.bitField0_ &= 0xFFFFFFFB;
        this.javaGenerateEqualsAndHash_ = false;
        this.bitField0_ &= 0xFFFFFFF7;
        this.javaStringCheckUtf8_ = false;
        this.bitField0_ &= 0xFFFFFFEF;
        this.optimizeFor_ = 1;
        this.bitField0_ &= 0xFFFFFFDF;
        this.goPackage_ = "";
        this.bitField0_ &= 0xFFFFFFBF;
        this.ccGenericServices_ = false;
        this.bitField0_ &= 0xFFFFFF7F;
        this.javaGenericServices_ = false;
        this.bitField0_ &= 0xFFFFFEFF;
        this.pyGenericServices_ = false;
        this.bitField0_ &= 0xFFFFFDFF;
        this.deprecated_ = false;
        this.bitField0_ &= 0xFFFFFBFF;
        this.ccEnableArenas_ = false;
        this.bitField0_ &= 0xFFFFF7FF;
        this.objcClassPrefix_ = "";
        this.bitField0_ &= 0xFFFFEFFF;
        this.csharpNamespace_ = "";
        this.bitField0_ &= 0xFFFFDFFF;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFBFFF;
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
    }
    
    public DescriptorProtos$FileOptions getDefaultInstanceForType() {
        return DescriptorProtos$FileOptions.getDefaultInstance();
    }
    
    public DescriptorProtos$FileOptions build() {
        final DescriptorProtos$FileOptions buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$FileOptions buildPartial() {
        final DescriptorProtos$FileOptions descriptorProtos$FileOptions = new DescriptorProtos$FileOptions(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$FileOptions.javaPackage_ = this.javaPackage_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$FileOptions.javaOuterClassname_ = this.javaOuterClassname_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        descriptorProtos$FileOptions.javaMultipleFiles_ = this.javaMultipleFiles_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        descriptorProtos$FileOptions.javaGenerateEqualsAndHash_ = this.javaGenerateEqualsAndHash_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        descriptorProtos$FileOptions.javaStringCheckUtf8_ = this.javaStringCheckUtf8_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        descriptorProtos$FileOptions.optimizeFor_ = this.optimizeFor_;
        if ((bitField0_ & 0x40) == 0x40) {
            n |= 0x40;
        }
        descriptorProtos$FileOptions.goPackage_ = this.goPackage_;
        if ((bitField0_ & 0x80) == 0x80) {
            n |= 0x80;
        }
        descriptorProtos$FileOptions.ccGenericServices_ = this.ccGenericServices_;
        if ((bitField0_ & 0x100) == 0x100) {
            n |= 0x100;
        }
        descriptorProtos$FileOptions.javaGenericServices_ = this.javaGenericServices_;
        if ((bitField0_ & 0x200) == 0x200) {
            n |= 0x200;
        }
        descriptorProtos$FileOptions.pyGenericServices_ = this.pyGenericServices_;
        if ((bitField0_ & 0x400) == 0x400) {
            n |= 0x400;
        }
        descriptorProtos$FileOptions.deprecated_ = this.deprecated_;
        if ((bitField0_ & 0x800) == 0x800) {
            n |= 0x800;
        }
        descriptorProtos$FileOptions.ccEnableArenas_ = this.ccEnableArenas_;
        if ((bitField0_ & 0x1000) == 0x1000) {
            n |= 0x1000;
        }
        descriptorProtos$FileOptions.objcClassPrefix_ = this.objcClassPrefix_;
        if ((bitField0_ & 0x2000) == 0x2000) {
            n |= 0x2000;
        }
        descriptorProtos$FileOptions.csharpNamespace_ = this.csharpNamespace_;
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 0x4000) == 0x4000) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
                this.bitField0_ &= 0xFFFFBFFF;
            }
            descriptorProtos$FileOptions.uninterpretedOption_ = this.uninterpretedOption_;
        }
        else {
            descriptorProtos$FileOptions.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
        }
        descriptorProtos$FileOptions.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$FileOptions;
    }
    
    public DescriptorProtos$FileOptions$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$FileOptions) {
            return this.mergeFrom((DescriptorProtos$FileOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder mergeFrom(final DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        if (descriptorProtos$FileOptions == DescriptorProtos$FileOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FileOptions.hasJavaPackage()) {
            this.bitField0_ |= 0x1;
            this.javaPackage_ = descriptorProtos$FileOptions.javaPackage_;
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasJavaOuterClassname()) {
            this.bitField0_ |= 0x2;
            this.javaOuterClassname_ = descriptorProtos$FileOptions.javaOuterClassname_;
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasJavaMultipleFiles()) {
            this.setJavaMultipleFiles(descriptorProtos$FileOptions.getJavaMultipleFiles());
        }
        if (descriptorProtos$FileOptions.hasJavaGenerateEqualsAndHash()) {
            this.setJavaGenerateEqualsAndHash(descriptorProtos$FileOptions.getJavaGenerateEqualsAndHash());
        }
        if (descriptorProtos$FileOptions.hasJavaStringCheckUtf8()) {
            this.setJavaStringCheckUtf8(descriptorProtos$FileOptions.getJavaStringCheckUtf8());
        }
        if (descriptorProtos$FileOptions.hasOptimizeFor()) {
            this.setOptimizeFor(descriptorProtos$FileOptions.getOptimizeFor());
        }
        if (descriptorProtos$FileOptions.hasGoPackage()) {
            this.bitField0_ |= 0x40;
            this.goPackage_ = descriptorProtos$FileOptions.goPackage_;
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasCcGenericServices()) {
            this.setCcGenericServices(descriptorProtos$FileOptions.getCcGenericServices());
        }
        if (descriptorProtos$FileOptions.hasJavaGenericServices()) {
            this.setJavaGenericServices(descriptorProtos$FileOptions.getJavaGenericServices());
        }
        if (descriptorProtos$FileOptions.hasPyGenericServices()) {
            this.setPyGenericServices(descriptorProtos$FileOptions.getPyGenericServices());
        }
        if (descriptorProtos$FileOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$FileOptions.getDeprecated());
        }
        if (descriptorProtos$FileOptions.hasCcEnableArenas()) {
            this.setCcEnableArenas(descriptorProtos$FileOptions.getCcEnableArenas());
        }
        if (descriptorProtos$FileOptions.hasObjcClassPrefix()) {
            this.bitField0_ |= 0x1000;
            this.objcClassPrefix_ = descriptorProtos$FileOptions.objcClassPrefix_;
            this.onChanged();
        }
        if (descriptorProtos$FileOptions.hasCsharpNamespace()) {
            this.bitField0_ |= 0x2000;
            this.csharpNamespace_ = descriptorProtos$FileOptions.csharpNamespace_;
            this.onChanged();
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!descriptorProtos$FileOptions.uninterpretedOption_.isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = descriptorProtos$FileOptions.uninterpretedOption_;
                    this.bitField0_ &= 0xFFFFBFFF;
                }
                else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(descriptorProtos$FileOptions.uninterpretedOption_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FileOptions.uninterpretedOption_.isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = descriptorProtos$FileOptions.uninterpretedOption_;
                this.bitField0_ &= 0xFFFFBFFF;
                this.uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null);
            }
            else {
                this.uninterpretedOptionBuilder_.addAllMessages(descriptorProtos$FileOptions.uninterpretedOption_);
            }
        }
        this.mergeExtensionFields(descriptorProtos$FileOptions);
        this.mergeUnknownFields(descriptorProtos$FileOptions.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getUninterpretedOptionCount(); ++i) {
            if (!this.getUninterpretedOption(i).isInitialized()) {
                return false;
            }
        }
        return this.extensionsAreInitialized();
    }
    
    public DescriptorProtos$FileOptions$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = null;
        try {
            descriptorProtos$FileOptions = (DescriptorProtos$FileOptions)DescriptorProtos$FileOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$FileOptions = (DescriptorProtos$FileOptions)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$FileOptions != null) {
                this.mergeFrom(descriptorProtos$FileOptions);
            }
        }
        return this;
    }
    
    public boolean hasJavaPackage() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getJavaPackage() {
        final Object javaPackage_ = this.javaPackage_;
        if (!(javaPackage_ instanceof String)) {
            final ByteString byteString = (ByteString)javaPackage_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaPackage_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)javaPackage_;
    }
    
    public ByteString getJavaPackageBytes() {
        final Object javaPackage_ = this.javaPackage_;
        if (javaPackage_ instanceof String) {
            return (ByteString)(this.javaPackage_ = ByteString.copyFromUtf8((String)javaPackage_));
        }
        return (ByteString)javaPackage_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaPackage(final String javaPackage_) {
        if (javaPackage_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.javaPackage_ = javaPackage_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaPackage() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.javaPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaPackage();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaPackageBytes(final ByteString javaPackage_) {
        if (javaPackage_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.javaPackage_ = javaPackage_;
        this.onChanged();
        return this;
    }
    
    public boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getJavaOuterClassname() {
        final Object javaOuterClassname_ = this.javaOuterClassname_;
        if (!(javaOuterClassname_ instanceof String)) {
            final ByteString byteString = (ByteString)javaOuterClassname_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaOuterClassname_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)javaOuterClassname_;
    }
    
    public ByteString getJavaOuterClassnameBytes() {
        final Object javaOuterClassname_ = this.javaOuterClassname_;
        if (javaOuterClassname_ instanceof String) {
            return (ByteString)(this.javaOuterClassname_ = ByteString.copyFromUtf8((String)javaOuterClassname_));
        }
        return (ByteString)javaOuterClassname_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaOuterClassname(final String javaOuterClassname_) {
        if (javaOuterClassname_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.javaOuterClassname_ = javaOuterClassname_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaOuterClassname() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.javaOuterClassname_ = DescriptorProtos$FileOptions.getDefaultInstance().getJavaOuterClassname();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaOuterClassnameBytes(final ByteString javaOuterClassname_) {
        if (javaOuterClassname_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.javaOuterClassname_ = javaOuterClassname_;
        this.onChanged();
        return this;
    }
    
    public boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaMultipleFiles(final boolean javaMultipleFiles_) {
        this.bitField0_ |= 0x4;
        this.javaMultipleFiles_ = javaMultipleFiles_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaMultipleFiles() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.javaMultipleFiles_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaGenerateEqualsAndHash(final boolean javaGenerateEqualsAndHash_) {
        this.bitField0_ |= 0x8;
        this.javaGenerateEqualsAndHash_ = javaGenerateEqualsAndHash_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaGenerateEqualsAndHash() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.javaGenerateEqualsAndHash_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaStringCheckUtf8(final boolean javaStringCheckUtf8_) {
        this.bitField0_ |= 0x10;
        this.javaStringCheckUtf8_ = javaStringCheckUtf8_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaStringCheckUtf8() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.javaStringCheckUtf8_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasOptimizeFor() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor() {
        final DescriptorProtos$FileOptions$OptimizeMode value = DescriptorProtos$FileOptions$OptimizeMode.valueOf(this.optimizeFor_);
        return (value == null) ? DescriptorProtos$FileOptions$OptimizeMode.SPEED : value;
    }
    
    public DescriptorProtos$FileOptions$Builder setOptimizeFor(final DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode) {
        if (descriptorProtos$FileOptions$OptimizeMode == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.optimizeFor_ = descriptorProtos$FileOptions$OptimizeMode.getNumber();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearOptimizeFor() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.optimizeFor_ = 1;
        this.onChanged();
        return this;
    }
    
    public boolean hasGoPackage() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    public String getGoPackage() {
        final Object goPackage_ = this.goPackage_;
        if (!(goPackage_ instanceof String)) {
            final ByteString byteString = (ByteString)goPackage_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.goPackage_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)goPackage_;
    }
    
    public ByteString getGoPackageBytes() {
        final Object goPackage_ = this.goPackage_;
        if (goPackage_ instanceof String) {
            return (ByteString)(this.goPackage_ = ByteString.copyFromUtf8((String)goPackage_));
        }
        return (ByteString)goPackage_;
    }
    
    public DescriptorProtos$FileOptions$Builder setGoPackage(final String goPackage_) {
        if (goPackage_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.goPackage_ = goPackage_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearGoPackage() {
        this.bitField0_ &= 0xFFFFFFBF;
        this.goPackage_ = DescriptorProtos$FileOptions.getDefaultInstance().getGoPackage();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setGoPackageBytes(final ByteString goPackage_) {
        if (goPackage_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.goPackage_ = goPackage_;
        this.onChanged();
        return this;
    }
    
    public boolean hasCcGenericServices() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }
    
    public DescriptorProtos$FileOptions$Builder setCcGenericServices(final boolean ccGenericServices_) {
        this.bitField0_ |= 0x80;
        this.ccGenericServices_ = ccGenericServices_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearCcGenericServices() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.ccGenericServices_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasJavaGenericServices() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }
    
    public DescriptorProtos$FileOptions$Builder setJavaGenericServices(final boolean javaGenericServices_) {
        this.bitField0_ |= 0x100;
        this.javaGenericServices_ = javaGenericServices_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearJavaGenericServices() {
        this.bitField0_ &= 0xFFFFFEFF;
        this.javaGenericServices_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasPyGenericServices() {
        return (this.bitField0_ & 0x200) == 0x200;
    }
    
    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }
    
    public DescriptorProtos$FileOptions$Builder setPyGenericServices(final boolean pyGenericServices_) {
        this.bitField0_ |= 0x200;
        this.pyGenericServices_ = pyGenericServices_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearPyGenericServices() {
        this.bitField0_ &= 0xFFFFFDFF;
        this.pyGenericServices_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x400) == 0x400;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public DescriptorProtos$FileOptions$Builder setDeprecated(final boolean deprecated_) {
        this.bitField0_ |= 0x400;
        this.deprecated_ = deprecated_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearDeprecated() {
        this.bitField0_ &= 0xFFFFFBFF;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasCcEnableArenas() {
        return (this.bitField0_ & 0x800) == 0x800;
    }
    
    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }
    
    public DescriptorProtos$FileOptions$Builder setCcEnableArenas(final boolean ccEnableArenas_) {
        this.bitField0_ |= 0x800;
        this.ccEnableArenas_ = ccEnableArenas_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearCcEnableArenas() {
        this.bitField0_ &= 0xFFFFF7FF;
        this.ccEnableArenas_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasObjcClassPrefix() {
        return (this.bitField0_ & 0x1000) == 0x1000;
    }
    
    public String getObjcClassPrefix() {
        final Object objcClassPrefix_ = this.objcClassPrefix_;
        if (!(objcClassPrefix_ instanceof String)) {
            final ByteString byteString = (ByteString)objcClassPrefix_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.objcClassPrefix_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)objcClassPrefix_;
    }
    
    public ByteString getObjcClassPrefixBytes() {
        final Object objcClassPrefix_ = this.objcClassPrefix_;
        if (objcClassPrefix_ instanceof String) {
            return (ByteString)(this.objcClassPrefix_ = ByteString.copyFromUtf8((String)objcClassPrefix_));
        }
        return (ByteString)objcClassPrefix_;
    }
    
    public DescriptorProtos$FileOptions$Builder setObjcClassPrefix(final String objcClassPrefix_) {
        if (objcClassPrefix_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1000;
        this.objcClassPrefix_ = objcClassPrefix_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearObjcClassPrefix() {
        this.bitField0_ &= 0xFFFFEFFF;
        this.objcClassPrefix_ = DescriptorProtos$FileOptions.getDefaultInstance().getObjcClassPrefix();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setObjcClassPrefixBytes(final ByteString objcClassPrefix_) {
        if (objcClassPrefix_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1000;
        this.objcClassPrefix_ = objcClassPrefix_;
        this.onChanged();
        return this;
    }
    
    public boolean hasCsharpNamespace() {
        return (this.bitField0_ & 0x2000) == 0x2000;
    }
    
    public String getCsharpNamespace() {
        final Object csharpNamespace_ = this.csharpNamespace_;
        if (!(csharpNamespace_ instanceof String)) {
            final ByteString byteString = (ByteString)csharpNamespace_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.csharpNamespace_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)csharpNamespace_;
    }
    
    public ByteString getCsharpNamespaceBytes() {
        final Object csharpNamespace_ = this.csharpNamespace_;
        if (csharpNamespace_ instanceof String) {
            return (ByteString)(this.csharpNamespace_ = ByteString.copyFromUtf8((String)csharpNamespace_));
        }
        return (ByteString)csharpNamespace_;
    }
    
    public DescriptorProtos$FileOptions$Builder setCsharpNamespace(final String csharpNamespace_) {
        if (csharpNamespace_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2000;
        this.csharpNamespace_ = csharpNamespace_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearCsharpNamespace() {
        this.bitField0_ &= 0xFFFFDFFF;
        this.csharpNamespace_ = DescriptorProtos$FileOptions.getDefaultInstance().getCsharpNamespace();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setCsharpNamespaceBytes(final ByteString csharpNamespace_) {
        if (csharpNamespace_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2000;
        this.csharpNamespace_ = csharpNamespace_;
        this.onChanged();
        return this;
    }
    
    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 0x4000) != 0x4000) {
            this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
            this.bitField0_ |= 0x4000;
        }
    }
    
    public List getUninterpretedOptionList() {
        if (this.uninterpretedOptionBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
        }
        return this.uninterpretedOptionBuilder_.getMessageList();
    }
    
    public int getUninterpretedOptionCount() {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.size();
        }
        return this.uninterpretedOptionBuilder_.getCount();
    }
    
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.get(n);
        }
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n, descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.setMessage(n, descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.setMessage(n, descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n, descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(n, descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(n, descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder addAllUninterpretedOption(final Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFBFFF;
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder removeUninterpretedOption(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(n);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.get(n);
        }
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(n);
    }
    
    public List getUninterpretedOptionOrBuilderList() {
        if (this.uninterpretedOptionBuilder_ != null) {
            return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(n, DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }
    
    public List getUninterpretedOptionBuilderList() {
        return this.getUninterpretedOptionFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 0x4000) == 0x4000, this.getParentForChildren(), this.isClean());
            this.uninterpretedOption_ = null;
        }
        return this.uninterpretedOptionBuilder_;
    }
}
