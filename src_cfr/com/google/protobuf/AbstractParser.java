/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser
implements Parser {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    private UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
        if (!(messageLite instanceof AbstractMessageLite)) return new UninitializedMessageException(messageLite);
        return ((AbstractMessageLite)messageLite).newUninitializedMessageException();
    }

    private MessageLite checkMessageInitialized(MessageLite messageLite) {
        if (messageLite == null) return messageLite;
        if (messageLite.isInitialized()) return messageLite;
        throw this.newUninitializedMessageException(messageLite).asInvalidProtocolBufferException().setUnfinishedMessage(messageLite);
    }

    @Override
    public MessageLite parsePartialFrom(CodedInputStream codedInputStream) {
        return (MessageLite)this.parsePartialFrom(codedInputStream, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized((MessageLite)this.parsePartialFrom(codedInputStream, extensionRegistryLite));
    }

    @Override
    public MessageLite parseFrom(CodedInputStream codedInputStream) {
        return this.parseFrom(codedInputStream, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream codedInputStream = byteString.newCodedInput();
        MessageLite messageLite = (MessageLite)this.parsePartialFrom(codedInputStream, extensionRegistryLite);
        try {
            codedInputStream.checkLastTagWas(0);
            return messageLite;
        }
        catch (InvalidProtocolBufferException var5_6) {
            throw var5_6.setUnfinishedMessage(messageLite);
        }
    }

    @Override
    public MessageLite parsePartialFrom(ByteString byteString) {
        return this.parsePartialFrom(byteString, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(byteString, extensionRegistryLite));
    }

    @Override
    public MessageLite parseFrom(ByteString byteString) {
        return this.parseFrom(byteString, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parsePartialFrom(byte[] arrby, int n2, int n3, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(arrby, n2, n3);
        MessageLite messageLite = (MessageLite)this.parsePartialFrom(codedInputStream, extensionRegistryLite);
        try {
            codedInputStream.checkLastTagWas(0);
            return messageLite;
        }
        catch (InvalidProtocolBufferException var7_8) {
            throw var7_8.setUnfinishedMessage(messageLite);
        }
    }

    @Override
    public MessageLite parsePartialFrom(byte[] arrby, int n2, int n3) {
        return this.parsePartialFrom(arrby, n2, n3, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parsePartialFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return this.parsePartialFrom(arrby, 0, arrby.length, extensionRegistryLite);
    }

    @Override
    public MessageLite parsePartialFrom(byte[] arrby) {
        return this.parsePartialFrom(arrby, 0, arrby.length, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseFrom(byte[] arrby, int n2, int n3, ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(arrby, n2, n3, extensionRegistryLite));
    }

    @Override
    public MessageLite parseFrom(byte[] arrby, int n2, int n3) {
        return this.parseFrom(arrby, n2, n3, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return this.parseFrom(arrby, 0, arrby.length, extensionRegistryLite);
    }

    @Override
    public MessageLite parseFrom(byte[] arrby) {
        return this.parseFrom(arrby, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(inputStream);
        MessageLite messageLite = (MessageLite)this.parsePartialFrom(codedInputStream, extensionRegistryLite);
        try {
            codedInputStream.checkLastTagWas(0);
            return messageLite;
        }
        catch (InvalidProtocolBufferException var5_5) {
            throw var5_5.setUnfinishedMessage(messageLite);
        }
    }

    @Override
    public MessageLite parsePartialFrom(InputStream inputStream) {
        return this.parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialFrom(inputStream, extensionRegistryLite));
    }

    @Override
    public MessageLite parseFrom(InputStream inputStream) {
        return this.parseFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        int n2;
        try {
            int n3 = inputStream.read();
            if (n3 == -1) {
                return null;
            }
            n2 = CodedInputStream.readRawVarint32(n3, inputStream);
        }
        catch (IOException var4_4) {
            throw new InvalidProtocolBufferException(var4_4.getMessage());
        }
        AbstractMessageLite$Builder$LimitedInputStream abstractMessageLite$Builder$LimitedInputStream = new AbstractMessageLite$Builder$LimitedInputStream(inputStream, n2);
        return this.parsePartialFrom(abstractMessageLite$Builder$LimitedInputStream, extensionRegistryLite);
    }

    @Override
    public MessageLite parsePartialDelimitedFrom(InputStream inputStream) {
        return this.parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    @Override
    public MessageLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.checkMessageInitialized(this.parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
    }

    @Override
    public MessageLite parseDelimitedFrom(InputStream inputStream) {
        return this.parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }
}

