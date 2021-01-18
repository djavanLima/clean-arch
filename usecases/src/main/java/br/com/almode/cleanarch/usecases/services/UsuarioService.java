package br.com.almode.cleanarch.usecases.services;

import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.adapters.usuario.UsuarioPersistenceAdapter;
import br.com.almode.cleanarch.usecases.usuario.CreateUsuarioUseCase;
import br.com.almode.cleanarch.usecases.usuario.CreateUsuarioUseCase.CreateUsuarioParams;
import br.com.almode.cleanarch.usecases.usuario.DeleteUsuarioUseCase;
import br.com.almode.cleanarch.usecases.usuario.FindUsuarioUseCase;
import br.com.almode.cleanarch.usecases.usuario.UpdateUsuarioUseCase;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.UUID;

import static br.com.almode.cleanarch.usecases.usuario.UpdateUsuarioUseCase.*;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UsuarioService {
    CreateUsuarioUseCase createUsuarioUseCase;
    FindUsuarioUseCase findUsuarioUseCase;
    DeleteUsuarioUseCase deleteUsuarioUseCase;
    UpdateUsuarioUseCase updateUsuarioUseCase;


    public UsuarioService(UsuarioPersistenceAdapter usuarioPersistenceAdapter) {
        this.createUsuarioUseCase = new CreateUsuarioUseCase(usuarioPersistenceAdapter);
        this.findUsuarioUseCase = new FindUsuarioUseCase(usuarioPersistenceAdapter);
        this.deleteUsuarioUseCase = new DeleteUsuarioUseCase(usuarioPersistenceAdapter);
        this.updateUsuarioUseCase = new UpdateUsuarioUseCase(usuarioPersistenceAdapter);
    }

    public UsuarioPresenter create(CreateUsuarioParams params) {
        return this.createUsuarioUseCase.execute(params);
    }

    public UsuarioPresenter get(UUID idDoUsuario) {
        return this.findUsuarioUseCase
                .get(idDoUsuario);
    }

    public Page<UsuarioPresenter> find(Pageable pageable) {
        return this.findUsuarioUseCase
                .find(pageable);
    }

    public UsuarioPresenter delete(UUID idDoUsuario) {
        return this.deleteUsuarioUseCase
                .delete(idDoUsuario);
    }
    public UsuarioPresenter update(UpdateUsuarioParams params, UUID idDoUsuario) {
        return this.updateUsuarioUseCase
                .update(params, idDoUsuario);
    }
}

