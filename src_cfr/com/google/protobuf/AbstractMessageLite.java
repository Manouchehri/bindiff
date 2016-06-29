/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public abstract class AbstractMessageLite
implements MessageLite {
    protected int memoizedHashCode = 0;

    @Override
    public ByteString toByteString() {
        try {
            ByteString$CodedBuilder byteString$CodedBuilder = ByteString.newCodedBuilder(this.getSerializedSize());
            this.writeTo(byteString$CodedBuilder.getCodedOutput());
            return byteString$CodedBuilder.build();
        }
        catch (IOException var1_2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", var1_2);
        }
    }

    @Override
    public byte[] toByteArray() {
        try {
            byte[] arrby = new byte[this.getSerializedSize()];
            CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(arrby);
            this.writeTo(codedOutputStream);
            codedOutputStream.checkNoSpaceLeft();
            return arrby;
        }
        catch (IOException var1_2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var1_2);
        }
    }

    @Override
    public void writeTo(OutputStream outputStream) {
        int n2 = CodedOutputStream.computePreferredBufferSize(this.getSerializedSize());
        CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(outputStream, n2);
        this.writeTo(codedOutputStream);
        codedOutputStream.flush();
    }

    @Override
    public void writeDelimitedTo(OutputStream outputStream) {
        int n2 = this.getSerializedSize();
        int n3 = CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(n2) + n2);
        CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(outputStream, n3);
        codedOutputStream.writeRawVarint32(n2);
        this.writeTo(codedOutputStream);
        codedOutputStream.flush();
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    protected static void checkByteStringIsUtf8(ByteString byteString) {
        if (byteString.isValidUtf8()) return;
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    protected static void addAll(Iterable iterable, Collection collection) {
        AbstractMessageLite$Builder.addAll(iterable, collection);
    }
}

