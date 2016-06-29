package y.h;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import y.h.dx;
import y.h.fj;

public abstract class c implements dx {
   private boolean a = true;
   private boolean b;
   private ArrayList c = new ArrayList();

   public boolean a() {
      return this.a;
   }

   public boolean b() {
      return this.a;
   }

   public boolean c() {
      return this.b;
   }

   public void d() {
      if(!this.b) {
         this.b = true;
         this.f();
      }

   }

   public void e() {
      if(this.b) {
         this.b = false;
         this.f();
      }

   }

   protected void f() {
      boolean var4 = fj.z;
      if(!this.c.isEmpty()) {
         ChangeEvent var1 = new ChangeEvent(this);
         ChangeListener[] var2 = new ChangeListener[this.c.size()];
         this.c.toArray(var2);
         int var3 = var2.length - 1;

         while(var3 >= 0) {
            var2[var3].stateChanged(var1);
            --var3;
            if(var4) {
               break;
            }
         }
      }

   }

   public void a(ChangeListener var1) {
      this.c.add(var1);
   }

   public void b(ChangeListener var1) {
      this.c.remove(var1);
   }
}
