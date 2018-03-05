package com.example.ricardo.appuntes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.Rating;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Oncreate", Toast.LENGTH_LONG);
        Log.e("test","Oncreate--Activity_1");

//------Ejemplo de solicitud de permiso
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)==0){
            Log.e("Pemission","Hay permiso de usar la cámara");
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
            Log.e("Pemission","No hay permiso de usar la cámara");
        }
//------Ejemplo de uso de activitys e Intent
        button_1 = (Button)findViewById(R.id.btn_next_activity);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //envio parametros  al siguiente activity
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra("var_int",23);
//                intent.putExtra("var_string","Mensaje de activity_1");
//                intent.putExtra("var_bool",true);
//                startActivity(intent);

                Intent  intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Un mensaje desde mi app Appuntes");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Envíar el mensaje a"));
            }
        });

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

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_LONG);
        Log.e("test","onStart-Activity_1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG);
        Log.e("test","onResume-Activity_1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG);
        Log.e("test","onPause-Activity_1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_LONG);
        Log.e("test","onStop-Activity_1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG);
        Log.e("test","onDestroy-Activity_1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_LONG);
        Log.e("test","onRestart-Activity_1");
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

    /**
     * Función que de la mano con onRestoreInstanceState, nos ayudan a rescatar los datos
     * al momento de cambiar la orientacaión del dispositivo.
     *
     * Envía información a onRestoreInstanceState
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("var_1", "Una variable");
    }

    /**
     * Función que de la mano con onSaveInstanceState, nos ayudan a rescatar los datos
     * al momento de cambiar la orientacaión del dispositivo. Esta funcion se ejecuta despues de
     * onStart
     *
     * Recibe la información de onSaveInstanceState
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Orientation",savedInstanceState.getString("var_1","-"));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Log.e("Pemission","Hay permiso de usar la cámara");
                }
                else{
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
                    Log.e("Pemission","No hay permiso de usar la cámara");
                }
        }
    }
}
