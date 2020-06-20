package com.example.notekeeper;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    public static final String ORIGINAL_NOTE_COURSE_ID = "com.example.notekeeper.ORIGINAL_NOTE_COURSE_ID";
    public static final String ORIGINAL_NOTE_TITLE = "com.example.notekeeper.ORIGINAL_NOTE_TITLE";
    public static final String ORIGINAL_NOTE_TEXT = "com.example.notekeeper.ORIGINAL_NOTE_TEXT";

    public String mOrignalNoteCourseId;
    public String mOrignalNoteTitle;
    public String mOrignalNoteText;
    public boolean mIsNewlyCreated = true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_COURSE_ID,mOrignalNoteCourseId);
        outState.putString(ORIGINAL_NOTE_TITLE,mOrignalNoteTitle);
        outState.putString(ORIGINAL_NOTE_TEXT,mOrignalNoteText);

    }
    public  void  restoreState(Bundle inState){
        mOrignalNoteCourseId = inState.getString(ORIGINAL_NOTE_COURSE_ID);
        mOrignalNoteTitle = inState.getString(ORIGINAL_NOTE_TITLE);
        mOrignalNoteText = inState.getString(ORIGINAL_NOTE_TEXT);
    }
}
