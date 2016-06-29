package org.jfree.chart;

import java.awt.*;

public class ChartColor extends Color
{
    public static final Color VERY_DARK_RED;
    public static final Color DARK_RED;
    public static final Color LIGHT_RED;
    public static final Color VERY_LIGHT_RED;
    public static final Color VERY_DARK_YELLOW;
    public static final Color DARK_YELLOW;
    public static final Color LIGHT_YELLOW;
    public static final Color VERY_LIGHT_YELLOW;
    public static final Color VERY_DARK_GREEN;
    public static final Color DARK_GREEN;
    public static final Color LIGHT_GREEN;
    public static final Color VERY_LIGHT_GREEN;
    public static final Color VERY_DARK_CYAN;
    public static final Color DARK_CYAN;
    public static final Color LIGHT_CYAN;
    public static final Color VERY_LIGHT_CYAN;
    public static final Color VERY_DARK_BLUE;
    public static final Color DARK_BLUE;
    public static final Color LIGHT_BLUE;
    public static final Color VERY_LIGHT_BLUE;
    public static final Color VERY_DARK_MAGENTA;
    public static final Color DARK_MAGENTA;
    public static final Color LIGHT_MAGENTA;
    public static final Color VERY_LIGHT_MAGENTA;
    
    public ChartColor(final int n, final int n2, final int n3) {
        super(n, n2, n3);
    }
    
    public static Paint[] createDefaultPaintArray() {
        return new Paint[] { new Color(255, 85, 85), new Color(85, 85, 255), new Color(85, 255, 85), new Color(255, 255, 85), new Color(255, 85, 255), new Color(85, 255, 255), Color.pink, Color.gray, ChartColor.DARK_RED, ChartColor.DARK_BLUE, ChartColor.DARK_GREEN, ChartColor.DARK_YELLOW, ChartColor.DARK_MAGENTA, ChartColor.DARK_CYAN, Color.darkGray, ChartColor.LIGHT_RED, ChartColor.LIGHT_BLUE, ChartColor.LIGHT_GREEN, ChartColor.LIGHT_YELLOW, ChartColor.LIGHT_MAGENTA, ChartColor.LIGHT_CYAN, Color.lightGray, ChartColor.VERY_DARK_RED, ChartColor.VERY_DARK_BLUE, ChartColor.VERY_DARK_GREEN, ChartColor.VERY_DARK_YELLOW, ChartColor.VERY_DARK_MAGENTA, ChartColor.VERY_DARK_CYAN, ChartColor.VERY_LIGHT_RED, ChartColor.VERY_LIGHT_BLUE, ChartColor.VERY_LIGHT_GREEN, ChartColor.VERY_LIGHT_YELLOW, ChartColor.VERY_LIGHT_MAGENTA, ChartColor.VERY_LIGHT_CYAN };
    }
    
    static {
        VERY_DARK_RED = new Color(128, 0, 0);
        DARK_RED = new Color(192, 0, 0);
        LIGHT_RED = new Color(255, 64, 64);
        VERY_LIGHT_RED = new Color(255, 128, 128);
        VERY_DARK_YELLOW = new Color(128, 128, 0);
        DARK_YELLOW = new Color(192, 192, 0);
        LIGHT_YELLOW = new Color(255, 255, 64);
        VERY_LIGHT_YELLOW = new Color(255, 255, 128);
        VERY_DARK_GREEN = new Color(0, 128, 0);
        DARK_GREEN = new Color(0, 192, 0);
        LIGHT_GREEN = new Color(64, 255, 64);
        VERY_LIGHT_GREEN = new Color(128, 255, 128);
        VERY_DARK_CYAN = new Color(0, 128, 128);
        DARK_CYAN = new Color(0, 192, 192);
        LIGHT_CYAN = new Color(64, 255, 255);
        VERY_LIGHT_CYAN = new Color(128, 255, 255);
        VERY_DARK_BLUE = new Color(0, 0, 128);
        DARK_BLUE = new Color(0, 0, 192);
        LIGHT_BLUE = new Color(64, 64, 255);
        VERY_LIGHT_BLUE = new Color(128, 128, 255);
        VERY_DARK_MAGENTA = new Color(128, 0, 128);
        DARK_MAGENTA = new Color(192, 0, 192);
        LIGHT_MAGENTA = new Color(255, 64, 255);
        VERY_LIGHT_MAGENTA = new Color(255, 128, 255);
    }
}
