package edu.temple.secondfragmentapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements NavFragment.OnFragmentInteractionListener{

    private boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = !(findViewById(R.id.fragment_details) == null);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_nav, new NavFragment(twoPanes));
        fragmentTransaction.commit();



        if (twoPanes){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_details, new DetailsFragment());
            fragmentTransaction.commit();
        }




    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        doTransition();
    }

    private void doTransition(){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_nav, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
