package com.google.protobuf;

import java.util.*;

interface MapField$Converter
{
    Message convertKeyAndValueToMessage(final Object p0, final Object p1);
    
    void convertMessageToKeyAndValue(final Message p0, final Map p1);
    
    Message getMessageDefaultInstance();
}
