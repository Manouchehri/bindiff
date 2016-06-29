package com.google.security.zynamics.zylib.gui.UrlLabel;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.border.*;
import java.awt.*;

final class UrlLabel$1 extends MouseAdapter
{
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        final UrlLabel urlLabel = (UrlLabel)mouseEvent.getSource();
        if (urlLabel.url == null) {
            return;
        }
        try {
            Desktop.getDesktop().browse(urlLabel.url.toURI());
        }
        catch (URISyntaxException ex) {
            System.out.println(ex);
        }
        catch (IOException ex2) {
            System.out.println(ex2);
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
        mouseEvent.getComponent().setCursor(Cursor.getPredefinedCursor(12));
    }
}
