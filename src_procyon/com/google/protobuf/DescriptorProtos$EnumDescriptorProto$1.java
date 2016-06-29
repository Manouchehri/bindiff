package com.google.protobuf;

final class DescriptorProtos$EnumDescriptorProto$1 extends AbstractParser
{
    public DescriptorProtos$EnumDescriptorProto parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$EnumDescriptorProto(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
