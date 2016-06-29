package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$ServiceDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   List getMethodList();

   DescriptorProtos$MethodDescriptorProto getMethod(int var1);

   int getMethodCount();

   List getMethodOrBuilderList();

   DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int var1);

   boolean hasOptions();

   DescriptorProtos$ServiceOptions getOptions();

   DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder();
}
