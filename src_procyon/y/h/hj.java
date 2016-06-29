package y.h;

import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.font.*;
import y.d.*;
import java.awt.geom.*;

final class hj extends a
{
    static final hj d;
    
    public void b(final gZ gz, final Graphics2D graphics2D, double n, double n2, double n3, double n4) {
        final boolean z = fj.z;
        if (gz.o.length() > 0 && gz.bb != null) {
            Insets insets = gz.getInsets();
            if (insets == null) {
                insets = gZ.defaultInsets;
            }
            n += insets.left;
            n2 += insets.top;
            final float n5 = (float)n;
            float n6 = (float)n2;
            n3 -= insets.left + insets.right;
            n4 -= insets.top + insets.bottom;
            if (n3 <= 0.0 || n4 <= 0.0) {
                return;
            }
            final Color color = graphics2D.getColor();
            graphics2D.setColor(gz.bb);
            final HashMap<TextAttribute, Font> hashMap = new HashMap<TextAttribute, Font>();
            hashMap.put(TextAttribute.FONT, gz.fb);
            if (gz.cb) {
                hashMap.put(TextAttribute.UNDERLINE, (Font)TextAttribute.UNDERLINE_ON);
            }
            final Shape clip = graphics2D.getClip();
            graphics2D.clip(new Rectangle2D.Double(n, n2, n3, n4));
            final LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(new AttributedString(gz.o, hashMap).getIterator(), graphics2D.getFontRenderContext());
            final int n7 = graphics2D.getFontMetrics(gz.fb).getHeight() - 1;
            final boolean b = gz.j == 2;
            final boolean b2 = gz.j == 1;
            try {
                int n8 = gz.o.indexOf(10);
                if (n8 == -1) {
                    n8 = gz.o.length();
                }
                while (n8 <= lineBreakMeasurer.getPosition() && lineBreakMeasurer.getPosition() < gz.o.length()) {
                    final TextLayout nextLayout = lineBreakMeasurer.nextLayout(100.0f, n8 + 1, false);
                    n6 += nextLayout.getAscent() + nextLayout.getLeading() + nextLayout.getDescent();
                    n8 = gz.o.indexOf(10, n8 + 1);
                    if (n8 == -1) {
                        n8 = gz.o.length();
                        if (z) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        continue;
                    }
                }
                while (lineBreakMeasurer.getPosition() < gz.o.length()) {
                    if (n2 + n4 < n6 + 2 * n7) {
                        final TextLayout textLayout = new TextLayout("\u2026", hashMap, graphics2D.getFontRenderContext());
                        final float advance = textLayout.getAdvance();
                        if (lineBreakMeasurer.nextOffset((float)n3, n8, false) >= gz.o.length()) {
                            final TextLayout nextLayout2 = lineBreakMeasurer.nextLayout((float)n3);
                            if (nextLayout2 == null) {
                                return;
                            }
                            nextLayout2.draw(graphics2D, n5 + (b2 ? (((float)n3 - nextLayout2.getAdvance()) * 0.5f) : ((nextLayout2.isLeftToRight() && !b) ? 0.0f : ((float)n3 - nextLayout2.getAdvance()))), n6 + nextLayout2.getAscent());
                        }
                        else {
                            if (n3 <= advance) {
                                textLayout.draw(graphics2D, n5 + (b2 ? (((float)n3 - textLayout.getAdvance()) * 0.5f) : ((textLayout.isLeftToRight() && !b) ? 0.0f : ((float)n3 - textLayout.getAdvance()))), n6 + textLayout.getAscent());
                                return;
                            }
                            final TextLayout nextLayout3 = lineBreakMeasurer.nextLayout((float)n3 - advance, n8, false);
                            if (lineBreakMeasurer.getPosition() == n8 && gz.o.indexOf(10, n8 + 1) == -1) {
                                gz.o.length();
                            }
                            if (nextLayout3 != null) {
                                final float n9 = n6 + nextLayout3.getAscent();
                                if (lineBreakMeasurer.getPosition() < gz.o.length()) {
                                    final float n10 = nextLayout3.getAdvance() + textLayout.getAdvance();
                                    final float n11 = b2 ? (((float)n3 - n10) * 0.5f) : ((nextLayout3.isLeftToRight() && !b) ? 0.0f : ((float)n3 - n10));
                                    nextLayout3.draw(graphics2D, n5 + n11, n9);
                                    textLayout.draw(graphics2D, n5 + (n11 + nextLayout3.getAdvance()), n9);
                                    if (!z) {
                                        return;
                                    }
                                }
                                nextLayout3.draw(graphics2D, n5 + (b2 ? (((float)n3 - nextLayout3.getAdvance()) * 0.5f) : ((nextLayout3.isLeftToRight() && !b) ? 0.0f : ((float)n3 - nextLayout3.getAdvance()))), n9);
                            }
                        }
                    }
                    else {
                        final TextLayout nextLayout4 = lineBreakMeasurer.nextLayout((float)n3, n8, false);
                        if (nextLayout4 == null) {
                            return;
                        }
                        if (lineBreakMeasurer.getPosition() == n8) {
                            n8 = gz.o.indexOf(10, n8 + 1);
                            if (n8 == -1) {
                                n8 = gz.o.length();
                            }
                        }
                        final float n12 = n6 + nextLayout4.getAscent();
                        final float n13 = b2 ? (((float)n3 - nextLayout4.getAdvance()) * 0.5f) : ((nextLayout4.isLeftToRight() && !b) ? 0.0f : ((float)n3 - nextLayout4.getAdvance()));
                        final float n14 = nextLayout4.getDescent() + nextLayout4.getLeading();
                        nextLayout4.draw(graphics2D, n5 + n13, n12);
                        n6 = n12 + n14;
                        if (z) {
                            break;
                        }
                        continue;
                    }
                }
            }
            finally {
                graphics2D.setClip(clip);
                graphics2D.setColor(color);
            }
        }
    }
    
    private double[] a(final gZ gz, final FontRenderContext fontRenderContext, double n, double n2) {
        final boolean z = fj.z;
        double[] array = null;
        if (gz.o.length() > 0 && gz.bb != null) {
            Insets insets = gz.getInsets();
            if (insets == null) {
                insets = gZ.defaultInsets;
            }
            final float n3 = insets.left;
            float n4 = insets.top;
            n -= insets.left + insets.right;
            n2 -= insets.top + insets.bottom;
            if (n <= 0.0 || n2 <= 0.0) {
                return array;
            }
            final HashMap<TextAttribute, Font> hashMap = new HashMap<TextAttribute, Font>();
            hashMap.put(TextAttribute.FONT, gz.fb);
            if (gz.cb) {
                hashMap.put(TextAttribute.UNDERLINE, (Font)TextAttribute.UNDERLINE_ON);
            }
            final LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(new AttributedString(gz.o, hashMap).getIterator(), fontRenderContext);
            final int n5 = (int)Math.rint(gz.fb.getLineMetrics(gz.o, fontRenderContext).getHeight()) - 3;
            final boolean b = gz.j == 2;
            final boolean b2 = gz.j == 1;
            int n6 = gz.o.indexOf(10);
            if (n6 == -1) {
                n6 = gz.o.length();
            }
            while (n6 <= lineBreakMeasurer.getPosition() && lineBreakMeasurer.getPosition() < gz.o.length()) {
                final TextLayout nextLayout = lineBreakMeasurer.nextLayout(100.0f, n6 + 1, false);
                n4 += nextLayout.getAscent() + nextLayout.getLeading() + nextLayout.getDescent();
                n6 = gz.o.indexOf(10, n6 + 1);
                if (n6 == -1) {
                    n6 = gz.o.length();
                }
            }
            while (lineBreakMeasurer.getPosition() < gz.o.length()) {
                if (n2 < n4 + 2 * n5) {
                    final TextLayout textLayout = new TextLayout("\u2026", hashMap, fontRenderContext);
                    final float advance = textLayout.getAdvance();
                    if (lineBreakMeasurer.nextOffset((float)n, n6, false) >= gz.o.length()) {
                        final TextLayout nextLayout2 = lineBreakMeasurer.nextLayout((float)n);
                        if (nextLayout2 == null) {
                            return array;
                        }
                        final float n7 = b2 ? (((float)n - nextLayout2.getAdvance()) * 0.5f) : ((nextLayout2.isLeftToRight() && !b) ? 0.0f : ((float)n - nextLayout2.getAdvance()));
                        if (array != null) {
                            array[0] = Math.min(array[0], n3 + n7);
                            array[1] = Math.min(array[1], n4);
                            array[2] = Math.max(array[2], n3 + n7 + nextLayout2.getAdvance());
                            array[3] = Math.max(array[3], n4 + nextLayout2.getAscent() + nextLayout2.getDescent());
                            if (!z) {
                                return array;
                            }
                        }
                        array = new double[] { n3 + n7, n4, n3 + n7 + nextLayout2.getAdvance(), n4 + nextLayout2.getAscent() + nextLayout2.getDescent() };
                        return array;
                    }
                    else {
                        if (n <= advance) {
                            final float n8 = b2 ? (((float)n - textLayout.getAdvance()) * 0.5f) : ((textLayout.isLeftToRight() && !b) ? 0.0f : ((float)n - textLayout.getAdvance()));
                            if (array != null) {
                                array[0] = Math.min(array[0], n3 + n8);
                                array[1] = Math.min(array[1], n4);
                                array[2] = Math.max(array[2], n3 + n8 + textLayout.getAdvance());
                                array[3] = Math.max(array[3], n4 + textLayout.getAscent() + textLayout.getDescent());
                                if (!z) {
                                    return array;
                                }
                            }
                            array = new double[] { n3 + n8, n4, n3 + n8 + textLayout.getAdvance(), n4 + textLayout.getAscent() + textLayout.getDescent() };
                            return array;
                        }
                        final TextLayout nextLayout3 = lineBreakMeasurer.nextLayout((float)n - advance, n6, false);
                        if (lineBreakMeasurer.getPosition() == n6 && gz.o.indexOf(10, n6 + 1) == -1) {
                            gz.o.length();
                        }
                        if (nextLayout3 != null) {
                            if (lineBreakMeasurer.getPosition() < gz.o.length()) {
                                final float n9 = nextLayout3.getAdvance() + textLayout.getAdvance();
                                final float n10 = b2 ? (((float)n - n9) * 0.5f) : ((nextLayout3.isLeftToRight() && !b) ? 0.0f : ((float)n - n9));
                                if (array != null) {
                                    array[0] = Math.min(array[0], n3 + n10);
                                    array[1] = Math.min(array[1], n4);
                                    array[2] = Math.max(array[2], n3 + n10 + n9);
                                    array[3] = Math.max(array[3], n4 + nextLayout3.getAscent() + nextLayout3.getDescent());
                                    if (!z) {
                                        return array;
                                    }
                                }
                                array = new double[] { n3 + n10, n4, n3 + n10 + n9, n4 + nextLayout3.getAscent() + nextLayout3.getDescent() };
                                if (!z) {
                                    return array;
                                }
                            }
                            final float n11 = b2 ? (((float)n - nextLayout3.getAdvance()) * 0.5f) : ((nextLayout3.isLeftToRight() && !b) ? 0.0f : ((float)n - nextLayout3.getAdvance()));
                            if (array != null) {
                                array[0] = Math.min(array[0], n3 + n11);
                                array[1] = Math.min(array[1], n4);
                                array[2] = Math.max(array[2], n3 + n11 + nextLayout3.getAdvance());
                                array[3] = Math.max(array[3], n4 + nextLayout3.getAscent() + nextLayout3.getDescent());
                                if (!z) {
                                    return array;
                                }
                            }
                            array = new double[] { n3 + n11, n4, n3 + n11 + nextLayout3.getAdvance(), n4 + nextLayout3.getAscent() + nextLayout3.getDescent() };
                            return array;
                        }
                        final float n12 = b2 ? (((float)n - textLayout.getAdvance()) * 0.5f) : ((textLayout.isLeftToRight() && !b) ? 0.0f : ((float)n - textLayout.getAdvance()));
                        if (array != null) {
                            array[0] = Math.min(array[0], n3 + n12);
                            array[1] = Math.min(array[1], n4);
                            array[2] = Math.max(array[2], n3 + n12 + textLayout.getAdvance());
                            array[3] = Math.max(array[3], n4 + nextLayout3.getAscent() + nextLayout3.getDescent());
                            if (!z) {
                                return array;
                            }
                        }
                        array = new double[] { n3 + n12, n4, n3 + n12 + textLayout.getAdvance(), n4 + nextLayout3.getAscent() + nextLayout3.getDescent() };
                        return array;
                    }
                }
                else {
                    final TextLayout nextLayout4 = lineBreakMeasurer.nextLayout((float)n, n6, false);
                    if (nextLayout4 == null) {
                        return array;
                    }
                    if (lineBreakMeasurer.getPosition() == n6) {
                        n6 = gz.o.indexOf(10, n6 + 1);
                        if (n6 == -1) {
                            n6 = gz.o.length();
                        }
                    }
                    final float n13 = b2 ? (((float)n - nextLayout4.getAdvance()) * 0.5f) : ((nextLayout4.isLeftToRight() && !b) ? 0.0f : ((float)n - nextLayout4.getAdvance()));
                    final float n14 = nextLayout4.getAscent() + nextLayout4.getDescent() + nextLayout4.getLeading();
                    Label_1748: {
                        if (array != null) {
                            array[0] = Math.min(array[0], n3 + n13);
                            array[1] = Math.min(array[1], n4);
                            array[2] = Math.max(array[2], n3 + n13 + nextLayout4.getAdvance());
                            array[3] = Math.max(array[3], n4 + nextLayout4.getAscent() + nextLayout4.getDescent());
                            if (!z) {
                                break Label_1748;
                            }
                        }
                        array = new double[] { n3 + n13, n4, n3 + n13 + nextLayout4.getAdvance(), n4 + nextLayout4.getAscent() + nextLayout4.getDescent() };
                    }
                    n4 += n14;
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
        }
        return array;
    }
    
    public n a(final gZ gz) {
        if (this.a()) {
            return this.a(gz, this.c(gz));
        }
        return this.c(gz);
    }
    
    private n c(final gZ gz) {
        final boolean z = fj.z;
        final double contentWidth = gz.contentWidth;
        final double contentHeight = gz.contentHeight;
        double[] a = null;
        Label_0107: {
            if (!gz.w) {
                a = null;
                if (!z) {
                    break Label_0107;
                }
            }
            final FontRenderContext access$000 = gZ.access$000();
            FontRenderContext fontRenderContext = null;
            Label_0095: {
                if (gz.s != 0.0f) {
                    final AffineTransform transform = access$000.getTransform();
                    transform.rotate(Math.toRadians(gz.s));
                    fontRenderContext = new FontRenderContext(transform, access$000.isAntiAliased(), access$000.usesFractionalMetrics());
                    if (!z) {
                        break Label_0095;
                    }
                }
                fontRenderContext = access$000;
            }
            a = this.a(gz, fontRenderContext, contentWidth, contentHeight);
        }
        if (a == null) {
            Insets insets = gz.getInsets();
            if (insets == null) {
                insets = gZ.defaultInsets;
            }
            return new n(insets.left, insets.top - contentHeight, 0.0, 0.0);
        }
        final double n = a[0];
        final double n2 = a[1];
        final double n3 = a[3] - n2;
        return new n(n, n2 + n3 - contentHeight, a[2] - n, n3);
    }
    
    public n b(final gZ gz) {
        if (this.a()) {
            return this.a(gz, this.d(gz));
        }
        return this.d(gz);
    }
    
    private n d(final gZ gz) {
        return new n(0.0, -gz.contentHeight, 0.0, 0.0);
    }
    
    public void a(final gZ gz, final FontRenderContext fontRenderContext, final byte b) {
        final boolean z = fj.z;
        Label_0463: {
            switch (b) {
                case 1: {
                    if (gz.o.length() <= 0) {
                        break;
                    }
                    Insets insets = gz.getInsets();
                    if (insets == null) {
                        insets = gZ.defaultInsets;
                    }
                    final fj g = ((eR)gz).g();
                    if (g == null) {
                        return;
                    }
                    final double width = g.getWidth();
                    final double n = 0.0;
                    final double n2 = Double.MAX_VALUE;
                    float n3 = (float)n + insets.top;
                    final double n4 = width - (insets.left + insets.right);
                    if (n4 <= 0.0 || n2 <= 0.0) {
                        return;
                    }
                    final HashMap<TextAttribute, Font> hashMap = new HashMap<TextAttribute, Font>();
                    hashMap.put(TextAttribute.FONT, gz.fb);
                    if (gz.cb) {
                        hashMap.put(TextAttribute.UNDERLINE, (Font)TextAttribute.UNDERLINE_ON);
                    }
                    final LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(new AttributedString(gz.o, hashMap).getIterator(), fontRenderContext);
                    int n5 = gz.o.indexOf(10);
                    if (n5 == -1) {
                        n5 = gz.o.length();
                    }
                Label_0458:
                    while (true) {
                        while (n5 <= lineBreakMeasurer.getPosition() && lineBreakMeasurer.getPosition() < gz.o.length()) {
                            final TextLayout nextLayout = lineBreakMeasurer.nextLayout(100.0f, n5 + 1, false);
                            n3 += nextLayout.getAscent() + nextLayout.getLeading() + nextLayout.getDescent();
                            n5 = gz.o.indexOf(10, n5 + 1);
                            if (n5 == -1) {
                                n5 = gz.o.length();
                                if (!z) {
                                    if (z) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (z) {
                                        break Label_0463;
                                    }
                                    break Label_0463;
                                }
                            }
                        }
                        while (lineBreakMeasurer.getPosition() < gz.o.length()) {
                            final TextLayout nextLayout2 = lineBreakMeasurer.nextLayout((float)n4, n5, false);
                            if (z) {
                                continue Label_0458;
                            }
                            if (nextLayout2 == null) {
                                return;
                            }
                            if (lineBreakMeasurer.getPosition() == n5) {
                                n5 = gz.o.indexOf(10, n5 + 1);
                                if (n5 == -1) {
                                    n5 = gz.o.length();
                                }
                            }
                            n3 += nextLayout2.getAscent() + nextLayout2.getDescent() + nextLayout2.getLeading();
                            if (z) {
                                break;
                            }
                        }
                        gz.setContentSize(n4, n3 + 2.0f + insets.bottom);
                        continue Label_0458;
                    }
                }
                case 0:
                case 2: {
                    final HashMap<TextAttribute, Font> hashMap2 = new HashMap<TextAttribute, Font>();
                    hashMap2.put(TextAttribute.FONT, gz.fb);
                    if (gz.cb) {
                        hashMap2.put(TextAttribute.UNDERLINE, (Font)TextAttribute.UNDERLINE_ON);
                    }
                    if (gz.o.length() > 0) {
                        final TextLayout textLayout = new TextLayout(new AttributedString(gz.o, hashMap2).getIterator(), fontRenderContext);
                        textLayout.getAdvance();
                        Insets insets2 = gz.getInsets();
                        if (insets2 == null) {
                            insets2 = gZ.defaultInsets;
                        }
                        gz.setContentSize(textLayout.getAdvance() + insets2.left + insets2.right + 3.0f, 3 + insets2.top + insets2.bottom + textLayout.getAscent() + textLayout.getDescent() + textLayout.getLeading());
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    static {
        d = new hj();
    }
}
