package it.octavianionel.intentserviceretrofitexample.activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.octavianionel.intentserviceretrofitexample.utils.Constants;
import it.octavianionel.intentserviceretrofitexample.R;
import it.octavianionel.intentserviceretrofitexample.fragments.CategoriesFragment;
import it.octavianionel.intentserviceretrofitexample.fragments.GeneralFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Fragment selectedFragment;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        fm = getSupportFragmentManager();
        addFragment(Constants.FragmentType.CATEGORIES, "");
    }


    public void addFragment(Constants.FragmentType fragType, String fragmentParameter1) {

        GeneralFragment genFrag;
        switch (fragType) {
            case CATEGORIES:
                genFrag = CategoriesFragment.newInstance();
                break;
            default:
                genFrag = CategoriesFragment.newInstance();
                break;
        }
        FragmentTransaction ft = fm.beginTransaction();
        if (fragType == Constants.FragmentType.CATEGORIES) {
            ft.add(R.id.fragmContainer, genFrag)
                    .commit();
            selectedFragment = genFrag;

        } else {
            ft.replace(R.id.fragmContainer, genFrag).
                    addToBackStack(selectedFragment.getTag()).
                    commit();
        }

    }
}
