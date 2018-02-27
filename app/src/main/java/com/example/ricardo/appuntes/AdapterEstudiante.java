package com.example.ricardo.appuntes;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ricardo on 19-02-18.
 */

public class AdapterEstudiante extends ArrayAdapter{

    private Activity context;
    private ArrayList<Estudiante> estudiantes;
    private int resource;

    //Constructor de ArrayAdapter
    public AdapterEstudiante(@NonNull Activity context, int resource, ArrayList<Estudiante> estudiantes) {
        //Todo lo que se necesite se debe cargar en el super
        super(context, resource, estudiantes);
        this.context = context;
        this.estudiantes = estudiantes;
        this.resource = resource;
    }

    //Funciones propias de BaseAdapter
    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public Object getItem(int position) {
        return estudiantes.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //Aca se lleva a cabo el manejo de la vista

        ViewHolder viewHolder = new ViewHolder();

        if (view== null) {//Carga por primera vez, por ende debe ir por la vista
            if (context != null) {
                //Debemos primero inflar la vista
                view = context.getLayoutInflater().inflate(resource, null);

                //TextView textView = (TextView) view.findViewById(R.id.txt_nombre);//sin viewHolder
                viewHolder.txtItem = (TextView) view.findViewById(R.id.txt_nombre);
                view.setTag(viewHolder);//Guardo el objeto
            }
        }else {//Ya se obtuvo antes la vista, por ende ahora no se buscan nuevcamente sino que se llama donde la guardamos
            viewHolder = (ViewHolder)view.getTag();
        }

        Estudiante estudiante = estudiantes.get(position);
        viewHolder.txtItem.setText(estudiante.getNombre());
        if (!estudiante.isAprobado()) {
            viewHolder.txtItem.setBackgroundColor(Color.RED);
        } else {
            viewHolder.txtItem.setBackgroundColor(Color.GREEN);
        }

        return view;
    }

    /***
     * Clase que nos ayudara a hacer el gerView mas rapido
     * mediante la mejora sobre el findViewById en la funcion
     */
    class ViewHolder{
        private TextView txtItem;
    }
}
