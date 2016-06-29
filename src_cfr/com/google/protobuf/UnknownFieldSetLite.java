/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UnknownFieldSetLite$1;
import com.google.protobuf.UnknownFieldSetLite$Builder;

public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(ByteString.EMPTY);
    private final ByteString byteString;

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static UnknownFieldSetLite$Builder newBuilder() {
        return new UnknownFieldSetLite$Builder(null);
    }

    static UnknownFieldSetLite concat(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return new UnknownFieldSetLite(unknownFieldSetLite.byteString.concat(unknownFieldSetLite2.byteString));
    }

    private UnknownFieldSetLite(ByteString byteString) {
        this.byteString = byteString;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        codedOutputStream.writeRawBytes(this.byteString);
    }

    public int getSerializedSize() {
        return this.byteString.size();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UnknownFieldSetLite)) return false;
        return this.byteString.equals(((UnknownFieldSetLite)object).byteString);
    }

    public int hashCode() {
        return this.byteString.hashCode();
    }

    /* synthetic */ UnknownFieldSetLite(ByteString byteString, UnknownFieldSetLite$1 unknownFieldSetLite$1) {
        this(byteString);
    }
}

