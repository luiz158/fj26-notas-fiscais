package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;
@Named
@RequestScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	@Inject
	UsuarioDAO dao;
	
	@Inject
	UsuarioLogado usuarioLogado;
	
	public String efetuaLogin(){
		boolean existe = dao.existe(this.usuario);
		if(existe){
			usuarioLogado.setUsuario(usuario);
			return "produto";
		}else{
			usuarioLogado.setUsuario(null);
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isLogado(){
		return usuarioLogado.isLogado();
	}
	
	public String logout(){
		usuario = new Usuario();
		return "login?redirect=true";
	}
}
