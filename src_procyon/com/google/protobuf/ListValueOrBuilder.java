package com.google.protobuf;

import java.util.*;

public interface ListValueOrBuilder extends MessageOrBuilder
{
    List getValuesList();
    
    Value getValues(final int p0);
    
    int getValuesCount();
    
    List getValuesOrBuilderList();
    
    ValueOrBuilder getValuesOrBuilder(final int p0);
}
