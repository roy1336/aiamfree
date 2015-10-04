package com.example.roger.iamfree;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Arrays;

public class activity_list extends AppCompatActivity {

    String value;
    ArrayList<String> nombre =new ArrayList<>(Arrays.asList("Juan","Jaime","Miguel","Pops"));
    ArrayList<String> ubicacion =new ArrayList<>(Arrays.asList("DF","Morelos","Veracruz","Queretaro"));
    ArrayList<String> profesion =new ArrayList<>(Arrays.asList("Diseñador","Carpintero","Fotografo","Diseñador"));
    ArrayList<String> competencias =new ArrayList<>(Arrays.asList("Corel Draw, Photoshop","Madera blanda, dura","Bodas, Arquitectura","Web y apps"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            value=extras.getString("palabra");
        }
        Log.d("bundle", "bun " + value);
        Fresco.initialize(this);
        inflater();
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

    public void abrirPerfil(View view){
        //Log.d("Prueba:", "Si es clickable!");
        TextView texto1 = (TextView) findViewById(R.id.textView);
        String input = texto1.getText().toString();
        Intent intent = new Intent(this, freelancer.class);
        intent.putExtra("id",input);
        startActivity(intent);
        //Log.d("Prueba:", input);
        //AQUI AGREGA EL INTENT PARA LA NUEVA ACTIVIDAD

    }

    public void inflater(){
        for(int i = 0; i<nombre.size()-1; i++) {
            LinearLayout ly = (LinearLayout) findViewById(R.id.mylinear);

            View custom =  LayoutInflater.from(this).inflate(R.layout.custom, null);
            TextView texto1 = (TextView) custom.findViewById(R.id.textView);
            TextView texto2 = (TextView) custom.findViewById(R.id.textView2);
            TextView texto3 = (TextView) custom.findViewById(R.id.textView3);
            TextView texto4 = (TextView) custom.findViewById(R.id.textView4);
            texto1.setText(nombre.get(i));
            texto2.setText(ubicacion.get(i));
            texto3.setText(profesion.get(i));
            texto4.setText(competencias.get(i));
            ly.addView(custom);
            Uri imageUri = Uri.parse("http://desmena.com/wp-content/uploads/2009/06/arquitectonica_the_gate_01.jpg");
            SimpleDraweeView draweeView = (SimpleDraweeView) custom.findViewById(R.id.sdvImage);
            draweeView.setImageURI(imageUri);

        }
    }
}
