package ru.unatco.fooddiary.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.unatco.fooddiary.R;
import ru.unatco.fooddiary.data.models.DiaryEntry;
import ru.unatco.fooddiary.presenters.DumbMainPresenter;
import ru.unatco.fooddiary.presenters.MainPresenter;
import ru.unatco.fooddiary.views.MainView;
import ru.unatco.fooddiary.views.adapters.DiaryEntriesListAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mPresenter;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(android.R.id.list)
    ListView mListView;
    @Bind(android.R.id.progress)
    ProgressBar mProgressBar;
    @Bind(R.id.error_message)
    TextView mErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar.setTitle(R.string.app_name);

        mPresenter = new DumbMainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadEntries();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoadProgress() {
        mListView.setVisibility(View.GONE);
        mErrorMessage.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEntries(List<DiaryEntry> entries) {
        mErrorMessage.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        mListView.setAdapter(new DiaryEntriesListAdapter(entries, LayoutInflater.from(this)));
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage() {
        mListView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        mErrorMessage.setVisibility(View.VISIBLE);
    }
}
