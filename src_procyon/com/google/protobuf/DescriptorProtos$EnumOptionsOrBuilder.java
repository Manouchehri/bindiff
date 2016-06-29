package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$EnumOptionsOrBuilder extends GeneratedMessage$ExtendableMessageOrBuilder
{
    boolean hasAllowAlias();
    
    boolean getAllowAlias();
    
    boolean hasDeprecated();
    
    boolean getDeprecated();
    
    List getUninterpretedOptionList();
    
    DescriptorProtos$UninterpretedOption getUninterpretedOption(final int p0);
    
    int getUninterpretedOptionCount();
    
    List getUninterpretedOptionOrBuilderList();
    
    DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int p0);
}
