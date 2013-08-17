package br.com.caelum.notasfiscais.validator;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;
@FacesValidator("nomeedescricao")
public class ValidadorNomeEDescricao implements Serializable, Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	@InputField
	private String nome;
	@Inject
	@InputField
	private String descricao;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		if(nome != null && descricao != null && nome.equals(descricao)){
			throw new ValidatorException(new FacesMessage("nome e descricao nao podem ser iguais"))
			;
		}

	}

}
