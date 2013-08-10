package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
public class ListaNotasFiscaisBean {
	private List<NotaFiscal> listaNotas;
	private LazyDataModel<NotaFiscal> dataModel;
	
	public List<NotaFiscal> listaNotas(){
		
		if(listaNotas == null){			
			DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
			listaNotas = dao.listaTodos();
		}
		return listaNotas;
	}
	
	public ListaNotasFiscaisBean() {
		this.dataModel = new DataModelNotasFiscais();
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		this.dataModel.setRowCount(dao.contaTodos());
	}
	
	

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public List<NotaFiscal> getListaNotas() {
		return listaNotas == null ? listaNotas : listaNotas;
	}

	public void setListaNotas(List<NotaFiscal> listaNotas) {
		this.listaNotas = listaNotas;
	}
	
	
}
