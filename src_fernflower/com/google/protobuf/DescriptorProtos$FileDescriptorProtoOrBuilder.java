package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;
import java.util.List;

public interface DescriptorProtos$FileDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   boolean hasPackage();

   String getPackage();

   ByteString getPackageBytes();

   ProtocolStringList getDependencyList();

   int getDependencyCount();

   String getDependency(int var1);

   ByteString getDependencyBytes(int var1);

   List getPublicDependencyList();

   int getPublicDependencyCount();

   int getPublicDependency(int var1);

   List getWeakDependencyList();

   int getWeakDependencyCount();

   int getWeakDependency(int var1);

   List getMessageTypeList();

   DescriptorProtos$DescriptorProto getMessageType(int var1);

   int getMessageTypeCount();

   List getMessageTypeOrBuilderList();

   DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int var1);

   List getEnumTypeList();

   DescriptorProtos$EnumDescriptorProto getEnumType(int var1);

   int getEnumTypeCount();

   List getEnumTypeOrBuilderList();

   DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1);

   List getServiceList();

   DescriptorProtos$ServiceDescriptorProto getService(int var1);

   int getServiceCount();

   List getServiceOrBuilderList();

   DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int var1);

   List getExtensionList();

   DescriptorProtos$FieldDescriptorProto getExtension(int var1);

   int getExtensionCount();

   List getExtensionOrBuilderList();

   DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1);

   boolean hasOptions();

   DescriptorProtos$FileOptions getOptions();

   DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder();

   boolean hasSourceCodeInfo();

   DescriptorProtos$SourceCodeInfo getSourceCodeInfo();

   DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();

   boolean hasSyntax();

   String getSyntax();

   ByteString getSyntaxBytes();
}
