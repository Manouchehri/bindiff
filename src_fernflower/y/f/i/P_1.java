package y.f.i;

import y.f.i.Q;
import y.f.i.R;

class P extends R {
   private final Q a;

   P(byte var1, double var2, Q var4) {
      super(var1, var2);
      this.a = var4;
   }

   Q a() {
      return this.a;
   }

   public int compareTo(Object var1) {
      R var2 = (R)var1;
      int var3 = y.g.e.a(this.j(), var2.j());
      if(var3 != 0) {
         return var3;
      } else {
         switch(this.k()) {
         case 3:
            switch(var2.k()) {
            case 3:
               return 0;
            case 4:
               return 1;
            default:
               return 0;
            }
         case 4:
            switch(var2.k()) {
            case 3:
               return -1;
            case 4:
               return 0;
            default:
               return 0;
            }
         default:
            return 0;
         }
      }
   }

   public String toString() {
      return "x = " + this.j() + ", type = " + (this.k() == 3?"Start":"End");
   }
}
