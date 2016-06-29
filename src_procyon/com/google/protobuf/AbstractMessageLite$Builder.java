package com.google.protobuf;

import java.io.*;
import java.util.*;

public abstract class AbstractMessageLite$Builder implements MessageLite$Builder
{
    public abstract AbstractMessageLite$Builder clone();
    
    public AbstractMessageLite$Builder mergeFrom(final CodedInputStream codedInputStream) {
        return this.mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public abstract AbstractMessageLite$Builder mergeFrom(final CodedInputStream p0, final ExtensionRegistryLite p1);
    
    public AbstractMessageLite$Builder mergeFrom(final ByteString byteString) {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            this.mergeFrom(codedInput);
            codedInput.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", ex2);
        }
    }
    
    public AbstractMessageLite$Builder mergeFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            this.mergeFrom(codedInput, extensionRegistryLite);
            codedInput.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", ex2);
        }
    }
    
    public AbstractMessageLite$Builder mergeFrom(final byte[] array) {
        return this.mergeFrom(array, 0, array.length);
    }
    
    public AbstractMessageLite$Builder mergeFrom(final byte[] array, final int n, final int n2) {
        try {
            final CodedInputStream instance = CodedInputStream.newInstance(array, n, n2);
            this.mergeFrom(instance);
            instance.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", ex2);
        }
    }
    
    public AbstractMessageLite$Builder mergeFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(array, 0, array.length, extensionRegistryLite);
    }
    
    public AbstractMessageLite$Builder mergeFrom(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            final CodedInputStream instance = CodedInputStream.newInstance(array, n, n2);
            this.mergeFrom(instance, extensionRegistryLite);
            instance.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", ex2);
        }
    }
    
    public AbstractMessageLite$Builder mergeFrom(final InputStream inputStream) {
        final CodedInputStream instance = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(instance);
        instance.checkLastTagWas(0);
        return this;
    }
    
    public AbstractMessageLite$Builder mergeFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final CodedInputStream instance = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(instance, extensionRegistryLite);
        instance.checkLastTagWas(0);
        return this;
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        this.mergeFrom((InputStream)new AbstractMessageLite$Builder$LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
        return true;
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream) {
        return this.mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(final MessageLite messageLite) {
        return new UninitializedMessageException(messageLite);
    }
    
    protected static void addAll(final Iterable iterable, final Collection collection) {
        if (iterable == null) {
            throw new NullPointerException();
        }
        if (iterable instanceof LazyStringList) {
            checkForNullValues(((LazyStringList)iterable).getUnderlyingElements());
            collection.addAll((Collection<?>)iterable);
        }
        else if (iterable instanceof Collection) {
            checkForNullValues(iterable);
            collection.addAll((Collection<?>)iterable);
        }
        else {
            for (final Object next : iterable) {
                if (next == null) {
                    throw new NullPointerException();
                }
                collection.add(next);
            }
        }
    }
    
    private static void checkForNullValues(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                throw new NullPointerException();
            }
        }
    }
}
