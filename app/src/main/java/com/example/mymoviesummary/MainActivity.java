package com.example.mymoviesummary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    Button likeButton2;
    TextView likeCountView;
    TextView likeCountView2;
    ListView listView;

    int likeCount = 15;
    int likeCount2 = 1;

    boolean likeState = false;
    boolean likeState2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        CommentAdapter adapter = new CommentAdapter();
        adapter.addcomment(new CommentItem("gyme102***","적당히 재밌다."));
        adapter.addcomment(new CommentItem("kym71***","적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addcomment(new CommentItem("ky2***","오랜만에 잠 안오는 영화 봤네요."));
        adapter.addcomment(new CommentItem("ua642***","적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));

        listView.setAdapter(adapter);

        Utility.setListViewHeightBasedOnChildren(listView);


        LinearLayout writeButton = (LinearLayout) findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button allViewButton = (Button) findViewById(R.id.allViewButton);
        allViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        

        likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState2) {
                    decrLikeCount2();
                    incrLikeCount();
                } else if (likeState) {
                    decrLikeCount();
                } else {
                    incrLikeCount();
                }
                likeState = !likeState;

            }
        });

        likeButton2 = (Button) findViewById(R.id.likeButton2);
        likeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState) {
                    decrLikeCount();
                    incrLikeCount2();
                } else if (likeState2) {
                    decrLikeCount2();
                } else {
                    incrLikeCount2();
                }
                likeState2 = !likeState2;


            }
        });

        likeCountView = (TextView) findViewById(R.id.likeCountView);

        likeCountView2 = (TextView) findViewById(R.id.likeCountView2);


    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> comments = new ArrayList<CommentItem>();

        @Override
        public int getCount() {

            return comments.size();
        }

        public void addcomment(CommentItem comment) {
            comments.add(comment);

        }

        @Override
        public Object getItem(int position) {

            return comments.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = null;
            if(convertView == null) {
                view = new CommentItemView(getApplicationContext());
            } else {
                view = (CommentItemView) convertView;
            }

            CommentItem comment = comments.get(position);
            view.setNames(comment.getName());
            view.setMemo(comment.getWrites());

            return view;
        }
    }

    public void incrLikeCount() {
        likeCount += 1;
        likeState2 = false;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeState2 = false;
        likeCountView.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }


    public void incrLikeCount2() {
        likeCount2 += 1;
        likeState = false;
        likeCountView2.setText(String.valueOf(likeCount2));
        likeButton2.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrLikeCount2() {
        likeCount2 -= 1;
        likeState = false;
        likeCountView2.setText(String.valueOf(likeCount2));
        likeButton2.setBackgroundResource(R.drawable.thumbs_down_selector);
    }

}