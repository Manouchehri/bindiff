package com.google.protobuf;

import java.util.*;

public interface TypeOrBuilder extends MessageOrBuilder
{
    String getName();
    
    ByteString getNameBytes();
    
    List getFieldsList();
    
    Field getFields(final int p0);
    
    int getFieldsCount();
    
    List getFieldsOrBuilderList();
    
    FieldOrBuilder getFieldsOrBuilder(final int p0);
    
    ProtocolStringList getOneofsList();
    
    int getOneofsCount();
    
    String getOneofs(final int p0);
    
    ByteString getOneofsBytes(final int p0);
    
    List getOptionsList();
    
    Option getOptions(final int p0);
    
    int getOptionsCount();
    
    List getOptionsOrBuilderList();
    
    OptionOrBuilder getOptionsOrBuilder(final int p0);
    
    boolean hasSourceContext();
    
    SourceContext getSourceContext();
    
    SourceContextOrBuilder getSourceContextOrBuilder();
}
