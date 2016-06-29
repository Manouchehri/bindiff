package com.google.protobuf;

final class DescriptorProtos$OneofDescriptorProto$1 extends AbstractParser
{
    public DescriptorProtos$OneofDescriptorProto parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$OneofDescriptorProto(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
