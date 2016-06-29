package com.google.protobuf;

final class Field$1 extends AbstractParser
{
    public Field parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new Field(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
