/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FileOptionsOrBuilder
extends GeneratedMessage$ExtendableMessageOrBuilder {
    public boolean hasJavaPackage();

    public String getJavaPackage();

    public ByteString getJavaPackageBytes();

    public boolean hasJavaOuterClassname();

    public String getJavaOuterClassname();

    public ByteString getJavaOuterClassnameBytes();

    public boolean hasJavaMultipleFiles();

    public boolean getJavaMultipleFiles();

    public boolean hasJavaGenerateEqualsAndHash();

    public boolean getJavaGenerateEqualsAndHash();

    public boolean hasJavaStringCheckUtf8();

    public boolean getJavaStringCheckUtf8();

    public boolean hasOptimizeFor();

    public DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor();

    public boolean hasGoPackage();

    public String getGoPackage();

    public ByteString getGoPackageBytes();

    public boolean hasCcGenericServices();

    public boolean getCcGenericServices();

    public boolean hasJavaGenericServices();

    public boolean getJavaGenericServices();

    public boolean hasPyGenericServices();

    public boolean getPyGenericServices();

    public boolean hasDeprecated();

    public boolean getDeprecated();

    public boolean hasCcEnableArenas();

    public boolean getCcEnableArenas();

    public boolean hasObjcClassPrefix();

    public String getObjcClassPrefix();

    public ByteString getObjcClassPrefixBytes();

    public boolean hasCsharpNamespace();

    public String getCsharpNamespace();

    public ByteString getCsharpNamespaceBytes();

    public List getUninterpretedOptionList();

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

    public int getUninterpretedOptionCount();

    public List getUninterpretedOptionOrBuilderList();

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}

