package com.vkuzel.intellij.tabmanagement;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.DumbAwareAction;

public class MoveTabToPrevTabGroup extends DumbAwareAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        var project = event.getProject();
        if (project == null) return;

        var activeWindowPane = EditorWindow.DATA_KEY.getData(event.getDataContext());
        if (activeWindowPane == null) return;

        var fileEditorManagerEx = FileEditorManagerEx.getInstanceEx(project);
        var prevWindowPane = fileEditorManagerEx.getPrevWindow(activeWindowPane);
        if (prevWindowPane == null || prevWindowPane == activeWindowPane) return;

        var activeEditorTab = activeWindowPane.getSelectedComposite();
        if (activeEditorTab == null) return;

        var activeFile = activeEditorTab.getFile();
        prevWindowPane.getManager().openFileImpl2(prevWindowPane, activeFile, true);

        prevWindowPane.setAsCurrentWindow(true);
        activeWindowPane.closeFile(activeFile, true, false);
        prevWindowPane.requestFocus(true);
    }
}
