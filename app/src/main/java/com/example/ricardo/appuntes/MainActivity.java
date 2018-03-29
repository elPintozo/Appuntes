package com.example.ricardo.appuntes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.Rating;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {/*AppCompatActivity es quien nos ayuda a manipular la vista*/

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;

    private Button button_1;
    private Button button_2;

    private CheckBox checkBox;
    private RadioButton radio_btn;

    private Spinner spinner;

    private ProgressBar progressBar;
    private int progreso;

    private SeekBar seekBar_1;
    private SeekBar seekBar_2;

    private QuickContactBadge quickContactBadge_1;
    private QuickContactBadge quickContactBadge_2;

    private RatingBar ratingBar_1;
    private RatingBar ratingBar_2;

    private Switch aSwitch;

    private RadioGroup radioGroup;

    private ListView listView;
    private ArrayList<Estudiante> estudiantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {/*Metodo que se ejecuta al iniciar la aplicacion*/
        super.onCreate(savedInstanceState);

        /*******************************************************************************************/
        /************************************METODO ACTUAL******************************************/
        /*******************************************************************************************/

        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Oncreate", Toast.LENGTH_LONG).show();
        Log.e("test","Oncreate--Activity_1");
//Ejemplo de ListView
        listView = (ListView)findViewById(R.id.my_listview);
        estudiantes = Estudiante.listaEstudiantes();
        final AdapterEstudiante adapterEstudiante = new AdapterEstudiante(this, R.layout.item_adapter_estudiante, estudiantes);
        listView.setAdapter(adapterEstudiante);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Estudiante estudiante = adapterEstudiante.getItem(i);
                Log.e("ListView","Seleccion de ListView: "+ estudiante.getNombre());
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Estudiante estudiante = adapterEstudiante.getItem(i);
                Log.e("ListView","Presiono bastante tiempola opcion del ListView: "+ estudiante.getNombre());
                return false;
            }
        });

//Ejemplo de RadioGroup
//        radioGroup = (RadioGroup)findViewById(R.id.my_radio_group);
//        textView_1 = (TextView)findViewById(R.id.txt_radio);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                RadioButton radio_seleccionado = (RadioButton)findViewById(i);
//                textView_1.setText(radio_seleccionado.getText());
//            }
//        });
//
//        RadioButton radioButton_seleccionado = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
//        if(radioButton_seleccionado!=null) {
//            Log.e("RadioButton", "Se seleccionó: " + radioButton_seleccionado.getText());
//        }
//Ejemplo de uso de Switch
//        aSwitch = (Switch)findViewById(R.id.switch1);
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b){
//                    Log.e("aSwitch","Se ha cambiado de estado On");
//                }else {
//                    Log.e("aSwitch","Se ha cambiado de estado Off");
//                }
//            }
//        });
//Ejemplo de RatingBar
//        ratingBar_1 = (RatingBar)findViewById(R.id.ratingBar_1);
//        ratingBar_2 = (RatingBar)findViewById(R.id.ratingBar_2);
//
//        textView_1 = (TextView)findViewById(R.id.txt_ratio_1);
//        textView_2 = (TextView)findViewById(R.id.txt_ratio_2);
//
//        ratingBar_1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                textView_1.setText("Puntuación: "+v);
//            }
//        });
//        ratingBar_2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                textView_2.setText("Puntuación: "+v);
//            }
//        });
//Ejemplo de QuickContactBadge
//        quickContactBadge_1 = (QuickContactBadge)findViewById(R.id.quickContactBadge_email);
//        quickContactBadge_2 = (QuickContactBadge)findViewById(R.id.quickContactBadge_phone);
//
//        quickContactBadge_1.assignContactFromEmail("correo@correo.cl",true);
//        quickContactBadge_2.assignContactFromPhone("+56981275085", true);
//
//        Bundle bundle = new Bundle();
//        bundle.putString(ContactsContract.Intents.Insert.NAME, "Ricardo");
//        quickContactBadge_2.assignContactFromPhone("+56981275085", true, bundle);

//Ejemplo de SeekBar
//        seekBar_1 = (SeekBar)findViewById(R.id.seekBar_1);
//        seekBar_2 = (SeekBar)findViewById(R.id.seekBar_2);
//
//        seekBar_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                /**
//                 * Reaciona cuando el porcentaje de la barra cambia
//                 */
//                if(b){
//                    Log.e("seekBar_1", "Progreso: " + i);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                /**
//                 * Ha iniciado la selección de una cantidad
//                 */
//                Log.e("seekBar_1","Comenzo");
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                /**
//                 * Ha finalizado la seleccion de una cantidad
//                 */
//                Log.e("seekBar_1","Finalizo");
//            }
//        });
//        seekBar_2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                /**
//                 * Reaciona cuando el porcentaje de la barra cambia
//                 */
//                if(b){
//                    Log.e("seekBar_2", "Progreso: " + i);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                /**
//                 * Ha iniciado la selección de una cantidad
//                 */
//                Log.e("seekBar_2","Comenzo");
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                /**
//                 * Ha finalizado la seleccion de una cantidad
//                 */
//                Log.e("seekBar_2","Finalizo");
//            }
//        });
//Ejemplo de progressbar
//        progressBar = (ProgressBar)findViewById(R.id.my_progressBar);
//        button_1 = (Button)findViewById(R.id.btn_progressbar);
//        button_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("progressBar","Progreso: "+progreso+ " | progressbar: "+progressBar.getProgress());
//                progreso = progressBar.getProgress();
//                if (progreso<100){
//                    progreso = progreso +10;
//                    progressBar.setProgress(progreso);
//                    button_1.setText(progreso+" %");
//                }else {
//                    progreso=0;
//                    progressBar.setProgress(0);
//                    button_1.setText("Comenzar");
//                }
//            }
//        });

//Ejemplo de uso de spinner
        //metodo personalizado
//        AdapterEstudiante adapter = new AdapterEstudiante(this, R.layout.item_adapter_estudiante, Estudiante.listaEstudiantes());
//        //metodo tradicional
//        //ArrayAdapter<Estudiante> adapter = new ArrayAdapter<Estudiante>(this,R.layout.item_adapter_estudiante, R.id.txt_nombre,Estudiante.listaEstudiantes());
//        spinner = (Spinner)findViewById(R.id.my_spinner);
//        //cargo una ventana desplegable predeterminada para el adaprter personalizado
//        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //la liena de arriba se puede omitir si se maneja dentro de la clase del adaptador mediante la funcion getDropDownView
//        spinner.setAdapter(adapter);

//------Ejemplo de uso de CheckBox y RadioButtun
//        radio_btn = (RadioButton) findViewById(R.id.radio_btn);
//        checkBox = (CheckBox)findViewById(R.id.checkBox);
//
//        radio_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    Toast.makeText(getApplicationContext(), "RadioButton seleccionado", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "RadioButton no seleccionado", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    Toast.makeText(getApplicationContext(), "CheckBox seleccionado", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "CheckBox no seleccionado", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//------Ejemplo de solicitud de permiso
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)==0){
//            Log.e("Pemission","Hay permiso de usar la cámara");
//        }
//        else{
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
//            Log.e("Pemission","No hay permiso de usar la cámara");
//        }
//------Ejemplo de uso de activitys e Intent
//        button_1 = (Button)findViewById(R.id.btn_next_activity);
//        button_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //envio parametros  al siguiente activity
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra("var_int",23);
//                intent.putExtra("var_string","Mensaje de activity_1");
//                intent.putExtra("var_bool",true);
//                startActivity(intent);
//
//                Intent  intent = new Intent();
//                intent.setAction(intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT, "Un mensaje desde mi app Appuntes");
//                intent.setType("text/plain");
//                startActivity(Intent.createChooser(intent, "Envíar el mensaje a"));
//            }
//        });

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
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_LONG).show();
        Log.e("test","onStart-Activity_1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();
        Log.e("test","onResume-Activity_1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
        Log.e("test","onPause-Activity_1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_LONG).show();
        Log.e("test","onStop-Activity_1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
        Log.e("test","onDestroy-Activity_1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_LONG).show();
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

    /**
     * Función que me permite solicitar los permisos al usuario en caso de no contar con ellos
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
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
    public void mensaje(View view){
        Button btn = (Button)view;
        btn.setTextSize(25);
        Toast.makeText(getApplicationContext(), "Has presionado el boton", Toast.LENGTH_LONG).show();
    }
}
