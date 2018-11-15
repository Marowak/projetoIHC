package rodrigo.minhasreceitas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ConfiguracoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        Button buttonLogout = (Button) findViewById(R.id.btnLogOut);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        Button buttonChangePass = (Button) findViewById(R.id.btnTrocarSenha);
        buttonChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = getBaseContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setCancelable(true);
                builder.setTitle("Change Password");
                final EditText oldPass = new EditText(ctx);
                final EditText newPass = new EditText(ctx);
                final EditText confirmPass = new EditText(ctx);

                oldPass.setHint("Old Password");
                newPass.setHint("New Password");
                confirmPass.setHint("Confirm New Password");

                oldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                newPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                confirmPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                LinearLayout ll = new LinearLayout(ctx);
                ll.setOrientation(LinearLayout.VERTICAL);

                ll.addView(oldPass);

                ll.addView(newPass);
                ll.addView(confirmPass);
                builder.setView(ll);
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
