package com.lushprojects.circuitjs1.client;

public class LabeledElm extends CircuitElm {
  String label = "";

  public EditInfo getLabelEditInfo() {
    return new EditInfo("Label", label);
  }

  public void setLabel(EditInfo ei) {
    label = ei.value;
  }

  String getLabel() {
    return label;
  }
}
