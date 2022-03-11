package com.pifinal.alucar.service;

import com.pifinal.alucar.model.Usuario;
import com.pifinal.alucar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario u) {
        return usuarioRepository.save(u);
    }

    public List<Usuario> buscarTodos() {return usuarioRepository.findAll();}

    public Optional<Usuario> buscar (Integer id) {return usuarioRepository.findById(id);}

    public void excluir(Integer id) {usuarioRepository.deleteById(id);}

    public Usuario atualizar (Usuario usuario) {return usuarioRepository.save(usuario);}
}
