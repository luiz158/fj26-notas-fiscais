package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;

	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		if(produto.getId() == null){			
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		this.produtos = dao.listaTodos();
		this.produto = new Produto();
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("Carregando produtos...");
			produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
