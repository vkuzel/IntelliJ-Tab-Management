package com.vkuzel.intellij.tabmanagement;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.DumbAwareAction;

public class MoveTabToNextTabGroup extends DumbAwareAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        var project = event.getProject();
        if (project == null) return;

        var activeWindowPane = EditorWindow.DATA_KEY.getData(event.getDataContext());
        if (activeWindowPane == null) return;

        var fileEditorManagerEx = FileEditorManagerEx.getInstanceEx(project);
        var nextWindowPane = fileEditorManagerEx.getNextWindow(activeWindowPane);
        if (nextWindowPane == null || nextWindowPane == activeWindowPane) return;

        var activeEditorTab = activeWindowPane.getSelectedComposite();
        if (activeEditorTab == null) return;

        var activeFile = activeEditorTab.getFile();

        activeWindowPane.closeFile(activeFile);
        nextWindowPane.getManager().openFileImpl2(nextWindowPane, activeFile, true);
    }
}
