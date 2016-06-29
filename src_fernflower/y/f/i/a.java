package y.f.i;

import java.util.Iterator;
import y.f.i.E;
import y.f.i.K;
import y.f.i.n;
import y.f.i.v;

public class a extends y.f.a {
   public static final Object a = "y.layout.router.ChannelEdgeRouter.AFFECTED_EDGES";
   private y.f.ah b;
   private y.f.ah c;

   public a() {
      E var1 = new E();
      var1.a(a);
      this.b = var1;
      K var2 = new K();
      var2.a(a);
      this.c = var2;
   }

   public void c(y.f.X var1) {
      boolean var2 = false;
      if(var1.c("y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.b(var1);
         var1.a((Object)"y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", (y.c.c)y.g.q.a((Object)Boolean.TRUE));
         var2 = true;
      }

      this.a(var1);
      if(var1.h() > 0) {
         if(this.b != null) {
            label32: {
               if(this.b instanceof v) {
                  (new n(this.b)).c(var1);
                  if(v.f == 0) {
                     break label32;
                  }
               }

               this.b.c(var1);
            }
         }

         if(this.c != null) {
            this.c.c(var1);
         }
      }

      if(var2) {
         var1.d_("y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
      }

   }

   private void b(y.f.X var1) {
      this.a((y.c.n)var1, (y.f.O)var1);
   }

   private void a(y.c.n var1, y.f.O var2) {
      int var6 = v.f;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(var6 == 0) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   public void b(y.f.ah var1) {
      this.b = var1;
   }
}
