package com.google.protobuf;

import java.util.*;

public interface ApiOrBuilder extends MessageOrBuilder
{
    String getName();
    
    ByteString getNameBytes();
    
    List getMethodsList();
    
    Method getMethods(final int p0);
    
    int getMethodsCount();
    
    List getMethodsOrBuilderList();
    
    MethodOrBuilder getMethodsOrBuilder(final int p0);
    
    List getOptionsList();
    
    Option getOptions(final int p0);
    
    int getOptionsCount();
    
    List getOptionsOrBuilderList();
    
    OptionOrBuilder getOptionsOrBuilder(final int p0);
    
    String getVersion();
    
    ByteString getVersionBytes();
    
    boolean hasSourceContext();
    
    SourceContext getSourceContext();
    
    SourceContextOrBuilder getSourceContextOrBuilder();
}
