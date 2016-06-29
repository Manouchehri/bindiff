/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$1;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.LiteralByteString;

final class ByteString$CodedBuilder {
    private final CodedOutputStream output;
    private final byte[] buffer;

    private ByteString$CodedBuilder(int n2) {
        this.buffer = new byte[n2];
        this.output = CodedOutputStream.newInstance(this.buffer);
    }

    public ByteString build() {
        this.output.checkNoSpaceLeft();
        return new LiteralByteString(this.buffer);
    }

    public CodedOutputStream getCodedOutput() {
        return this.output;
    }

    /* synthetic */ ByteString$CodedBuilder(int n2, ByteString$1 byteString$1) {
        this(n2);
    }
}

