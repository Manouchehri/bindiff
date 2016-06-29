package com.google.common.io;

import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import java.io.OutputStream;
import java.io.Writer;

class BaseEncoding$StandardBaseEncoding$1 extends OutputStream {
   int bitBuffer;
   int bitBufferLength;
   int writtenChars;
   // $FF: synthetic field
   final Writer val$out;
   // $FF: synthetic field
   final BaseEncoding$StandardBaseEncoding this$0;

   BaseEncoding$StandardBaseEncoding$1(BaseEncoding$StandardBaseEncoding var1, Writer var2) {
      this.this$0 = var1;
      this.val$out = var2;
      this.bitBuffer = 0;
      this.bitBufferLength = 0;
      this.writtenChars = 0;
   }

   public void write(int var1) {
      this.bitBuffer <<= 8;
      this.bitBuffer |= var1 & 255;

      for(this.bitBufferLength += 8; this.bitBufferLength >= this.this$0.alphabet.bitsPerChar; this.bitBufferLength -= this.this$0.alphabet.bitsPerChar) {
         int var2 = this.bitBuffer >> this.bitBufferLength - this.this$0.alphabet.bitsPerChar & this.this$0.alphabet.mask;
         this.val$out.write(this.this$0.alphabet.encode(var2));
         ++this.writtenChars;
      }

   }

   public void flush() {
      this.val$out.flush();
   }

   public void close() {
      if(this.bitBufferLength > 0) {
         int var1 = this.bitBuffer << this.this$0.alphabet.bitsPerChar - this.bitBufferLength & this.this$0.alphabet.mask;
         this.val$out.write(this.this$0.alphabet.encode(var1));
         ++this.writtenChars;
         if(this.this$0.paddingChar != null) {
            while(this.writtenChars % this.this$0.alphabet.charsPerChunk != 0) {
               this.val$out.write(this.this$0.paddingChar.charValue());
               ++this.writtenChars;
            }
         }
      }

      this.val$out.close();
   }
}
