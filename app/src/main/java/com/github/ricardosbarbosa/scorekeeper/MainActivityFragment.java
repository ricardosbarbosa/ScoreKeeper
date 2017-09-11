package com.github.ricardosbarbosa.scorekeeper;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Integer scoreLeft = 0;
    private Integer scoreRight = 0;
    private TextView textViewLeft;
    private TextView textViewRight;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        textViewLeft = rootView.findViewById(R.id.textViewLeft);
        textViewRight = rootView.findViewById(R.id.textViewRight);

        FloatingActionButton fabLeft = rootView.findViewById(R.id.fab_left);
        FloatingActionButton fabRight = rootView.findViewById(R.id.fab_right);

        fabLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreLeft++;
                updateUI();
            }
        });

        fabRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreRight++;
                updateUI();
            }
        });

        if (savedInstanceState != null) {
            scoreLeft = savedInstanceState.getInt(getString(R.string.score_left_key));
            scoreRight = savedInstanceState.getInt(getString(R.string.score_left_right));
        }

        updateUI();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getString(R.string.score_left_key), scoreLeft);
        outState.putInt(getString(R.string.score_left_right), scoreRight);
    }

    private void updateUI() {
        textViewLeft.setText(scoreLeft.toString());
        textViewRight.setText(scoreRight.toString());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_main, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            reset();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void reset() {
        scoreLeft = 0;
        scoreRight = 0;
        updateUI();
    }

}
