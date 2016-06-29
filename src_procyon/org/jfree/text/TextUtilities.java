package org.jfree.text;

import java.text.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.base.*;

public class TextUtilities
{
    protected static final LogContext logger;
    private static boolean useDrawRotatedStringWorkaround;
    private static boolean useFontMetricsGetStringBounds;
    static Class class$org$jfree$text$TextUtilities;
    
    public static TextBlock createTextBlock(final String s, final Font font, final Paint paint) {
        if (s == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        final TextBlock textBlock = new TextBlock();
        String s2 = s;
        int i = (s.length() > 0) ? 1 : 0;
        while (i != 0) {
            final int index = s2.indexOf("\n");
            if (index > 0) {
                final String substring = s2.substring(0, index);
                if (index < s2.length() - 1) {
                    textBlock.addLine(substring, font, paint);
                    s2 = s2.substring(index + 1);
                }
                else {
                    i = 0;
                }
            }
            else if (index == 0) {
                if (index < s2.length() - 1) {
                    s2 = s2.substring(index + 1);
                }
                else {
                    i = 0;
                }
            }
            else {
                textBlock.addLine(s2, font, paint);
                i = 0;
            }
        }
        return textBlock;
    }
    
    public static TextBlock createTextBlock(final String s, final Font font, final Paint paint, final float n, final TextMeasurer textMeasurer) {
        return createTextBlock(s, font, paint, n, Integer.MAX_VALUE, textMeasurer);
    }
    
    public static TextBlock createTextBlock(final String text, final Font font, final Paint paint, final float n, final int n2, final TextMeasurer textMeasurer) {
        final TextBlock textBlock = new TextBlock();
        final BreakIterator lineInstance = BreakIterator.getLineInstance();
        lineInstance.setText(text);
        int n3 = 0;
        int n4 = 0;
        final int length = text.length();
        while (n3 < length && n4 < n2) {
            final int nextLineBreak = nextLineBreak(text, n3, n, lineInstance, textMeasurer);
            if (nextLineBreak == -1) {
                textBlock.addLine(text.substring(n3), font, paint);
                return textBlock;
            }
            textBlock.addLine(text.substring(n3, nextLineBreak), font, paint);
            ++n4;
            for (n3 = nextLineBreak; n3 < text.length() && text.charAt(n3) == '\n'; ++n3) {}
        }
        if (n3 < length) {
            final TextLine lastLine = textBlock.getLastLine();
            final TextFragment lastTextFragment = lastLine.getLastTextFragment();
            final String text2 = lastTextFragment.getText();
            String string = "...";
            if (text2.length() > 3) {
                string = text2.substring(0, text2.length() - 3) + "...";
            }
            lastLine.removeFragment(lastTextFragment);
            lastLine.addFragment(new TextFragment(string, lastTextFragment.getFont(), lastTextFragment.getPaint()));
        }
        return textBlock;
    }
    
    private static int nextLineBreak(final String s, final int n, final float n2, final BreakIterator breakIterator, final TextMeasurer textMeasurer) {
        int n3 = n;
        float n4 = 0.0f;
        int n5 = 1;
        int index = s.indexOf(10, n);
        if (index < 0) {
            index = Integer.MAX_VALUE;
        }
        int next;
        while ((next = breakIterator.next()) != -1) {
            if (next > index) {
                return index;
            }
            n4 += textMeasurer.getStringWidth(s, n3, next);
            if (n4 > n2) {
                if (n5 != 0) {
                    while (textMeasurer.getStringWidth(s, n, next) > n2) {
                        if (--next <= n) {
                            return next;
                        }
                    }
                    return next;
                }
                return breakIterator.previous();
            }
            else {
                n5 = 0;
                n3 = next;
            }
        }
        return -1;
    }
    
    public static Rectangle2D getTextBounds(final String s, final Graphics2D graphics2D, final FontMetrics fontMetrics) {
        Rectangle2D stringBounds;
        if (TextUtilities.useFontMetricsGetStringBounds) {
            stringBounds = fontMetrics.getStringBounds(s, graphics2D);
            stringBounds.setRect(stringBounds.getX(), stringBounds.getY(), stringBounds.getWidth(), fontMetrics.getFont().getLineMetrics(s, graphics2D.getFontRenderContext()).getHeight());
        }
        else {
            final double n = fontMetrics.stringWidth(s);
            final double n2 = fontMetrics.getHeight();
            if (TextUtilities.logger.isDebugEnabled()) {
                TextUtilities.logger.debug("Height = " + n2);
            }
            stringBounds = new Rectangle2D.Double(0.0, -fontMetrics.getAscent(), n, n2);
        }
        return stringBounds;
    }
    
    public static Rectangle2D drawAlignedString(final String s, final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final float[] deriveTextBoundsAnchorOffsets = deriveTextBoundsAnchorOffsets(graphics2D, s, textAnchor, double1);
        double1.setRect(n + deriveTextBoundsAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1] + deriveTextBoundsAnchorOffsets[2], double1.getWidth(), double1.getHeight());
        graphics2D.drawString(s, n + deriveTextBoundsAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1]);
        return double1;
    }
    
    private static float[] deriveTextBoundsAnchorOffsets(final Graphics2D graphics2D, final String s, final TextAnchor textAnchor, final Rectangle2D rectangle2D) {
        final float[] array = new float[3];
        final FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        final Font font = graphics2D.getFont();
        final Rectangle2D textBounds = getTextBounds(s, graphics2D, graphics2D.getFontMetrics(font));
        final LineMetrics lineMetrics = font.getLineMetrics(s, fontRenderContext);
        final float ascent = lineMetrics.getAscent();
        array[2] = -ascent;
        final float n = ascent / 2.0f;
        final float descent = lineMetrics.getDescent();
        final float leading = lineMetrics.getLeading();
        float n2 = 0.0f;
        float n3 = 0.0f;
        if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            n2 = (float)(-textBounds.getWidth()) / 2.0f;
        }
        else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n2 = (float)(-textBounds.getWidth());
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            n3 = -descent - leading + (float)textBounds.getHeight();
        }
        else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n3 = n;
        }
        else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            n3 = -descent - leading + (float)(textBounds.getHeight() / 2.0);
        }
        else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            n3 = 0.0f;
        }
        else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            n3 = -lineMetrics.getDescent() - lineMetrics.getLeading();
        }
        if (rectangle2D != null) {
            rectangle2D.setRect(textBounds);
        }
        array[0] = n2;
        array[1] = n3;
        return array;
    }
    
    public static void setUseDrawRotatedStringWorkaround(final boolean useDrawRotatedStringWorkaround) {
        TextUtilities.useDrawRotatedStringWorkaround = useDrawRotatedStringWorkaround;
    }
    
    public static void drawRotatedString(final String s, final Graphics2D graphics2D, final double n, final float n2, final float n3) {
        drawRotatedString(s, graphics2D, n2, n3, n, n2, n3);
    }
    
    public static void drawRotatedString(final String s, final Graphics2D graphics2D, final float n, final float n2, final double n3, final float n4, final float n5) {
        if (s == null || s.equals("")) {
            return;
        }
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.transform(AffineTransform.getRotateInstance(n3, n4, n5));
        if (TextUtilities.useDrawRotatedStringWorkaround) {
            new TextLayout(s, graphics2D.getFont(), graphics2D.getFontRenderContext()).draw(graphics2D, n, n2);
        }
        else {
            graphics2D.drawString(s, n, n2);
        }
        graphics2D.setTransform(transform);
    }
    
    public static void drawRotatedString(final String s, final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor, final double n3, final float n4, final float n5) {
        if (s == null || s.equals("")) {
            return;
        }
        final float[] deriveTextBoundsAnchorOffsets = deriveTextBoundsAnchorOffsets(graphics2D, s, textAnchor);
        drawRotatedString(s, graphics2D, n + deriveTextBoundsAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1], n3, n4, n5);
    }
    
    public static void drawRotatedString(final String s, final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor, final double n3, final TextAnchor textAnchor2) {
        if (s == null || s.equals("")) {
            return;
        }
        final float[] deriveTextBoundsAnchorOffsets = deriveTextBoundsAnchorOffsets(graphics2D, s, textAnchor);
        final float[] deriveRotationAnchorOffsets = deriveRotationAnchorOffsets(graphics2D, s, textAnchor2);
        drawRotatedString(s, graphics2D, n + deriveTextBoundsAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1], n3, n + deriveTextBoundsAnchorOffsets[0] + deriveRotationAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1] + deriveRotationAnchorOffsets[1]);
    }
    
    public static Shape calculateRotatedStringBounds(final String s, final Graphics2D graphics2D, final float n, final float n2, final TextAnchor textAnchor, final double n3, final TextAnchor textAnchor2) {
        if (s == null || s.equals("")) {
            return null;
        }
        final float[] deriveTextBoundsAnchorOffsets = deriveTextBoundsAnchorOffsets(graphics2D, s, textAnchor);
        if (TextUtilities.logger.isDebugEnabled()) {
            TextUtilities.logger.debug("TextBoundsAnchorOffsets = " + deriveTextBoundsAnchorOffsets[0] + ", " + deriveTextBoundsAnchorOffsets[1]);
        }
        final float[] deriveRotationAnchorOffsets = deriveRotationAnchorOffsets(graphics2D, s, textAnchor2);
        if (TextUtilities.logger.isDebugEnabled()) {
            TextUtilities.logger.debug("RotationAnchorOffsets = " + deriveRotationAnchorOffsets[0] + ", " + deriveRotationAnchorOffsets[1]);
        }
        return calculateRotatedStringBounds(s, graphics2D, n + deriveTextBoundsAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1], n3, n + deriveTextBoundsAnchorOffsets[0] + deriveRotationAnchorOffsets[0], n2 + deriveTextBoundsAnchorOffsets[1] + deriveRotationAnchorOffsets[1]);
    }
    
    private static float[] deriveTextBoundsAnchorOffsets(final Graphics2D graphics2D, final String s, final TextAnchor textAnchor) {
        final float[] array = new float[2];
        final FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        final Font font = graphics2D.getFont();
        final Rectangle2D textBounds = getTextBounds(s, graphics2D, graphics2D.getFontMetrics(font));
        final LineMetrics lineMetrics = font.getLineMetrics(s, fontRenderContext);
        final float n = lineMetrics.getAscent() / 2.0f;
        final float descent = lineMetrics.getDescent();
        final float leading = lineMetrics.getLeading();
        float n2 = 0.0f;
        float n3 = 0.0f;
        if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            n2 = (float)(-textBounds.getWidth()) / 2.0f;
        }
        else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n2 = (float)(-textBounds.getWidth());
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            n3 = -descent - leading + (float)textBounds.getHeight();
        }
        else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n3 = n;
        }
        else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            n3 = -descent - leading + (float)(textBounds.getHeight() / 2.0);
        }
        else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            n3 = 0.0f;
        }
        else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            n3 = -lineMetrics.getDescent() - lineMetrics.getLeading();
        }
        array[0] = n2;
        array[1] = n3;
        return array;
    }
    
    private static float[] deriveRotationAnchorOffsets(final Graphics2D graphics2D, final String s, final TextAnchor textAnchor) {
        final float[] array = new float[2];
        final LineMetrics lineMetrics = graphics2D.getFont().getLineMetrics(s, graphics2D.getFontRenderContext());
        final Rectangle2D textBounds = getTextBounds(s, graphics2D, graphics2D.getFontMetrics());
        final float n = lineMetrics.getAscent() / 2.0f;
        final float descent = lineMetrics.getDescent();
        final float leading = lineMetrics.getLeading();
        float n2 = 0.0f;
        float n3 = 0.0f;
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.HALF_ASCENT_LEFT) {
            n2 = 0.0f;
        }
        else if (textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.HALF_ASCENT_CENTER) {
            n2 = (float)textBounds.getWidth() / 2.0f;
        }
        else if (textAnchor == TextAnchor.TOP_RIGHT || textAnchor == TextAnchor.CENTER_RIGHT || textAnchor == TextAnchor.BOTTOM_RIGHT || textAnchor == TextAnchor.BASELINE_RIGHT || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n2 = (float)textBounds.getWidth();
        }
        if (textAnchor == TextAnchor.TOP_LEFT || textAnchor == TextAnchor.TOP_CENTER || textAnchor == TextAnchor.TOP_RIGHT) {
            n3 = descent + leading - (float)textBounds.getHeight();
        }
        else if (textAnchor == TextAnchor.CENTER_LEFT || textAnchor == TextAnchor.CENTER || textAnchor == TextAnchor.CENTER_RIGHT) {
            n3 = descent + leading - (float)(textBounds.getHeight() / 2.0);
        }
        else if (textAnchor == TextAnchor.HALF_ASCENT_LEFT || textAnchor == TextAnchor.HALF_ASCENT_CENTER || textAnchor == TextAnchor.HALF_ASCENT_RIGHT) {
            n3 = -n;
        }
        else if (textAnchor == TextAnchor.BASELINE_LEFT || textAnchor == TextAnchor.BASELINE_CENTER || textAnchor == TextAnchor.BASELINE_RIGHT) {
            n3 = 0.0f;
        }
        else if (textAnchor == TextAnchor.BOTTOM_LEFT || textAnchor == TextAnchor.BOTTOM_CENTER || textAnchor == TextAnchor.BOTTOM_RIGHT) {
            n3 = lineMetrics.getDescent() + lineMetrics.getLeading();
        }
        array[0] = n2;
        array[1] = n3;
        return array;
    }
    
    public static Shape calculateRotatedStringBounds(final String s, final Graphics2D graphics2D, final float n, final float n2, final double n3, final float n4, final float n5) {
        if (s == null || s.equals("")) {
            return null;
        }
        return AffineTransform.getRotateInstance(n3, n4, n5).createTransformedShape(AffineTransform.getTranslateInstance(n, n2).createTransformedShape(getTextBounds(s, graphics2D, graphics2D.getFontMetrics())));
    }
    
    public static boolean getUseFontMetricsGetStringBounds() {
        return TextUtilities.useFontMetricsGetStringBounds;
    }
    
    public static void setUseFontMetricsGetStringBounds(final boolean useFontMetricsGetStringBounds) {
        TextUtilities.useFontMetricsGetStringBounds = useFontMetricsGetStringBounds;
    }
    
    public static boolean isUseDrawRotatedStringWorkaround() {
        return TextUtilities.useDrawRotatedStringWorkaround;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        logger = Log.createContext((TextUtilities.class$org$jfree$text$TextUtilities == null) ? (TextUtilities.class$org$jfree$text$TextUtilities = class$("org.jfree.text.TextUtilities")) : TextUtilities.class$org$jfree$text$TextUtilities);
        final boolean jdk14 = ObjectUtilities.isJDK14();
        final String configProperty = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseDrawRotatedStringWorkaround", "auto");
        if (configProperty.equals("auto")) {
            TextUtilities.useDrawRotatedStringWorkaround = !jdk14;
        }
        else {
            TextUtilities.useDrawRotatedStringWorkaround = configProperty.equals("true");
        }
        final String configProperty2 = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseFontMetricsGetStringBounds", "auto");
        if (configProperty2.equals("auto")) {
            TextUtilities.useFontMetricsGetStringBounds = jdk14;
        }
        else {
            TextUtilities.useFontMetricsGetStringBounds = configProperty2.equals("true");
        }
    }
}
