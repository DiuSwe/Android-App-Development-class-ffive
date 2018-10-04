package com.example.user.androidclassfour;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText first_number, second_number;
    private TextView textViewResult;
    private Button add, sub, mul, div;

    double num1, num2;

    double resultValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first_number= findViewById(R.id.firstNumber_edit_text);
        second_number= findViewById(R.id.secondNumber_edit_text);

        textViewResult= findViewById(R.id.result_text);


        add= findViewById(R.id.button_add);
        sub= findViewById(R.id.button_sub);
        mul= findViewById(R.id.buton_mul);
        div= findViewById(R.id.buton_div);

        additionMethod();
        substractionMethod();
        multiplicationMethod();

        divisionMethod();







    }

    private void divisionMethod() {


    }

    private void multiplicationMethod() {


    }

    private void substractionMethod() {


    }

    private void additionMethod() {


      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String valueOfnum1= first_number.getText().toString();

              String valueOfNum2= second_number.getText().toString();





                  try{


                      if(valueOfnum1.equals("") || valueOfNum2.equals("")){
                         // Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();
                          alertDialogeMethod();
                      }

                      else{
                          num1= Double.valueOf(valueOfnum1);

                          num2 = Double.valueOf(valueOfNum2);
                          resultValue= num1+num2;
                          textViewResult.setText("Your result of addition is ::"+resultValue);
                          //here need to create progress dialoge

                          final ProgressDialog progressDialog= new ProgressDialog(MainActivity.this);
                          progressDialog.setMessage("Loading data.... please wait.....");
                          progressDialog.setCancelable(false);
                          progressDialog.show();


                          //set timer cause hoow many time you ewant to show progress
                          long delayInMillis = 5000;


                          //timer is help for show time in progress
                          Timer timer = new Timer();

                          //timer.scheduler is helping for progress schedule

                          timer.schedule(new TimerTask() {
                              @Override
                              public void run() {
                                  //close progress dialoge..
                                  progressDialog.dismiss();
                                 // alertDialogeMethod();
                                 // alertDialogeMethod();
                              }
                          }, delayInMillis);



                      }

                  }catch (InputMismatchException e){
                      e.printStackTrace();
                  }
                  catch (NumberFormatException e){
                      e.printStackTrace();
                  }
                  catch (Exception e){
                      e.printStackTrace();
                  }



          }
      });





    }

    private void alertDialogeMethod(){
        AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);
        myBuilder.setTitle("App development class");
        myBuilder.setMessage("Your field is empty");
        myBuilder.setIcon(R.drawable.alert);
        myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You press ok button", Toast.LENGTH_SHORT).show();

            }
        });

        //
        myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "You press No", Toast.LENGTH_SHORT).show();

            }
        });

        // alert dialog class for creatr alert dialoge......
        AlertDialog myDialog= myBuilder.create();
        myDialog.show();

    }

    private void progressDialogMethod(){


    }



}
