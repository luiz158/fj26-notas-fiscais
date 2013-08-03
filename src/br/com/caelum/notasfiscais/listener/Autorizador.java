package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		FacesContext context = arg0.getFacesContext();
		if("/login.xhtml".equals(context.getViewRoot().getViewId())){
			return;
		}
		
		LoginBean login = context.getApplication().evaluateExpressionGet(
				context, "#{loginBean}", LoginBean.class);

		if (!login.isLogado()) {
			NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
			navigationHandler.handleNavigation(context, null, "login?faces-redirect=true");
		}
		
		context.renderResponse();
	
	}
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Antes da Phase: "+arg0.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
