/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;

public final class UnknownFieldSet$Parser
extends AbstractParser {
    @Override
    public UnknownFieldSet parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            unknownFieldSet$Builder.mergeFrom(codedInputStream);
            return unknownFieldSet$Builder.buildPartial();
        }
        catch (InvalidProtocolBufferException var4_4) {
            throw var4_4.setUnfinishedMessage(unknownFieldSet$Builder.buildPartial());
        }
        catch (IOException var4_5) {
            throw new InvalidProtocolBufferException(var4_5.getMessage()).setUnfinishedMessage(unknownFieldSet$Builder.buildPartial());
        }
    }
}

