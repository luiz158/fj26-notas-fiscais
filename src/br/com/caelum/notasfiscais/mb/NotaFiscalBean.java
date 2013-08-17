package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@SessionScoped
public class NotaFiscalBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;
	
	public void gravar(){
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
	}
	
	public NotaFiscal getNotaFiscal(){
		return notaFiscal;
	}
	
	public void guardaItem(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		Produto produto = dao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		item = new Item();
		idProduto = null;
	}
	
	public Long getIdProduto(){
		return idProduto;
	}
	
	public void setIdProduto(Long id){
		this.idProduto = id;
	}
	
	public Item getItem(){
		return item;
	}
}
