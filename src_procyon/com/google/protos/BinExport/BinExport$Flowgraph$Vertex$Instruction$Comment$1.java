package com.google.protos.BinExport;

import com.google.protobuf.*;

final class BinExport$Flowgraph$Vertex$Instruction$Comment$1 extends AbstractParser
{
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Flowgraph$Vertex$Instruction$Comment(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
