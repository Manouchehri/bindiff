package y.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import y.h.aZ;
import y.h.ba;
import y.h.bb;
import y.h.bc;
import y.h.bd;
import y.h.bf;
import y.h.bg;
import y.h.bh;
import y.h.bi;
import y.h.bj;
import y.h.bk;
import y.h.bl;
import y.h.bm;
import y.h.bn;
import y.h.bo;
import y.h.bp;
import y.h.bq;
import y.h.br;
import y.h.bs;

public final class be {
   private final bc c;
   Map a;
   Set b;

   private be() {
      this.c = new bc("DEFAULT");
      this.a = new HashMap();
      this.b = Collections.unmodifiableSet(this.a.keySet());
   }

   public Map a() {
      return new HashMap();
   }

   public void a(String var1, Map var2) {
      bc var3 = new bc(var1);
      var3.e = (bo)var2.get(aZ.e == null?(aZ.e = aZ.e("y.h.bo")):aZ.e);
      var3.b = (bf)var2.get(aZ.f == null?(aZ.f = aZ.e("y.h.bf")):aZ.f);
      var3.f = (bh)var2.get(aZ.g == null?(aZ.g = aZ.e("y.h.bh")):aZ.g);
      var3.g = (bi)var2.get(aZ.h == null?(aZ.h = aZ.e("y.h.bi")):aZ.h);
      var3.i = (bd)var2.get(aZ.i == null?(aZ.i = aZ.e("y.h.bd")):aZ.i);
      var3.h = (bk)var2.get(aZ.k == null?(aZ.k = aZ.e("y.h.bk")):aZ.k);
      var3.j = (bs)var2.get(aZ.l == null?(aZ.l = aZ.e("y.h.bs")):aZ.l);
      var3.d = (br)var2.get(aZ.m == null?(aZ.m = aZ.e("y.h.br")):aZ.m);
      var3.k = (bb)var2.get(aZ.n == null?(aZ.n = aZ.e("y.h.bb")):aZ.n);
      var3.l = (bl)var2.get(aZ.o == null?(aZ.o = aZ.e("y.h.bl")):aZ.o);
      var3.c = (bp)var2.get(aZ.p == null?(aZ.p = aZ.e("y.h.bp")):aZ.p);
      var3.m = (y.h.a.f)var2.get(aZ.q == null?(aZ.q = aZ.e("y.h.a.f")):aZ.q);
      var3.n = (bg)var2.get(aZ.r == null?(aZ.r = aZ.e("y.h.bg")):aZ.r);
      var3.o = (bj)var2.get(aZ.s == null?(aZ.s = aZ.e("y.h.bj")):aZ.s);
      var3.p = (bq)var2.get(aZ.t == null?(aZ.t = aZ.e("y.h.bq")):aZ.t);
      var3.q = (bn)var2.get(aZ.u == null?(aZ.u = aZ.e("y.h.bn")):aZ.u);
      var3.r = (bm)var2.get(aZ.v == null?(aZ.v = aZ.e("y.h.bm")):aZ.v);
      this.a.put(var1, var3);
   }

   public Object a(String var1, Class var2) {
      bc var3 = (bc)this.a.get(var1);
      if(var3 != null) {
         if(var2 == (aZ.e == null?(aZ.e = aZ.e("y.h.bo")):aZ.e)) {
            return var3.e;
         }

         if(var2 == (aZ.f == null?(aZ.f = aZ.e("y.h.bf")):aZ.f)) {
            return var3.b;
         }

         if(var2 == (aZ.g == null?(aZ.g = aZ.e("y.h.bh")):aZ.g)) {
            return var3.f;
         }

         if(var2 == (aZ.h == null?(aZ.h = aZ.e("y.h.bi")):aZ.h)) {
            return var3.g;
         }

         if(var2 == (aZ.i == null?(aZ.i = aZ.e("y.h.bd")):aZ.i)) {
            return var3.i;
         }

         if(var2 == (aZ.k == null?(aZ.k = aZ.e("y.h.bk")):aZ.k)) {
            return var3.h;
         }

         if(var2 == (aZ.l == null?(aZ.l = aZ.e("y.h.bs")):aZ.l)) {
            return var3.j;
         }

         if(var2 == (aZ.m == null?(aZ.m = aZ.e("y.h.br")):aZ.m)) {
            return var3.d;
         }

         if(var2 == (aZ.n == null?(aZ.n = aZ.e("y.h.bb")):aZ.n)) {
            return var3.k;
         }

         if(var2 == (aZ.o == null?(aZ.o = aZ.e("y.h.bl")):aZ.o)) {
            return var3.l;
         }

         if(var2 == (aZ.p == null?(aZ.p = aZ.e("y.h.bp")):aZ.p)) {
            return var3.c;
         }

         if(var2 == (aZ.q == null?(aZ.q = aZ.e("y.h.a.f")):aZ.q)) {
            return var3.m;
         }

         if(var2 == (aZ.r == null?(aZ.r = aZ.e("y.h.bg")):aZ.r)) {
            return var3.n;
         }

         if(var2 == (aZ.s == null?(aZ.s = aZ.e("y.h.bj")):aZ.s)) {
            return var3.o;
         }

         if(var2 == (aZ.t == null?(aZ.t = aZ.e("y.h.bq")):aZ.t)) {
            return var3.p;
         }

         if(var2 == (aZ.u == null?(aZ.u = aZ.e("y.h.bn")):aZ.u)) {
            return var3.q;
         }

         if(var2 == (aZ.v == null?(aZ.v = aZ.e("y.h.bm")):aZ.v)) {
            return var3.r;
         }
      }

      return null;
   }

   bc b() {
      return this.c;
   }

   bc a(String var1) {
      bc var2 = (bc)this.a.get(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("Given configuration for GenericNodeRealizer does not exist: \"" + var1 + "\"");
      } else {
         return var2;
      }
   }

   public void a(aZ var1, String var2) {
      bc var3 = this.a(var2);
      if(var1.a != var3) {
         var1.a = var3;
         a(var1);
      }

   }

   public Set c() {
      return this.b;
   }

   static void a(aZ var0) {
      bj var1 = var0.a.o;
      if(var1 != null) {
         var1.a(var0);
      }

      var0.invalidatePortPositions();
      var0.setEdgesDirty();
   }

   be(ba var1) {
      this();
   }
}
