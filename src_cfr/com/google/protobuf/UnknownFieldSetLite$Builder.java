/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$Output;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnknownFieldSetLite$1;
import com.google.protobuf.WireFormat;
import java.io.IOException;

public final class UnknownFieldSetLite$Builder {
    private ByteString$Output byteStringOutput;
    private CodedOutputStream output;
    private boolean built;

    private UnknownFieldSetLite$Builder() {
    }

    private void ensureInitializedButNotBuilt() {
        if (this.built) {
            throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
        }
        if (this.output != null) return;
        if (this.byteStringOutput != null) return;
        this.byteStringOutput = ByteString.newOutput(100);
        this.output = CodedOutputStream.newInstance(this.byteStringOutput);
    }

    public boolean mergeFieldFrom(int n2, CodedInputStream codedInputStream) {
        this.ensureInitializedButNotBuilt();
        int n3 = WireFormat.getTagFieldNumber(n2);
        switch (WireFormat.getTagWireType(n2)) {
            case 0: {
                this.output.writeUInt64(n3, codedInputStream.readInt64());
                return true;
            }
            case 5: {
                this.output.writeFixed32(n3, codedInputStream.readFixed32());
                return true;
            }
            case 1: {
                this.output.writeFixed64(n3, codedInputStream.readFixed64());
                return true;
            }
            case 2: {
                this.output.writeBytes(n3, codedInputStream.readBytes());
                return true;
            }
            case 3: {
                UnknownFieldSetLite$Builder unknownFieldSetLite$Builder = UnknownFieldSetLite.newBuilder();
                unknownFieldSetLite$Builder.mergeFrom(codedInputStream);
                codedInputStream.checkLastTagWas(WireFormat.makeTag(n3, 4));
                this.output.writeTag(n3, 3);
                unknownFieldSetLite$Builder.build().writeTo(this.output);
                this.output.writeTag(n3, 4);
                return true;
            }
            case 4: {
                return false;
            }
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public UnknownFieldSetLite$Builder mergeVarintField(int n2, int n3) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.ensureInitializedButNotBuilt();
        try {
            this.output.writeUInt64(n2, n3);
            return this;
        }
        catch (IOException var3_3) {
            // empty catch block
        }
        return this;
    }

    public UnknownFieldSetLite$Builder mergeLengthDelimitedField(int n2, ByteString byteString) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.ensureInitializedButNotBuilt();
        try {
            this.output.writeBytes(n2, byteString);
            return this;
        }
        catch (IOException var3_3) {
            // empty catch block
        }
        return this;
    }

    public UnknownFieldSetLite build() {
        UnknownFieldSetLite unknownFieldSetLite;
        if (this.built) {
            throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
        }
        this.built = true;
        if (this.output == null) {
            unknownFieldSetLite = UnknownFieldSetLite.getDefaultInstance();
        } else {
            try {
                this.output.flush();
            }
            catch (IOException var2_2) {
                // empty catch block
            }
            ByteString byteString = this.byteStringOutput.toByteString();
            unknownFieldSetLite = byteString.isEmpty() ? UnknownFieldSetLite.getDefaultInstance() : new UnknownFieldSetLite(byteString, null);
        }
        this.output = null;
        this.byteStringOutput = null;
        return unknownFieldSetLite;
    }

    private UnknownFieldSetLite$Builder mergeFrom(CodedInputStream codedInputStream) {
        int n2;
        do {
            if ((n2 = codedInputStream.readTag()) == 0) return this;
        } while (this.mergeFieldFrom(n2, codedInputStream));
        return this;
    }

    /* synthetic */ UnknownFieldSetLite$Builder(UnknownFieldSetLite$1 unknownFieldSetLite$1) {
        this();
    }
}

