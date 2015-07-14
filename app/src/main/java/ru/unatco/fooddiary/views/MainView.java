package ru.unatco.fooddiary.views;

import java.util.List;

import ru.unatco.fooddiary.data.models.DiaryEntry;

public interface MainView {
    void showLoadProgress();

    void showEntries(List<DiaryEntry> entries);

    void showErrorMessage();
}
