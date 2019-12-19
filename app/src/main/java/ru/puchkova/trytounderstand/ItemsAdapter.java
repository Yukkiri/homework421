package ru.puchkova.trytounderstand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends BaseAdapter {

    private List<Items> items;

    private LayoutInflater inflater;

    private CompoundButton.OnCheckedChangeListener myCheckChangeList
            = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            items.get((Integer) buttonView.getTag()).setChecked(isChecked);
        }
    };



    ItemsAdapter(Context context, List<Items> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(Items item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    // вообще не поняла, зачем нам этот метод, но он был в примере поэтому пусть лежит
    void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Items getItem(int position) {
        if (position < items.size()) {
            return items.get(position);
        } else {
            return null;
        }
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    // если я скажу, что понимаю, что тут происходит - я совру, потому что ничего не понимаю
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_activity, parent, false);
        }

        Items itemData = items.get(position);

        ImageView image = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.first);
        TextView subtitle = view.findViewById(R.id.second);
        CheckBox checkBox = view.findViewById(R.id.checkbox);

        image.setImageDrawable(itemData.getImage());
        title.setText(itemData.getTitle());
        subtitle.setText(itemData.getSubtitle());

        checkBox.setOnCheckedChangeListener(myCheckChangeList);
        checkBox.setTag(position);
        checkBox.setChecked(itemData.isChecked());

        return view;
    }
}