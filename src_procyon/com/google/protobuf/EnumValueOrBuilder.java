package com.google.protobuf;

import java.util.*;

public interface EnumValueOrBuilder extends MessageOrBuilder
{
    String getName();
    
    ByteString getNameBytes();
    
    int getNumber();
    
    List getOptionsList();
    
    Option getOptions(final int p0);
    
    int getOptionsCount();
    
    List getOptionsOrBuilderList();
    
    OptionOrBuilder getOptionsOrBuilder(final int p0);
}
