package ipn.cecyt9.practica1_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Double numero1,numero2,resultado;
    String operador;
    boolean restriction = false;

    public void onClickButtonOne(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "1");
    }

    public void onClickButtonTwo(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "2");
    }

    public void onClickButtonThree(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "3");
    }

    public void onClickButtonFour(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "4");
    }

    public void onClickButtonFive(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "5");
    }

    public void onClickButtonSix(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "6");
    }

    public void onClickButtonSeven(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "7");
    }

    public void onClickButtonEight(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "8");
    }

    public void onClickButtonNine(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "9");
    }

    public void onClickButtonZero(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "0");
    }

    public void onClickButtonAC(View miView) {
        TextView tv = findViewById(R.id.textView);
        tv.setText("");
    }

    public void onClickButtonDEL(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        int prevSize = value.length() - 1;
        String value2 = "";
        if (value.length() <= 1) {
            tv.setText("");
        } else {
            for (int i = 0; i < prevSize; i++) {
                tv.setText(value2 + value.charAt(i));
                value2 = tv.getText().toString();
            }
        }
    }

    public void onClickOperacionCapturaNumero1(View miView) {
        TextView tv = findViewById(R.id.textView);
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }

    public void onClickSum(View miView) {
        operador = "+";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickSubt(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        if(value == "")
        {
            tv.setText("-");
        }
        else {
            operador = "-";
            onClickOperacionCapturaNumero1(miView);
        }
    }

    public void onClickMulti(View miView) {
        operador = "*";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickDivi(View miView) {
        operador = "/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickDot(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + ".");
    }

    public void onClickSin(View miView) {
        onClickOperacionCapturaNumero1(miView);
        TextView tv = (TextView) findViewById(R.id.textView);
        double rad = Math.toRadians(numero1);
        resultado = Math.sin(rad);
        tv.setText(resultado.toString());
    }

    public void onClickCos(View miView) {
        onClickOperacionCapturaNumero1(miView);
        TextView tv = (TextView) findViewById(R.id.textView);
        if(numero1 == 90)
        {
            tv.setText("0");
        }
        else {
            double rad = Math.toRadians(numero1);
            resultado = Math.cos(rad);
            tv.setText(resultado.toString());
        }
    }

    public void onClickTan(View miView) {
        onClickOperacionCapturaNumero1(miView);
        TextView tv = (TextView) findViewById(R.id.textView);
        if(numero1 == 90)
        {
            tv.setText("∞");
        }
        else {
            double rad = Math.toRadians(numero1);
            resultado = Math.tan(rad);
            tv.setText(resultado.toString());
        }
    }

    public void onClickEquals(View miView) {
        TextView tv = (TextView) findViewById(R.id.textView);
        numero2 = Double.parseDouble(tv.getText().toString());
        try{
            if(operador.equals("+")){
                resultado = numero1 + numero2;
            }
            else
                if(operador.equals("-"))
                {
                    resultado = numero1 - numero2;
                }
                else
                    if(operador.equals("*"))
                    {
                        resultado = numero1 * numero2;
                    }
                    else
                        if(operador.equals("/"))
                        {
                            if(numero2 == 0)
                            {
                                restriction = true;
                            }
                            else {
                                resultado = numero1 / numero2;
                            }
                        }

            if(restriction == true)
            {
                tv.setText("Indeterminado");
                restriction = false;
            }
            else {
                tv.setText(resultado.toString());
            }
        }catch(NumberFormatException nfe){
            Toast.makeText(this, "Numero incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

}
