package com.google.protos.BinExport;

import com.google.protobuf.*;

final class BinExport$Callgraph$Vertex$1 extends AbstractParser
{
    @Override
    public BinExport$Callgraph$Vertex parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Callgraph$Vertex(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
