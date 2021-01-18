package br.com.almode.cleanarch.usecases.usuario;

import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DeleteUsuarioUseCase {
    UsuarioPersistenceAdapter usuarioPersistenceAdapter;
    
    public UsuarioPresenter delete(UUID idDoUsuario) {
        var usuario = this.usuarioPersistenceAdapter.delete(idDoUsuario);
        return new UsuarioPresenter(usuario);
    }
}
