package y.h;

import javax.swing.plaf.basic.*;
import java.util.*;
import java.awt.geom.*;
import y.d.*;
import javax.swing.*;
import java.awt.*;
import java.awt.font.*;

class hh extends a implements ha, hc
{
    static final hh d;
    
    public void a(final gZ gz, final Rectangle2D rectangle2D) {
        final y box = gz.getBox();
        if (rectangle2D.getWidth() < 0.0 || rectangle2D.getHeight() < 0.0) {
            rectangle2D.setRect(box.c, box.d, box.a, box.b);
            if (!fj.z) {
                return;
            }
        }
        rectangle2D.setFrameFromDiagonal(Math.min(box.c, rectangle2D.getX()), Math.min(box.d, rectangle2D.getY()), Math.max(box.c + box.a, rectangle2D.getX() + rectangle2D.getWidth()), Math.max(box.d + box.b, rectangle2D.getY() + rectangle2D.getWidth()));
    }
    
    public void b(final gZ gz, final Graphics2D graphics2D, double n, double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        double n5 = 0.0;
        double n6 = 0.0;
        Label_0124: {
            if (gz.p != null) {
                final double[] b = this.b(gz, hC.a().n);
                this.a(graphics2D, gz.p, n + b[0], n2 + b[1]);
                this.a(gz, b);
                n5 = b[0];
                n6 = b[1];
                if (!z) {
                    break Label_0124;
                }
            }
            final Insets insets = (gz.x == null) ? gZ.defaultInsets : gz.x;
            n5 = n3 - (insets.left + insets.right);
            n6 = n4 - (insets.top + insets.bottom);
        }
        if (gz.o.length() > 0) {
            final Color color = graphics2D.getColor();
            final Font font = graphics2D.getFont();
            final Stroke stroke = graphics2D.getStroke();
            final Color bb = gz.bb;
            if (bb != null) {
                graphics2D.setColor(bb);
            }
            graphics2D.setFont(gz.fb);
            graphics2D.setStroke(dr.a);
            Label_0750: {
                Label_0738: {
                    if (BasicHTML.isHTMLString(gz.o) && gZ.l) {
                        final hC a = hC.a();
                        final JComponent c = this.c(gz);
                        final double[] c2 = this.c(gz, a.n);
                        n += c2[0];
                        n2 += c2[1];
                        SwingUtilities.paintComponent(graphics2D, c, a.f, (int)n, (int)n2, (int)n5, (int)n6);
                        if (!z) {
                            break Label_0738;
                        }
                    }
                    if (bb != null) {
                        final Object q = gz.q;
                        Label_0526: {
                            if (q instanceof ArrayList) {
                                final ArrayList<hi> list = (ArrayList<hi>)q;
                                final double[] c3 = this.c(gz, hC.a().n);
                                n += c3[0];
                                n2 += c3[1];
                                int i = 0;
                                while (i < list.size()) {
                                    final hi hi = list.get(i);
                                    n2 += hi.b;
                                    if (z) {
                                        break Label_0750;
                                    }
                                    double n7 = 0.0;
                                    Label_0441: {
                                        Label_0423: {
                                            switch (gz.j) {
                                                case 0: {
                                                    n7 = 0.0;
                                                    if (z) {
                                                        break Label_0423;
                                                    }
                                                    break Label_0441;
                                                }
                                                case 1: {
                                                    n7 = (n5 - hi.a) / 2.0;
                                                    if (z) {
                                                        break Label_0423;
                                                    }
                                                    break Label_0441;
                                                }
                                                case 2: {
                                                    n7 = n5 - hi.a;
                                                    if (z) {
                                                        break;
                                                    }
                                                    break Label_0441;
                                                }
                                            }
                                        }
                                        n7 = 0.0;
                                    }
                                    graphics2D.drawString(hi.d, (float)(n + n7), (float)n2);
                                    n2 += hi.c;
                                    if (gz.cb) {
                                        final Line2D.Double l = hC.a().l;
                                        l.x1 = n;
                                        final Line2D.Double double1 = l;
                                        final Line2D.Double double2 = l;
                                        final double n8 = n2;
                                        double2.y2 = n8;
                                        double1.y1 = n8;
                                        l.x2 = n + n5;
                                        graphics2D.draw(l);
                                    }
                                    ++i;
                                    if (z) {
                                        break Label_0526;
                                    }
                                }
                                break Label_0738;
                            }
                        }
                        if (q instanceof hi) {
                            final double[] c4 = this.c(gz, hC.a().n);
                            n += c4[0];
                            n2 += c4[1];
                            final hi hi2 = (hi)q;
                            n2 += hi2.b;
                            double n9 = 0.0;
                            Label_0661: {
                                Label_0643: {
                                    switch (gz.j) {
                                        case 0: {
                                            n9 = 0.0;
                                            if (z) {
                                                break Label_0643;
                                            }
                                            break Label_0661;
                                        }
                                        case 1: {
                                            n9 = (n5 - hi2.a) / 2.0;
                                            if (z) {
                                                break Label_0643;
                                            }
                                            break Label_0661;
                                        }
                                        case 2: {
                                            n9 = n5 - hi2.a;
                                            if (z) {
                                                break;
                                            }
                                            break Label_0661;
                                        }
                                    }
                                }
                                n9 = 0.0;
                            }
                            graphics2D.drawString(hi2.d, (float)(n + n9), (float)n2);
                            n2 += hi2.c;
                            if (gz.cb) {
                                final Line2D.Double j = hC.a().l;
                                j.x1 = n;
                                final Line2D.Double double3 = j;
                                final Line2D.Double double4 = j;
                                final double n10 = n2;
                                double4.y2 = n10;
                                double3.y1 = n10;
                                j.x2 = n + n5;
                                graphics2D.draw(j);
                            }
                        }
                    }
                }
                graphics2D.setStroke(stroke);
                graphics2D.setFont(font);
            }
            if (bb != null) {
                graphics2D.setColor(color);
            }
        }
    }
    
    protected void a(final Graphics2D graphics2D, final Icon icon, final double n, final double n2) {
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.translate(n - (int)n, n2 - (int)n2);
        icon.paintIcon(null, graphics2D, (int)n, (int)n2);
        graphics2D.setTransform(transform);
    }
    
    private double[] b(final gZ gz, final double n, final double n2) {
        final boolean z = fj.z;
        double[] array = null;
        double n3 = 0.0;
        double n4 = 0.0;
        Label_0104: {
            if (gz.p != null) {
                final double[] b = this.b(gz, hC.a().n);
                this.a(gz, b);
                n3 = b[0];
                n4 = b[1];
                if (!z) {
                    break Label_0104;
                }
            }
            final Insets insets = (gz.x == null) ? gZ.defaultInsets : gz.x;
            n3 = n - (insets.left + insets.right);
            n4 = n2 - (insets.top + insets.bottom);
        }
        if (gz.o.length() > 0) {
            if (BasicHTML.isHTMLString(gz.o) && gZ.l) {
                final double[] c = this.c(gz, hC.a().n);
                final double n5 = c[0];
                final double n6 = c[1];
                array = new double[] { n5, n6, n5 + n3, n6 + n4 };
            }
            else {
                final Object q = gz.q;
                if (q instanceof ArrayList) {
                    final ArrayList<hi> list = (ArrayList<hi>)q;
                    final double[] c2 = this.c(gz, hC.a().n);
                    final double n7 = c2[0];
                    double n8 = c2[1];
                    for (int i = 0; i < list.size(); ++i) {
                        final hi hi = list.get(i);
                        double n9 = 0.0;
                        Label_0337: {
                            Label_0319: {
                                switch (gz.j) {
                                    case 0: {
                                        n9 = 0.0;
                                        if (z) {
                                            break Label_0319;
                                        }
                                        break Label_0337;
                                    }
                                    case 1: {
                                        n9 = (n3 - hi.a) / 2.0;
                                        if (z) {
                                            break Label_0319;
                                        }
                                        break Label_0337;
                                    }
                                    case 2: {
                                        n9 = n3 - hi.a;
                                        if (z) {
                                            break;
                                        }
                                        break Label_0337;
                                    }
                                }
                            }
                            n9 = 0.0;
                        }
                        Label_0476: {
                            if (array != null) {
                                array[0] = Math.min(array[0], n7 + n9);
                                array[1] = Math.min(array[1], n8);
                                array[2] = Math.max(array[2], n7 + n9 + hi.a);
                                array[3] = Math.max(array[3], n8 + hi.b + hi.c);
                                if (!z) {
                                    break Label_0476;
                                }
                            }
                            array = new double[] { n7 + n9, n8, n7 + n9 + hi.a, n8 + hi.b + hi.c };
                        }
                        n8 += hi.b + hi.c;
                    }
                }
                else if (q instanceof hi) {
                    final double[] c3 = this.c(gz, hC.a().n);
                    final double n10 = c3[0];
                    final double n11 = c3[1];
                    final hi hi2 = (hi)q;
                    double n12 = 0.0;
                    Label_0617: {
                        Label_0599: {
                            switch (gz.j) {
                                case 0: {
                                    n12 = 0.0;
                                    if (z) {
                                        break Label_0599;
                                    }
                                    break Label_0617;
                                }
                                case 1: {
                                    n12 = (n3 - hi2.a) / 2.0;
                                    if (z) {
                                        break Label_0599;
                                    }
                                    break Label_0617;
                                }
                                case 2: {
                                    n12 = n3 - hi2.a;
                                    if (z) {
                                        break;
                                    }
                                    break Label_0617;
                                }
                            }
                        }
                        n12 = 0.0;
                    }
                    array = new double[] { n10 + n12, n11, n10 + n12 + hi2.a, n11 + hi2.b + hi2.c };
                }
            }
        }
        return array;
    }
    
    public n a(final gZ gz) {
        if (this.a()) {
            return this.a(gz, this.d(gz));
        }
        return this.d(gz);
    }
    
    private n d(final gZ gz) {
        final double contentWidth = gz.contentWidth;
        final double contentHeight = gz.contentHeight;
        double[] b = null;
        Label_0037: {
            if (!gz.w) {
                b = null;
                if (!fj.z) {
                    break Label_0037;
                }
            }
            b = this.b(gz, contentWidth, contentHeight);
        }
        if (b == null) {
            Insets insets = gz.getInsets();
            if (insets == null) {
                insets = gZ.defaultInsets;
            }
            return new n(insets.left, insets.top - contentHeight, 0.0, 0.0);
        }
        final double n = b[0];
        final double n2 = b[1];
        final double n3 = b[3] - n2;
        return new n(n, n2 + n3 - contentHeight, b[2] - n, n3);
    }
    
    public n b(final gZ gz) {
        if (this.a()) {
            return this.a(gz, this.e(gz));
        }
        return this.e(gz);
    }
    
    private n e(final gZ gz) {
        final Icon p = gz.p;
        if (p == null) {
            return new n(0.0, -gz.contentHeight, 0.0, 0.0);
        }
        final int iconHeight = p.getIconHeight();
        final double[] b = this.b(gz, new double[2]);
        return new n(b[0], b[1] + iconHeight - gz.contentHeight, p.getIconWidth(), iconHeight);
    }
    
    void a(final gZ gz, final double[] array) {
        final boolean z = fj.z;
        if (BasicHTML.isHTMLString(gz.o) && gZ.l) {
            final JComponent c = this.c(gz);
            array[0] = c.getWidth();
            array[1] = c.getHeight();
            if (!z) {
                return;
            }
        }
        double n = 0.0;
        double n2 = 0.0;
        final Object q = gz.q;
        Label_0198: {
            Label_0194: {
                Label_0146: {
                    if (q instanceof ArrayList) {
                        final ArrayList<hi> list = (ArrayList<hi>)q;
                        int i = list.size() - 1;
                        while (i >= 0) {
                            final hi hi = list.get(i);
                            if (z) {
                                break Label_0198;
                            }
                            if (hi.a > n) {
                                n = hi.a;
                            }
                            n2 += hi.b + hi.c;
                            --i;
                            if (z) {
                                break Label_0146;
                            }
                        }
                        break Label_0194;
                    }
                }
                if (q instanceof hi) {
                    final hi hi2 = (hi)q;
                    if (hi2.a > n) {
                        n = hi2.a;
                    }
                    n2 += hi2.b + hi2.c;
                }
            }
            array[0] = n;
        }
        array[1] = n2;
    }
    
    double[] b(final gZ gz, final double[] array) {
        final boolean z = fj.z;
        if (gz.p == null) {
            return null;
        }
        final Insets insets = (gz.x == null) ? gZ.defaultInsets : gz.x;
        double n = insets.left;
        double n2 = insets.top;
        this.a(gz, array);
        final double n3 = array[0];
        final double n4 = array[1];
        final double n5 = gz.p.getIconWidth();
        final double n6 = gz.p.getIconHeight();
        final boolean b = n3 == 0.0 && n4 == 0.0;
        Label_0202: {
            if (gz.z == 2 && n3 > n5) {
                n += 0.5 * (n3 - n5);
                if (!z) {
                    break Label_0202;
                }
            }
            if (gz.z == 8) {
                n += n3 + (b ? 0 : gz.u);
                if (!z) {
                    break Label_0202;
                }
            }
            if (gz.z == 64) {
                n += Math.max(n3, n5) - n5;
            }
        }
        Label_0329: {
            if (gz.t == 2 && n4 > n6) {
                n2 += 0.5 * (n4 - n6);
                if (!z) {
                    break Label_0329;
                }
            }
            if (gz.t == 1) {
                switch (gz.z) {
                    case 2:
                    case 32:
                    case 64: {
                        n2 += n4 + (b ? 0 : gz.u);
                        if (z) {
                            break;
                        }
                        break Label_0329;
                    }
                }
                if (n4 > n6) {
                    n2 += n4 - n6;
                }
            }
        }
        array[0] = n;
        array[1] = n2;
        return array;
    }
    
    double[] c(final gZ gz, final double[] array) {
        final boolean z = fj.z;
        final Insets insets = (gz.x == null) ? gZ.defaultInsets : gz.x;
        double n = insets.left;
        double n2 = insets.top;
        Label_0325: {
            if (gz.p != null) {
                this.a(gz, array);
                final double n3 = array[0];
                final double n4 = array[1];
                final double n5 = gz.p.getIconWidth();
                final double n6 = gz.p.getIconHeight();
                final boolean b = n3 == 0.0 && n4 == 0.0;
                Label_0200: {
                    if (gz.z == 2 && n5 > n3) {
                        n += 0.5 * (n5 - n3);
                        if (!z) {
                            break Label_0200;
                        }
                    }
                    if (gz.z == 16) {
                        n += n5 + (b ? 0 : gz.u);
                        if (!z) {
                            break Label_0200;
                        }
                    }
                    if (gz.z == 64) {
                        n += Math.max(n3, n5) - n3;
                    }
                }
                if (gz.t == 2 && n6 > n4) {
                    n2 += 0.5 * (n6 - n4);
                    if (!z) {
                        break Label_0325;
                    }
                }
                if (gz.t == 4) {
                    switch (gz.z) {
                        case 2:
                        case 32:
                        case 64: {
                            n2 += n6 + (b ? 0 : gz.u);
                            if (z) {
                                break;
                            }
                            break Label_0325;
                        }
                    }
                    if (n6 > n4) {
                        n2 += n6 - n4;
                    }
                }
            }
        }
        array[0] = n;
        array[1] = n2;
        return array;
    }
    
    JComponent c(final gZ gz) {
        final JLabel e = hC.a().e;
        this.a(e, gz);
        return e;
    }
    
    void a(final JLabel label, final gZ gz) {
        label.setText("");
        label.setFont(gz.fb);
        label.setText(gz.o);
        label.setBackground(gz.k);
        label.setForeground(gz.bb);
        final Dimension preferredSize = label.getPreferredSize();
        label.setSize(preferredSize.width, preferredSize.height);
    }
    
    public void a(final gZ gz, final FontRenderContext fontRenderContext) {
        final boolean z = fj.z;
        double n = 0.0;
        double n2 = 0.0;
        Label_0307: {
            if (BasicHTML.isHTMLString(gz.o) && gZ.l) {
                gz.q = null;
                if (gz.getAutoSizePolicy() == 4) {
                    break Label_0307;
                }
                final JComponent c = this.c(gz);
                n = c.getWidth();
                n2 = c.getHeight();
                if (!z) {
                    break Label_0307;
                }
            }
            final ArrayList<Object> q = new ArrayList<Object>(5);
            String s = gz.o;
            String s3 = null;
        Label_0111_Outer:
            while (true) {
                final int index = s.indexOf("\n");
                while (true) {
                    Label_0162: {
                        if (index < 0) {
                            break Label_0162;
                        }
                        s.substring(0, index);
                        String s2 = s3;
                        if (s2.length() == 0) {
                            s2 = " ";
                        }
                        q.add(new hi(s2, gz.fb, fontRenderContext));
                        s = s.substring(index + 1);
                        if (index >= 0) {
                            continue Label_0111_Outer;
                        }
                    }
                    s3 = s;
                    if (!z) {
                        break;
                    }
                    continue;
                }
            }
            if (s3.length() > 0) {
                q.add(new hi(s, gz.fb, fontRenderContext));
            }
            n2 = (n = 0.0);
            int i = q.size() - 1;
            while (true) {
                while (i >= 0) {
                    final hi hi = q.get(i);
                    final double n3 = dcmpl(hi.a, n);
                    if (z) {
                        if (n3 == 1) {
                            gz.q = q.get(0);
                            if (!z) {
                                break Label_0307;
                            }
                        }
                        q.trimToSize();
                        gz.q = q;
                        break Label_0307;
                    }
                    if (n3 > 0) {
                        n = hi.a;
                    }
                    n2 += hi.b + hi.c;
                    --i;
                    if (z) {
                        break;
                    }
                }
                q.size();
                continue;
            }
        }
        final boolean b = n == 0.0 && n2 == 0.0;
        Label_0591: {
            if (gz.getAutoSizePolicy() != 4 && gz.p != null) {
                switch (gz.z) {
                    case 2:
                    case 32:
                    case 64: {
                        n = Math.max(n, gz.p.getIconWidth());
                        if (gz.t != 2) {
                            n2 += gz.p.getIconHeight() + (b ? 0 : gz.u);
                            if (!z) {
                                break Label_0591;
                            }
                        }
                        n2 = Math.max(n2, gz.p.getIconHeight());
                        if (z) {
                            break;
                        }
                        break Label_0591;
                    }
                }
                if (gz.z == 32) {
                    n = Math.max(n, gz.p.getIconWidth());
                    if (gz.t != 2) {
                        n2 += gz.p.getIconHeight() + (b ? 0 : gz.u);
                        if (!z) {
                            break Label_0591;
                        }
                    }
                    n2 = Math.max(n2, gz.p.getIconHeight());
                    if (!z) {
                        break Label_0591;
                    }
                }
                n2 = Math.max(n2, gz.p.getIconHeight());
                n += gz.p.getIconWidth() + (b ? 0 : gz.u);
            }
        }
        Label_0666: {
            if (gz.getAutoSizePolicy() == 4) {
                n = gz.contentWidth;
                n2 = gz.contentHeight;
                if (!z) {
                    break Label_0666;
                }
            }
            final Insets insets = (gz.x == null) ? gZ.defaultInsets : gz.x;
            n += insets.left + insets.right;
            n2 += insets.top + insets.bottom;
        }
        gz.setContentSize(n, n2);
    }
    
    public boolean a(final gZ gz, final double n, final double n2) {
        return gz.getContentBox().a(n, n2, true);
    }
    
    static {
        d = new hh();
    }
}
