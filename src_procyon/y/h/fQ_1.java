package y.h;

import java.awt.print.*;
import java.awt.*;
import java.beans.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class fQ extends JPanel
{
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
    
    public fQ(final PrinterJob c, final Printable g, final int n, final int n2, final PageFormat b) {
        super(new BorderLayout());
        (this.c = c).setPrintable(g, b);
        this.g = g;
        this.b = b;
        (this.d = new JComboBox((E[])new Object[] { this.getString("ZOOM_TO_FIT"), this.getString("ZOOM_TO_FIT_WIDTH"), "400%", "300%", "200%", "100%", "90%", "80%", "70%", "60%", "50%", "25%", "10%" })).setEditable(true);
        this.f = new JPanel(new FlowLayout(3));
        final ga ga = new ga(this);
        this.initAction(ga, "PAGE_FORMAT_ACTION");
        this.f.add(new JButton(ga));
        final gc gc = new gc(this);
        this.initAction(gc, "PRINT_ACTION");
        this.f.add(new JButton(gc));
        final JPanel panel = new JPanel(new BorderLayout());
        this.h = new gb(this, 0, n, n2, 500);
        final Action c2 = this.h.c();
        this.initAction(c2, "ZOOM_IN_ACTION");
        final Action d = this.h.d();
        this.initAction(d, "ZOOM_OUT_ACTION");
        this.f.add(new JButton(c2));
        this.f.add(new JButton(d));
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(this.e = new JScrollPane(this.h), "Center");
        this.e.setPreferredSize(new Dimension(400, 700));
        this.h.addPropertyChangeListener("ZOOM", new fR(this));
        this.d.addActionListener(new fS(this));
        this.h.e(250);
        this.f.add(this.d);
        this.add(panel, "Center");
        this.add(this.f, "North");
    }
    
    public PageFormat getPageFormat() {
        return this.b;
    }
    
    public void setPageFormat(final PageFormat b) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (b != this.b) {
            this.b = b;
            this.h.a();
            this.repaint();
        }
    }
    
    protected String getString(final String s) {
        if (fQ.i != null) {
            try {
                return fQ.i.getString(s);
            }
            catch (MissingResourceException ex) {}
        }
        return s;
    }
    
    public void setPages(final int n, final int n2, final int n3) {
        this.h.a(n);
        this.h.b(n2);
        this.h.c(n3);
        this.h.a();
    }
    
    public void zoomToFit() {
        this.h.e(this.h.a(this.e.getViewport().getWidth() - 3, this.e.getViewport().getHeight() - 3));
    }
    
    public void zoomToFitWidth() {
        this.h.e(this.h.d(this.e.getViewport().getWidth() - 20));
    }
    
    public void addControlComponent(final JComponent component) {
        this.f.add(component);
    }
    
    protected void initAction(final Action action, final String s) {
        action.putValue("ActionCommandKey", s);
        action.putValue("Name", this.getString(s + ".NAME"));
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static JComboBox access$000(final fQ fq) {
        return fq.d;
    }
    
    static gb access$100(final fQ fq) {
        return fq.h;
    }
    
    static PageFormat access$300(final fQ fq) {
        return fq.b;
    }
    
    static PrinterJob access$400(final fQ fq) {
        return fq.c;
    }
    
    static Printable access$800(final fQ fq) {
        return fq.g;
    }
    
    static {
        try {
            fQ.i = ResourceBundle.getBundle(((fQ.class$y$view$PrintPreviewPanel == null) ? (fQ.class$y$view$PrintPreviewPanel = class$("y.h.fQ")) : fQ.class$y$view$PrintPreviewPanel).getName());
        }
        catch (Exception ex) {}
    }
}
