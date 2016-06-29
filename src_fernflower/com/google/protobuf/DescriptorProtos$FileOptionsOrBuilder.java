package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FileOptionsOrBuilder extends GeneratedMessage$ExtendableMessageOrBuilder {
   boolean hasJavaPackage();

   String getJavaPackage();

   ByteString getJavaPackageBytes();

   boolean hasJavaOuterClassname();

   String getJavaOuterClassname();

   ByteString getJavaOuterClassnameBytes();

   boolean hasJavaMultipleFiles();

   boolean getJavaMultipleFiles();

   boolean hasJavaGenerateEqualsAndHash();

   boolean getJavaGenerateEqualsAndHash();

   boolean hasJavaStringCheckUtf8();

   boolean getJavaStringCheckUtf8();

   boolean hasOptimizeFor();

   DescriptorProtos$FileOptions$OptimizeMode getOptimizeFor();

   boolean hasGoPackage();

   String getGoPackage();

   ByteString getGoPackageBytes();

   boolean hasCcGenericServices();

   boolean getCcGenericServices();

   boolean hasJavaGenericServices();

   boolean getJavaGenericServices();

   boolean hasPyGenericServices();

   boolean getPyGenericServices();

   boolean hasDeprecated();

   boolean getDeprecated();

   boolean hasCcEnableArenas();

   boolean getCcEnableArenas();

   boolean hasObjcClassPrefix();

   String getObjcClassPrefix();

   ByteString getObjcClassPrefixBytes();

   boolean hasCsharpNamespace();

   String getCsharpNamespace();

   ByteString getCsharpNamespaceBytes();

   List getUninterpretedOptionList();

   DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

   int getUninterpretedOptionCount();

   List getUninterpretedOptionOrBuilderList();

   DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}
