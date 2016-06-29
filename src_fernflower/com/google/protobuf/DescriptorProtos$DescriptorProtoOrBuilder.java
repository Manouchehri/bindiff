package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;
import java.util.List;

public interface DescriptorProtos$DescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   List getFieldList();

   DescriptorProtos$FieldDescriptorProto getField(int var1);

   int getFieldCount();

   List getFieldOrBuilderList();

   DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int var1);

   List getExtensionList();

   DescriptorProtos$FieldDescriptorProto getExtension(int var1);

   int getExtensionCount();

   List getExtensionOrBuilderList();

   DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1);

   List getNestedTypeList();

   DescriptorProtos$DescriptorProto getNestedType(int var1);

   int getNestedTypeCount();

   List getNestedTypeOrBuilderList();

   DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int var1);

   List getEnumTypeList();

   DescriptorProtos$EnumDescriptorProto getEnumType(int var1);

   int getEnumTypeCount();

   List getEnumTypeOrBuilderList();

   DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1);

   List getExtensionRangeList();

   DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int var1);

   int getExtensionRangeCount();

   List getExtensionRangeOrBuilderList();

   DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int var1);

   List getOneofDeclList();

   DescriptorProtos$OneofDescriptorProto getOneofDecl(int var1);

   int getOneofDeclCount();

   List getOneofDeclOrBuilderList();

   DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int var1);

   boolean hasOptions();

   DescriptorProtos$MessageOptions getOptions();

   DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder();

   List getReservedRangeList();

   DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int var1);

   int getReservedRangeCount();

   List getReservedRangeOrBuilderList();

   DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int var1);

   ProtocolStringList getReservedNameList();

   int getReservedNameCount();

   String getReservedName(int var1);

   ByteString getReservedNameBytes(int var1);
}
