package com.domain.milene.imc;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private EditText editPeso;
    private EditText editAltura;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso =  findViewById(R.id.editPeso);
        editAltura =  findViewById(R.id.editAltura);
        btnOk =  findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.calcularImc();
    }

    public void calcularImc() {

        try {
            float peso = Float.parseFloat(editPeso.getText().toString());
            float altura = Float.parseFloat(editAltura.getText().toString());
            float imc = peso / (altura * altura);
            String resultado = situacaoIMC(imc);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Vamos ver se vc esta gordo... ");
            alertDialog.setMessage(resultado);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }catch (Exception ex){

        }
    }

    public String situacaoIMC(float imc){

        String situacao;

        if(imc < 17){
            situacao = "Peso bolha de sabão ipê";
        }else if(imc >= 17 && imc < 18.49){
            situacao = "Na capa da costela";
        }else if(imc > 18.49 && imc <= 24.99){
            situacao = "Tá normal.. Igual minha vida";
        }else if(imc > 24.99 && imc <= 29.99){
            situacao = "Tá gordinho... Ja da pra rolar no morro";
        }else if (imc > 29.99 && imc <= 34.99){
            situacao = "Modo xupeta de baleia ativado";
        }else if (imc > 34.99 && imc <= 39.99){
            situacao = "Pior que o professor aloprado";
        }else{
            situacao = "Acho que vc tem mais um ano de vida";
        }
        return  situacao;
    }
}
