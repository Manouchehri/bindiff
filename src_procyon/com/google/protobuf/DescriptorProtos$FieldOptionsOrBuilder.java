package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$FieldOptionsOrBuilder extends GeneratedMessage$ExtendableMessageOrBuilder
{
    boolean hasCtype();
    
    DescriptorProtos$FieldOptions$CType getCtype();
    
    boolean hasPacked();
    
    boolean getPacked();
    
    boolean hasJstype();
    
    DescriptorProtos$FieldOptions$JSType getJstype();
    
    boolean hasLazy();
    
    boolean getLazy();
    
    boolean hasDeprecated();
    
    boolean getDeprecated();
    
    boolean hasWeak();
    
    boolean getWeak();
    
    List getUninterpretedOptionList();
    
    DescriptorProtos$UninterpretedOption getUninterpretedOption(final int p0);
    
    int getUninterpretedOptionCount();
    
    List getUninterpretedOptionOrBuilderList();
    
    DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int p0);
}
