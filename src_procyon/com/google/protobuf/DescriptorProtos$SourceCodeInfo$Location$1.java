package com.google.protobuf;

final class DescriptorProtos$SourceCodeInfo$Location$1 extends AbstractParser
{
    public DescriptorProtos$SourceCodeInfo$Location parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$SourceCodeInfo$Location(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
