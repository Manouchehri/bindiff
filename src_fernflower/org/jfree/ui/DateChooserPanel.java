package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.jfree.date.SerialDate;

public class DateChooserPanel extends JPanel implements ActionListener {
   private Calendar chosenDate;
   private Color chosenDateButtonColor;
   private Color chosenMonthButtonColor;
   private Color chosenOtherButtonColor;
   private int firstDayOfWeek;
   private int yearSelectionRange;
   private Font dateFont;
   private JComboBox monthSelector;
   private JComboBox yearSelector;
   private JButton todayButton;
   private JButton[] buttons;
   private boolean refreshing;
   private int[] WEEK_DAYS;

   public DateChooserPanel() {
      this(Calendar.getInstance(), false);
   }

   public DateChooserPanel(Calendar var1, boolean var2) {
      super(new BorderLayout());
      this.yearSelectionRange = 20;
      this.dateFont = new Font("SansSerif", 0, 10);
      this.refreshing = false;
      this.chosenDateButtonColor = UIManager.getColor("textHighlight");
      this.chosenMonthButtonColor = UIManager.getColor("control");
      this.chosenOtherButtonColor = UIManager.getColor("controlShadow");
      this.chosenDate = var1;
      this.firstDayOfWeek = var1.getFirstDayOfWeek();
      this.WEEK_DAYS = new int[7];

      for(int var3 = 0; var3 < 7; ++var3) {
         this.WEEK_DAYS[var3] = (this.firstDayOfWeek + var3 - 1) % 7 + 1;
      }

      this.add(this.constructSelectionPanel(), "North");
      this.add(this.getCalendarPanel(), "Center");
      if(var2) {
         this.add(this.constructControlPanel(), "South");
      }

      this.setDate(var1.getTime());
   }

   public void setDate(Date var1) {
      this.chosenDate.setTime(var1);
      this.monthSelector.setSelectedIndex(this.chosenDate.get(2));
      this.refreshYearSelector();
      this.refreshButtons();
   }

   public Date getDate() {
      return this.chosenDate.getTime();
   }

   public void actionPerformed(ActionEvent var1) {
      JComboBox var2;
      int var3;
      int var4;
      if(var1.getActionCommand().equals("monthSelectionChanged")) {
         var2 = (JComboBox)var1.getSource();
         var3 = this.chosenDate.get(5);
         this.chosenDate.set(5, 1);
         this.chosenDate.set(2, var2.getSelectedIndex());
         var4 = this.chosenDate.getActualMaximum(5);
         this.chosenDate.set(5, Math.min(var3, var4));
         this.refreshButtons();
      } else if(var1.getActionCommand().equals("yearSelectionChanged")) {
         if(!this.refreshing) {
            var2 = (JComboBox)var1.getSource();
            Integer var7 = (Integer)var2.getSelectedItem();
            var4 = this.chosenDate.get(5);
            this.chosenDate.set(5, 1);
            this.chosenDate.set(1, var7.intValue());
            int var5 = this.chosenDate.getActualMaximum(5);
            this.chosenDate.set(5, Math.min(var4, var5));
            this.refreshYearSelector();
            this.refreshButtons();
         }
      } else if(var1.getActionCommand().equals("todayButtonClicked")) {
         this.setDate(new Date());
      } else if(var1.getActionCommand().equals("dateButtonClicked")) {
         JButton var6 = (JButton)var1.getSource();
         var3 = Integer.parseInt(var6.getName());
         Calendar var8 = this.getFirstVisibleDate();
         var8.add(5, var3);
         this.setDate(var8.getTime());
      }

   }

   private JPanel getCalendarPanel() {
      JPanel var1 = new JPanel(new GridLayout(7, 7));
      DateFormatSymbols var2 = new DateFormatSymbols();
      String[] var3 = var2.getShortWeekdays();

      int var4;
      for(var4 = 0; var4 < this.WEEK_DAYS.length; ++var4) {
         var1.add(new JLabel(var3[this.WEEK_DAYS[var4]], 0));
      }

      this.buttons = new JButton[42];

      for(var4 = 0; var4 < 42; ++var4) {
         JButton var5 = new JButton("");
         var5.setMargin(new Insets(1, 1, 1, 1));
         var5.setName(Integer.toString(var4));
         var5.setFont(this.dateFont);
         var5.setFocusPainted(false);
         var5.setActionCommand("dateButtonClicked");
         var5.addActionListener(this);
         this.buttons[var4] = var5;
         var1.add(var5);
      }

      return var1;
   }

   private Color getButtonColor(Calendar var1) {
      return this.equalDates(var1, this.chosenDate)?this.chosenDateButtonColor:(var1.get(2) == this.chosenDate.get(2)?this.chosenMonthButtonColor:this.chosenOtherButtonColor);
   }

   private boolean equalDates(Calendar var1, Calendar var2) {
      return var1.get(5) == var2.get(5) && var1.get(2) == var2.get(2) && var1.get(1) == var2.get(1);
   }

   private Calendar getFirstVisibleDate() {
      Calendar var1 = Calendar.getInstance();
      var1.set(this.chosenDate.get(1), this.chosenDate.get(2), 1);
      var1.add(5, -1);

      while(var1.get(7) != this.getFirstDayOfWeek()) {
         var1.add(5, -1);
      }

      return var1;
   }

   private int getFirstDayOfWeek() {
      return this.firstDayOfWeek;
   }

   private void refreshButtons() {
      Calendar var1 = this.getFirstVisibleDate();

      for(int var2 = 0; var2 < 42; ++var2) {
         JButton var3 = this.buttons[var2];
         var3.setText(Integer.toString(var1.get(5)));
         var3.setBackground(this.getButtonColor(var1));
         var1.add(5, 1);
      }

   }

   private void refreshYearSelector() {
      if(!this.refreshing) {
         this.refreshing = true;
         this.yearSelector.removeAllItems();
         Integer[] var1 = this.getYears(this.chosenDate.get(1));

         for(int var2 = 0; var2 < var1.length; ++var2) {
            this.yearSelector.addItem(var1[var2]);
         }

         this.yearSelector.setSelectedItem(new Integer(this.chosenDate.get(1)));
         this.refreshing = false;
      }

   }

   private Integer[] getYears(int var1) {
      int var2 = this.yearSelectionRange * 2 + 1;
      int var3 = var1 - this.yearSelectionRange;
      Integer[] var4 = new Integer[var2];

      for(int var5 = 0; var5 < var2; ++var5) {
         var4[var5] = new Integer(var5 + var3);
      }

      return var4;
   }

   private JPanel constructSelectionPanel() {
      JPanel var1 = new JPanel();
      int var2 = this.chosenDate.getMinimum(2);
      int var3 = this.chosenDate.getMaximum(2);
      String[] var4 = new String[var3 - var2 + 1];
      System.arraycopy(SerialDate.getMonths(), var2, var4, 0, var4.length);
      this.monthSelector = new JComboBox(var4);
      this.monthSelector.addActionListener(this);
      this.monthSelector.setActionCommand("monthSelectionChanged");
      var1.add(this.monthSelector);
      this.yearSelector = new JComboBox(this.getYears(0));
      this.yearSelector.addActionListener(this);
      this.yearSelector.setActionCommand("yearSelectionChanged");
      var1.add(this.yearSelector);
      return var1;
   }

   private JPanel constructControlPanel() {
      JPanel var1 = new JPanel();
      var1.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
      this.todayButton = new JButton("Today");
      this.todayButton.addActionListener(this);
      this.todayButton.setActionCommand("todayButtonClicked");
      var1.add(this.todayButton);
      return var1;
   }

   public Color getChosenDateButtonColor() {
      return this.chosenDateButtonColor;
   }

   public void setChosenDateButtonColor(Color var1) {
      if(var1 == null) {
         throw new NullPointerException("UIColor must not be null.");
      } else {
         Color var2 = this.chosenDateButtonColor;
         this.chosenDateButtonColor = var1;
         this.refreshButtons();
         this.firePropertyChange("chosenDateButtonColor", var2, var1);
      }
   }

   public Color getChosenMonthButtonColor() {
      return this.chosenMonthButtonColor;
   }

   public void setChosenMonthButtonColor(Color var1) {
      if(var1 == null) {
         throw new NullPointerException("UIColor must not be null.");
      } else {
         Color var2 = this.chosenMonthButtonColor;
         this.chosenMonthButtonColor = var1;
         this.refreshButtons();
         this.firePropertyChange("chosenMonthButtonColor", var2, var1);
      }
   }

   public Color getChosenOtherButtonColor() {
      return this.chosenOtherButtonColor;
   }

   public void setChosenOtherButtonColor(Color var1) {
      if(var1 == null) {
         throw new NullPointerException("UIColor must not be null.");
      } else {
         Color var2 = this.chosenOtherButtonColor;
         this.chosenOtherButtonColor = var1;
         this.refreshButtons();
         this.firePropertyChange("chosenOtherButtonColor", var2, var1);
      }
   }

   public int getYearSelectionRange() {
      return this.yearSelectionRange;
   }

   public void setYearSelectionRange(int var1) {
      int var2 = this.yearSelectionRange;
      this.yearSelectionRange = var1;
      this.refreshYearSelector();
      this.firePropertyChange("yearSelectionRange", var2, var1);
   }
}
