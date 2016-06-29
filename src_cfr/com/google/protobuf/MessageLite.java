/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.OutputStream;

public interface MessageLite
extends MessageLiteOrBuilder {
    public void writeTo(CodedOutputStream var1);

    public int getSerializedSize();

    public Parser getParserForType();

    public ByteString toByteString();

    public byte[] toByteArray();

    public void writeTo(OutputStream var1);

    public void writeDelimitedTo(OutputStream var1);

    public MessageLite$Builder newBuilderForType();

    public MessageLite$Builder toBuilder();
}

