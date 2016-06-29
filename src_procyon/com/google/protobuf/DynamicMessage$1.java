package com.google.protobuf;

import java.io.*;
import java.util.*;

class DynamicMessage$1 extends AbstractParser
{
    final /* synthetic */ DynamicMessage this$0;
    
    DynamicMessage$1(final DynamicMessage this$0) {
        this.this$0 = this$0;
    }
    
    public DynamicMessage parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final DynamicMessage$Builder builder = DynamicMessage.newBuilder(this.this$0.type);
        try {
            builder.mergeFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex.setUnfinishedMessage(builder.buildPartial());
        }
        catch (IOException ex2) {
            throw new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
    }
}
