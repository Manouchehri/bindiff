package y.h;

import java.beans.PropertyChangeSupport;
import java.util.Stack;
import y.h.ch;
import y.h.gI;
import y.h.gT;
import y.h.gU;
import y.h.gX;

public class gV implements gT {
   private Stack b;
   private gX c;
   private ch d;
   private y.c.D e;
   protected gU a;
   private PropertyChangeSupport f;

   public gV() {
      this.b = new Stack();
      this.e = new y.c.D();
      this.c = null;
      this.f = new PropertyChangeSupport(this);
   }

   public gV(gU var1) {
      this();
      this.a(var1);
   }

   public void a(gU var1) {
      if(this.a != null) {
         this.a();
      }

      if(var1 != null) {
         var1.addViewChangeListener(this);
         this.a = var1;
         this.d = null;
         gI var2 = var1.getCurrentView();
         if(var2 != null && var2 instanceof ch) {
            this.d = (ch)var2;
         }

         if(this.d != null && this.c != null) {
            this.a(this.c);
         }
      }

   }

   public void a() {
      this.a = null;
      if(this.d != null && this.c != null) {
         this.d.removeViewMode(this.c);
      }

   }

   public void b() {
      this.a((gX)this.b.pop());
   }

   protected void a(gX var1) {
      if(this.c != null) {
         b(this.d, this.c);
      }

      this.f.firePropertyChange("Mode", this.c, var1);
      this.c = var1;
      a(this.d, this.c);
   }

   protected static void a(ch var0, gX var1) {
      if(var0 != null && var1 != null) {
         var1.setActiveView(var0);
         var0.addViewMode(var1);
      }
   }

   protected static void b(ch var0, gX var1) {
      if(var0 != null) {
         var0.removeViewMode(var1);
      }
   }
}
