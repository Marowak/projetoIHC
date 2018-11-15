package rodrigo.minhasreceitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CategoriaListActivity extends AppCompatActivity {

    private LinearLayout mSobremesa;
    private LinearLayout mMexicana;
    private FloatingActionButton mfab;
    private ImageView mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mSobremesa = (LinearLayout) findViewById(R.id.sobremesa);
        mMexicana = (LinearLayout) findViewById(R.id.mexicana);
        mfab = (FloatingActionButton) findViewById(R.id.fab);
        mConfig = (ImageView) findViewById(R.id.config);

        mSobremesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ReceitaListActivity.class);
                startActivity(intent);
            }
        });

        mMexicana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ReceitaVaziaActivity.class);
                startActivity(intent);
            }
        });

        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NovaCategoriaActivity.class);
                startActivity(intent);
            }
        });

        mConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ConfiguracoesActivity.class);
                startActivity(intent);
            }
        });
    }

}
