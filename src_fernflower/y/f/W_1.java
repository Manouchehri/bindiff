package y.f;

import y.f.C;
import y.f.E;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aH;
import y.f.aO;
import y.f.aP;
import y.f.aj;
import y.f.z;

public class W implements aH {
   public double a(Q var1) {
      boolean var12 = X.j;
      R var2 = var1.e();
      if(var2 instanceof aj) {
         return 1.0D;
      } else {
         C var3 = (C)var2;
         byte var4 = var3.getPreferredPlacementDescriptor().a();
         E var5 = var3.getLabelModel();
         double var6 = 0.0D;
         double var8 = 0.5D;
         switch(var4) {
         case 1:
            var8 = 0.0D;
            if(!var12) {
               break;
            }
         case 2:
            var8 = 1.0D;
            if(!var12) {
               break;
            }
         case 4:
            var8 = 0.5D;
         case 3:
         }

         Object var10;
         if(var5 instanceof aO) {
            var10 = var1.l();
            aP var11 = (aP)var10;
            var6 = var11.e();
         }

         if(var5 instanceof z) {
            var10 = var1.l();
            int var13 = ((Integer)var10).intValue();
            switch(var13) {
            case 1:
            case 8:
            case 64:
               var6 = 0.05D;
               if(!var12) {
                  break;
               }
            case 2:
            case 16:
            case 128:
               var6 = 0.5D;
               if(!var12) {
                  break;
               }
            case 4:
            case 32:
            case 256:
               var6 = 0.95D;
            }
         }

         return 1.0D - Math.abs((var8 - var6) * 2.0D);
      }
   }
}
