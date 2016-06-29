package y.h;

import y.h.bu;
import y.h.ce;
import y.h.cf;
import y.h.fj;

public class gj implements y.c.o, cf {
   int xe = 0;
   boolean we = false;

   public void onGraph2DSelectionEvent(ce var1) {
      this.we = true;
      if(this.xe == 0) {
         this.updateSelectionState(var1.e());
         this.we = false;
      }

   }

   public void onGraphEvent(y.c.l var1) {
      boolean var2 = fj.z;
      switch(var1.a()) {
      case 2:
      case 4:
      case 8:
      case 9:
      default:
         break;
      case 12:
         ++this.xe;
         if(!var2) {
            break;
         }
      case 13:
         --this.xe;
         if(!this.we || this.xe != 0) {
            break;
         }

         this.updateSelectionState((bu)var1.c());
         this.we = false;
         if(!var2) {
            break;
         }
      case 0:
      case 1:
      case 3:
      case 5:
      case 6:
      case 7:
      case 10:
      case 11:
         this.we = true;
         if(this.xe == 0) {
            this.updateSelectionState((bu)var1.c());
            this.we = false;
         }
      }

   }

   protected void updateSelectionState(bu var1) {
   }
}
