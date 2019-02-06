package com.example.shuaibsolomons.esave;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class popUp extends AppCompatActivity implements TextWatcher{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);



        Button btnAddMoney = findViewById(R.id.btnAddMoney);
        Button btnWithDraw = findViewById(R.id.btnWithDraw);

        Globals g = Globals.getInstance();
        g.setAns(0);                                    //to always begin at zero for adding inputs

        final TextView txtAddMoney = findViewById(R.id.txtAddMoney);
        final float[] secondValue = new float[1];
        final float[] initialValue = new float[1];

        final float[] cash = new float[1];

        final float[] category = new float[6];
        final String[] categoryVal = new String[6];

        final String txtCash;

        final String[] newCategoryVal; //= validation(categoryVal);

        //This is the initialisation of the previous activities category values
        final TextView varFood = findViewById(R.id.varFood);
        final TextView varEntertain = findViewById(R.id.varEntertain);
        final TextView varPersonal = findViewById(R.id.varPersonal);
        final TextView varEmerg = findViewById(R.id.varEmerg);
        final TextView varTravel = findViewById(R.id.varTravel);
        final TextView varAirtime = findViewById(R.id.varAirtime);

        final TextView totalExpense = findViewById(R.id.totalExpense);

        //This is the initialisation of the input placeholders that values need to be taken from and also the authority to listen for new values
        final TextView foodInput = findViewById(R.id.foodInput);
        foodInput.addTextChangedListener(this);
        final TextView entertainInput = findViewById(R.id.entertainInput);
        entertainInput.addTextChangedListener(this);
        final TextView personalInput = findViewById(R.id.personalInput);
        personalInput.addTextChangedListener(this);
        final TextView emergInput = findViewById(R.id.emergInput);
        emergInput.addTextChangedListener(this);
        final TextView travelInput = findViewById(R.id.travelInput);
        travelInput.addTextChangedListener(this);
        final TextView airtimeInput = findViewById(R.id.airtimeInput);
        airtimeInput.addTextChangedListener(this);

        Bundle bun = getIntent().getExtras();

        if (bun != null){

            //values received
            String textMoney = bun.getString("com.example.shuaibsolomons.esave.SOMETHING");
            txtCash = bun.getString("com.example.shuaibsolomons.esave.Cash");

            initialValue[0] = Float.parseFloat(textMoney);
            cash[0] = Float.parseFloat(txtCash);

            //This is the values that have been received from the previous activity and putting it in a list to make to use in the future.
            String food = bun.getString("com.example.shuaibsolomons.esave.Food");
            String entertain = bun.getString("com.example.shuaibsolomons.esave.Entertain");
            String personal = bun.getString("com.example.shuaibsolomons.esave.Personal");
            String emergency = bun.getString("com.example.shuaibsolomons.esave.Emergency");
            String travel = bun.getString("com.example.shuaibsolomons.esave.Travel");
            String airtime = bun.getString("com.example.shuaibsolomons.esave.Airtime");

            //This is the values that have been received from the previous activity and putting it in a list to make it easier to work with.
            category[0] = Float.parseFloat(food);
            category[1] = Float.parseFloat(entertain);
            category[2] = Float.parseFloat(personal);
            category[3] = Float.parseFloat(emergency);
            category[4] = Float.parseFloat(travel);
            category[5] = Float.parseFloat(airtime);


            //Setting/showing the previous activities values to the on screen values.
            varFood.setText(String.valueOf(category[0]));
            varEntertain.setText(String.valueOf(category[1]));
            varPersonal.setText(String.valueOf(category[2]));
            varEmerg.setText(String.valueOf(category[3]));
            varTravel.setText(String.valueOf(category[4]));
            varAirtime.setText(String.valueOf(category[5]));

        }

/*        String[] temp = validation(categoryVal);
        if(temp.length>0)
        {
            for (int i=0; i<temp.length;i++)
            {
                categoryVal[i] = temp[i];
            }
        }
        else
        {
            //break and tell user the they never added any money
        }
*/


        //Setting the onClick for the button to add the money
        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(),MainActivity.class);

                //getting the values that the user inputs adn setting it to a list to make it easier to access.
                categoryVal[0] = foodInput.getText().toString();
                categoryVal[1] = entertainInput.getText().toString();
                categoryVal[2] = personalInput.getText().toString();
                categoryVal[3] = emergInput.getText().toString();
                categoryVal[4] = travelInput.getText().toString();
                categoryVal[5] = airtimeInput.getText().toString();

                /*String[] temp = validation(categoryVal);
                if(temp.length>0)
                {
                    for (int i=0; i<temp.length;i++)
                    {
                        categoryVal[i] = temp[i];
                    }
                }
                else
                {
                    //break and tell user the they never added any money
                }*/

                //totalExpense.setText(String.valueOf(moneyNotAllocated(categoryVal,Integer.parseInt(txtAddMoney.getText().toString()))));

                for (int i = 0; i<categoryVal.length; i++)
                {
                    if(categoryVal[i].equals(""))
                    {
                        categoryVal[i] = "0";
                    }
                }

                float numExpense = Float.parseFloat(totalExpense.getText().toString());   //Gets the total amount of money that is allocated
                //if the total amount of expenses == the total amount of money you are adding
                DecimalFormat df = new DecimalFormat("#.000");
                txtAddMoney.setText(df.format(Float.parseFloat(txtAddMoney.getText().toString())));
                if(numExpense == Float.parseFloat(txtAddMoney.getText().toString()))
                {
                    String txtSecondValue = String.valueOf(txtAddMoney.getText());
                    secondValue[0] = Float.parseFloat(txtSecondValue) + Float.parseFloat(String.valueOf(initialValue[0]));
                    txtSecondValue = String.valueOf(secondValue[0]);

                    //category[0] += Integer.parseInt(categoryVal[0]);// + Integer.parseInt(varFood.getText().toString());
                    //int num = category[0]+Integer.parseInt(categoryVal[0]);
                    //String cat0 = String.valueOf((category[0]+Integer.parseInt(categoryVal[0])));

                    //adding the values from the previous activity to the values gotten from the user to form the new values.
                    category[0] += Float.parseFloat(categoryVal[0]);
                    category[1] += Float.parseFloat(categoryVal[1]);// + Integer.parseInt(varEntertain.getText().toString());
                    category[2] += Float.parseFloat(categoryVal[2]);// + Integer.parseInt(varPersonal.getText().toString());
                    category[3] += Float.parseFloat(categoryVal[3]);// + Integer.parseInt(varEmerg.getText().toString());
                    category[4] += Float.parseFloat(categoryVal[4]);// + Integer.parseInt(varTravel.getText().toString());
                    category[5] += Float.parseFloat(categoryVal[5]);// + Integer.parseInt(varAirtime.getText().toString());

                    Bundle bun = new Bundle();          //bundling values to send back to mainActivity
                    bun.putString("com.example.shuaibsolomons.esave.SOMETHING2", txtSecondValue);
                    bun.putString("com.example.shuaibsolomons.esave.Cash2", String.valueOf(cash[0]));

                    bun.putString("com.example.shuaibsolomons.esave.Food2",String.valueOf(category[0]));
                    bun.putString("com.example.shuaibsolomons.esave.Entertain2",String.valueOf(category[1]));
                    bun.putString("com.example.shuaibsolomons.esave.Personal2",String.valueOf(category[2]));
                    bun.putString("com.example.shuaibsolomons.esave.Emergency2",String.valueOf(category[3]));
                    bun.putString("com.example.shuaibsolomons.esave.Travel2",String.valueOf(category[4]));
                    bun.putString("com.example.shuaibsolomons.esave.Airtime2",String.valueOf(category[5]));
                    startIntent2.putExtras(bun);
                    setResult(RESULT_OK, startIntent2);
                    finish();
                }
                else
                {
                    //displays an alert if the amount of money does not == the amount of allocation.
                    AlertDialog builder1 = new AlertDialog.Builder(popUp.this)
                            .setTitle("Money allocation error")
                            .setMessage("The allocation total does not add up to the total amount of money you are adding.")
                            .setCancelable(true)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        btnWithDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(), MainActivity.class);


                String txtSecondValue = String.valueOf(txtAddMoney.getText());
                cash[0] = Float.parseFloat(txtSecondValue) + cash[0];
                initialValue[0] = initialValue[0]-Float.parseFloat(txtSecondValue);



                Bundle bun = new Bundle();          //bundling values to send back to mainActivity
                bun.putString("com.example.shuaibsolomons.esave.SOMETHING2", String.valueOf(initialValue[0]));
                bun.putString("com.example.shuaibsolomons.esave.Cash2", String.valueOf(cash[0]));

                bun.putString("com.example.shuaibsolomons.esave.Food2",String.valueOf(category[0]));
                bun.putString("com.example.shuaibsolomons.esave.Entertain2",String.valueOf(category[1]));
                bun.putString("com.example.shuaibsolomons.esave.Personal2",String.valueOf(category[2]));
                bun.putString("com.example.shuaibsolomons.esave.Emergency2",String.valueOf(category[3]));
                bun.putString("com.example.shuaibsolomons.esave.Travel2",String.valueOf(category[4]));
                bun.putString("com.example.shuaibsolomons.esave.Airtime2",String.valueOf(category[5]));
                startIntent2.putExtras(bun);
                setResult(RESULT_OK, startIntent2);
                finish();

            }
        });
    }

    //int ans = 0;
    public int moneyNotAllocated(String[] catData, int totalCash){
        int allocationNum = 0, excess = 0;
        int[] moneyAllocation = new int[6];

        for(int i = 0; i<catData.length; i++)
        {
            moneyAllocation[i] = Integer.parseInt(catData[i]);
            allocationNum = allocationNum +moneyAllocation[i];
        }
/*
        for(int i = 0; i <catData.length ; i++)
        {
            allocationNum = allocationNum +moneyAllocation[i];
        }
*/
        excess = totalCash - allocationNum;
        if(excess>=0)
        {
            return excess;
        }

        else
        {
            return (-1);
        }
    }

    //receives a list of if list has empty values fill with "0"
    public String[] validation (String[] catInputData)
    {
        //String[] intCatData = new String[6];
        //int num = 0;

        for(int i =0; i<catInputData.length; i++)
        {
            if(catInputData[i].equals(""));
            {
                catInputData[i] ="0";
            }
            //intCatData[i] = Integer.parseInt(catInputData[i]);
        }
        return catInputData;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Globals g = Globals.getInstance();

        String temp;
        String lastVal;//= s.charAt(s.length()-1)+"";


        if (s.length() > 0) {                                   //in order to avoid 1 + 10 + 102 instead of just 102 check
            temp = s.toString();
            lastVal = s.charAt(s.length()-1)+"";
            float val = g.getAns();                               //previous value
            if(lastVal.equals("."))
            {
                temp = s+"0";
            }

            float number = Float.parseFloat(temp);        //new value
            val -= number;
            g.setAns(val);
        }


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        TextView totalExpense = findViewById(R.id.totalExpense);
        String lastVal;// = s.charAt(s.length()-1)+"";
        String temp;// = s.toString();

        DecimalFormat df = new DecimalFormat("#.000");

        if (s.length() == 0) {
            CharSequence val = "0";
            s = val;
        }

        lastVal = s.charAt(s.length()-1)+"";
        temp = s.toString();
        if(lastVal.equals("."))
        {
            temp = s+"0";
        }

        Globals g = Globals.getInstance();
        float val = g.getAns();
        float number = Float.parseFloat(temp);
        val += number;
        val = Float.parseFloat(df.format(val));
        g.setAns(val);
        totalExpense.setText(String.valueOf(g.getAns()));
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
