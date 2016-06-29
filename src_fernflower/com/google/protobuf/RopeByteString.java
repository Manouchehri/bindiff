package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$Balancer;
import com.google.protobuf.RopeByteString$PieceIterator;
import com.google.protobuf.RopeByteString$RopeByteIterator;
import com.google.protobuf.RopeByteString$RopeInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class RopeByteString extends ByteString {
   private static final int[] minLengthByDepth;
   private final int totalLength;
   private final ByteString left;
   private final ByteString right;
   private final int leftLength;
   private final int treeDepth;
   private int hash;
   private static final long serialVersionUID = 1L;

   private RopeByteString(ByteString var1, ByteString var2) {
      this.hash = 0;
      this.left = var1;
      this.right = var2;
      this.leftLength = var1.size();
      this.totalLength = this.leftLength + var2.size();
      this.treeDepth = Math.max(var1.getTreeDepth(), var2.getTreeDepth()) + 1;
   }

   static ByteString concatenate(ByteString var0, ByteString var1) {
      RopeByteString var3 = var0 instanceof RopeByteString?(RopeByteString)var0:null;
      Object var2;
      if(var1.size() == 0) {
         var2 = var0;
      } else if(var0.size() == 0) {
         var2 = var1;
      } else {
         int var4 = var0.size() + var1.size();
         if(var4 < 128) {
            var2 = concatenateBytes(var0, var1);
         } else if(var3 != null && var3.right.size() + var1.size() < 128) {
            LiteralByteString var7 = concatenateBytes(var3.right, var1);
            var2 = new RopeByteString(var3.left, var7);
         } else if(var3 != null && var3.left.getTreeDepth() > var3.right.getTreeDepth() && var3.getTreeDepth() > var1.getTreeDepth()) {
            RopeByteString var6 = new RopeByteString(var3.right, var1);
            var2 = new RopeByteString(var3.left, var6);
         } else {
            int var5 = Math.max(var0.getTreeDepth(), var1.getTreeDepth()) + 1;
            if(var4 >= minLengthByDepth[var5]) {
               var2 = new RopeByteString(var0, var1);
            } else {
               var2 = RopeByteString$Balancer.access$100(new RopeByteString$Balancer((RopeByteString$1)null), var0, var1);
            }
         }
      }

      return (ByteString)var2;
   }

   private static LiteralByteString concatenateBytes(ByteString var0, ByteString var1) {
      int var2 = var0.size();
      int var3 = var1.size();
      byte[] var4 = new byte[var2 + var3];
      var0.copyTo(var4, 0, 0, var2);
      var1.copyTo(var4, 0, var2, var3);
      return new LiteralByteString(var4);
   }

   static RopeByteString newInstanceForTest(ByteString var0, ByteString var1) {
      return new RopeByteString(var0, var1);
   }

   public byte byteAt(int var1) {
      if(var1 < 0) {
         throw new ArrayIndexOutOfBoundsException((new StringBuilder(22)).append("Index < 0: ").append(var1).toString());
      } else if(var1 > this.totalLength) {
         int var3 = this.totalLength;
         throw new ArrayIndexOutOfBoundsException((new StringBuilder(40)).append("Index > length: ").append(var1).append(", ").append(var3).toString());
      } else {
         byte var2;
         if(var1 < this.leftLength) {
            var2 = this.left.byteAt(var1);
         } else {
            var2 = this.right.byteAt(var1 - this.leftLength);
         }

         return var2;
      }
   }

   public int size() {
      return this.totalLength;
   }

   protected int getTreeDepth() {
      return this.treeDepth;
   }

   protected boolean isBalanced() {
      return this.totalLength >= minLengthByDepth[this.treeDepth];
   }

   public ByteString substring(int var1, int var2) {
      if(var1 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(32)).append("Beginning index: ").append(var1).append(" < 0").toString());
      } else if(var2 > this.totalLength) {
         int var7 = this.totalLength;
         throw new IndexOutOfBoundsException((new StringBuilder(36)).append("End index: ").append(var2).append(" > ").append(var7).toString());
      } else {
         int var3 = var2 - var1;
         if(var3 < 0) {
            throw new IndexOutOfBoundsException((new StringBuilder(66)).append("Beginning index larger than ending index: ").append(var1).append(", ").append(var2).toString());
         } else {
            Object var4;
            if(var3 == 0) {
               var4 = ByteString.EMPTY;
            } else if(var3 == this.totalLength) {
               var4 = this;
            } else if(var2 <= this.leftLength) {
               var4 = this.left.substring(var1, var2);
            } else if(var1 >= this.leftLength) {
               var4 = this.right.substring(var1 - this.leftLength, var2 - this.leftLength);
            } else {
               ByteString var5 = this.left.substring(var1);
               ByteString var6 = this.right.substring(0, var2 - this.leftLength);
               var4 = new RopeByteString(var5, var6);
            }

            return (ByteString)var4;
         }
      }
   }

   protected void copyToInternal(byte[] var1, int var2, int var3, int var4) {
      if(var2 + var4 <= this.leftLength) {
         this.left.copyToInternal(var1, var2, var3, var4);
      } else if(var2 >= this.leftLength) {
         this.right.copyToInternal(var1, var2 - this.leftLength, var3, var4);
      } else {
         int var5 = this.leftLength - var2;
         this.left.copyToInternal(var1, var2, var3, var5);
         this.right.copyToInternal(var1, 0, var3 + var5, var4 - var5);
      }

   }

   public void copyTo(ByteBuffer var1) {
      this.left.copyTo(var1);
      this.right.copyTo(var1);
   }

   public ByteBuffer asReadOnlyByteBuffer() {
      ByteBuffer var1 = ByteBuffer.wrap(this.toByteArray());
      return var1.asReadOnlyBuffer();
   }

   public List asReadOnlyByteBufferList() {
      ArrayList var1 = new ArrayList();
      RopeByteString$PieceIterator var2 = new RopeByteString$PieceIterator(this, (RopeByteString$1)null);

      while(var2.hasNext()) {
         LiteralByteString var3 = var2.next();
         var1.add(var3.asReadOnlyByteBuffer());
      }

      return var1;
   }

   public void writeTo(OutputStream var1) {
      this.left.writeTo(var1);
      this.right.writeTo(var1);
   }

   void writeToInternal(OutputStream var1, int var2, int var3) {
      if(var2 + var3 <= this.leftLength) {
         this.left.writeToInternal(var1, var2, var3);
      } else if(var2 >= this.leftLength) {
         this.right.writeToInternal(var1, var2 - this.leftLength, var3);
      } else {
         int var4 = this.leftLength - var2;
         this.left.writeToInternal(var1, var2, var4);
         this.right.writeToInternal(var1, 0, var3 - var4);
      }

   }

   protected String toStringInternal(Charset var1) {
      return new String(this.toByteArray(), var1);
   }

   public boolean isValidUtf8() {
      int var1 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
      int var2 = this.right.partialIsValidUtf8(var1, 0, this.right.size());
      return var2 == 0;
   }

   protected int partialIsValidUtf8(int var1, int var2, int var3) {
      int var4 = var2 + var3;
      if(var4 <= this.leftLength) {
         return this.left.partialIsValidUtf8(var1, var2, var3);
      } else if(var2 >= this.leftLength) {
         return this.right.partialIsValidUtf8(var1, var2 - this.leftLength, var3);
      } else {
         int var5 = this.leftLength - var2;
         int var6 = this.left.partialIsValidUtf8(var1, var2, var5);
         return this.right.partialIsValidUtf8(var6, 0, var3 - var5);
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ByteString)) {
         return false;
      } else {
         ByteString var2 = (ByteString)var1;
         if(this.totalLength != var2.size()) {
            return false;
         } else if(this.totalLength == 0) {
            return true;
         } else {
            if(this.hash != 0) {
               int var3 = var2.peekCachedHashCode();
               if(var3 != 0 && this.hash != var3) {
                  return false;
               }
            }

            return this.equalsFragments(var2);
         }
      }
   }

   private boolean equalsFragments(ByteString var1) {
      int var2 = 0;
      RopeByteString$PieceIterator var3 = new RopeByteString$PieceIterator(this, (RopeByteString$1)null);
      LiteralByteString var4 = (LiteralByteString)var3.next();
      int var5 = 0;
      RopeByteString$PieceIterator var6 = new RopeByteString$PieceIterator(var1, (RopeByteString$1)null);
      LiteralByteString var7 = (LiteralByteString)var6.next();
      int var8 = 0;

      while(true) {
         int var9 = var4.size() - var2;
         int var10 = var7.size() - var5;
         int var11 = Math.min(var9, var10);
         boolean var12 = var2 == 0?var4.equalsRange(var7, var5, var11):var7.equalsRange(var4, var2, var11);
         if(!var12) {
            return false;
         }

         var8 += var11;
         if(var8 >= this.totalLength) {
            if(var8 == this.totalLength) {
               return true;
            }

            throw new IllegalStateException();
         }

         if(var11 == var9) {
            var2 = 0;
            var4 = (LiteralByteString)var3.next();
         } else {
            var2 += var11;
         }

         if(var11 == var10) {
            var5 = 0;
            var7 = (LiteralByteString)var6.next();
         } else {
            var5 += var11;
         }
      }
   }

   public int hashCode() {
      int var1 = this.hash;
      if(var1 == 0) {
         var1 = this.totalLength;
         var1 = this.partialHash(var1, 0, this.totalLength);
         if(var1 == 0) {
            var1 = 1;
         }

         this.hash = var1;
      }

      return var1;
   }

   protected int peekCachedHashCode() {
      return this.hash;
   }

   protected int partialHash(int var1, int var2, int var3) {
      int var4 = var2 + var3;
      if(var4 <= this.leftLength) {
         return this.left.partialHash(var1, var2, var3);
      } else if(var2 >= this.leftLength) {
         return this.right.partialHash(var1, var2 - this.leftLength, var3);
      } else {
         int var5 = this.leftLength - var2;
         int var6 = this.left.partialHash(var1, var2, var5);
         return this.right.partialHash(var6, 0, var3 - var5);
      }
   }

   public CodedInputStream newCodedInput() {
      return CodedInputStream.newInstance((InputStream)(new RopeByteString$RopeInputStream(this)));
   }

   public InputStream newInput() {
      return new RopeByteString$RopeInputStream(this);
   }

   Object writeReplace() {
      return new LiteralByteString(this.toByteArray());
   }

   private void readObject(ObjectInputStream var1) {
      throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
   }

   public ByteString$ByteIterator iterator() {
      return new RopeByteString$RopeByteIterator(this, (RopeByteString$1)null);
   }

   // $FF: synthetic method
   RopeByteString(ByteString var1, ByteString var2, RopeByteString$1 var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static ByteString access$400(RopeByteString var0) {
      return var0.left;
   }

   // $FF: synthetic method
   static ByteString access$500(RopeByteString var0) {
      return var0.right;
   }

   // $FF: synthetic method
   static int[] access$600() {
      return minLengthByDepth;
   }

   static {
      ArrayList var0 = new ArrayList();
      int var1 = 1;

      int var3;
      for(int var2 = 1; var2 > 0; var2 = var3) {
         var0.add(Integer.valueOf(var2));
         var3 = var1 + var2;
         var1 = var2;
      }

      var0.add(Integer.valueOf(Integer.MAX_VALUE));
      minLengthByDepth = new int[var0.size()];

      for(var3 = 0; var3 < minLengthByDepth.length; ++var3) {
         minLengthByDepth[var3] = ((Integer)var0.get(var3)).intValue();
      }

   }
}
