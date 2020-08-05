package com.example.notekeeper;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance = null;

    private List<CourseInfo> mCourses = new ArrayList<>();
    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeCourses();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    public String getCurrentUserName() {
        return "Jim Wilson";
    }

    public String getCurrentUserEmail() {
        return "jimw@jwhh.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo note) {
        for(int index = 0; index < mNotes.size(); index++) {
            if(note.equals(mNotes.get(index)))
                return index;
        }

        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    public CourseInfo getCourse(String id) {
        for (CourseInfo course : mCourses) {
            if (id.equals(course.getCourseId()))
                return course;
        }
        return null;
    }

    public List<NoteInfo> getNotes(CourseInfo course) {
        ArrayList<NoteInfo> notes = new ArrayList<>();
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                notes.add(note);
        }
        return notes;
    }

    public int getNoteCount(CourseInfo course) {
        int count = 0;
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                count++;
        }
        return count;
    }

    private DataManager() {
    }

    //region Initialization code

    private void initializeCourses() {
        mCourses.add(initializeCourse1());
        mCourses.add(initializeCourse2());
        mCourses.add(initializeCourse3());
        mCourses.add(initializeCourse4());
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        CourseInfo course = dm.getCourse("android intents");
        course.getModule("android intents m01").setComplete(true);
        course.getModule("android intents m02").setComplete(true);
        course.getModule("android intents m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Dynamic intent resolution",
                "Wow, intents allow components to be resolved at runtime"));
        mNotes.add(new NoteInfo(course, "Delegating intents",
                "PendingIntents are powerful; they delegate much more than just a component invocation"));

        course = dm.getCourse("android async");
        course.getModule("android async_m01").setComplete(true);
        course.getModule("android async_m02").setComplete(true);
        mNotes.add(new NoteInfo(course, "Service default threads",
                "Did you know that by default an Android Service will tie up the UI thread?"));
        mNotes.add(new NoteInfo(course, "Long running operations",
                "Foreground Services can be tied to a notification icon"));

        course = dm.getCourse("java lang");
        course.getModule("java lang m01").setComplete(true);
        course.getModule("java lang m02").setComplete(true);
        course.getModule("java lang m03").setComplete(true);
        course.getModule("java lang m04").setComplete(true);
        course.getModule("java lang m05").setComplete(true);
        course.getModule("java lang m06").setComplete(true);
        course.getModule("java lang m07").setComplete(true);
        mNotes.add(new NoteInfo(course, "Parameters",
                "Leverage variable-length parameter lists"));
        mNotes.add(new NoteInfo(course, "Anonymous classes",
                "Anonymous classes simplify implementing one-use types"));

        course = dm.getCourse("java core");
        course.getModule("java core m01").setComplete(true);
        course.getModule("java core m02").setComplete(true);
        course.getModule("java core m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Compiler options",
                "The -jar option isn't compatible with with the -cp option"));
        mNotes.add(new NoteInfo(course, "Serialization",
                "Remember to include SerialVersionUID to assure version compatibility"));
    }

    private CourseInfo initializeCourse1() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android intents_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android intents_m02", "Component activation with intents"));
        modules.add(new ModuleInfo("android intents_m03", "Delegation and Callbacks through PendingIntents"));
        modules.add(new ModuleInfo("android intents_m04", "IntentFilter data tests"));
        modules.add(new ModuleInfo("android intents_m05", "Working with Platform Features Through Intents"));

        return new CourseInfo("android intents", "Android Programming with Intents", modules);
    }

    private CourseInfo initializeCourse2() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android async m01", "Challenges to a responsive user experience"));
        modules.add(new ModuleInfo("android async m02", "Implementing long-running operations as a service"));
        modules.add(new ModuleInfo("android async m03", "Service lifecycle management"));
        modules.add(new ModuleInfo("android async m04", "Interacting with services"));

        return new CourseInfo("android async", "Android Async Programming and Services", modules);
    }

    private CourseInfo initializeCourse3() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java lang m01", "Introduction and Setting up Your Environment"));
        modules.add(new ModuleInfo("java lang m02", "Creating a Simple App"));
        modules.add(new ModuleInfo("java lang m03", "Variables, Data Types, and Math Operators"));
        modules.add(new ModuleInfo("java lang m04", "Conditional Logic, Looping, and Arrays"));
        modules.add(new ModuleInfo("java lang m05", "Representing Complex Types with Classes"));
        modules.add(new ModuleInfo("java lang m06", "Class Initializers and Constructors"));
        modules.add(new ModuleInfo("java lang m07", "A Closer Look at Parameters"));
        modules.add(new ModuleInfo("java lang m08", "Class Inheritance"));
        modules.add(new ModuleInfo("java lang m09", "More About Data Types"));
        modules.add(new ModuleInfo("java lang m10", "Exceptions and Error Handling"));
        modules.add(new ModuleInfo("java lang m11", "Working with Packages"));
        modules.add(new ModuleInfo("java lang m12", "Creating Abstract Relationships with Interfaces"));
        modules.add(new ModuleInfo("java lang m13", "Static Members, Nested Types, and Anonymous Classes"));

        return new CourseInfo("java lang", "Java Fundamentals: The Java Language", modules);
    }

    private CourseInfo initializeCourse4() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java core m01", "Introduction"));
        modules.add(new ModuleInfo("java core m02", "Input and Output with Streams and Files"));
        modules.add(new ModuleInfo("java core m03", "String Formatting and Regular Expressions"));
        modules.add(new ModuleInfo("java core m04", "Working with Collections"));
        modules.add(new ModuleInfo("java core m05", "Controlling App Execution and Environment"));
        modules.add(new ModuleInfo("java core m06", "Capturing Application Activity with the Java Log System"));
        modules.add(new ModuleInfo("java core m07", "Multithreading and Concurrency"));
        modules.add(new ModuleInfo("java core m08", "Runtime Type Information and Reflection"));
        modules.add(new ModuleInfo("java core m09", "Adding Type Metadata with Annotations"));
        modules.add(new ModuleInfo("java core m10", "Persisting Objects with Serialization"));

        return new CourseInfo("java core", "Java Fundamentals: The Core Platform", modules);
    }

    public int createNewNote(CourseInfo course, String noteTilte, String noteText) {
        int index = createNewNote();
        NoteInfo note = getNotes().get(index);
        note.setCourse(course);
        note.setTitle(noteTilte);
        note.setText(noteText);

        return index;
    }
    //endregion

}
