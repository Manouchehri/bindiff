package y.e;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import y.c.q;
import y.c.x;
import y.e.c;
import y.e.i;
import y.g.o;
import y.h.aB;
import y.h.bV;
import y.h.bu;
import y.h.fj;
import y.h.a.v;

public class h extends c {
   private v v;
   private boolean w;
   protected static Map b = new HashMap();
   protected static Map c = new HashMap();
   private Map x;
   static Class d;
   static Class e;
   static Class f;
   static Class g;
   static Class h;
   static Class i;
   static Class j;
   static Class k;
   static Class l;
   static Class m;
   static Class n;
   static Class o;
   static Class p;
   static Class q;
   static Class r;
   static Class s;
   static Class t;
   static Class u;

   public static void a(String var0, String var1) {
      b.put(var0, var1);
      c.put(var1, var0);
   }

   public static String a(String var0) {
      String var1 = (String)c.get(var0);
      return var1 != null?var1:var0;
   }

   public static String b(String var0) {
      String var1 = (String)b.get(var0);
      return var1 != null?var1:var0;
   }

   public void a(bu var1, OutputStream var2) {
      o.a(this, "writeOS");
      this.v = v.a((y.c.i)var1);
      ObjectOutputStream var3 = this.a(var2);
      byte var4 = 3;
      if(this.x.size() > 0) {
         var4 = 4;
      }

      var3.writeByte(var4);
      var3.flush();
      GZIPOutputStream var5 = new GZIPOutputStream(var2);
      var3 = this.a((OutputStream)var5);
      this.b(var1, var3);
      if(var4 > 3) {
         this.a(var1, var3);
      }

      var3.flush();
      var5.flush();
      var5.finish();
   }

   void a(bu var1, ObjectOutputStream var2) {
      int var5 = c.a;
      var2.writeInt(305419896);
      var2.writeInt(this.x.size());
      Iterator var3 = this.x.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.writeObject(var4.getKey());
         this.a(var1, (i)var4.getValue(), var2);
         if(var5 != 0) {
            break;
         }
      }

   }

   void a(bu var1, i var2, ObjectOutputStream var3) {
      int var9 = c.a;
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      ObjectOutputStream var5 = new ObjectOutputStream(var4);
      var2.a(var1, var1, var5);
      v var6 = var1.C();
      x var7 = var1.o();

      while(var7.f()) {
         q var8 = var7.e();
         var2.a(var1, var8, var5);
         if(var6 != null && var6.j(var8)) {
            this.a((bu)var6.m(var8), var2, var5);
         }

         var7.g();
         if(var9 != 0) {
            break;
         }
      }

      y.c.e var10 = var1.p();

      while(true) {
         if(var10.f()) {
            y.c.d var11 = var10.a();
            var2.a(var1, var11, var5);
            var10.g();
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
               continue;
            }
         }

         var5.flush();
         var5.close();
         var4.flush();
         var3.writeInt(var4.size());
         var4.writeTo(var3);
         break;
      }

   }

   protected void b(bu var1, ObjectOutputStream var2) {
      int var6;
      label40: {
         var6 = c.a;
         o.a(this, "writeOOS");
         var2.writeByte(2);
         if(this.v != null) {
            this.w = this.v.f();
            if(var6 == 0) {
               break label40;
            }
         }

         this.w = false;
      }

      boolean var3 = this.v != null;
      var2.writeBoolean(this.w);
      var2.writeBoolean(var3);
      var2.writeInt(var1.f());
      x var4 = var1.o();

      while(true) {
         if(var4.f()) {
            this.a(var1, var4.e(), var2);
            var4.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         var2.writeInt(var1.h());
         break;
      }

      y.c.e var7 = var1.p();

      while(var7.f()) {
         y.c.d var5 = var7.a();
         var2.writeInt(var5.c().d());
         var2.writeInt(var5.d().d());
         this.a(var1, var5, var2);
         var7.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(bu var1, y.c.d var2, ObjectOutputStream var3) {
      var3.writeByte(1);
      this.b(var1, var2, var3);
      this.c(var1, var2, var3);
   }

   protected void b(bu var1, y.c.d var2, ObjectOutputStream var3) {
      aB var4 = var1.i(var2);
      var3.writeObject(a(var4.getClass().getName()));
      var4.write(var3);
   }

   protected void c(bu var1, y.c.d var2, ObjectOutputStream var3) {
      int var8 = c.a;
      if(this.v != null) {
         if(this.v.e(var2)) {
            label82: {
               var3.writeBoolean(true);
               q var4 = this.v.b(var2);
               if(var4 != var2.c()) {
                  var3.writeBoolean(true);
                  Object[] var5 = this.v.a((Object)var4);
                  int var6 = 1;

                  while(var6 < var5.length && var5[var6] != var2.c()) {
                     ++var6;
                     if(var8 != 0) {
                        break;
                     }
                  }

                  var3.writeInt(var5.length - var6);
                  ++var6;

                  label69: {
                     while(var6 < var5.length) {
                        var3.writeInt(((q)var5[var6]).d());
                        ++var6;
                        if(var8 != 0) {
                           break label69;
                        }

                        if(var8 != 0) {
                           break;
                        }
                     }

                     var3.writeInt(var4.d());
                  }

                  if(var8 == 0) {
                     break label82;
                  }
               }

               var3.writeBoolean(false);
            }

            q var9 = this.v.c(var2);
            if(var9 != var2.d()) {
               var3.writeBoolean(true);
               Object[] var10 = this.v.a((Object)var9);
               int var7 = 1;

               while(var7 < var10.length && var10[var7] != var2.d()) {
                  ++var7;
                  if(var8 != 0) {
                     break;
                  }
               }

               var3.writeInt(var10.length - var7);
               ++var7;

               while(true) {
                  if(var7 < var10.length) {
                     var3.writeInt(((q)var10[var7]).d());
                     ++var7;
                     if(var8 != 0) {
                        break;
                     }

                     if(var8 == 0) {
                        continue;
                     }
                  }

                  var3.writeInt(var9.d());
                  break;
               }

               if(var8 == 0) {
                  return;
               }
            }

            var3.writeBoolean(false);
            if(var8 == 0) {
               return;
            }
         }

         var3.writeBoolean(false);
      }
   }

   protected void a(bu var1, q var2, ObjectOutputStream var3) {
      var3.writeByte(2);
      this.b(var1, var2, var3);
      this.c(var1, var2, var3);
      this.d(var1, var2, var3);
   }

   protected void b(bu var1, q var2, ObjectOutputStream var3) {
      fj var4 = var1.t(var2);
      var3.writeObject(a(var4.getClass().getName()));
      var4.write(var3);
      if(var4 instanceof bV && this.v == null) {
         this.b(((bV)var4).g(), var3);
      }

   }

   protected void c(bu var1, q var2, ObjectOutputStream var3) {
      if(this.v != null) {
         if(this.v.j(var2)) {
            var3.writeBoolean(true);
            this.b((bu)this.v.m(var2), var3);
            if(c.a == 0) {
               return;
            }
         }

         var3.writeBoolean(false);
      }
   }

   protected void d(bu var1, q var2, ObjectOutputStream var3) {
      if(this.v != null && this.w) {
         var3.writeBoolean(this.v.k(var2));
         q var4 = this.v.n(var2);
         if(var4 != null && this.v.k(var4)) {
            var3.writeInt(var4.d());
            if(c.a == 0) {
               return;
            }
         }

         var3.writeInt(-1);
      }
   }

   protected ObjectOutputStream a(OutputStream var1) {
      return new ObjectOutputStream(var1);
   }

   static Class c(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      StringBuffer var0 = new StringBuffer("y.view.");
      a(var0.toString() + "ShapeNodeRealizer", (d == null?(d = c("y.h.gn")):d).getName());
      a(var0.toString() + "ImageNodeRealizer", (e == null?(e = c("y.h.df")):e).getName());
      a(var0.toString() + "Graph2DNodeRealizer", (f == null?(f = c("y.h.bV")):f).getName());
      a(var0.toString() + "GenericNodeRealizer", (g == null?(g = c("y.h.aZ")):g).getName());
      a(var0.toString() + "GenericGroupNodeRealizer", (h == null?(h = c("y.h.a.e")):h).getName());
      a(var0.toString() + "tabular.TableGroupNodeRealizer", (i == null?(i = c("y.h.b.a")):i).getName());
      a(var0.toString() + "hierarchy.GroupNodeRealizer", (j == null?(j = c("y.h.a.p")):j).getName());
      a(var0.toString() + "ProxyShapeNodeRealizer", (k == null?(k = c("y.h.gd")):k).getName());
      a(var0.toString() + "hierarchy.ProxyAutoBoundsNodeRealizer", (l == null?(l = c("y.h.a.L")):l).getName());
      a(var0.toString() + "PolyLineEdgeRealizer", (m == null?(m = c("y.h.fJ")):m).getName());
      a(var0.toString() + "QuadCurveEdgeRealizer", (n == null?(n = c("y.h.ge")):n).getName());
      a(var0.toString() + "GenericEdgeRealizer", (o == null?(o = c("y.h.aF")):o).getName());
      a(var0.toString() + "ArcEdgeRealizer", (p == null?(p = c("y.h.g")):p).getName());
      a(var0.toString() + "BezierEdgeRealizer", (q == null?(q = c("y.h.B")):q).getName());
      a(var0.toString() + "SplineEdgeRealizer", (r == null?(r = c("y.h.gD")):r).getName());
      a(var0.toString() + "Port", (s == null?(s = c("y.h.fL")):s).getName());
      a(var0.toString() + "InterfacePort", (t == null?(t = c("y.h.dg")):t).getName());
      a(var0.toString() + "tabular.TableStyle.SimpleStyle", (u == null?(u = c("y.h.b.Z")):u).getName());
      var0.setLength(0);
      var0.append("demo.uml.");
      a(var0.toString() + "ClassNodeRealizer", "demo.uml.ClassNodeRealizer");
      a(var0.toString() + "NoteNodeRealizer", "demo.uml.NoteNodeRealizer");
      b.put(var0.toString() + "UMLClassNodeRealizer", "demo.uml.ClassNodeRealizer");
      b.put(var0.toString() + "UMLNoteNodeRealizer", "demo.uml.NoteNodeRealizer");
   }
}
