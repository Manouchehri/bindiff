package com.google.protobuf;

final class DescriptorProtos$EnumValueDescriptorProto$1 extends AbstractParser
{
    public DescriptorProtos$EnumValueDescriptorProto parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new DescriptorProtos$EnumValueDescriptorProto(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
