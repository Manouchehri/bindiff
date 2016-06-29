package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$FileDescriptorProtoOrBuilder extends MessageOrBuilder
{
    boolean hasName();
    
    String getName();
    
    ByteString getNameBytes();
    
    boolean hasPackage();
    
    String getPackage();
    
    ByteString getPackageBytes();
    
    ProtocolStringList getDependencyList();
    
    int getDependencyCount();
    
    String getDependency(final int p0);
    
    ByteString getDependencyBytes(final int p0);
    
    List getPublicDependencyList();
    
    int getPublicDependencyCount();
    
    int getPublicDependency(final int p0);
    
    List getWeakDependencyList();
    
    int getWeakDependencyCount();
    
    int getWeakDependency(final int p0);
    
    List getMessageTypeList();
    
    DescriptorProtos$DescriptorProto getMessageType(final int p0);
    
    int getMessageTypeCount();
    
    List getMessageTypeOrBuilderList();
    
    DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(final int p0);
    
    List getEnumTypeList();
    
    DescriptorProtos$EnumDescriptorProto getEnumType(final int p0);
    
    int getEnumTypeCount();
    
    List getEnumTypeOrBuilderList();
    
    DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(final int p0);
    
    List getServiceList();
    
    DescriptorProtos$ServiceDescriptorProto getService(final int p0);
    
    int getServiceCount();
    
    List getServiceOrBuilderList();
    
    DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(final int p0);
    
    List getExtensionList();
    
    DescriptorProtos$FieldDescriptorProto getExtension(final int p0);
    
    int getExtensionCount();
    
    List getExtensionOrBuilderList();
    
    DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(final int p0);
    
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
