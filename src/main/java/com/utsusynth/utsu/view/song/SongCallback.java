package com.utsusynth.utsu.view.song;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import com.utsusynth.utsu.common.RegionBounds;
import com.utsusynth.utsu.common.data.MutateResponse;
import com.utsusynth.utsu.common.data.NoteData;
import com.utsusynth.utsu.common.data.NoteUpdateData;
import com.utsusynth.utsu.controller.SongController.Mode;

/**
 * The view can use this interface to communicate with the model by way of the controller.
 */
public interface SongCallback {
    /** Add a one or more notes to the song. Input list must be in order. */
    void addNotes(List<NoteData> toAdd);

    /** Remove one or more notes from the song. */
    MutateResponse removeNotes(Set<Integer> positions);

    /** Modify a note without changing its position or duration. */
    void modifyNote(NoteData toModify);

    /** Standardizes a section of notes and returns any frontend updates. */
    LinkedList<NoteUpdateData> standardizeNotes(int firstPosition, int lastPosition);

    /** Open the note properties editor on the given RegionBounds. */
    void openNoteProperties(RegionBounds regionBounds);

    /** Gets the current mode: ADD, EDIT, or DELETE. */
    Mode getCurrentMode();
}
