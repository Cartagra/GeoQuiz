package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.bignerdranch.android.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private boolean mAnswerShown;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            setShownAnswerResult(savedInstanceState.getBoolean(EXTRA_ANSWER_SHOWN));
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnswerTextView.setText(Boolean.toString(mAnswerIsTrue).toUpperCase());
                setShownAnswerResult(true);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(EXTRA_ANSWER_SHOWN, mAnswerShown);

        super.onSaveInstanceState(bundle);
    }


    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    private void setShownAnswerResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        mAnswerShown = isAnswerShown;
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent data) {
        return data.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
}
