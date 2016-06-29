package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$FieldDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   boolean hasNumber();

   int getNumber();

   boolean hasLabel();

   DescriptorProtos$FieldDescriptorProto$Label getLabel();

   boolean hasType();

   DescriptorProtos$FieldDescriptorProto$Type getType();

   boolean hasTypeName();

   String getTypeName();

   ByteString getTypeNameBytes();

   boolean hasExtendee();

   String getExtendee();

   ByteString getExtendeeBytes();

   boolean hasDefaultValue();

   String getDefaultValue();

   ByteString getDefaultValueBytes();

   boolean hasOneofIndex();

   int getOneofIndex();

   boolean hasOptions();

   DescriptorProtos$FieldOptions getOptions();

   DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder();
}
