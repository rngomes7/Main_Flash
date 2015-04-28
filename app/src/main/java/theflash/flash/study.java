package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rickygomes on 4/27/15.
 */
public class study extends Activity implements View.OnClickListener
{
    TextView question;
    Button next_Question;
    Button back_button;
    Button show_answer;
    String answer;
    private card currentQues;
    public static final String answer2 = "tag";

    @Override

        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.study_quest);
            next_Question = (Button)findViewById(R.id.next_card_button);
            back_button = (Button)findViewById(R.id.back_button);
            show_answer = (Button)findViewById(R.id.show_ans_button);
            question = (TextView)findViewById(R.id.question_input);
            next_Question.setOnClickListener(this);
            back_button.setOnClickListener(this);
            show_answer.setOnClickListener(this);
        }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.show_ans_button:
            {
                if(currentQues == null)
                {
                    break;
                }
                answer = currentQues.getAnswer().toString();
                Intent answerActivity = new Intent(study.this, study_answer.class);
                answerActivity.putExtra(answer2, answer);
                startActivity(answerActivity);
                break;
            }
            case R.id.next_card_button:
            {
                currentQues = MainActivity.myDeck.getCard(false);
                if(currentQues!=null)
                {
                    question.setText(currentQues.getQuestion());
                }
                break;

            }
            case R.id.back_button:
            {
                finish();
                break;
            }
        }

    }




}
