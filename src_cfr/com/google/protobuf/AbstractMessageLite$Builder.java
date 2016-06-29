/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMessageLite$Builder
implements MessageLite$Builder {
    @Override
    public abstract AbstractMessageLite$Builder clone();

    @Override
    public AbstractMessageLite$Builder mergeFrom(CodedInputStream codedInputStream) {
        return this.mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override
    public abstract AbstractMessageLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    @Override
    public AbstractMessageLite$Builder mergeFrom(ByteString byteString) {
        try {
            CodedInputStream codedInputStream = byteString.newCodedInput();
            this.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var2_3) {
            throw var2_3;
        }
        catch (IOException var2_4) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", var2_4);
        }
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            CodedInputStream codedInputStream = byteString.newCodedInput();
            this.mergeFrom(codedInputStream, extensionRegistryLite);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var3_4) {
            throw var3_4;
        }
        catch (IOException var3_5) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", var3_5);
        }
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(byte[] arrby) {
        return this.mergeFrom(arrby, 0, arrby.length);
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(byte[] arrby, int n2, int n3) {
        try {
            CodedInputStream codedInputStream = CodedInputStream.newInstance(arrby, n2, n3);
            this.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var4_5) {
            throw var4_5;
        }
        catch (IOException var4_6) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var4_6);
        }
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(arrby, 0, arrby.length, extensionRegistryLite);
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(byte[] arrby, int n2, int n3, ExtensionRegistryLite extensionRegistryLite) {
        try {
            CodedInputStream codedInputStream = CodedInputStream.newInstance(arrby, n2, n3);
            this.mergeFrom(codedInputStream, extensionRegistryLite);
            codedInputStream.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException var5_6) {
            throw var5_6;
        }
        catch (IOException var5_7) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", var5_7);
        }
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(InputStream inputStream) {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return this;
    }

    @Override
    public AbstractMessageLite$Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(codedInputStream, extensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        return this;
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        int n2 = inputStream.read();
        if (n2 == -1) {
            return false;
        }
        int n3 = CodedInputStream.readRawVarint32(n2, inputStream);
        AbstractMessageLite$Builder$LimitedInputStream abstractMessageLite$Builder$LimitedInputStream = new AbstractMessageLite$Builder$LimitedInputStream(inputStream, n3);
        this.mergeFrom(abstractMessageLite$Builder$LimitedInputStream, extensionRegistryLite);
        return true;
    }

    @Override
    public boolean mergeDelimitedFrom(InputStream inputStream) {
        return this.mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
        return new UninitializedMessageException(messageLite);
    }

    protected static void addAll(Iterable iterable, Collection collection) {
        if (iterable == null) {
            throw new NullPointerException();
        }
        if (iterable instanceof LazyStringList) {
            AbstractMessageLite$Builder.checkForNullValues(((LazyStringList)iterable).getUnderlyingElements());
            collection.addAll((Collection)iterable);
            return;
        }
        if (iterable instanceof Collection) {
            AbstractMessageLite$Builder.checkForNullValues(iterable);
            collection.addAll((Collection)iterable);
            return;
        }
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T t2 = iterator.next();
            if (t2 == null) {
                throw new NullPointerException();
            }
            collection.add(t2);
        }
    }

    private static void checkForNullValues(Iterable iterable) {
        T t2;
        Iterator<T> iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) return;
        } while ((t2 = iterator.next()) != null);
        throw new NullPointerException();
    }
}

