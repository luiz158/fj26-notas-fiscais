package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
public class ListaNotasFiscaisBean {
	private List<NotaFiscal> listaNotas;
	
	public List<NotaFiscal> listaNotas(){
		
		if(listaNotas == null){			
			DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
			listaNotas = dao.listaTodos();
		}
		return listaNotas;
	}

	public List<NotaFiscal> getListaNotas() {
		return listaNotas == null ? listaNotas : listaNotas;
	}

	public void setListaNotas(List<NotaFiscal> listaNotas) {
		this.listaNotas = listaNotas;
	}
	
	
}
