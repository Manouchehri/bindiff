/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeListener;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.Border;
import y.h.fR;
import y.h.fS;
import y.h.ga;
import y.h.gb;
import y.h.gc;

public class fQ
extends JPanel {
    private Printable g;
    private PageFormat b;
    private gb h;
    private PrinterJob c;
    private JScrollPane e;
    private JComboBox d;
    private JPanel f;
    public static final String ZOOM_TO_FIT = "ZOOM_TO_FIT";
    public static final String ZOOM_TO_FIT_WIDTH = "ZOOM_TO_FIT_WIDTH";
    public static final String PAGE_FORMAT_ACTION = "PAGE_FORMAT_ACTION";
    public static final String PRINT_ACTION = "PRINT_ACTION";
    public static final String ZOOM_IN_ACTION = "ZOOM_IN_ACTION";
    public static final String ZOOM_OUT_ACTION = "ZOOM_OUT_ACTION";
    static ResourceBundle i;
    static Class class$y$view$PrintPreviewPanel;

    public fQ(PrinterJob printerJob, Printable printable, int n2, int n3, PageFormat pageFormat) {
        super(new BorderLayout());
        this.c = printerJob;
        printerJob.setPrintable(printable, pageFormat);
        this.g = printable;
        this.b = pageFormat;
        this.d = new JComboBox<Object>(new Object[]{this.getString("ZOOM_TO_FIT"), this.getString("ZOOM_TO_FIT_WIDTH"), "400%", "300%", "200%", "100%", "90%", "80%", "70%", "60%", "50%", "25%", "10%"});
        this.d.setEditable(true);
        this.f = new JPanel(new FlowLayout(3));
        ga ga2 = new ga(this);
        this.initAction(ga2, "PAGE_FORMAT_ACTION");
        this.f.add(new JButton(ga2));
        gc gc2 = new gc(this);
        this.initAction(gc2, "PRINT_ACTION");
        this.f.add(new JButton(gc2));
        JPanel jPanel = new JPanel(new BorderLayout());
        this.h = new gb(this, 0, n2, n3, 500);
        Action action = this.h.c();
        this.initAction(action, "ZOOM_IN_ACTION");
        Action action2 = this.h.d();
        this.initAction(action2, "ZOOM_OUT_ACTION");
        this.f.add(new JButton(action));
        this.f.add(new JButton(action2));
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        this.e = new JScrollPane(this.h);
        jPanel.add((Component)this.e, "Center");
        this.e.setPreferredSize(new Dimension(400, 700));
        this.h.addPropertyChangeListener("ZOOM", new fR(this));
        this.d.addActionListener(new fS(this));
        this.h.e(250);
        this.f.add(this.d);
        this.add((Component)jPanel, "Center");
        this.add((Component)this.f, "North");
    }

    public PageFormat getPageFormat() {
        return this.b;
    }

    public void setPageFormat(PageFormat pageFormat) {
        if (pageFormat == null) {
            throw new NullPointerException();
        }
        if (pageFormat == this.b) return;
        this.b = pageFormat;
        this.h.a();
        this.repaint();
    }

    protected String getString(String string) {
        if (i == null) return string;
        try {
            return i.getString(string);
        }
        catch (MissingResourceException var2_2) {
            // empty catch block
        }
        return string;
    }

    public void setPages(int n2, int n3, int n4) {
        this.h.a(n2);
        this.h.b(n3);
        this.h.c(n4);
        this.h.a();
    }

    public void zoomToFit() {
        this.h.e(this.h.a(this.e.getViewport().getWidth() - 3, this.e.getViewport().getHeight() - 3));
    }

    public void zoomToFitWidth() {
        this.h.e(this.h.d(this.e.getViewport().getWidth() - 20));
    }

    public void addControlComponent(JComponent jComponent) {
        this.f.add(jComponent);
    }

    protected void initAction(Action action, String string) {
        action.putValue("ActionCommandKey", string);
        action.putValue("Name", this.getString(new StringBuffer().append(string).append(".NAME").toString()));
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static JComboBox access$000(fQ fQ2) {
        return fQ2.d;
    }

    static gb access$100(fQ fQ2) {
        return fQ2.h;
    }

    static PageFormat access$300(fQ fQ2) {
        return fQ2.b;
    }

    static PrinterJob access$400(fQ fQ2) {
        return fQ2.c;
    }

    static Printable access$800(fQ fQ2) {
        return fQ2.g;
    }

    static {
        try {
            Class class_ = class$y$view$PrintPreviewPanel == null ? (fQ.class$y$view$PrintPreviewPanel = fQ.class$("y.h.fQ")) : class$y$view$PrintPreviewPanel;
            i = ResourceBundle.getBundle(class_.getName());
            return;
        }
        catch (Exception var0) {
            // empty catch block
        }
    }
}

