package com.google.protobuf;

import java.util.*;

public interface FieldOrBuilder extends MessageOrBuilder
{
    int getKindValue();
    
    Field$Kind getKind();
    
    int getCardinalityValue();
    
    Field$Cardinality getCardinality();
    
    int getNumber();
    
    String getName();
    
    ByteString getNameBytes();
    
    String getTypeUrl();
    
    ByteString getTypeUrlBytes();
    
    int getOneofIndex();
    
    boolean getPacked();
    
    List getOptionsList();
    
    Option getOptions(final int p0);
    
    int getOptionsCount();
    
    List getOptionsOrBuilderList();
    
    OptionOrBuilder getOptionsOrBuilder(final int p0);
}
