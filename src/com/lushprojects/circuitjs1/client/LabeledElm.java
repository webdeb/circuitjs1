/**
 * 
 */
package com.lushprojects.circuitjs1.client;

import com.lushprojects.circuitjs1.client.util.Locale;

public class LabeledElm extends CircuitElm {
  String label = "";

  public LabeledElm(int xx, int yy) {
    super(xx, yy);
  }

  public void restoreLabel(StringTokenizer st) {
    if (st.hasMoreElements()) {
      label = unescape(st.nextToken()).substring(3);
    }
  }

  public String dumpLabel() {
    return escape("LL_" + label);
  }

  // public LabeledElm(int xa, int ya, int xb, int yb, int f, StringTokenizer st)
  // {
  // super(xa, ya, xb, yb, f);
  // try {
  // label = unescape(st.nextToken());
  // if (label.substring(0, 3) == "LL_") {
  // label = label.substring(3);
  // } else {
  // throw new Error("Error");
  // }
  // } catch (Error e) {
  // st.pos--;
  // }
  // }

  public LabeledElm(int xa, int ya, int xb, int yb, int f) {
    super(xa, ya, xb, yb, f);
  }

  // String dump() {
  // return super.dump() + " " + escape("LL_" + label);
  // }

  public EditInfo getLabelEditInfo() {
    EditInfo ei = new EditInfo("Label", label);
    ei.text = label;
    return ei;
  }

  public void setLabel(EditInfo ei) {
    label = ei.textf.getText();
  }

  public void setLabel(String str) {
    label = str;
  }

  String getLabel() {
    return label;
  }

  static String escape(String s) {
    if (s.length() == 0)
      return "\\0";
    return s.replace("\\", "\\\\").replace("\n", "\\n").replace(" ", "\\s").replace("+", "\\p").replace("=", "\\q")
        .replace("#", "\\h").replace("&", "\\a").replace("\r", "\\r");
  }

  static String unescape(String s) {
    if (s.equals("\\0"))
      return "";
    int i;
    for (i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '\\') {
        char c = s.charAt(i + 1);
        if (c == 'n')
          s = s.substring(0, i) + "\n" + s.substring(i + 2);
        else if (c == 'r')
          s = s.substring(0, i) + "\r" + s.substring(i + 2);
        else if (c == 's')
          s = s.substring(0, i) + " " + s.substring(i + 2);
        else if (c == 'p')
          s = s.substring(0, i) + "+" + s.substring(i + 2);
        else if (c == 'q')
          s = s.substring(0, i) + "=" + s.substring(i + 2);
        else if (c == 'h')
          s = s.substring(0, i) + "#" + s.substring(i + 2);
        else if (c == 'a')
          s = s.substring(0, i) + "&" + s.substring(i + 2);
        else
          s = s.substring(0, i) + s.substring(i + 1);
      }
    }
    return s;
  }
}
