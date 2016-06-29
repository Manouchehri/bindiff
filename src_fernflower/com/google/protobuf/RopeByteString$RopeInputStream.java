package com.google.protobuf;

import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$PieceIterator;
import java.io.InputStream;

class RopeByteString$RopeInputStream extends InputStream {
   private RopeByteString$PieceIterator pieceIterator;
   private LiteralByteString currentPiece;
   private int currentPieceSize;
   private int currentPieceIndex;
   private int currentPieceOffsetInRope;
   private int mark;
   // $FF: synthetic field
   final RopeByteString this$0;

   public RopeByteString$RopeInputStream(RopeByteString var1) {
      this.this$0 = var1;
      this.initialize();
   }

   public int read(byte[] var1, int var2, int var3) {
      if(var1 == null) {
         throw new NullPointerException();
      } else if(var2 >= 0 && var3 >= 0 && var3 <= var1.length - var2) {
         return this.readSkipInternal(var1, var2, var3);
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public long skip(long var1) {
      if(var1 < 0L) {
         throw new IndexOutOfBoundsException();
      } else {
         if(var1 > 2147483647L) {
            var1 = 2147483647L;
         }

         return (long)this.readSkipInternal((byte[])null, 0, (int)var1);
      }
   }

   private int readSkipInternal(byte[] var1, int var2, int var3) {
      int var4;
      int var6;
      for(var4 = var3; var4 > 0; var4 -= var6) {
         this.advanceIfCurrentPieceFullyRead();
         if(this.currentPiece == null) {
            if(var4 == var3) {
               return -1;
            }
            break;
         }

         int var5 = this.currentPieceSize - this.currentPieceIndex;
         var6 = Math.min(var5, var4);
         if(var1 != null) {
            this.currentPiece.copyTo(var1, this.currentPieceIndex, var2, var6);
            var2 += var6;
         }

         this.currentPieceIndex += var6;
      }

      return var3 - var4;
   }

   public int read() {
      this.advanceIfCurrentPieceFullyRead();
      return this.currentPiece == null?-1:this.currentPiece.byteAt(this.currentPieceIndex++) & 255;
   }

   public int available() {
      int var1 = this.currentPieceOffsetInRope + this.currentPieceIndex;
      return this.this$0.size() - var1;
   }

   public boolean markSupported() {
      return true;
   }

   public void mark(int var1) {
      this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
   }

   public synchronized void reset() {
      this.initialize();
      this.readSkipInternal((byte[])null, 0, this.mark);
   }

   private void initialize() {
      this.pieceIterator = new RopeByteString$PieceIterator(this.this$0, (RopeByteString$1)null);
      this.currentPiece = this.pieceIterator.next();
      this.currentPieceSize = this.currentPiece.size();
      this.currentPieceIndex = 0;
      this.currentPieceOffsetInRope = 0;
   }

   private void advanceIfCurrentPieceFullyRead() {
      if(this.currentPiece != null && this.currentPieceIndex == this.currentPieceSize) {
         this.currentPieceOffsetInRope += this.currentPieceSize;
         this.currentPieceIndex = 0;
         if(this.pieceIterator.hasNext()) {
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
         } else {
            this.currentPiece = null;
            this.currentPieceSize = 0;
         }
      }

   }
}
