package com.example.shuaibsolomons.esave;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class removeCash extends AppCompatActivity implements TextWatcher{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_cash);



        Button btnAddExpenses = findViewById(R.id.btnAddExpenses);

        //final TextView txtAddMoney = findViewById(R.id.txtAddMoney);
        //final int[] secondValue = new int[1];

        Globals g = Globals.getInstance();
        g.setAns(0);                                    //to always begin at zero for adding inputs

        final TextView txtMoney = findViewById(R.id.txtMoney);
        final TextView txtCash = findViewById(R.id.txtCash);

        final float[] initialValue = new float[2];
        final float[] category = new float[6];
        final String[] categoryVal = new String[6];

        final String[] newCategoryVal; //= validation(categoryVal);

        //This is the initialisation of the previous activities category values
        final TextView varFood = findViewById(R.id.varFood);
        final TextView varEntertain = findViewById(R.id.varEntertain);
        final TextView varPersonal = findViewById(R.id.varPersonal);
        final TextView varEmerg = findViewById(R.id.varEmerg);
        final TextView varTravel = findViewById(R.id.varTravel);
        final TextView varAirtime = findViewById(R.id.varAirtime);

        final TextView totalExpense = findViewById(R.id.totalExpense);

        //This is the initialisation of the input placeholders that values need to be taken from.
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

        txtMoney.setBackgroundColor(Color.parseColor("#2542e4"));        //always make card the selected method of payment.
        Globals.getInstance().setCardSelected(true);

        if (bun != null){

            String textMoney = bun.getString("com.example.shuaibsolomons.esave.SOMETHING");
            String textCash = bun.getString("com.example.shuaibsolomons.esave.Cash");

            String food = bun.getString("com.example.shuaibsolomons.esave.Food");
            String entertain = bun.getString("com.example.shuaibsolomons.esave.Entertain");
            String personal = bun.getString("com.example.shuaibsolomons.esave.Personal");
            String emergency = bun.getString("com.example.shuaibsolomons.esave.Emergency");
            String travel = bun.getString("com.example.shuaibsolomons.esave.Travel");
            String airtime = bun.getString("com.example.shuaibsolomons.esave.Airtime");

            initialValue[0] = Float.parseFloat(textMoney);
            initialValue[1] = Float.parseFloat(textCash);

            category[0] = Float.parseFloat(food);
            category[1] = Float.parseFloat(entertain);
            category[2] = Float.parseFloat(personal);
            category[3] = Float.parseFloat(emergency);
            category[4] = Float.parseFloat(travel);
            category[5] = Float.parseFloat(airtime);

            txtMoney.setText(bun.getString("com.example.shuaibsolomons.esave.SOMETHING"));
            txtCash.setText(bun.getString("com.example.shuaibsolomons.esave.Cash"));

            varFood.setText(String.valueOf(category[0]));
            varEntertain.setText(String.valueOf(category[1]));
            varPersonal.setText(String.valueOf(category[2]));
            varEmerg.setText(String.valueOf(category[3]));
            varTravel.setText(String.valueOf(category[4]));
            varAirtime.setText(String.valueOf(category[5]));

        }

        //totalExpense.setText(moneyNotAllocated(validation(categoryVal)));


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

        btnAddExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(),MainActivity.class);

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


                //category[0] += Integer.parseInt(categoryVal[0]);// + Integer.parseInt(varFood.getText().toString());
                //int num = category[0]+Integer.parseInt(categoryVal[0]);
                //String cat0 = String.valueOf((category[0]+Integer.parseInt(categoryVal[0])));
                for (int i = 0; i<categoryVal.length; i++)
                {
                    if(categoryVal[i].equals(""))
                    {
                        categoryVal[i] = "0";
                    }
                }

                category[0] -= Float.parseFloat(categoryVal[0]);
                category[1] -= Float.parseFloat(categoryVal[1]);// + Integer.parseInt(varEntertain.getText().toString());
                category[2] -= Float.parseFloat(categoryVal[2]);// + Integer.parseInt(varPersonal.getText().toString());
                category[3] -= Float.parseFloat(categoryVal[3]);// + Integer.parseInt(varEmerg.getText().toString());
                category[4] -= Float.parseFloat(categoryVal[4]);// + Integer.parseInt(varTravel.getText().toString());
                category[5] -= Float.parseFloat(categoryVal[5]);// + Integer.parseInt(varAirtime.getText().toString());
                /*int[] temp = new int[6];
                for (int i =0; i<6; i++)
                {
                    temp[i]=Integer.parseInt(categoryVal[i]);
                }*/
                Globals g = Globals.getInstance();
                if (g.getCashSelected() == true)
                {
                    initialValue[1] = initialValue[1]-sumExpense(toFloat(categoryVal));
                }

                if (g.getCardSelected() == true)
                {
                    initialValue[0] = initialValue[0]-sumExpense(toFloat(categoryVal));
                }



                Bundle bun = new Bundle();          //bundling values to send back to mainActivity
                bun.putString("com.example.shuaibsolomons.esave.Food2",String.valueOf(category[0]));
                bun.putString("com.example.shuaibsolomons.esave.Entertain2",String.valueOf(category[1]));
                bun.putString("com.example.shuaibsolomons.esave.Personal2",String.valueOf(category[2]));
                bun.putString("com.example.shuaibsolomons.esave.Emergency2",String.valueOf(category[3]));
                bun.putString("com.example.shuaibsolomons.esave.Travel2",String.valueOf(category[4]));
                bun.putString("com.example.shuaibsolomons.esave.Airtime2",String.valueOf(category[5]));

                bun.putString("com.example.shuaibsolomons.esave.SOMETHING2",String.valueOf(initialValue[0]));
                bun.putString("com.example.shuaibsolomons.esave.Cash2",String.valueOf(initialValue[1]));

                startIntent2.putExtras(bun);
                setResult(RESULT_OK, startIntent2);
                finish();


            }
        });
    }

    public void selectorCard1(View v)
    {
        TextView txtMoney = findViewById(R.id.txtMoney);
        TextView txtCash = findViewById(R.id.txtCash);
        Globals g = Globals.getInstance();

        if(g.getCardSelected() == false)
        {
            txtMoney.setBackgroundColor(Color.parseColor("#2542e4"));
            txtMoney.setTextColor(Color.parseColor("#ffffff"));
            txtCash.setBackgroundColor(Color.parseColor("#eeeeee"));
            txtCash.setTextColor(Color.parseColor("#757575"));

            g.setCardSelected(true);
            g.setCashSelected(false);
        }
    }

    public void selectorCash1(View v)
    {
        TextView txtMoney = findViewById(R.id.txtMoney);
        TextView txtCash = findViewById(R.id.txtCash);
        Globals g = Globals.getInstance();

        if(g.getCashSelected() == false)
        {
            txtMoney.setBackgroundColor(Color.parseColor("#eeeeee"));
            txtMoney.setTextColor(Color.parseColor("#757575"));
            txtCash.setBackgroundColor(Color.parseColor("#2542e4"));
            txtCash.setTextColor(Color.parseColor("#ffffff"));

            g.setCardSelected(false);
            g.setCashSelected(true);
        }
    }

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

    public float[] toFloat(String[] data)
    {
        float[] temp = new float[data.length];
        for(int i=0; i<data.length; i++)
        {
            temp[i] = Float.parseFloat(data[i]);
        }

        return temp;
    }

    public float sumExpense(float[] expenses)
    {
        float totExpense = 0;
        for(int i = 0; i<expenses.length;i++)
        {
            totExpense += expenses[i];
        }

        DecimalFormat df = new DecimalFormat("#.000");
        totExpense = Float.parseFloat(df.format(totExpense));

        return totExpense;
    }

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
