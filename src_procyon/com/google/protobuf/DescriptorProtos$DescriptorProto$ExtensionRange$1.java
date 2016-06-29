package com.google.protobuf;

final class DescriptorProtos$DescriptorProto$ExtensionRange$1 extends AbstractParser
{
    public DescriptorProtos$DescriptorProto$ExtensionRange parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$DescriptorProto$ExtensionRange(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
