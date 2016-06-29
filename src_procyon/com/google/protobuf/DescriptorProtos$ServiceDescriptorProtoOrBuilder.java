package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$ServiceDescriptorProtoOrBuilder extends MessageOrBuilder
{
    boolean hasName();
    
    String getName();
    
    ByteString getNameBytes();
    
    List getMethodList();
    
    DescriptorProtos$MethodDescriptorProto getMethod(final int p0);
    
    int getMethodCount();
    
    List getMethodOrBuilderList();
    
    DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(final int p0);
    
    boolean hasOptions();
    
    DescriptorProtos$ServiceOptions getOptions();
    
    DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder();
}
