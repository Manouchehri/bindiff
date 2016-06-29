package y.f;

import y.f.X;
import y.f.aE;
import y.f.an;

class aq extends y.g.p {
   y.c.c a;
   private final an b;

   aq(an var1, y.c.c var2) {
      this.b = var1;
      this.a = var2;
   }

   public Object b(Object var1) {
      aE var2 = (aE)this.a.b(var1);
      if(var2 != null && !var2.g()) {
         boolean var3 = var2.a();
         byte var4 = this.b.b();
         if(this.b.b(var4)) {
            switch(var4) {
            case 1:
               switch(var2.b()) {
               case 1:
                  return aE.a((byte)8, var3);
               case 2:
                  return aE.a((byte)4, var3);
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 4:
                  return aE.a((byte)2, var3);
               case 8:
                  return aE.a((byte)1, var3);
               }
            case 3:
               switch(var2.b()) {
               case 1:
                  return aE.a((byte)4, var3);
               case 2:
                  return aE.a((byte)8, var3);
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 4:
                  return aE.a((byte)1, var3);
               case 8:
                  return aE.a((byte)2, var3);
               }
            case 2:
               switch(var2.b()) {
               case 1:
                  return aE.a((byte)2, var3);
               case 2:
                  return aE.a((byte)1, var3);
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 4:
                  return var2;
               case 8:
                  return var2;
               }
            case 0:
               switch(var2.b()) {
               case 1:
                  return var2;
               case 2:
                  return var2;
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 4:
                  return aE.a((byte)8, var3);
               case 8:
                  return aE.a((byte)4, var3);
               }
            }

            if(!X.j) {
               return var2;
            }
         }

         switch(var4) {
         case 1:
            switch(var2.b()) {
            case 1:
               return aE.a((byte)4, var3);
            case 2:
               return aE.a((byte)8, var3);
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4:
               return aE.a((byte)2, var3);
            case 8:
               return aE.a((byte)1, var3);
            }
         case 3:
            switch(var2.b()) {
            case 1:
               return aE.a((byte)8, var3);
            case 2:
               return aE.a((byte)4, var3);
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4:
               return aE.a((byte)1, var3);
            case 8:
               return aE.a((byte)2, var3);
            }
         case 2:
            switch(var2.b()) {
            case 1:
               return aE.a((byte)2, var3);
            case 2:
               return aE.a((byte)1, var3);
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4:
               return aE.a((byte)8, var3);
            case 8:
               return aE.a((byte)4, var3);
            }
         }
      }

      return var2;
   }
}
