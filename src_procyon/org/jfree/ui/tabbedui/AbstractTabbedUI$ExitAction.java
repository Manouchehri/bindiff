package org.jfree.ui.tabbedui;

import javax.swing.*;
import java.awt.event.*;

public class AbstractTabbedUI$ExitAction extends AbstractAction
{
    private final AbstractTabbedUI this$0;
    
    public AbstractTabbedUI$ExitAction(final AbstractTabbedUI this$0) {
        this.this$0 = this$0;
        this.putValue("Name", "Exit");
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.attempExit();
    }
}
