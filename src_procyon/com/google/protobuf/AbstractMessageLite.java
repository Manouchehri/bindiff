package com.google.protobuf;

import java.io.*;
import java.util.*;

public abstract class AbstractMessageLite implements MessageLite
{
    protected int memoizedHashCode;
    
    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }
    
    public ByteString toByteString() {
        try {
            final ByteString$CodedBuilder codedBuilder = ByteString.newCodedBuilder(this.getSerializedSize());
            this.writeTo(codedBuilder.getCodedOutput());
            return codedBuilder.build();
        }
        catch (IOException ex) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ex);
        }
    }
    
    public byte[] toByteArray() {
        try {
            final byte[] array = new byte[this.getSerializedSize()];
            final CodedOutputStream instance = CodedOutputStream.newInstance(array);
            this.writeTo(instance);
            instance.checkNoSpaceLeft();
            return array;
        }
        catch (IOException ex) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ex);
        }
    }
    
    public void writeTo(final OutputStream outputStream) {
        final CodedOutputStream instance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(this.getSerializedSize()));
        this.writeTo(instance);
        instance.flush();
    }
    
    public void writeDelimitedTo(final OutputStream outputStream) {
        final int serializedSize = this.getSerializedSize();
        final CodedOutputStream instance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        instance.writeRawVarint32(serializedSize);
        this.writeTo(instance);
        instance.flush();
    }
    
    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }
    
    protected static void checkByteStringIsUtf8(final ByteString byteString) {
        if (!byteString.isValidUtf8()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }
    
    protected static void addAll(final Iterable iterable, final Collection collection) {
        AbstractMessageLite$Builder.addAll(iterable, collection);
    }
}
