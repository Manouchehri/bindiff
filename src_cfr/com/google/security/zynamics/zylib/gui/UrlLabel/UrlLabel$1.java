/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.UrlLabel;

import com.google.security.zynamics.zylib.gui.UrlLabel.UrlLabel;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;

final class UrlLabel$1
extends MouseAdapter {
    UrlLabel$1() {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        UrlLabel urlLabel = (UrlLabel)mouseEvent.getSource();
        if (UrlLabel.access$000(urlLabel) == null) {
            return;
        }
        try {
            Desktop.getDesktop().browse(UrlLabel.access$000(urlLabel).toURI());
            return;
        }
        catch (URISyntaxException var3_3) {
            System.out.println(var3_3);
            return;
        }
        catch (IOException var3_4) {
            System.out.println(var3_4);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(12));
    }
}

