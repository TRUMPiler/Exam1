package com.example.exam1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater inflates=getMenuInflater();

        if(menu instanceof MenuBuilder)
        {
            MenuBuilder mb=(MenuBuilder) menu;
            mb.setOptionalIconsVisible(true);
        }
        inflates.inflate(R.menu.main_menu,menu);
         return true;
    }
    String City;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        UserFragment uf=(UserFragment) getSupportFragmentManager().findFragmentById(R.id.userFrag);

        if(R.id.register==item.getItemId())
        {
            AlertDialog.Builder build=new AlertDialog.Builder(this);
            build.setTitle("User Registeration");

            build.setCancelable(false);
            View v= getLayoutInflater().inflate(R.layout.registerform,null);
            build.setView(v);
            build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    TextView Name=v.findViewById(R.id.txtname);
                    TextView contactno=v.findViewById(R.id.contactno);
                    RadioButton rbmale,rbfemale;
                    rbmale=v.findViewById(R.id.rtrMale);
                    rbfemale=v.findViewById(R.id.rtrFemale);

                    CheckBox ele,cloth,acc;
                    ele=v.findViewById(R.id.cbele);
                    cloth=v.findViewById(R.id.cbCloth);
                    acc=v.findViewById(R.id.cbAcce);
                    String Names,ContactNo,Gender="";
                    Names=Name.getText().toString();
                    ContactNo=contactno.getText().toString();
                    if(rbmale.isChecked())
                    {
                        Gender="Male";
                    }
                    else if(rbfemale.isChecked())
                    {
                        Gender="Female";
                    }
                    Spinner city = v.findViewById(R.id.City);
                    City=city.getSelectedItem().toString();


                    String Choices="";
                    if(ele.isChecked())
                    {
                        Choices=Choices+"Electronics\n";
                    }
                    if(cloth.isChecked())
                    {
                        Choices=Choices+"Clothes\n";
                    }
                    if(acc.isChecked())
                    {
                        Choices=Choices+"Accessories\n";
                    }


                    // Call the displayGG method on UserFragment
                    if (uf != null) {
                        uf.displayGG(Names, City, ContactNo, Choices, Gender);
                }

                }


            });


            AlertDialog at= build.create();
            at.show();
        }
        return true;

    }
}