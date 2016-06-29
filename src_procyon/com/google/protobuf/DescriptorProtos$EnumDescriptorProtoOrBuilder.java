package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$EnumDescriptorProtoOrBuilder extends MessageOrBuilder
{
    boolean hasName();
    
    String getName();
    
    ByteString getNameBytes();
    
    List getValueList();
    
    DescriptorProtos$EnumValueDescriptorProto getValue(final int p0);
    
    int getValueCount();
    
    List getValueOrBuilderList();
    
    DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(final int p0);
    
    boolean hasOptions();
    
    DescriptorProtos$EnumOptions getOptions();
    
    DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder();
}
