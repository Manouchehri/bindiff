package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$EnumDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   List getValueList();

   DescriptorProtos$EnumValueDescriptorProto getValue(int var1);

   int getValueCount();

   List getValueOrBuilderList();

   DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int var1);

   boolean hasOptions();

   DescriptorProtos$EnumOptions getOptions();

   DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder();
}
