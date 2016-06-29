package y.h;

import java.awt.event.MouseEvent;
import java.util.EventObject;
import y.h.fj;

public class dw extends EventObject {
   private final Object a;
   private final double b;
   private final double c;
   private final int d;
   private final long e;
   private final int f;
   private final int g;
   private final int h;
   private final boolean i;

   public double a() {
      return this.b;
   }

   public double b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public int d() {
      return this.f;
   }

   public int e() {
      return this.g;
   }

   public int f() {
      return this.h;
   }

   public dw(Object var1, Object var2, int var3, long var4, int var6, double var7, double var9, int var11, int var12, boolean var13) {
      super(var1);
      this.a = var2;
      this.c = var9;
      this.b = var7;
      this.d = var3;
      this.e = var4;
      this.f = var6;
      this.g = var11;
      this.h = var12;
      this.i = var13;
   }

   public dw(Object var1, Object var2, double var3, double var5, MouseEvent var7) {
      this(var1, var2, var7.getID(), var7.getWhen(), var7.getModifiersEx(), var3, var5, var7.getButton(), var7.getClickCount(), var7.isPopupTrigger());
   }

   public String toString() {
      boolean var2 = fj.z;
      String var1;
      switch(this.d) {
      case 500:
         var1 = "MOUSE_CLICKED";
         if(!var2) {
            break;
         }
      case 506:
         var1 = "MOUSE_DRAGGED";
         if(!var2) {
            break;
         }
      case 505:
         var1 = "MOUSE_EXITED";
         if(!var2) {
            break;
         }
      case 504:
         var1 = "MOUSE_ENTERED";
         if(!var2) {
            break;
         }
      case 501:
         var1 = "MOUSE_PRESSED";
         if(!var2) {
            break;
         }
      case 502:
         var1 = "MOUSE_RELEASED";
         if(!var2) {
            break;
         }
      case 503:
         var1 = "MOUSE_MOVED";
         if(!var2) {
            break;
         }
      default:
         var1 = "unknown";
      }

      return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + var1 + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
   }
}
