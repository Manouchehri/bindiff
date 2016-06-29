package y.h;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import y.h.ch;
import y.h.fj;

class ck implements AdjustmentListener {
   private final ch a;

   ck(ch var1) {
      this.a = var1;
   }

   public void adjustmentValueChanged(AdjustmentEvent var1) {
      if(!ch.access$100(this.a)) {
         if(var1.getAdjustable() == ch.access$200(this.a)) {
            ch.access$300(this.a).a((double)var1.getValue(), ch.access$300(this.a).b.y);
            if(ch.access$300(this.a).getWidth() <= 0) {
               return;
            }

            ch.access$300(this.a).d();
            if(!fj.z) {
               return;
            }
         }

         if(var1.getAdjustable() == ch.access$400(this.a)) {
            ch.access$300(this.a).a(ch.access$300(this.a).b.x, (double)var1.getValue());
            if(ch.access$300(this.a).getWidth() > 0) {
               ch.access$300(this.a).d();
            }
         }

      }
   }
}
