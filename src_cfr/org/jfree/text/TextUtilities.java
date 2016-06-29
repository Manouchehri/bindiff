/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.text.BreakIterator;
import org.jfree.base.BaseBoot;
import org.jfree.text.TextBlock;
import org.jfree.text.TextFragment;
import org.jfree.text.TextLine;
import org.jfree.text.TextMeasurer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Configuration;
import org.jfree.util.Log;
import org.jfree.util.LogContext;
import org.jfree.util.ObjectUtilities;

public class TextUtilities {
    protected static final LogContext logger;
    private static boolean useDrawRotatedStringWorkaround;
    private static boolean useFontMetricsGetStringBounds;
    static Class class$org$jfree$text$TextUtilities;

    private TextUtilities() {
    }

    public static TextBlock createTextBlock(String string, Font font, Paint paint) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        TextBlock textBlock = new TextBlock();
        String string2 = string;
        if (string.length() <= 0) return textBlock;
        boolean bl2 = true;
        boolean bl3 = bl2;
        boolean bl4 = false;
        while (bl3) {
            int n2 = string2.indexOf("\n");
            if (n2 > 0) {
                String string3 = string2.substring(0, n2);
                if (n2 < string2.length() - 1) {
                    textBlock.addLine(string3, font, paint);
                    string2 = string2.substring(n2 + 1);
                    continue;
                }
                bl3 = false;
                continue;
            }
            if (n2 == 0) {
                if (n2 < string2.length() - 1) {
                    string2 = string2.substring(n2 + 1);
                    continue;
                }
                bl3 = false;
                continue;
            }
            textBlock.addLine(string2, font, paint);
            bl3 = false;
        }
        return textBlock;
    }

    public static TextBlock createTextBlock(String string, Font font, Paint paint, float f2, TextMeasurer textMeasurer) {
        return TextUtilities.createTextBlock(string, font, paint, f2, Integer.MAX_VALUE, textMeasurer);
    }

    public static TextBlock createTextBlock(String string, Font font, Paint paint, float f2, int n2, TextMeasurer textMeasurer) {
        TextBlock textBlock = new TextBlock();
        BreakIterator breakIterator = BreakIterator.getLineInstance();
        breakIterator.setText(string);
        int n3 = 0;
        int n4 = 0;
        int n5 = string.length();
        while (n3 < n5 && n4 < n2) {
            int n6 = TextUtilities.nextLineBreak(string, n3, f2, breakIterator, textMeasurer);
            if (n6 == -1) {
                textBlock.addLine(string.substring(n3), font, paint);
                return textBlock;
            }
            textBlock.addLine(string.substring(n3, n6), font, paint);
            ++n4;
            for (n3 = n6; n3 < string.length() && string.charAt(n3) == '\n'; ++n3) {
            }
        }
        if (n3 >= n5) return textBlock;
        TextLine textLine = textBlock.getLastLine();
        TextFragment textFragment = textLine.getLastTextFragment();
        String string2 = textFragment.getText();
        String string3 = "...";
        if (string2.length() > 3) {
            string3 = new StringBuffer().append(string2.substring(0, string2.length() - 3)).append("...").toString();
        }
        textLine.removeFragment(textFragment);
        TextFragment textFragment2 = new TextFragment(string3, textFragment.getFont(), textFragment.getPaint());
        textLine.addFragment(textFragment2);
        return textBlock;
    }

    private static int nextLineBreak(String string, int n2, float f2, BreakIterator breakIterator, TextMeasurer textMeasurer) {
        int n3;
        int n4 = n2;
        float f3 = 0.0f;
        boolean bl2 = true;
        int n5 = string.indexOf(10, n2);
        if (n5 < 0) {
            n5 = Integer.MAX_VALUE;
        }
        while ((n3 = breakIterator.next()) != -1) {
            if (n3 > n5) {
                return n5;
            }
            if ((f3 += textMeasurer.getStringWidth(string, n4, n3)) > f2) {
                if (!bl2) {
                    return breakIterator.previous();
                }
                do {
                    if (textMeasurer.getStringWidth(string, n2, n3) <= f2) return n3;
                } while (--n3 > n2);
                return n3;
            }
            bl2 = false;
            n4 = n3;
        }
        return -1;
    }

    public static Rectangle2D getTextBounds(String string, Graphics2D graphics2D, FontMetrics fontMetrics) {
        if (useFontMetricsGetStringBounds) {
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(string, graphics2D);
            LineMetrics lineMetrics = fontMetrics.getFont().getLineMetrics(string, graphics2D.getFontRenderContext());
            rectangle2D.setRect(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), lineMetrics.getHeight());
            return rectangle2D;
        }
        double d2 = fontMetrics.stringWidth(string);
        double d3 = fontMetrics.getHeight();
        if (!logger.isDebugEnabled()) return new Rectangle2D.Double(0.0, - fontMetrics.getAscent(), d2, d3);
        logger.debug(new StringBuffer().append("Height = ").append(d3).toString());
        return new Rectangle2D.Double(0.0, - fontMetrics.getAscent(), d2, d3);
    }

    public static Rectangle2D drawAlignedString(String string, Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor) {
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        float[] arrf = TextUtilities.deriveTextBoundsAnchorOffsets(graphics2D, string, textAnchor, double_);
        double_.setRect(f2 + arrf[0], f3 + arrf[1] + arrf[2], double_.getWidth(), double_.getHeight());
        graphics2D.drawString(string, f2 + arrf[0], f3 + arrf[1]);
        return double_;
    }

    private static float[] deriveTextBoundsAnchorOffsets(Graphics2D graphics2D, String string, TextAnchor textAnchor, Rectangle2D rectangle2D) {
        float[] arrf = new float[3];
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        LineMetrics lineMetrics = font.getLineMetrics(string, fontRenderContext);
        float f2 = lineMetrics.getAscent();
        arrf[2] = - f2;
        float f3 = f2 / 2.0f;
        float f4 = lineMetrics.getDescent();
        float f5 = lineMetrics.getLeading();
        float f6 = 0.0f;
        float f7 = 0.0f;
        if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            f6 = (float)(- rectangle2D2.getWidth()) / 2.0f;
        } else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f6 = (float)(- rectangle2D2.getWidth());
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            f7 = - f4 - f5 + (float)rectangle2D2.getHeight();
        } else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f7 = f3;
        } else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            f7 = - f4 - f5 + (float)(rectangle2D2.getHeight() / 2.0);
        } else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            f7 = 0.0f;
        } else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            f7 = - lineMetrics.getDescent() - lineMetrics.getLeading();
        }
        if (rectangle2D != null) {
            rectangle2D.setRect(rectangle2D2);
        }
        arrf[0] = f6;
        arrf[1] = f7;
        return arrf;
    }

    public static void setUseDrawRotatedStringWorkaround(boolean bl2) {
        useDrawRotatedStringWorkaround = bl2;
    }

    public static void drawRotatedString(String string, Graphics2D graphics2D, double d2, float f2, float f3) {
        TextUtilities.drawRotatedString(string, graphics2D, f2, f3, d2, f2, f3);
    }

    public static void drawRotatedString(String string, Graphics2D graphics2D, float f2, float f3, double d2, float f4, float f5) {
        if (string == null) return;
        if (string.equals("")) {
            return;
        }
        AffineTransform affineTransform = graphics2D.getTransform();
        AffineTransform affineTransform2 = AffineTransform.getRotateInstance(d2, f4, f5);
        graphics2D.transform(affineTransform2);
        if (useDrawRotatedStringWorkaround) {
            TextLayout textLayout = new TextLayout(string, graphics2D.getFont(), graphics2D.getFontRenderContext());
            textLayout.draw(graphics2D, f2, f3);
        } else {
            graphics2D.drawString(string, f2, f3);
        }
        graphics2D.setTransform(affineTransform);
    }

    public static void drawRotatedString(String string, Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor, double d2, float f4, float f5) {
        if (string == null) return;
        if (string.equals("")) {
            return;
        }
        float[] arrf = TextUtilities.deriveTextBoundsAnchorOffsets(graphics2D, string, textAnchor);
        TextUtilities.drawRotatedString(string, graphics2D, f2 + arrf[0], f3 + arrf[1], d2, f4, f5);
    }

    public static void drawRotatedString(String string, Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor, double d2, TextAnchor textAnchor2) {
        if (string == null) return;
        if (string.equals("")) {
            return;
        }
        float[] arrf = TextUtilities.deriveTextBoundsAnchorOffsets(graphics2D, string, textAnchor);
        float[] arrf2 = TextUtilities.deriveRotationAnchorOffsets(graphics2D, string, textAnchor2);
        TextUtilities.drawRotatedString(string, graphics2D, f2 + arrf[0], f3 + arrf[1], d2, f2 + arrf[0] + arrf2[0], f3 + arrf[1] + arrf2[1]);
    }

    public static Shape calculateRotatedStringBounds(String string, Graphics2D graphics2D, float f2, float f3, TextAnchor textAnchor, double d2, TextAnchor textAnchor2) {
        if (string == null) return null;
        if (string.equals("")) {
            return null;
        }
        float[] arrf = TextUtilities.deriveTextBoundsAnchorOffsets(graphics2D, string, textAnchor);
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuffer().append("TextBoundsAnchorOffsets = ").append(arrf[0]).append(", ").append(arrf[1]).toString());
        }
        float[] arrf2 = TextUtilities.deriveRotationAnchorOffsets(graphics2D, string, textAnchor2);
        if (!logger.isDebugEnabled()) return TextUtilities.calculateRotatedStringBounds(string, graphics2D, f2 + arrf[0], f3 + arrf[1], d2, f2 + arrf[0] + arrf2[0], f3 + arrf[1] + arrf2[1]);
        logger.debug(new StringBuffer().append("RotationAnchorOffsets = ").append(arrf2[0]).append(", ").append(arrf2[1]).toString());
        return TextUtilities.calculateRotatedStringBounds(string, graphics2D, f2 + arrf[0], f3 + arrf[1], d2, f2 + arrf[0] + arrf2[0], f3 + arrf[1] + arrf2[1]);
    }

    private static float[] deriveTextBoundsAnchorOffsets(Graphics2D graphics2D, String string, TextAnchor textAnchor) {
        float[] arrf = new float[2];
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        Font font = graphics2D.getFont();
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        Rectangle2D rectangle2D = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        LineMetrics lineMetrics = font.getLineMetrics(string, fontRenderContext);
        float f2 = lineMetrics.getAscent();
        float f3 = f2 / 2.0f;
        float f4 = lineMetrics.getDescent();
        float f5 = lineMetrics.getLeading();
        float f6 = 0.0f;
        float f7 = 0.0f;
        if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            f6 = (float)(- rectangle2D.getWidth()) / 2.0f;
        } else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f6 = (float)(- rectangle2D.getWidth());
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            f7 = - f4 - f5 + (float)rectangle2D.getHeight();
        } else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f7 = f3;
        } else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            f7 = - f4 - f5 + (float)(rectangle2D.getHeight() / 2.0);
        } else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            f7 = 0.0f;
        } else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            f7 = - lineMetrics.getDescent() - lineMetrics.getLeading();
        }
        arrf[0] = f6;
        arrf[1] = f7;
        return arrf;
    }

    private static float[] deriveRotationAnchorOffsets(Graphics2D graphics2D, String string, TextAnchor textAnchor) {
        float[] arrf = new float[2];
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        LineMetrics lineMetrics = graphics2D.getFont().getLineMetrics(string, fontRenderContext);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        float f2 = lineMetrics.getAscent();
        float f3 = f2 / 2.0f;
        float f4 = lineMetrics.getDescent();
        float f5 = lineMetrics.getLeading();
        float f6 = 0.0f;
        float f7 = 0.0f;
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.HALF_ASCENT_LEFT) {
            f6 = 0.0f;
        } else if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            f6 = (float)rectangle2D.getWidth() / 2.0f;
        } else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f6 = (float)rectangle2D.getWidth();
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            f7 = f4 + f5 - (float)rectangle2D.getHeight();
        } else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            f7 = f4 + f5 - (float)(rectangle2D.getHeight() / 2.0);
        } else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            f7 = - f3;
        } else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            f7 = 0.0f;
        } else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            f7 = lineMetrics.getDescent() + lineMetrics.getLeading();
        }
        arrf[0] = f6;
        arrf[1] = f7;
        return arrf;
    }

    public static Shape calculateRotatedStringBounds(String string, Graphics2D graphics2D, float f2, float f3, double d2, float f4, float f5) {
        if (string == null) return null;
        if (string.equals("")) {
            return null;
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(f2, f3);
        Shape shape = affineTransform.createTransformedShape(rectangle2D);
        AffineTransform affineTransform2 = AffineTransform.getRotateInstance(d2, f4, f5);
        return affineTransform2.createTransformedShape(shape);
    }

    public static boolean getUseFontMetricsGetStringBounds() {
        return useFontMetricsGetStringBounds;
    }

    public static void setUseFontMetricsGetStringBounds(boolean bl2) {
        useFontMetricsGetStringBounds = bl2;
    }

    public static boolean isUseDrawRotatedStringWorkaround() {
        return useDrawRotatedStringWorkaround;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        Class class_ = class$org$jfree$text$TextUtilities == null ? (TextUtilities.class$org$jfree$text$TextUtilities = TextUtilities.class$("org.jfree.text.TextUtilities")) : class$org$jfree$text$TextUtilities;
        logger = Log.createContext(class_);
        boolean bl2 = ObjectUtilities.isJDK14();
        String string = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseDrawRotatedStringWorkaround", "auto");
        useDrawRotatedStringWorkaround = string.equals("auto") ? !bl2 : string.equals("true");
        String string2 = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseFontMetricsGetStringBounds", "auto");
        if (!string2.equals("auto")) {
            useFontMetricsGetStringBounds = string2.equals("true");
            return;
        }
        useFontMetricsGetStringBounds = bl2;
    }
}

