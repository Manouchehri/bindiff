package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$UninterpretedOptionOrBuilder extends MessageOrBuilder
{
    List getNameList();
    
    DescriptorProtos$UninterpretedOption$NamePart getName(final int p0);
    
    int getNameCount();
    
    List getNameOrBuilderList();
    
    DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(final int p0);
    
    boolean hasIdentifierValue();
    
    String getIdentifierValue();
    
    ByteString getIdentifierValueBytes();
    
    boolean hasPositiveIntValue();
    
    long getPositiveIntValue();
    
    boolean hasNegativeIntValue();
    
    long getNegativeIntValue();
    
    boolean hasDoubleValue();
    
    double getDoubleValue();
    
    boolean hasStringValue();
    
    ByteString getStringValue();
    
    boolean hasAggregateValue();
    
    String getAggregateValue();
    
    ByteString getAggregateValueBytes();
}
