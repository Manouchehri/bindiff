package com.google.security.zynamics.bindiff.resources;

import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public class Fonts
{
    public static final Font BOLD_FONT;
    public static final Font NORMAL_FONT;
    
    static {
        BOLD_FONT = new Font(GuiHelper.getMonospaceFont(), 1, 12);
        NORMAL_FONT = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    }
}
