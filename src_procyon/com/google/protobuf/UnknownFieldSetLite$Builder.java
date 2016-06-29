package com.google.protobuf;

import java.io.*;

public final class UnknownFieldSetLite$Builder
{
    private ByteString$Output byteStringOutput;
    private CodedOutputStream output;
    private boolean built;
    
    private void ensureInitializedButNotBuilt() {
        if (this.built) {
            throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
        }
        if (this.output == null && this.byteStringOutput == null) {
            this.byteStringOutput = ByteString.newOutput(100);
            this.output = CodedOutputStream.newInstance(this.byteStringOutput);
        }
    }
    
    public boolean mergeFieldFrom(final int n, final CodedInputStream codedInputStream) {
        this.ensureInitializedButNotBuilt();
        final int tagFieldNumber = WireFormat.getTagFieldNumber(n);
        switch (WireFormat.getTagWireType(n)) {
            case 0: {
                this.output.writeUInt64(tagFieldNumber, codedInputStream.readInt64());
                return true;
            }
            case 5: {
                this.output.writeFixed32(tagFieldNumber, codedInputStream.readFixed32());
                return true;
            }
            case 1: {
                this.output.writeFixed64(tagFieldNumber, codedInputStream.readFixed64());
                return true;
            }
            case 2: {
                this.output.writeBytes(tagFieldNumber, codedInputStream.readBytes());
                return true;
            }
            case 3: {
                final UnknownFieldSetLite$Builder builder = UnknownFieldSetLite.newBuilder();
                builder.mergeFrom(codedInputStream);
                codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
                this.output.writeTag(tagFieldNumber, 3);
                builder.build().writeTo(this.output);
                this.output.writeTag(tagFieldNumber, 4);
                return true;
            }
            case 4: {
                return false;
            }
            default: {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }
    
    public UnknownFieldSetLite$Builder mergeVarintField(final int n, final int n2) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.ensureInitializedButNotBuilt();
        try {
            this.output.writeUInt64(n, n2);
        }
        catch (IOException ex) {}
        return this;
    }
    
    public UnknownFieldSetLite$Builder mergeLengthDelimitedField(final int n, final ByteString byteString) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.ensureInitializedButNotBuilt();
        try {
            this.output.writeBytes(n, byteString);
        }
        catch (IOException ex) {}
        return this;
    }
    
    public UnknownFieldSetLite build() {
        if (this.built) {
            throw new IllegalStateException("Do not reuse UnknownFieldSetLite Builders.");
        }
        this.built = true;
        UnknownFieldSetLite unknownFieldSetLite;
        if (this.output == null) {
            unknownFieldSetLite = UnknownFieldSetLite.getDefaultInstance();
        }
        else {
            try {
                this.output.flush();
            }
            catch (IOException ex) {}
            final ByteString byteString = this.byteStringOutput.toByteString();
            if (byteString.isEmpty()) {
                unknownFieldSetLite = UnknownFieldSetLite.getDefaultInstance();
            }
            else {
                unknownFieldSetLite = new UnknownFieldSetLite(byteString, null);
            }
        }
        this.output = null;
        this.byteStringOutput = null;
        return unknownFieldSetLite;
    }
    
    private UnknownFieldSetLite$Builder mergeFrom(final CodedInputStream codedInputStream) {
        int tag;
        do {
            tag = codedInputStream.readTag();
        } while (tag != 0 && this.mergeFieldFrom(tag, codedInputStream));
        return this;
    }
}
