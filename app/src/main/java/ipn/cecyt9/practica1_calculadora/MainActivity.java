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
    String cadNum = ".1234567890";
    String num1 = "";
    String num2 = "";
    Double dNum1, dNum2, resultado;
    String sResultado;
    String operacion;
    char operador = ' ';
    int operPos = 0;
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
        if(operador == 's' || operador == 'c' || operador == 't' || operador == 'r')
        {
            operador = ' ';
        }
        if (value.length() <= 1) {
            tv.setText("");
        } else {
            for (int i = 0; i < prevSize; i++) {
                tv.setText(value2 + value.charAt(i));
                value2 = tv.getText().toString();
            }
        }
    }


    public void onClickSum(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "+");
    }

    public void onClickSubt(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "-");
    }

    public void onClickMulti(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "x");
    }

    public void onClickDivi(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + "÷");
    }

    public void onClickDot(View miView) {
        TextView tv = findViewById(R.id.textView);
        String value = tv.getText().toString();
        tv.setText(value + ".");
    }

    public void onClickSin(View miView) { ;
        TextView tv = findViewById(R.id.textView);
        tv.setText("Sin");
        operador = 's';
    }

    public void onClickCos(View miView) {
        TextView tv = findViewById(R.id.textView);
        tv.setText("Cos");
        operador = 'c';
    }
    public void onClickSRoot(View miView) {
        TextView tv = findViewById(R.id.textView);
        tv.setText("√");
        operador = 'r';
    }

    public void onClickTan(View miView) {
        TextView tv = findViewById(R.id.textView);
        tv.setText("Tan");
        operador = 't';
        }


    public void onClickEquals(View miView) {
        TextView tv = findViewById(R.id.textView);
        operacion = tv.getText().toString();
        if (operador == ' ') {
            for (int i = 0; i < operacion.length(); i++) {
                if (i == 0 && operacion.charAt(i) == '-') {
                    num1 = num1 + operacion.charAt(i);
                }
                for (int j = 0; j < cadNum.length(); j++) {
                    if (operacion.charAt(i) == cadNum.charAt(j)) {
                        num1 = num1 + operacion.charAt(i);
                    }

                    if ((operacion.charAt(i) == 'x') || (operacion.charAt(i) == '+') || (operacion.charAt(i) == '-' && i != 0) || (operacion.charAt(i) == '÷')) {
                        operador = operacion.charAt(i);
                        operPos = i;
                        break;
                    }
                }
                if (operador == 'x' || operador == '+' || operador == '-' || operador == '÷') {
                    break;
                }
            }
            for (int i = operPos + 1; i < operacion.length(); i++) {
                num2 = num2 + operacion.charAt(i);
            }
            dNum1 = Double.parseDouble(num1);
            dNum2 = Double.parseDouble(num2);
            if (operador == 'x') {
                resultado = dNum1 * dNum2;
            }

            if (operador == '+') {
                resultado = dNum1 + dNum2;
            }

            if (operador == '-') {
                resultado = dNum1 - dNum2;
            }

            if (operador == '÷') {
                resultado = dNum1 / dNum2;
            }
            sResultado = resultado.toString();
            if(dNum2 == 0.0)
            {
                tv.setText("Indeterminado");
            }
            else {
                tv.setText(sResultado);
            }
            num1 = "";
            num2 = "";
            dNum1 = 0.0;
            dNum2 = 0.0;
            operador = ' ';
            resultado = 0.0;
            operacion = "";
            sResultado = "";
            operPos = 0;
        } else {
            if (operador == 's') {
                for (int i = 3; i < operacion.length(); i++) {
                    num1 = num1 + operacion.charAt(i);
                }
                dNum1 = Double.parseDouble(num1);
                double rad = Math.toRadians(dNum1);
                resultado = Math.sin(rad);
                sResultado = resultado.toString();
                tv.setText(sResultado);
                num1 = "";
                dNum1 = 0.0;
                operador = ' ';
                resultado = 0.0;
                operacion = "";
                sResultado = "";
            }
            if (operador == 'c') {
                for (int i = 3; i < operacion.length(); i++) {
                    num1 = num1 + operacion.charAt(i);
                }
                dNum1 = Double.parseDouble(num1);
                double rad = Math.toRadians(dNum1);
                resultado = Math.cos(rad);
                sResultado = resultado.toString();
                if(dNum1 == 90.0){
                    tv.setText("0.0");
                }
                else {
                    tv.setText(sResultado);
                }
                num1 = "";
                dNum1 = 0.0;
                operador = ' ';
                resultado = 0.0;
                operacion = "";
                sResultado = "";
            }
            if (operador == 't') {
                for (int i = 3; i < operacion.length(); i++) {
                    num1 = num1 + operacion.charAt(i);
                }
                dNum1 = Double.parseDouble(num1);
                double rad = Math.toRadians(dNum1);
                resultado = Math.tan(rad);
                sResultado = resultado.toString();
                if(dNum1 == 90.0){
                    tv.setText("∞");
                }
                else {
                    tv.setText(sResultado);
                }
                num1 = "";
                dNum1 = 0.0;
                operador = ' ';
                resultado = 0.0;
                operacion = "";
                sResultado = "";
            }
            if (operador == 'r') {
                for (int i = 1; i < operacion.length(); i++) {
                    num1 = num1 + operacion.charAt(i);
                }
                dNum1 = Double.parseDouble(num1);
                resultado = Math.sqrt(dNum1);
                sResultado = resultado.toString();
                tv.setText(sResultado);
                num1 = "";
                dNum1 = 0.0;
                operador = ' ';
                resultado = 0.0;
                operacion = "";
                sResultado = "";
            }
        }
    }
}
