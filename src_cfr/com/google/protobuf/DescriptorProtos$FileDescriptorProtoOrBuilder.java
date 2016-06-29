/*
 * Decompiled with CFR 0_115.
 */
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

public interface DescriptorProtos$FileDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean hasName();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasPackage();

    public String getPackage();

    public ByteString getPackageBytes();

    public ProtocolStringList getDependencyList();

    public int getDependencyCount();

    public String getDependency(int var1);

    public ByteString getDependencyBytes(int var1);

    public List getPublicDependencyList();

    public int getPublicDependencyCount();

    public int getPublicDependency(int var1);

    public List getWeakDependencyList();

    public int getWeakDependencyCount();

    public int getWeakDependency(int var1);

    public List getMessageTypeList();

    public DescriptorProtos$DescriptorProto getMessageType(int var1);

    public int getMessageTypeCount();

    public List getMessageTypeOrBuilderList();

    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int var1);

    public List getEnumTypeList();

    public DescriptorProtos$EnumDescriptorProto getEnumType(int var1);

    public int getEnumTypeCount();

    public List getEnumTypeOrBuilderList();

    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int var1);

    public List getServiceList();

    public DescriptorProtos$ServiceDescriptorProto getService(int var1);

    public int getServiceCount();

    public List getServiceOrBuilderList();

    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int var1);

    public List getExtensionList();

    public DescriptorProtos$FieldDescriptorProto getExtension(int var1);

    public int getExtensionCount();

    public List getExtensionOrBuilderList();

    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int var1);

    public boolean hasOptions();

    public DescriptorProtos$FileOptions getOptions();

    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder();

    public boolean hasSourceCodeInfo();

    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo();

    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();

    public boolean hasSyntax();

    public String getSyntax();

    public ByteString getSyntaxBytes();
}

