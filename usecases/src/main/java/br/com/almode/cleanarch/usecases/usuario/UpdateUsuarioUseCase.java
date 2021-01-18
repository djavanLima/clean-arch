package br.com.almode.cleanarch.usecases.usuario;

import br.com.almode.cleanarch.models.Usuario;
import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import br.com.almode.cleanarch.usecases.usuario.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UpdateUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;

    public UsuarioPresenter update(UpdateUsuarioParams params, UUID idDoUsuario) {
        var usuarioBuscado = new Usuario(params.getNome(), params.getCpf());
        var usuario = this.usuarioPersistenceAdapter.update(usuarioBuscado, idDoUsuario);
        return new UsuarioPresenter(usuario);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @FieldDefaults(level = PRIVATE)
    public static class UpdateUsuarioParams {
        @NonNull
        String nome;

        @NonNull
        String cpf;
    }
}
