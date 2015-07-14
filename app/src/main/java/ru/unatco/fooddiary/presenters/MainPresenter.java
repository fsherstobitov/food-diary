package ru.unatco.fooddiary.presenters;

import ru.unatco.fooddiary.views.MainView;

public interface MainPresenter {
    void attachView(MainView mainView);

    void detachView();

    void loadEntries();
}
