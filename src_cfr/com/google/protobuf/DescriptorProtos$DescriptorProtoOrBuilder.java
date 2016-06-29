/*
 * Decompiled with CFR 0_115.
 */
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

public interface DescriptorProtos$DescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public List getFieldList();

    public DescriptorProtos$FieldDescriptorProto getField(int var1);

    public int getFieldCount();

    public List getFieldOrBuilderList();

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int var1);

    public List getExtensionList();

    public DescriptorProtos$FieldDescriptorProto getExtension(int var1);

    public int getExtensionCount();

    public List getExtensionOrBuilderList();

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1);

    public List getNestedTypeList();

    public DescriptorProtos$DescriptorProto getNestedType(int var1);

    public int getNestedTypeCount();

    public List getNestedTypeOrBuilderList();

    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int var1);

    public List getEnumTypeList();

    public DescriptorProtos$EnumDescriptorProto getEnumType(int var1);

    public int getEnumTypeCount();

    public List getEnumTypeOrBuilderList();

    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1);

    public List getExtensionRangeList();

    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(int var1);

    public int getExtensionRangeCount();

    public List getExtensionRangeOrBuilderList();

    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int var1);

    public List getOneofDeclList();

    public DescriptorProtos$OneofDescriptorProto getOneofDecl(int var1);

    public int getOneofDeclCount();

    public List getOneofDeclOrBuilderList();

    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int var1);

    public boolean hasOptions();

    public DescriptorProtos$MessageOptions getOptions();

    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder();

    public List getReservedRangeList();

    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(int var1);

    public int getReservedRangeCount();

    public List getReservedRangeOrBuilderList();

    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(int var1);

    public ProtocolStringList getReservedNameList();

    public int getReservedNameCount();

    public String getReservedName(int var1);

    public ByteString getReservedNameBytes(int var1);
}

