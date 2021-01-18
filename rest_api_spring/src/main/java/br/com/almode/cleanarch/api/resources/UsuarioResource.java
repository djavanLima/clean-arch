package br.com.almode.cleanarch.api.resources;

import br.com.almode.cleanarch.models.presenters.UsuarioPresenter;
import br.com.almode.cleanarch.usecases.usuario.CreateUsuarioUseCase.CreateUsuarioParams;
import br.com.almode.cleanarch.usecases.usuario.UpdateUsuarioUseCase.UpdateUsuarioParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public interface UsuarioResource {
    @PostMapping
    ResponseEntity<UsuarioPresenter> create(@RequestBody @Valid CreateUsuarioParams params);

    @GetMapping("/{id}")
    ResponseEntity<UsuarioPresenter> get(@PathVariable String id);

    @GetMapping
    ResponseEntity<Page<UsuarioPresenter>> find(@PageableDefault Pageable page);

    @DeleteMapping("/{id}")
    ResponseEntity<UsuarioPresenter> delete(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<UsuarioPresenter> update(@RequestBody @Valid UpdateUsuarioParams params, @PathVariable String id);

}
