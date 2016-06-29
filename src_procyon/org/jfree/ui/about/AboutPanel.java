package org.jfree.ui.about;

import org.jfree.ui.*;
import java.awt.*;
import javax.swing.*;

public class AboutPanel extends JPanel
{
    public AboutPanel(final String s, final String s2, final String s3, final String s4) {
        this(s, s2, s3, s4, null);
    }
    
    public AboutPanel(final String s, final String s2, final String s3, final String s4, final Image image) {
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new GridLayout(4, 1, 0, 4));
        final JPanel panel2 = new JPanel();
        final JLabel jLabel = RefineryUtilities.createJLabel(s, new Font("Dialog", 1, 14), Color.black);
        jLabel.setHorizontalTextPosition(0);
        panel2.add(jLabel);
        final JPanel panel3 = new JPanel();
        final Font font = new Font("Dialog", 0, 12);
        final JLabel jLabel2 = RefineryUtilities.createJLabel(s2, font, Color.black);
        jLabel2.setHorizontalTextPosition(0);
        panel3.add(jLabel2);
        final JPanel panel4 = new JPanel();
        final JLabel jLabel3 = RefineryUtilities.createJLabel(s3, font, Color.black);
        jLabel3.setHorizontalTextPosition(0);
        panel4.add(jLabel3);
        final JPanel panel5 = new JPanel();
        final JLabel jLabel4 = RefineryUtilities.createJLabel(s4, font, Color.black);
        jLabel4.setHorizontalTextPosition(0);
        panel5.add(jLabel4);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        this.add(panel);
        if (image != null) {
            final JPanel panel6 = new JPanel(new BorderLayout());
            panel6.add(new JLabel(new ImageIcon(image)));
            panel6.setBorder(BorderFactory.createLineBorder(Color.black));
            final JPanel panel7 = new JPanel(new BorderLayout());
            panel7.add(panel6, "North");
            this.add(panel7, "West");
        }
    }
}
