package com.example.notekeeper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManagerTest {
    static  DataManager sDataManager;
    @BeforeClass
    public static void classSetUp(){
        sDataManager = DataManager.getInstance();
    }

    @Before
    public void setUp(){

        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();
    }

    @Test
    public void createNewNote() {

        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my text note";

        int noteIndex = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTitle, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
    }
    @Test
    public void findSimilarNote() {

        final CourseInfo course = sDataManager.getCourse("android async");
        final String noteTitle = "Test note title";
        final String noteText1 = "This is the body text of my text note";
        final String noteText2 = "This is the body text of my second text note";


        int noteIndex1 = sDataManager.createNewNote();
        NoteInfo newNote1 = sDataManager.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(noteTitle);
        newNote1.setText(noteText2);

        int noteIndex2 = sDataManager.createNewNote();
        NoteInfo newNote2 = sDataManager.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(noteTitle);
        newNote2.setText(noteText2);

        int foundIndex1 = sDataManager.findNote(newNote1);
        assertEquals(noteIndex1, foundIndex1);

        int foundIndex2 = sDataManager.findNote(newNote2);
        assertEquals(noteIndex2, foundIndex2);
    }


@Test
public void createNewNoteOneStepCreation() {
        final CourseInfo course = sDataManager.getCourse("android_sync");
        final String noteTilte = "Test note title";
        final String noteText = "This is the body of my test note";

        int noteIndex = sDataManager.createNewNote(course, noteTilte, noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteTilte, compareNote.getTitle());
        assertEquals(noteText, compareNote.getText());
}
}