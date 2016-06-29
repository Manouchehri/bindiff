package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.util.Arrays;
import java.util.Stack;

class RopeByteString$Balancer {
   private final Stack prefixesStack;

   private RopeByteString$Balancer() {
      this.prefixesStack = new Stack();
   }

   private ByteString balance(ByteString var1, ByteString var2) {
      this.doBalance(var1);
      this.doBalance(var2);

      Object var3;
      ByteString var4;
      for(var3 = (ByteString)this.prefixesStack.pop(); !this.prefixesStack.isEmpty(); var3 = new RopeByteString(var4, (ByteString)var3, (RopeByteString$1)null)) {
         var4 = (ByteString)this.prefixesStack.pop();
      }

      return (ByteString)var3;
   }

   private void doBalance(ByteString var1) {
      if(var1.isBalanced()) {
         this.insert(var1);
      } else {
         if(!(var1 instanceof RopeByteString)) {
            String var3 = String.valueOf(String.valueOf(var1.getClass()));
            throw new IllegalArgumentException((new StringBuilder(49 + var3.length())).append("Has a new type of ByteString been created? Found ").append(var3).toString());
         }

         RopeByteString var2 = (RopeByteString)var1;
         this.doBalance(RopeByteString.access$400(var2));
         this.doBalance(RopeByteString.access$500(var2));
      }

   }

   private void insert(ByteString var1) {
      int var2 = this.getDepthBinForLength(var1.size());
      int var3 = RopeByteString.access$600()[var2 + 1];
      if(!this.prefixesStack.isEmpty() && ((ByteString)this.prefixesStack.peek()).size() < var3) {
         int var4 = RopeByteString.access$600()[var2];

         Object var5;
         ByteString var6;
         for(var5 = (ByteString)this.prefixesStack.pop(); !this.prefixesStack.isEmpty() && ((ByteString)this.prefixesStack.peek()).size() < var4; var5 = new RopeByteString(var6, (ByteString)var5, (RopeByteString$1)null)) {
            var6 = (ByteString)this.prefixesStack.pop();
         }

         RopeByteString var7;
         for(var7 = new RopeByteString((ByteString)var5, var1, (RopeByteString$1)null); !this.prefixesStack.isEmpty(); var7 = new RopeByteString(var6, var7, (RopeByteString$1)null)) {
            var2 = this.getDepthBinForLength(var7.size());
            var3 = RopeByteString.access$600()[var2 + 1];
            if(((ByteString)this.prefixesStack.peek()).size() >= var3) {
               break;
            }

            var6 = (ByteString)this.prefixesStack.pop();
         }

         this.prefixesStack.push(var7);
      } else {
         this.prefixesStack.push(var1);
      }

   }

   private int getDepthBinForLength(int var1) {
      int var2 = Arrays.binarySearch(RopeByteString.access$600(), var1);
      if(var2 < 0) {
         int var3 = -(var2 + 1);
         var2 = var3 - 1;
      }

      return var2;
   }

   // $FF: synthetic method
   RopeByteString$Balancer(RopeByteString$1 var1) {
      this();
   }

   // $FF: synthetic method
   static ByteString access$100(RopeByteString$Balancer var0, ByteString var1, ByteString var2) {
      return var0.balance(var1, var2);
   }
}
