package com.vkuzel.intellij.tabmanagement;

public class MoveTabLeft extends SameSplitterAction {
    @Override
    public void performAction() {
        var index = tabs.getIndexOf(selectedInfo);
        if (index == 0) return;

        tabs.removeTab(selectedInfo);
        tabs.addTab(selectedInfo, index - 1);
        tabs.select(selectedInfo, true);
    }
}
