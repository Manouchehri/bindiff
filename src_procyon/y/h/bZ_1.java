package y.h;

import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

public class bZ extends bY
{
    void a() {
        final boolean z = fj.z;
        this.f.setFrame(0.0, 0.0, 0.0, 0.0);
        if (this.a != null && !"".equals(this.a)) {
            this.e = new TextLayout(this.a, this.b, this.d.b.getFontRenderContext());
            final double n = this.e.getBounds().getHeight() + 20.0;
            final Paper paper = this.d.a.getPaper();
            Label_0249: {
                if (this.d.a.getOrientation() == 1) {
                    this.f = new Rectangle2D.Double(paper.getImageableX(), paper.getImageableY(), paper.getImageableWidth(), n);
                    if (!z) {
                        break Label_0249;
                    }
                }
                if (this.d.a.getOrientation() == 0) {
                    this.f = new Rectangle2D.Double(paper.getHeight() - paper.getImageableY() - paper.getImageableHeight(), paper.getImageableX(), paper.getImageableHeight(), n);
                    if (!z) {
                        break Label_0249;
                    }
                }
                if (this.d.a.getOrientation() == 2) {
                    this.f = new Rectangle2D.Double(paper.getImageableY(), paper.getWidth() - paper.getImageableX() - paper.getImageableWidth(), paper.getImageableHeight(), n);
                }
            }
            final Rectangle2D.Double f = this.f;
            f.x -= this.d.d * this.f.width;
            final Rectangle2D.Double f2 = this.f;
            f2.y -= this.d.e * paper.getImageableHeight();
            final Rectangle2D.Double f3 = this.f;
            f3.width *= this.d.g;
        }
    }
}
