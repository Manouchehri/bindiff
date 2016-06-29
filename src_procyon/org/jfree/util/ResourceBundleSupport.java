package org.jfree.util;

import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.text.*;

public class ResourceBundleSupport
{
    private ResourceBundle resources;
    private TreeMap cache;
    private TreeSet lookupPath;
    private String resourceBase;
    private Locale locale;
    static Class class$org$jfree$util$ResourceBundleSupport;
    static Class class$java$awt$event$KeyEvent;
    
    public ResourceBundleSupport(final Locale locale, final String s) {
        this(locale, ResourceBundle.getBundle(s, locale), s);
    }
    
    protected ResourceBundleSupport(final Locale locale, final ResourceBundle resources, final String resourceBase) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null");
        }
        if (resources == null) {
            throw new NullPointerException("Resources must not be null");
        }
        if (resourceBase == null) {
            throw new NullPointerException("BaseName must not be null");
        }
        this.locale = locale;
        this.resources = resources;
        this.resourceBase = resourceBase;
        this.cache = new TreeMap();
        this.lookupPath = new TreeSet();
    }
    
    public ResourceBundleSupport(final Locale locale, final ResourceBundle resourceBundle) {
        this(locale, resourceBundle, resourceBundle.toString());
    }
    
    public ResourceBundleSupport(final String s) {
        this(Locale.getDefault(), ResourceBundle.getBundle(s), s);
    }
    
    protected ResourceBundleSupport(final ResourceBundle resourceBundle, final String s) {
        this(Locale.getDefault(), resourceBundle, s);
    }
    
    public ResourceBundleSupport(final ResourceBundle resourceBundle) {
        this(Locale.getDefault(), resourceBundle, resourceBundle.toString());
    }
    
    protected final String getResourceBase() {
        return this.resourceBase;
    }
    
    public synchronized String getString(final String s) {
        final String s2 = this.cache.get(s);
        if (s2 != null) {
            return s2;
        }
        this.lookupPath.clear();
        return this.internalGetString(s);
    }
    
    protected String internalGetString(final String s) {
        if (this.lookupPath.contains(s)) {
            throw new MissingResourceException("InfiniteLoop in resource lookup", this.getResourceBase(), this.lookupPath.toString());
        }
        final String string = this.resources.getString(s);
        if (string.startsWith("@@")) {
            final int index = string.indexOf(64, 2);
            if (index == -1) {
                throw new MissingResourceException("Invalid format for global lookup key.", this.getResourceBase(), s);
            }
            try {
                return ResourceBundle.getBundle(string.substring(2, index)).getString(string.substring(index + 1));
            }
            catch (Exception ex) {
                Log.error("Error during global lookup", ex);
                throw new MissingResourceException("Error during global lookup", this.getResourceBase(), s);
            }
        }
        if (string.startsWith("@")) {
            final String substring = string.substring(1);
            this.lookupPath.add(s);
            final String internalGetString = this.internalGetString(substring);
            this.cache.put(s, internalGetString);
            return internalGetString;
        }
        this.cache.put(s, string);
        return string;
    }
    
    public Icon getIcon(final String s, final boolean b) {
        return this.createIcon(this.getString(s), true, b);
    }
    
    public Icon getIcon(final String s) {
        return this.createIcon(this.getString(s), false, false);
    }
    
    public Integer getMnemonic(final String s) {
        return this.createMnemonic(this.getString(s));
    }
    
    public Integer getOptionalMnemonic(final String s) {
        final String string = this.getString(s);
        if (string != null && string.length() > 0) {
            return this.createMnemonic(string);
        }
        return null;
    }
    
    public KeyStroke getKeyStroke(final String s) {
        return this.getKeyStroke(s, this.getMenuKeyMask());
    }
    
    public KeyStroke getOptionalKeyStroke(final String s) {
        return this.getOptionalKeyStroke(s, this.getMenuKeyMask());
    }
    
    public KeyStroke getKeyStroke(final String s, final int n) {
        return KeyStroke.getKeyStroke(this.createMnemonic(this.getString(s)), n);
    }
    
    public KeyStroke getOptionalKeyStroke(final String s, final int n) {
        final String string = this.getString(s);
        if (string != null && string.length() > 0) {
            return KeyStroke.getKeyStroke(this.createMnemonic(string), n);
        }
        return null;
    }
    
    public JMenu createMenu(final String s) {
        final JMenu menu = new JMenu();
        menu.setText(this.getString(s + ".name"));
        menu.setMnemonic(this.getMnemonic(s + ".mnemonic"));
        return menu;
    }
    
    public URL getResourceURL(final String s) {
        final String string = this.getString(s);
        final URL resource = ObjectUtilities.getResource(string, (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport == null) ? (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport = class$("org.jfree.util.ResourceBundleSupport")) : ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport);
        if (resource == null) {
            Log.warn("Unable to find file in the class path: " + string + "; key=" + s);
        }
        return resource;
    }
    
    private ImageIcon createIcon(final String s, final boolean b, final boolean b2) {
        final URL resource = ObjectUtilities.getResource(s, (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport == null) ? (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport = class$("org.jfree.util.ResourceBundleSupport")) : ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport);
        if (resource == null) {
            Log.warn("Unable to find file in the class path: " + s);
            return new ImageIcon(this.createTransparentImage(1, 1));
        }
        final Image image = Toolkit.getDefaultToolkit().createImage(resource);
        if (image == null) {
            Log.warn("Unable to instantiate the image: " + s);
            return new ImageIcon(this.createTransparentImage(1, 1));
        }
        if (!b) {
            return new ImageIcon(image);
        }
        if (b2) {
            return new ImageIcon(image.getScaledInstance(24, 24, 4));
        }
        return new ImageIcon(image.getScaledInstance(16, 16, 4));
    }
    
    private Integer createMnemonic(final String s) {
        if (s == null) {
            throw new NullPointerException("Key is null.");
        }
        if (s.length() == 0) {
            throw new IllegalArgumentException("Key is empty.");
        }
        int n = s.charAt(0);
        if (s.startsWith("VK_")) {
            try {
                n = (int)((ResourceBundleSupport.class$java$awt$event$KeyEvent == null) ? (ResourceBundleSupport.class$java$awt$event$KeyEvent = class$("java.awt.event.KeyEvent")) : ResourceBundleSupport.class$java$awt$event$KeyEvent).getField(s).get(null);
            }
            catch (Exception ex) {}
        }
        return new Integer(n);
    }
    
    private int getMenuKeyMask() {
        try {
            return Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        }
        catch (UnsupportedOperationException ex) {
            return 2;
        }
    }
    
    private BufferedImage createTransparentImage(final int n, final int n2) {
        final BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
        final int[] rgb = bufferedImage.getRGB(0, 0, n, n2, null, 0, n);
        Arrays.fill(rgb, 0);
        bufferedImage.setRGB(0, 0, n, n2, rgb, 0, n);
        return bufferedImage;
    }
    
    public Icon createTransparentIcon(final int n, final int n2) {
        return new ImageIcon(this.createTransparentImage(n, n2));
    }
    
    public String formatMessage(final String s, final Object o) {
        return this.formatMessage(s, new Object[] { o });
    }
    
    public String formatMessage(final String s, final Object o, final Object o2) {
        return this.formatMessage(s, new Object[] { o, o2 });
    }
    
    public String formatMessage(final String s, final Object[] array) {
        final MessageFormat messageFormat = new MessageFormat(this.getString(s));
        messageFormat.setLocale(this.getLocale());
        return messageFormat.format(array);
    }
    
    public Locale getLocale() {
        return this.locale;
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
