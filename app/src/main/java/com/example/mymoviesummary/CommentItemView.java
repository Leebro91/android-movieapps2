package com.example.mymoviesummary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {
    TextView memo;
    TextView names;

    public CommentItemView(Context context) {
        super(context);

        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        memo = (TextView) findViewById(R.id.memo);
        names = (TextView) findViewById(R.id.names);

    }

    public void setNames(String name) {
        names.setText(name);
    }

    public void setMemo(String writes) {
        memo.setText(writes);
    }
}
