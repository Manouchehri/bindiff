/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;

final class DescriptorProtos$SourceCodeInfo$Location$1
extends AbstractParser {
    DescriptorProtos$SourceCodeInfo$Location$1() {
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$SourceCodeInfo$Location(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException var3_3) {
            if (!(var3_3.getCause() instanceof InvalidProtocolBufferException)) throw var3_3;
            throw (InvalidProtocolBufferException)var3_3.getCause();
        }
    }
}

