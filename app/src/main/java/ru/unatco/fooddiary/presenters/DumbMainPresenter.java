package ru.unatco.fooddiary.presenters;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.unatco.fooddiary.data.models.DiaryEntry;
import ru.unatco.fooddiary.views.MainView;

public class DumbMainPresenter implements MainPresenter {

    private final WeakReference<MainView> mMainView;

    public DumbMainPresenter(MainView mainView) {
        mMainView = new WeakReference<>(mainView);
    }

    @Override
    public void loadEntries() {
        mMainView.get().showLoadProgress();

        List<DiaryEntry> entries = new ArrayList<>();
        entries.add(new DiaryEntry("entry_1", new Date(), null, null, null));
        entries.add(new DiaryEntry("entry_2", new Date(), null, null, null));
        entries.add(new DiaryEntry("entry_3", new Date(), null, null, null));

        mMainView.get().showEntries(entries);
    }
}
