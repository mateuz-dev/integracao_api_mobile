package com.cristianomoraes.libri_retorfit.remote;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {

    /** rotas USUÁRIO **/
    /* INSERIR */
    @POST("/usuario/cadastrarUsuario")
    Call<Usuario> addUsuario(@Body Usuario usuario);



    /** rotas USUÁRIO  **/
    /* INSERIR */
    @POST("/livro/cadastrarLivro")
    Call<Livro> addLivro(@Body Livro livro);

    /* LISTAR */
    @GET("/livro/listarLivro")
    Call<List<Livro>> getLivros();

}
