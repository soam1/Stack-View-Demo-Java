package com.akashsoam.stackviewdemojava;

import android.os.Bundle;
import android.widget.StackView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        stackView = findViewById(R.id.stack_view);

        MainAdapter mainAdapter = new MainAdapter(numberWords(), numberImages(), R.layout.item, this);
        stackView.setAdapter(mainAdapter);
    }

    private List<String> numberWords() {
        List<String> numberWords = new ArrayList<>();
        numberWords.add("One");
        numberWords.add("Two");
        numberWords.add("Three");
        numberWords.add("Four");
        numberWords.add("Five");
        numberWords.add("Six");
        numberWords.add("Seven");
        return numberWords;
    }

    private List<Integer> numberImages() {
        List<Integer> numberImages = new ArrayList<>();
        numberImages.add(R.drawable.one);
        numberImages.add(R.drawable.two);
        numberImages.add(R.drawable.three);
        numberImages.add(R.drawable.four);
        numberImages.add(R.drawable.five);
        numberImages.add(R.drawable.six);
        numberImages.add(R.drawable.seven);
        return numberImages;
    }
}