package com.cristianomoraes.libri_retorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroLivro extends AppCompatActivity {

    RouterInterface routerInterface;
    EditText txtTitulo;
    EditText txtDescricao;
    EditText txtFoto;
    Button btnInserirLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtFoto);
        txtFoto = findViewById(R.id.txtFoto);
        btnInserirLivro = findViewById(R.id.btnCadastrarLivro);

        /** configuração do RouterInterface **/
        routerInterface = APIUtil.getUsuarioInterface();

        btnInserirLivro.setOnClickListener(view -> {
            /* criando objeto de Livro */
            Livro livro = new Livro();
            livro.setTitulo(txtTitulo.getText().toString());
            livro.setDescricao(txtDescricao.getText().toString());
            livro.setImagem(txtFoto.getText().toString());
            livro.setTblUsuarioCodUsuario(1);

            /** chamada do método de inserção de Livro **/
            addLivro(livro);
        });
    }


    /** método ~addLivro~ da RouterInterface **/
    public void addLivro(Livro livro) {
        Call<Livro> call = routerInterface.addLivro(livro);

        /* executar a chamada da rota */
        call.enqueue(new Callback<Livro>() {
            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                txtTitulo.setText("");
                txtDescricao.setText("");
                txtFoto.setText("");

                Toast.makeText(CadastroLivro.this,
                        "LIVRO CADASTRADO COM SUCESSO",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Livro> call, Throwable t) {
                Log.d("ERRO-API", t.getMessage());
            }
        });
    }
}