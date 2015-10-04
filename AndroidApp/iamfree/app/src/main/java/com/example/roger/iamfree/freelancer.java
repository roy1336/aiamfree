package com.example.roger.iamfree;

import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class freelancer extends AppCompatActivity {
    ViewPager viewPager;
    String value;
    ArrayList<String> nombre =new ArrayList<>(Arrays.asList("Juan", "Jaime", "Miguel", "Pops"));
    ArrayList<String> ubicacion =new ArrayList<>(Arrays.asList("DF","Morelos","Veracruz","Queretaro"));
    ArrayList<String> profesion =new ArrayList<>(Arrays.asList("Diseñador","Carpintero","Fotografo","Diseñador"));
    ArrayList<String> competencias =new ArrayList<>(Arrays.asList("Corel Draw, Photoshop","Madera blanda, dura","Bodas, Arquitectura","Web y apps"));
    ArrayList<String> facebook =new ArrayList<>(Arrays.asList("www.facebook.com/Juan","www.facebook.com/Jaime","www.facebook.com/Miguel","www.facebook.com/Pops"));
    ArrayList<String> twitter =new ArrayList<>(Arrays.asList("www.twitter.com/Juan","www.twitter.com/Jaime","www.twitter.com/Miguel","www.twitter.com/Pops"));
    ArrayList<String> nombre_proyecto =new ArrayList<>(Arrays.asList("Web Responsiva","Mueble de Roble","Minimalista","Logo empresa"));
    ArrayList<String> descripcion =new ArrayList<>(Arrays.asList("Utiliza bootstrap y crea un REST","Lijada avanzada","Paisaje mexicano","Imagen para empresa multinacional"));
    ArrayList<String> link =new ArrayList<>(Arrays.asList("Juan","Jaime","Miguel","Pops"));
    ArrayList<String> idiomas =new ArrayList<>(Arrays.asList("Ingles","Español","Coreano","Ingls"));
    ArrayList<String> celular =new ArrayList<>(Arrays.asList("5523838282","5367283833","53738292939","5382927373"));
    ArrayList<String> correo =new ArrayList<>(Arrays.asList("Juan@gmail.com","Jaime@hotmail.com","Miguel@yahoo.com.mx","Pops@live.com"));
    int id_free;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelancer);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomPagerAdapter(freelancer.this);
        viewPager.setAdapter(adapter);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            value=extras.getString("id");
        }
        Log.d("bundle","bun "+value);
        for(int i=0;i<descripcion.size();i++){
            if(value==nombre.get(i)){
                id_free=i;
            }
        }
        TextView texto1 = (TextView) findViewById(R.id.nombre);
        TextView texto2 = (TextView) findViewById(R.id.ubicacion);
        TextView texto3 = (TextView) findViewById(R.id.profesion);
        TextView texto4 = (TextView) findViewById(R.id.competencias);
        TextView texto5 = (TextView) findViewById(R.id.facebook);
        TextView texto6 = (TextView) findViewById(R.id.twitter);
        TextView texto7 = (TextView) findViewById(R.id.nombre_proyecto1);
        TextView texto8 = (TextView) findViewById(R.id.descripcion_proyecto1);
        TextView texto9 = (TextView) findViewById(R.id.link_proyecto1);
        TextView texto10 = (TextView) findViewById(R.id.idiomas);
        TextView texto11 = (TextView) findViewById(R.id.celular);
        TextView texto12 = (TextView) findViewById(R.id.correo);
        texto1.setText(nombre.get(id_free));
        texto2.setText(ubicacion.get(id_free));
        texto3.setText(profesion.get(id_free));
        texto4.setText(competencias.get(id_free));
        texto5.setText(facebook.get(id_free));
        texto6.setText(twitter.get(id_free));
        texto7.setText(nombre_proyecto.get(id_free));
        texto8.setText(descripcion.get(id_free));
        texto9.setText(link.get(id_free));
        texto10.setText(idiomas.get(id_free));
        texto11.setText(celular.get(id_free));
        texto12.setText(correo.get(id_free));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
