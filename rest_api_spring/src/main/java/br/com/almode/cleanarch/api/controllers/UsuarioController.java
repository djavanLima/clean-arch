package br.com.almode.cleanarch.api.controllers;

import br.com.almode.cleanarch.api.resources.UsuarioResource;
import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.services.UsuarioService;
import br.com.almode.cleanarch.usecases.usuario.CreateUsuarioUseCase.CreateUsuarioParams;
import br.com.almode.cleanarch.usecases.usuario.UpdateUsuarioUseCase;
import br.com.almode.cleanarch.usecases.usuario.UpdateUsuarioUseCase.UpdateUsuarioParams;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class UsuarioController implements UsuarioResource {
    UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioPresenter> create(@Valid CreateUsuarioParams params) {
        var usuario = this.usuarioService.create(params);
        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<UsuarioPresenter> get(String id) {
        var usuario = this.usuarioService.get(UUID.fromString(id));
        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<Page<UsuarioPresenter>> find(Pageable page) {
        var usuarios = this.usuarioService
                .find(page);
        return ResponseEntity.ok(usuarios);
    }

    @Override
    public ResponseEntity<UsuarioPresenter> delete(String id) {
        var usuario = this.usuarioService.delete(UUID.fromString(id));
        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<UsuarioPresenter> update(@Valid UpdateUsuarioParams params, String id) {
        var usuario = this.usuarioService.update(params, UUID.fromString(id));
        return ResponseEntity.ok(usuario);
    }

}
