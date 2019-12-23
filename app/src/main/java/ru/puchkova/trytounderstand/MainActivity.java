package ru.puchkova.trytounderstand;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

//короче я уже ничего не понимаю, адаптеры оказались чем-то непонятным для меня, хэлп!

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ItemsAdapter adapter;
    private List<Integer> images = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        fillImages();

        adapter = new ItemsAdapter(this, null);
        generateItems();
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                showItemData(position);
            }
        });
    }

    //Непонятно, как получить мои загруженные картинки? Он их просто не видит
    private void fillImages() {
        images.add(R.drawable.cities);
        images.add(R.drawable.money);
        images.add(R.drawable.monitoring);
        images.add(R.drawable.photo);
        images.add(R.drawable.subscribe);
        images.add(R.drawable.tasks);
    }

    private void generateItems() {
        String[] titles = getString(R.string.apps).split("\n\n");
        String[] subtitles = getString(R.string.apps_sub).split("\n\n");

        for (int i = 0; i < images.size(); i++){
            adapter.addItem(new Items(images.get(i), titles[i],subtitles[i], false));
        }
    }

    private void showItemData(int position) {
        Items itemData = adapter.getItem(position);
        Toast.makeText(MainActivity.this,
                "Title: " + itemData.getTitle() + "\n" +
                        "Subtitle: " + itemData.getSubtitle() + "\n" +
                        "Checked: " + itemData.isChecked(),
                Toast.LENGTH_SHORT).show();
    }

}
