package y.f;

import y.f.C;
import y.f.E;
import y.f.T;
import y.f.aG;

public class D extends T implements C {
   private E a;
   private aG b = aG.g((byte)0);

   public E getLabelModel() {
      return this.a;
   }

   public void a(E var1) {
      this.a = var1;
   }

   public void a(aG var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.b = var1;
      }
   }

   public aG getPreferredPlacementDescriptor() {
      return this.b;
   }
}
