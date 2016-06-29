/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;

final class BinExport$Flowgraph$Vertex$Instruction$Comment$1
extends AbstractParser {
    BinExport$Flowgraph$Vertex$Instruction$Comment$1() {
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Flowgraph$Vertex$Instruction$Comment(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException var3_3) {
            if (!(var3_3.getCause() instanceof InvalidProtocolBufferException)) throw var3_3;
            throw (InvalidProtocolBufferException)var3_3.getCause();
        }
    }
}

