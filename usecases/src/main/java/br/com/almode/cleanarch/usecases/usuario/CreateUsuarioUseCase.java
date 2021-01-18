package br.com.almode.cleanarch.usecases.usuario;

import br.com.almode.cleanarch.models.Usuario;
import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CreateUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter execute(CreateUsuarioParams createUsuarioParams) {
        var usuario = new Usuario(createUsuarioParams.getNome(), createUsuarioParams.getCpf());
        var usuarioCriado = this.usuarioPersistenceAdapter.create(usuario);
        return new UsuarioPresenter(usuarioCriado);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @FieldDefaults(level = PRIVATE)
    public static class CreateUsuarioParams {
        @NonNull
        String nome;

        @NonNull
        String cpf;
     }

}
