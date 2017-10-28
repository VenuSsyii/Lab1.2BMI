package my.edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewMessage;
    private ImageView imageViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView method displays the UI
        //R = resource class
        setContentView(R.layout.activity_bmi);

        //Linking program with UI
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewMessage = (TextView)findViewById(R.id.textViewMessage);
        imageViewMessage = (ImageView)findViewById(R.id.imageView1);

    }
    //A method to handle View click event
    public void displayMessage(View view){
        double weight;
        double height;
        double bmiValue;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height = height/100;
        bmiValue = weight / (height*height);

        if(bmiValue <= 18.5){
            textViewMessage.setText("Under Weight");
            imageViewMessage.setImageResource(R.drawable.under);
        }
        else if(bmiValue > 18.5 && bmiValue < 25){
            textViewMessage.setText("Normal");
            imageViewMessage.setImageResource(R.drawable.normal);
        }
        else{
            textViewMessage.setText("Over Weight");
            imageViewMessage.setImageResource(R.drawable.over);
        }

    }

    public void resetScreen(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        imageViewMessage.setImageResource(R.drawable.empty);
    }

}
