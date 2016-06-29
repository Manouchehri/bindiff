package com.google.protobuf;

import java.io.*;

public abstract class AbstractParser implements Parser
{
    private static final ExtensionRegistryLite EMPTY_REGISTRY;
    
    private UninitializedMessageException newUninitializedMessageException(final MessageLite messageLite) {
        if (messageLite instanceof AbstractMessageLite) {
            return ((AbstractMessageLite)messageLite).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messageLite);
    }
    
    private MessageLite checkMessageInitialized(final MessageLite unfinishedMessage) {
        if (unfinishedMessage != null && !unfinishedMessage.isInitialized()) {
            throw this.newUninitializedMessageException(unfinishedMessage).asInvalidProtocolBufferException().setUnfinishedMessage(unfinishedMessage);
        }
        return unfinishedMessage;
    }
    
    public MessageLite parsePartialFrom(final CodedInputStream codedInputStream) {
        return (MessageLite)this.parsePartialFrom(codedInputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized((MessageLite)this.parsePartialFrom(codedInputStream, extensionRegistryLite));
    }
    
    public MessageLite parseFrom(final CodedInputStream codedInputStream) {
        return this.parseFrom(codedInputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parsePartialFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            final MessageLite unfinishedMessage = (MessageLite)this.parsePartialFrom(codedInput, extensionRegistryLite);
            try {
                codedInput.checkLastTagWas(0);
            }
            catch (InvalidProtocolBufferException ex) {
                throw ex.setUnfinishedMessage(unfinishedMessage);
            }
            return unfinishedMessage;
        }
        catch (InvalidProtocolBufferException ex2) {
            throw ex2;
        }
    }
    
    public MessageLite parsePartialFrom(final ByteString byteString) {
        return this.parsePartialFrom(byteString, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(byteString, extensionRegistryLite));
    }
    
    public MessageLite parseFrom(final ByteString byteString) {
        return this.parseFrom(byteString, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parsePartialFrom(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            final CodedInputStream instance = CodedInputStream.newInstance(array, n, n2);
            final MessageLite unfinishedMessage = (MessageLite)this.parsePartialFrom(instance, extensionRegistryLite);
            try {
                instance.checkLastTagWas(0);
            }
            catch (InvalidProtocolBufferException ex) {
                throw ex.setUnfinishedMessage(unfinishedMessage);
            }
            return unfinishedMessage;
        }
        catch (InvalidProtocolBufferException ex2) {
            throw ex2;
        }
    }
    
    public MessageLite parsePartialFrom(final byte[] array, final int n, final int n2) {
        return this.parsePartialFrom(array, n, n2, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parsePartialFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return this.parsePartialFrom(array, 0, array.length, extensionRegistryLite);
    }
    
    public MessageLite parsePartialFrom(final byte[] array) {
        return this.parsePartialFrom(array, 0, array.length, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseFrom(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(array, n, n2, extensionRegistryLite));
    }
    
    public MessageLite parseFrom(final byte[] array, final int n, final int n2) {
        return this.parseFrom(array, n, n2, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return this.parseFrom(array, 0, array.length, extensionRegistryLite);
    }
    
    public MessageLite parseFrom(final byte[] array) {
        return this.parseFrom(array, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parsePartialFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final CodedInputStream instance = CodedInputStream.newInstance(inputStream);
        final MessageLite unfinishedMessage = (MessageLite)this.parsePartialFrom(instance, extensionRegistryLite);
        try {
            instance.checkLastTagWas(0);
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex.setUnfinishedMessage(unfinishedMessage);
        }
        return unfinishedMessage;
    }
    
    public MessageLite parsePartialFrom(final InputStream inputStream) {
        return this.parsePartialFrom(inputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(inputStream, extensionRegistryLite));
    }
    
    public MessageLite parseFrom(final InputStream inputStream) {
        return this.parseFrom(inputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parsePartialDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        int rawVarint32;
        try {
            final int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            rawVarint32 = CodedInputStream.readRawVarint32(read, inputStream);
        }
        catch (IOException ex) {
            throw new InvalidProtocolBufferException(ex.getMessage());
        }
        return this.parsePartialFrom((InputStream)new AbstractMessageLite$Builder$LimitedInputStream(inputStream, rawVarint32), extensionRegistryLite);
    }
    
    public MessageLite parsePartialDelimitedFrom(final InputStream inputStream) {
        return this.parsePartialDelimitedFrom(inputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    public MessageLite parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
    }
    
    public MessageLite parseDelimitedFrom(final InputStream inputStream) {
        return this.parseDelimitedFrom(inputStream, AbstractParser.EMPTY_REGISTRY);
    }
    
    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }
}
