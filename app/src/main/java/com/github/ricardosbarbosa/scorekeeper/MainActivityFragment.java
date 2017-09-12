package com.github.ricardosbarbosa.scorekeeper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Integer golsLeft = 0;
    private Integer amarelosLeft = 0;
    private Integer vermelhosLeft = 0;
    private Integer faltasLeft = 0;
    private Integer escanteiosLeft = 0;
    private Integer golsRight = 0;
    private Integer amarelosRight = 0;
    private Integer vermelhosRight = 0;
    private Integer faltasRight = 0;
    private Integer escanteiosRight = 0;


    private TextView textViewLeftGols;
    private TextView textViewLeftCartoesAmarelos;
    private TextView textViewLeftEscanteios;
    private TextView textViewLeftFaltas;
    private TextView textViewLeftCartoesVermelhos;
    private TextView textViewRightGols;
    private TextView textViewRightCartoesAmarelos;
    private TextView textViewRightEscanteios;
    private TextView textViewRightFaltas;
    private TextView textViewRightCartoesVermelhos;

    private Button buttonLeftGols;
    private Button buttonLeftCartoesAmarelos;
    private Button buttonLeftEscanteios;
    private Button buttonLeftFaltas;
    private Button buttonLeftCartoesVermelhos;
    private Button buttonRightGols;
    private Button buttonRightCartoesAmarelos;
    private Button buttonRightEscanteios;
    private Button buttonRightFaltas;
    private Button buttonRightCartoesVermelhos;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //lefts
        textViewLeftGols = rootView.findViewById(R.id.textViewLeftGols);
        textViewLeftCartoesAmarelos = rootView.findViewById(R.id.textViewLeftCartoesAmarelos);
        textViewLeftEscanteios = rootView.findViewById(R.id.textViewLeftEscanteios);
        textViewLeftFaltas = rootView.findViewById(R.id.textViewLeftFaltas);
        textViewLeftCartoesVermelhos = rootView.findViewById(R.id.textViewLeftCartoesVermelhos);

        //right
        textViewRightGols = rootView.findViewById(R.id.textViewRightGols);
        textViewRightCartoesAmarelos = rootView.findViewById(R.id.textViewRightCartoesAmarelos);
        textViewRightEscanteios = rootView.findViewById(R.id.textViewRightEscanteios);
        textViewRightFaltas = rootView.findViewById(R.id.textViewRightFaltas);
        textViewRightCartoesVermelhos = rootView.findViewById(R.id.textViewRightCartoesVermelhos);

        //buttons
        buttonLeftGols = rootView.findViewById(R.id.buttonLeftGols);
        buttonLeftCartoesAmarelos = rootView.findViewById(R.id.buttonLeftCartoesAmarelos);
        buttonLeftEscanteios = rootView.findViewById(R.id.buttonLeftEscanteios);
        buttonLeftFaltas = rootView.findViewById(R.id.buttonLeftFaltas);
        buttonLeftCartoesVermelhos = rootView.findViewById(R.id.buttonLeftCartoesVermelhos);
        buttonRightGols = rootView.findViewById(R.id.buttonRightGols);
        buttonRightCartoesAmarelos = rootView.findViewById(R.id.buttonRightCartoesAmarelos);
        buttonRightEscanteios = rootView.findViewById(R.id.buttonRightEscanteios);
        buttonRightFaltas = rootView.findViewById(R.id.buttonRightFaltas);
        buttonRightCartoesVermelhos = rootView.findViewById(R.id.buttonRightCartoesVermelhos);

        buttonLeftGols.setOnClickListener(this);
        buttonLeftCartoesAmarelos.setOnClickListener(this);
        buttonLeftEscanteios.setOnClickListener(this);
        buttonLeftFaltas.setOnClickListener(this);
        buttonLeftCartoesVermelhos.setOnClickListener(this);
        buttonRightGols.setOnClickListener(this);
        buttonRightCartoesAmarelos.setOnClickListener(this);
        buttonRightEscanteios.setOnClickListener(this);
        buttonRightFaltas.setOnClickListener(this);
        buttonRightCartoesVermelhos.setOnClickListener(this);

        if (savedInstanceState != null) {
            golsLeft = savedInstanceState.getInt(getString(R.string.golsLeft));
            amarelosLeft = savedInstanceState.getInt(getString(R.string.golsLeft));
            vermelhosLeft = savedInstanceState.getInt(getString(R.string.amarelosLeft));
            faltasLeft = savedInstanceState.getInt(getString(R.string.vermelhosLeft));
            escanteiosLeft = savedInstanceState.getInt(getString(R.string.faltasLeft));
            golsRight = savedInstanceState.getInt(getString(R.string.escanteiosLeft));
            amarelosRight = savedInstanceState.getInt(getString(R.string.golsRight));
            vermelhosRight = savedInstanceState.getInt(getString(R.string.amarelosRight));
            faltasRight = savedInstanceState.getInt(getString(R.string.vermelhosRight));
            escanteiosRight = savedInstanceState.getInt(getString(R.string.faltasRight));
        }

        updateUI();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getString(R.string.golsLeft), golsLeft);
        outState.putInt(getString(R.string.amarelosLeft), amarelosLeft);
        outState.putInt(getString(R.string.vermelhosLeft), vermelhosLeft);
        outState.putInt(getString(R.string.faltasLeft), faltasLeft);
        outState.putInt(getString(R.string.escanteiosLeft), escanteiosLeft);
        outState.putInt(getString(R.string.golsRight), golsRight);
        outState.putInt(getString(R.string.amarelosRight), amarelosRight);
        outState.putInt(getString(R.string.vermelhosRight), vermelhosRight);
        outState.putInt(getString(R.string.faltasRight), faltasRight);
        outState.putInt(getString(R.string.escanteiosRight), escanteiosRight);
    }

    private void updateUI() {
        textViewLeftGols.setText(golsLeft.toString());
        textViewLeftCartoesAmarelos.setText(amarelosLeft.toString());
        textViewLeftEscanteios.setText(escanteiosLeft.toString());
        textViewLeftFaltas.setText(faltasLeft.toString());
        textViewLeftCartoesVermelhos.setText(vermelhosLeft.toString());

        textViewRightGols.setText(golsRight.toString());
        textViewRightCartoesAmarelos.setText(amarelosRight.toString());
        textViewRightEscanteios.setText(escanteiosRight.toString());
        textViewRightFaltas.setText(faltasRight.toString());
        textViewRightCartoesVermelhos.setText(vermelhosRight.toString());
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
        golsLeft = 0;
        amarelosLeft = 0;
        vermelhosLeft = 0;
        faltasLeft = 0;
        escanteiosLeft = 0;
        golsRight = 0;
        amarelosRight = 0;
        vermelhosRight = 0;
        faltasRight = 0;
        escanteiosRight = 0;
        updateUI();
    }

    @Override
    public void onClick(View view) {
        if (buttonLeftGols.equals(view))
            golsLeft++;
        if (buttonLeftCartoesAmarelos.equals(view))
            amarelosLeft++;
        if (buttonLeftEscanteios.equals(view))
            escanteiosLeft++;
        if (buttonLeftFaltas.equals(view))
            faltasLeft++;
        if (buttonLeftCartoesVermelhos.equals(view))
            vermelhosLeft++;
        if (buttonRightGols.equals(view))
            golsRight++;
        if (buttonRightCartoesAmarelos.equals(view))
            amarelosRight++;
        if (buttonRightEscanteios.equals(view))
            escanteiosRight++;
        if (buttonRightFaltas.equals(view))
            faltasRight++;
        if (buttonRightCartoesVermelhos.equals(view))
            vermelhosRight++;

        updateUI();
    }
}
