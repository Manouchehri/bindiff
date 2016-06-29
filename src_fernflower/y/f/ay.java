package y.f;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.f.aA;
import y.f.aB;
import y.f.aC;
import y.f.aD;
import y.f.ax;
import y.f.az;

public class ay {
   public static final Object a = "y.layout.PortCandidateSet.DP_KEY";
   static final Comparator b = new aC();
   private List c = new ArrayList();
   private long d;

   public void a(ax var1) {
      this.a(var1, 1);
   }

   public void a(ax var1, int var2) {
      if(var2 > 0) {
         this.d += (long)var2;
         this.c.add(new aB(var1, var2));
      }

   }

   public Iterator a() {
      return this.c.iterator();
   }

   public az b() {
      return new aD(this, this.c);
   }

   protected double a(aA var1, y.c.d var2, boolean var3) {
      return -var1.a().f();
   }
}
