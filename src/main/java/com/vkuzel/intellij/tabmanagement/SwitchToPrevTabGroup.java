package com.vkuzel.intellij.tabmanagement;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.DumbAwareAction;

public class SwitchToPrevTabGroup extends DumbAwareAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        var project = event.getProject();
        if (project == null) return;

        var activeWindow = EditorWindow.DATA_KEY.getData(event.getDataContext());
        if (activeWindow == null) return;

        var fileEditorManager = FileEditorManagerEx.getInstanceEx(project);
        var nextWindow = fileEditorManager.getPrevWindow(activeWindow);
        if (nextWindow == null || nextWindow == activeWindow) return;

        fileEditorManager.setCurrentWindow(nextWindow);
    }
}