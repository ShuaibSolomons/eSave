package com.example.shuaibsolomons.esave;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    SharedPreferences sharedPreferences;
    public static final String EXPENDITURE ="Expenditure";
    //public static final String TOTAL_AMOUNT_MONEY = "TotalCash";
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtMoney = findViewById(R.id.txtMoney);
        final TextView txtCash = findViewById(R.id.txtCash);
        Button btnAddMoney = findViewById(R.id.btnAddMoney);
        Button btnRemoveMoney = findViewById((R.id.btnRemoveMoney));

        final TextView varFood = findViewById(R.id.varFood);
        final TextView varEntertain = findViewById(R.id.varEntertain);
        final TextView varPersonal = findViewById(R.id.varPersonal);
        final TextView varEmerg = findViewById(R.id.varEmerg);
        final TextView varTravel = findViewById(R.id.varTravel);
        final TextView varAirtime = findViewById(R.id.varAirtime);


        //txtMoney.setBackgroundColor(Color.parseColor("#2542e4"));        //always make card the selected method of payment.
        //Globals.getInstance().setCardSelected(true);

        sharedPreferences = getSharedPreferences(EXPENDITURE, Context.MODE_PRIVATE);

        if(sharedPreferences.contains("com.example.shuaibsolomons.esave.SOMETHING2"))
        {
            txtMoney.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.SOMETHING2",""));
            txtCash.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Cash",""));

            varFood.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Food",""));
            varEntertain.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Entertain",""));
            varPersonal.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Personal",""));
            varEmerg.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Emerg",""));
            varTravel.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Travel",""));
            varAirtime.setText(sharedPreferences.getString("com.example.shuaibsolomons.esave.Airtime",""));

        }
        else
        {
            String zero = "0";

            txtMoney.setText(zero);
            txtCash.setText(zero);

            varFood.setText(zero);
            varEntertain.setText(zero);
            varPersonal.setText(zero);
            varEmerg.setText(zero);
            varTravel.setText(zero);
            varAirtime.setText(zero);
        }



        //Bundle bun = getIntent().getExtras();

        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),popUp.class);
                Bundle bun = new Bundle();
                bun.putString("com.example.shuaibsolomons.esave.SOMETHING", String.valueOf(txtMoney.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Cash", String.valueOf(txtCash.getText()));

                bun.putString("com.example.shuaibsolomons.esave.Food",String.valueOf(varFood.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Entertain",String.valueOf(varEntertain.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Personal",String.valueOf(varPersonal.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Emergency",String.valueOf(varEmerg.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Travel",String.valueOf(varTravel.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Airtime",String.valueOf(varAirtime.getText()));

                startIntent.putExtras(bun);
                startActivityForResult(startIntent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });

        btnRemoveMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),removeCash.class);
                Bundle bun = new Bundle();
                bun.putString("com.example.shuaibsolomons.esave.SOMETHING", String.valueOf(txtMoney.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Cash", String.valueOf(txtCash.getText()));

                bun.putString("com.example.shuaibsolomons.esave.Food",String.valueOf(varFood.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Entertain",String.valueOf(varEntertain.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Personal",String.valueOf(varPersonal.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Emergency",String.valueOf(varEmerg.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Travel",String.valueOf(varTravel.getText()));
                bun.putString("com.example.shuaibsolomons.esave.Airtime",String.valueOf(varAirtime.getText()));

                startIntent.putExtras(bun);
                startActivityForResult(startIntent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });




        //Intent startIntent2 = new Intent(getApplicationContext(),popUp.class);
        /*Bundle bun2 = getIntent().getExtras();
        if (bun2 != null) {

            String val = bun2.getString(Intent.EXTRA_TEXT);

            //Bundle bun2 = new Bundle();
            //String text = getIntent().getExtras().getString("com.example.shuaibsolomons.esave.SOMETHING2");
            txtMoney.setText(bun2.getString("com.example.shuaibsolomons.esave.SOMETHING2"));
            varFood.setText(bun2.getString("com.example.shuaibsolomons.esave.Food2"));
            varEntertain.setText(bun2.getString("com.example.shuaibsolomons.esave.Entertain2"));
            varPersonal.setText(bun2.getString("com.example.shuaibsolomons.esave.Personal2"));
            varEmerg.setText(bun2.getString("com.example.shuaibsolomons.esave.Emergency2"));
            varTravel.setText(bun2.getString("com.example.shuaibsolomons.esave.Travel2"));
            varAirtime.setText(bun2.getString("com.example.shuaibsolomons.esave.Airtime2"));


        }*/
    }

    public void selectorCard(View v)
    {
        TextView txtMoney = findViewById(R.id.txtMoney);
        TextView txtCash = findViewById(R.id.txtCash);
        Globals g = Globals.getInstance();

        if(g.getCardSelected() == false)
        {
            txtMoney.setBackgroundColor(Color.parseColor("#2542e4"));
            txtCash.setBackgroundColor(Color.parseColor("#eeeeee"));

            g.setCardSelected(true);
            g.setCashSelected(false);
        }
    }

    public void selectorCash(View v)
    {
        TextView txtMoney = findViewById(R.id.txtMoney);
        TextView txtCash = findViewById(R.id.txtCash);
        Globals g = Globals.getInstance();

        if(g.getCashSelected() == false)
        {
            txtMoney.setBackgroundColor(Color.parseColor("#eeeeee"));
            txtCash.setBackgroundColor(Color.parseColor("#2542e4"));

            g.setCardSelected(false);
            g.setCashSelected(true);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        //SharedPreferences totalCash = getSharedPreferences(TOTAL_AMOUNT_MONEY,0);
        //SharedPreferences.Editor editor = expense.edit();
        //editor.putString("",);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                //Bundle bun2 = data.getExtras();
                final TextView txtMoney = findViewById(R.id.txtMoney);
                final TextView txtCash = findViewById(R.id.txtCash);
                //Button btnAddMoney = findViewById(R.id.btnAddMoney);

                final TextView varFood = findViewById(R.id.varFood);
                final TextView varEntertain = findViewById(R.id.varEntertain);
                final TextView varPersonal = findViewById(R.id.varPersonal);
                final TextView varEmerg = findViewById(R.id.varEmerg);
                final TextView varTravel = findViewById(R.id.varTravel);
                final TextView varAirtime = findViewById(R.id.varAirtime);

                txtMoney.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.SOMETHING2"));
                txtCash.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Cash2"));

                varFood.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Food2"));
                varEntertain.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Entertain2"));
                varPersonal.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Personal2"));
                varEmerg.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Emergency2"));
                varTravel.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Travel2"));
                varAirtime.setText(data.getExtras().getString("com.example.shuaibsolomons.esave.Airtime2"));

                editor.putString("com.example.shuaibsolomons.esave.SOMETHING2", txtMoney.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Cash", txtCash.getText().toString());

                editor.putString("com.example.shuaibsolomons.esave.Food", varFood.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Entertain", varEntertain.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Personal", varPersonal.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Emerg", varEmerg.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Travel", varTravel.getText().toString());
                editor.putString("com.example.shuaibsolomons.esave.Airtime", varAirtime.getText().toString());
                editor.commit();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenus, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        //About shows Toast on Screen
        if(id == R.id.mnuAbout)
        {
            Toast.makeText(this, "eSave Version 1.0",Toast.LENGTH_SHORT).show();
        }

        //Exit closes the Application
        if(id == R.id.mnuExit)
        {
            Toast.makeText(this, "Application about to close",Toast.LENGTH_SHORT).show();
            System.exit(0);
        }

        //Reset sets everything back to ZERO
        if (id == R.id.mnuReset)
        {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you would like to reset the figures?");
            builder1.setCancelable(true);

            final TextView txtMoney = findViewById(R.id.txtMoney);
            final TextView txtCash = findViewById(R.id.txtCash);

            final TextView varFood = findViewById(R.id.varFood);
            final TextView varEntertain = findViewById(R.id.varEntertain);
            final TextView varPersonal = findViewById(R.id.varPersonal);
            final TextView varEmerg = findViewById(R.id.varEmerg);
            final TextView varTravel = findViewById(R.id.varTravel);
            final TextView varAirtime = findViewById(R.id.varAirtime);

            //Checks for Positive feedback
            builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    txtMoney.setText("0");
                    txtCash.setText("0");

                    varFood.setText("0");
                    varEntertain.setText("0");
                    varPersonal.setText("0");
                    varEmerg.setText("0");
                    varTravel.setText("0");
                    varAirtime.setText("0");


                    editor.putString("com.example.shuaibsolomons.esave.SOMETHING2", txtMoney.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Cash", txtCash.getText().toString());

                    editor.putString("com.example.shuaibsolomons.esave.Food", varFood.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Entertain", varEntertain.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Personal", varPersonal.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Emerg", varEmerg.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Travel", varTravel.getText().toString());
                    editor.putString("com.example.shuaibsolomons.esave.Airtime", varAirtime.getText().toString());
                    editor.commit();
                    dialog.cancel();
                }
            });


            //Checks for Negative feedback
            builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alert1 = builder1.create();
            alert1.show();

            //Toast.makeText(this,"Reset was selected ",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
