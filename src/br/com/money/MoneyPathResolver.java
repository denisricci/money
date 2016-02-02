package br.com.money;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class MoneyPathResolver extends DefaultPathResolver {

	public MoneyPathResolver() {
		this(null);
	}

	@Inject
	public MoneyPathResolver(FormatResolver resolver) {
		super(resolver);
	}
	
	public String pathFor(ControllerMethod controllerMethod){		
		String htmlName = extractControllerFromName(controllerMethod.getController().getType().getSimpleName());
		return "../WEB-INF/html/" + htmlName + ".html";
	}

}
