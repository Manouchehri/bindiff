package com.google.common.io;

import java.io.*;

class BaseEncoding$StandardBaseEncoding$1 extends OutputStream
{
    int bitBuffer;
    int bitBufferLength;
    int writtenChars;
    final /* synthetic */ Writer val$out;
    final /* synthetic */ BaseEncoding$StandardBaseEncoding this$0;
    
    BaseEncoding$StandardBaseEncoding$1(final BaseEncoding$StandardBaseEncoding this$0, final Writer val$out) {
        this.this$0 = this$0;
        this.val$out = val$out;
        this.bitBuffer = 0;
        this.bitBufferLength = 0;
        this.writtenChars = 0;
    }
    
    @Override
    public void write(final int n) {
        this.bitBuffer <<= 8;
        this.bitBuffer |= (n & 0xFF);
        this.bitBufferLength += 8;
        while (this.bitBufferLength >= this.this$0.alphabet.bitsPerChar) {
            this.val$out.write(this.this$0.alphabet.encode(this.bitBuffer >> this.bitBufferLength - this.this$0.alphabet.bitsPerChar & this.this$0.alphabet.mask));
            ++this.writtenChars;
            this.bitBufferLength -= this.this$0.alphabet.bitsPerChar;
        }
    }
    
    @Override
    public void flush() {
        this.val$out.flush();
    }
    
    @Override
    public void close() {
        if (this.bitBufferLength > 0) {
            this.val$out.write(this.this$0.alphabet.encode(this.bitBuffer << this.this$0.alphabet.bitsPerChar - this.bitBufferLength & this.this$0.alphabet.mask));
            ++this.writtenChars;
            if (this.this$0.paddingChar != null) {
                while (this.writtenChars % this.this$0.alphabet.charsPerChunk != 0) {
                    this.val$out.write(this.this$0.paddingChar);
                    ++this.writtenChars;
                }
            }
        }
        this.val$out.close();
    }
}
