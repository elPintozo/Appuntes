package com.example.ricardo.appuntes;

import android.graphics.Color;
import android.media.Rating;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {/*AppCompatActivity es quien nos ayuda a manipular la vista*/

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;

    private Button button_1;
    private Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {/*Metodo que se ejecuta al iniciar la aplicacion*/
        super.onCreate(savedInstanceState);

        /*******************************************************************************************/
        /************************************METODO ACTUAL******************************************/
        /*******************************************************************************************/
        setContentView(R.layout.activity_main);

//--------Ejemplo de ListView
        //Metodo Personalizado
        //AdapterEstudiante adapterEstudiante = new AdapterEstudiante(this, R.layout.item_adapter_estudiante,Estudiante.listaEstudiantes());

        //Metodo Tradicional
        //ArrayAdapter<Estudiante> adapter = new ArrayAdapter<Estudiante>(this,R.layout.item_adapter_estudiante,R.id.txt_nombre, Estudiante.listaEstudiantes());

        //ListView listView = (ListView)findViewById(R.id.list_view_estudiantes);
        //listView.setAdapter(adapter);
        //listView.setAdapter(adapterEstudiante);
//--------Ejemplo de botones
//        textView_1 = (TextView)findViewById(R.id.text_1);
//        textView_2 = (TextView)findViewById(R.id.text_2);
//        textView_3 = (TextView)findViewById(R.id.text_3);
//
//        button_1 = (Button)findViewById(R.id.button_1);
//        button_2 = (Button)findViewById(R.id.button_2);
//
//        textView_1.setText(getString(R.string.txt_textview_1));
//        textView_2.setText(getString(R.string.txt_textview_2));
//        textView_3.setText(getString(R.string.txt_textview_3));
//        button_1.setText(getString(R.string.txt_button_1));
//        button_2.setText(getString(R.string.txt_button_2));
//
//        button_1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.buttom));
//        button_2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.buttom));

        /*******************************************************************************************/
        /************************************METODO CONVENCIONAL************************************/
        /*******************************************************************************************/

//--------Ejemplo de botones
//        /*Inicializo el ViewGroup*/
//        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
//
//        /*Inicializo los Views*/
//        TextView textView_1 = new TextView(getApplicationContext());
//        TextView textView_2 = new TextView(getApplicationContext());
//        TextView textView_3 = new TextView(getApplicationContext());
//        Button button_1 = new Button(getApplicationContext());
//        Button button_2 = new Button(getApplicationContext());
//
//        /*anado atributos a los componentes*/
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//        /*Defino tamanio de los Views que contendra*/
//        /* WRAP_CONTENT ->Usa solo lo que necesita de espacio / */
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        /*Defino los margenes de los Views*/
//        LinearLayout.LayoutParams params_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        params_2.setMargins(10,10,10,10);
//
//        /*seteo los Views*/
//        textView_1.setText("Texto 1");
//        textView_2.setText("Texto 2");
//        textView_2.setPadding(25,25,25,25);
//        textView_3.setText("Texto 3");
//        button_1.setText("Boton 1");
//        button_2.setText("Boton 1");
//
//        textView_1.setBackgroundColor(Color.GREEN);
//        textView_2.setBackgroundColor(Color.BLUE);
//        textView_3.setBackgroundColor(Color.BLACK);
//        button_1.setBackgroundColor(Color.YELLOW);
//        button_2.setBackgroundColor(Color.MAGENTA);
//
//        /*Anado los Views al ViewGroup*/
//        linearLayout.addView(textView_1, params);
//        linearLayout.addView(button_1, params);
//        linearLayout.addView(textView_2, params);
//
//        /*implemento el View al ViewGroup con otros params*/
//        linearLayout.addView(button_2, params_2);
//
//        linearLayout.addView(textView_3, params);
//
//        /*Anado el ViewGroup al contenedor*/
//        setContentView(linearLayout);/*Java infla la vista, es decir, se crea la vista */
        test();
    }

    /**
     * Metodo que lista los mensajes para ver en el log de android studio
     * estan ordenaos segun su prioridad
     */
    public void test(){
        Log.e("test","Error");
        Log.w("test","Advertencia");
        Log.i("test","Informar");
        Log.d("test","Depuracion");
        Log.v("test","Detalle");
    }
}
