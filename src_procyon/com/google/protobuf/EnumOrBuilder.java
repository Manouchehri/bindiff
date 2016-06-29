package com.google.protobuf;

import java.util.*;

public interface EnumOrBuilder extends MessageOrBuilder
{
    String getName();
    
    ByteString getNameBytes();
    
    List getEnumvalueList();
    
    EnumValue getEnumvalue(final int p0);
    
    int getEnumvalueCount();
    
    List getEnumvalueOrBuilderList();
    
    EnumValueOrBuilder getEnumvalueOrBuilder(final int p0);
    
    List getOptionsList();
    
    Option getOptions(final int p0);
    
    int getOptionsCount();
    
    List getOptionsOrBuilderList();
    
    OptionOrBuilder getOptionsOrBuilder(final int p0);
    
    boolean hasSourceContext();
    
    SourceContext getSourceContext();
    
    SourceContextOrBuilder getSourceContextOrBuilder();
}
