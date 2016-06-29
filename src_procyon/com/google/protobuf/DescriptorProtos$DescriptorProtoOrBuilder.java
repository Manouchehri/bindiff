package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$DescriptorProtoOrBuilder extends MessageOrBuilder
{
    boolean hasName();
    
    String getName();
    
    ByteString getNameBytes();
    
    List getFieldList();
    
    DescriptorProtos$FieldDescriptorProto getField(final int p0);
    
    int getFieldCount();
    
    List getFieldOrBuilderList();
    
    DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(final int p0);
    
    List getExtensionList();
    
    DescriptorProtos$FieldDescriptorProto getExtension(final int p0);
    
    int getExtensionCount();
    
    List getExtensionOrBuilderList();
    
    DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(final int p0);
    
    List getNestedTypeList();
    
    DescriptorProtos$DescriptorProto getNestedType(final int p0);
    
    int getNestedTypeCount();
    
    List getNestedTypeOrBuilderList();
    
    DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(final int p0);
    
    List getEnumTypeList();
    
    DescriptorProtos$EnumDescriptorProto getEnumType(final int p0);
    
    int getEnumTypeCount();
    
    List getEnumTypeOrBuilderList();
    
    DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(final int p0);
    
    List getExtensionRangeList();
    
    DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(final int p0);
    
    int getExtensionRangeCount();
    
    List getExtensionRangeOrBuilderList();
    
    DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(final int p0);
    
    List getOneofDeclList();
    
    DescriptorProtos$OneofDescriptorProto getOneofDecl(final int p0);
    
    int getOneofDeclCount();
    
    List getOneofDeclOrBuilderList();
    
    DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(final int p0);
    
    boolean hasOptions();
    
    DescriptorProtos$MessageOptions getOptions();
    
    DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder();
    
    List getReservedRangeList();
    
    DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(final int p0);
    
    int getReservedRangeCount();
    
    List getReservedRangeOrBuilderList();
    
    DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(final int p0);
    
    ProtocolStringList getReservedNameList();
    
    int getReservedNameCount();
    
    String getReservedName(final int p0);
    
    ByteString getReservedNameBytes(final int p0);
}
