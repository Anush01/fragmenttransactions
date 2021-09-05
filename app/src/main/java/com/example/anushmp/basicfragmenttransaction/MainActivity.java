package com.example.anushmp.basicfragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button adda;//addA
    private Button removea;//removea
    private Button addb;//addb
    private Button removeb;//removeb
    private Button replacewithoutbackstac;//replaceawithbwithoutbackstack
    private Button replacewithback;//replaceawithbwithbackstack
    private Button replacebwitha;//replacebwitha

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adda = findViewById(R.id.btnAddA);
        removea = findViewById(R.id.btnRemoveA);
        addb = findViewById(R.id.btnAddB);
        removeb = findViewById(R.id.btnRemoveB);
        replacewithoutbackstac = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        replacewithback = findViewById(R.id.btnReplaceAWithBackStack);
        replacebwitha = findViewById(R.id.btnReplaceBWithA);

        fm = getSupportFragmentManager();

       // FragmentTransaction ft2 = fm.beginTransaction();
       // ft2.replace()


        adda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addafunc();
            }
        });
        removea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeafunc();
            }
        });
        addb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbfunc();
            }
        });
        removeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removebfunc();
            }
        });
        replacewithoutbackstac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacewithoutbackstacfunc();
            }
        });
        replacewithback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacewithbackfunc();
            }
        });
        replacebwitha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacebwithafunc();
            }
        });





    }

    private void addbfunc() {

        FragmentTransaction ft = fm.beginTransaction();

        FragmentB fragmentB = new FragmentB();

        ft.add(R.id.flContainer,fragmentB,"fragmentB").commit();

    }

    private void removebfunc() {

        FragmentTransaction ft = fm.beginTransaction();

        FragmentB fb = (FragmentB) fm.findFragmentByTag("fragmentB");

        if(fb !=null){

            ft.remove(fb).commit();
        }



    }

    private void replacewithoutbackstacfunc() {

        FragmentTransaction ft = fm.beginTransaction();

        FragmentB fragmentB = new FragmentB();

        ft.replace(R.id.flContainer,fragmentB,"fragmentB").commit();

    }

    private void replacewithbackfunc() {

        FragmentTransaction ft = fm.beginTransaction();

        FragmentB fragmentB = new FragmentB();

        ft.replace(R.id.flContainer,fragmentB,"fragmentB").addToBackStack("fragmentA").commit();


    }

    private void replacebwithafunc() {

        FragmentA fragA = new FragmentA();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.flContainer,fragA,"fragA").commit();

    }

    private void removeafunc() {

        FragmentA fragA = (FragmentA) fm.findFragmentByTag("fragmentA");

        if(fragA !=null){

            FragmentTransaction ft = fm.beginTransaction();

            ft.remove(fragA).commit();

        }


    }

    private void addafunc() {

        FragmentTransaction ft = fm.beginTransaction();

        FragmentA fragmentA = new FragmentA();

        ft.add(R.id.flContainer,fragmentA,"fragmentA").commit();


    }


}