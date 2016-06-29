package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$EnumValueDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   boolean hasNumber();

   int getNumber();

   boolean hasOptions();

   DescriptorProtos$EnumValueOptions getOptions();

   DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder();
}
