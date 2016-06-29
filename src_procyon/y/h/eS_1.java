package y.h;

import java.awt.font.*;

final class eS implements hc
{
    public void a(final gZ gz, final FontRenderContext fontRenderContext) {
        final boolean z = fj.z;
        if (gz instanceof eR) {
            final eR er = (eR)gz;
            hh.d.a(gz, fontRenderContext);
            er.sizeDirty = false;
            double n = er.contentHeight;
            double n2 = er.contentWidth;
            Label_0149: {
                switch (er.v) {
                    case 4: {
                        if (z) {
                            break Label_0149;
                        }
                        break;
                    }
                    case 2: {
                        final fj g = er.g();
                        if (g == null) {
                            break;
                        }
                        n = Math.max(n, g.getHeight());
                        if (z) {
                            break Label_0149;
                        }
                        break;
                    }
                    case 3: {
                        final fj g2 = er.g();
                        if (g2 == null) {
                            break;
                        }
                        n2 = Math.max(n2, g2.getWidth());
                        n = Math.max(n, g2.getHeight());
                        if (z) {
                            break Label_0149;
                        }
                        break;
                    }
                    case 1: {
                        final fj g3 = er.g();
                        if (g3 != null) {
                            n2 = Math.max(n2, g3.getWidth());
                            break;
                        }
                        break;
                    }
                }
            }
            er.setContentSize(n2, n);
        }
    }
    
    public boolean a(final gZ gz, final double n, final double n2) {
        return gz.getContentBox().a(n, n2, true);
    }
}
