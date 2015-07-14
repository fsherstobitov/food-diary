package ru.unatco.fooddiary.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.unatco.fooddiary.R;
import ru.unatco.fooddiary.data.models.DiaryEntry;

public class DiaryEntriesListAdapter extends BaseAdapter {

    class ViewHolder {
        @Bind(R.id.date)
        TextView mDate;
        @Bind(R.id.note)
        TextView mNote;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private final List<DiaryEntry> mEntries;
    private final LayoutInflater mInflater;

    public DiaryEntriesListAdapter(List<DiaryEntry> entries, LayoutInflater inflater) {
        mEntries = entries;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mEntries.size();
    }

    @Override
    public DiaryEntry getItem(int i) {
        return mEntries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_diary_entry, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        DiaryEntry entry = getItem(i);
        holder.mDate.setText(entry.getDate().toString());
        holder.mNote.setText(entry.getNote());

        return view;
    }
}
