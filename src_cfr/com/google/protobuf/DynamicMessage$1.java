/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.io.IOException;

class DynamicMessage$1
extends AbstractParser {
    final /* synthetic */ DynamicMessage this$0;

    DynamicMessage$1(DynamicMessage dynamicMessage) {
        this.this$0 = dynamicMessage;
    }

    @Override
    public DynamicMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DynamicMessage$Builder dynamicMessage$Builder = DynamicMessage.newBuilder(DynamicMessage.access$200(this.this$0));
        try {
            dynamicMessage$Builder.mergeFrom(codedInputStream, extensionRegistryLite);
            return dynamicMessage$Builder.buildPartial();
        }
        catch (InvalidProtocolBufferException var4_4) {
            throw var4_4.setUnfinishedMessage(dynamicMessage$Builder.buildPartial());
        }
        catch (IOException var4_5) {
            throw new InvalidProtocolBufferException(var4_5.getMessage()).setUnfinishedMessage(dynamicMessage$Builder.buildPartial());
        }
    }
}

