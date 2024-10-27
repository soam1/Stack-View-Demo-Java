package com.akashsoam.stackviewdemojava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MainAdapter extends ArrayAdapter {
    List<String> numberWords;
    List<Integer> numberImages;
    int itemLayout;
    Context context;

    public MainAdapter(List<String> numberWords, List<Integer> numberImages, int itemLayout, Context context) {
        super(context, itemLayout, numberWords);
        this.numberWords = numberWords;
        this.numberImages = numberImages;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return numberWords.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return numberWords.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        }
        String word= numberWords.get(position);
        Integer image = numberImages.get(position);
        TextView textView = (TextView) convertView.findViewById(R.id.text_view);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
        textView.setText(word);
        imageView.setImageResource(image);
        return convertView;

    }
}
