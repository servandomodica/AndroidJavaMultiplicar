package com.example.practico2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv2,tv4,tv5,tv6;
	EditText et1;
	int valor1,valor2;
	int contFall=0;
	int contGan=0;
	int jugadas=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2=(TextView)findViewById(R.id.textView2);
        tv4=(TextView)findViewById(R.id.textView4);
        tv5=(TextView)findViewById(R.id.textView5);
        tv6=(TextView)findViewById(R.id.textView6);
        et1=(EditText)findViewById(R.id.editText1);
        valor1 = 1+(int)(Math.random()*10);
        valor2 = 1+(int)(Math.random()*10);
        tv2.setText(String.valueOf(valor1));
        tv4.setText(String.valueOf(valor2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void verificar (View v) {
    	String cadena=et1.getText().toString();
    	if (cadena.length()==0) {
    		Toast.makeText(this, "No has ingresado tu respuesta.", Toast.LENGTH_LONG).show();
    	}else{
    		int numUser=Integer.parseInt(cadena);
	    	int objetivo=valor1*valor2;
	    	if (numUser!=objetivo){
	    		contFall=contFall+1;
	    		Toast.makeText(this, valor1+" x "+valor2+" no es igual a "+numUser+", volvé a jugar ahora.", Toast.LENGTH_LONG).show();
	            valor1 = 1+(int)(Math.random()*10);
	            valor2 = 1+(int)(Math.random()*10);
	            tv2.setText(String.valueOf(valor1));
	            tv4.setText(String.valueOf(valor2));
	            et1.setText("");
	            tv5.setText("Acabás de perder, ¡jugá otra vez!");
	            }else{
	    		contGan=contGan+1;
	    		Toast.makeText(this, "¡GANASTE! "+valor1+" x "+valor2+" = "+numUser, Toast.LENGTH_LONG).show();
	            valor1 = 1+(int)(Math.random()*10);
	            valor2 = 1+(int)(Math.random()*10);
	            tv2.setText(String.valueOf(valor1));
	            tv4.setText(String.valueOf(valor2));
	    		et1.setText("");
	    		tv5.setText("Has ganado "+contGan+" veces en total. ¿Podrás una vez más?");
	    	}
	    	jugadas=contFall+contGan;
	    	tv6.setText("Has jugado "+jugadas+" veces.");
    	}
    }
    
}
