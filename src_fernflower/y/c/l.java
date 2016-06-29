package y.c;

import java.util.EventObject;
import y.c.d;
import y.c.i;
import y.c.q;

public class l extends EventObject {
   private Object a;
   private byte b;

   public l(i var1, byte var2, Object var3) {
      super(var1);
      this.b = var2;
      this.a = var3;
   }

   public byte a() {
      return this.b;
   }

   public Object b() {
      return this.a;
   }

   public i c() {
      return (i)this.getSource();
   }

   public String toString() {
      return this.a(this.a());
   }

   private String a(byte var1) {
      switch(var1) {
      case 0:
         return "NODE_CREATION";
      case 1:
         return "EDGE_CREATION";
      case 2:
         return "PRE_NODE_REMOVAL";
      case 3:
         return "POST_NODE_REMOVAL";
      case 4:
         return "PRE_EDGE_REMOVAL";
      case 5:
         return "POST_EDGE_REMOVAL";
      case 6:
         return "NODE_REINSERTION";
      case 7:
         return "EDGE_REINSERTION";
      case 8:
         return "PRE_EDGE_CHANGE";
      case 9:
         return "POST_EDGE_CHANGE";
      case 10:
         return "SUBGRAPH_INSERTION";
      case 11:
         return "SUBGRAPH_REMOVAL";
      case 12:
         return "PRE_EVENT";
      case 13:
         return "POST_EVENT";
      default:
         return "UNKNOWN TYPE (" + var1 + ")";
      }
   }

   static l a(i var0, q var1) {
      return new l(var0, (byte)0, var1);
   }

   static l a(i var0, d var1) {
      return new l(var0, (byte)1, var1);
   }

   static l b(i var0, q var1) {
      return new l(var0, (byte)2, var1);
   }

   static l c(i var0, q var1) {
      return new l(var0, (byte)3, var1);
   }

   static l b(i var0, d var1) {
      return new l(var0, (byte)4, var1);
   }

   static l c(i var0, d var1) {
      return new l(var0, (byte)5, var1);
   }

   static l d(i var0, q var1) {
      return new l(var0, (byte)6, var1);
   }

   static l d(i var0, d var1) {
      return new l(var0, (byte)7, var1);
   }

   static l a(i var0) {
      return new l(var0, (byte)12, (Object)null);
   }

   static l b(i var0) {
      return new l(var0, (byte)13, (Object)null);
   }
}
