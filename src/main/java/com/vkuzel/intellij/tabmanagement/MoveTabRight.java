package com.vkuzel.intellij.tabmanagement;

public class MoveTabRight extends SameSplitterAction {

    @Override
    public void performAction() {
        var index = tabs.getIndexOf(selectedInfo);
        if (index >= tabbedPane.getTabCount() - 1) return;

        tabs.removeTab(selectedInfo);
        tabs.addTab(selectedInfo, index + 1);
        tabs.select(selectedInfo, true);
    }
}
