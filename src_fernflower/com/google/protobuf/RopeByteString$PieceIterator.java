package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString$PieceIterator implements Iterator {
   private final Stack breadCrumbs;
   private LiteralByteString next;

   private RopeByteString$PieceIterator(ByteString var1) {
      this.breadCrumbs = new Stack();
      this.next = this.getLeafByLeft(var1);
   }

   private LiteralByteString getLeafByLeft(ByteString var1) {
      ByteString var2;
      RopeByteString var3;
      for(var2 = var1; var2 instanceof RopeByteString; var2 = RopeByteString.access$400(var3)) {
         var3 = (RopeByteString)var2;
         this.breadCrumbs.push(var3);
      }

      return (LiteralByteString)var2;
   }

   private LiteralByteString getNextNonEmptyLeaf() {
      LiteralByteString var1;
      do {
         if(this.breadCrumbs.isEmpty()) {
            return null;
         }

         var1 = this.getLeafByLeft(RopeByteString.access$500((RopeByteString)this.breadCrumbs.pop()));
      } while(var1.isEmpty());

      return var1;
   }

   public boolean hasNext() {
      return this.next != null;
   }

   public LiteralByteString next() {
      if(this.next == null) {
         throw new NoSuchElementException();
      } else {
         LiteralByteString var1 = this.next;
         this.next = this.getNextNonEmptyLeaf();
         return var1;
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   RopeByteString$PieceIterator(ByteString var1, RopeByteString$1 var2) {
      this(var1);
   }
}
