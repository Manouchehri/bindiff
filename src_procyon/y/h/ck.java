package y.h;

import java.awt.event.*;

class ck implements AdjustmentListener
{
    private final ch a;
    
    ck(final ch a) {
        this.a = a;
    }
    
    public void adjustmentValueChanged(final AdjustmentEvent adjustmentEvent) {
        if (ch.access$100(this.a)) {
            return;
        }
        if (adjustmentEvent.getAdjustable() == ch.access$200(this.a)) {
            ch.access$300(this.a).a(adjustmentEvent.getValue(), ch.access$300(this.a).b.y);
            if (ch.access$300(this.a).getWidth() <= 0) {
                return;
            }
            ch.access$300(this.a).d();
            if (!fj.z) {
                return;
            }
        }
        if (adjustmentEvent.getAdjustable() == ch.access$400(this.a)) {
            ch.access$300(this.a).a(ch.access$300(this.a).b.x, adjustmentEvent.getValue());
            if (ch.access$300(this.a).getWidth() > 0) {
                ch.access$300(this.a).d();
            }
        }
    }
}
