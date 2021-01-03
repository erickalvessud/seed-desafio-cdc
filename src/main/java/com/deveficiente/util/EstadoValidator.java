package com.deveficiente.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.controller.dto.PagamentoRequest;
import com.deveficiente.jpa.repository.EstadoRepository;

@Component
public class EstadoValidator implements Validator {
	
	private EstadoRepository estadoRepository;

	public EstadoValidator(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PagamentoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		PagamentoRequest pagamento = (PagamentoRequest)target;
		
		Long paisId = pagamento.getPais();
		
		boolean exists = estadoRepository.existsByPaisId(paisId);
		
		if (exists) {
			Long estadoId = pagamento.getEstado();
			
			if (pagamento.getEstado() != null) {
				if( !estadoRepository.existsByIdAndPaisId(estadoId, paisId)) {
					errors.rejectValue("estado", null, "Estado [" + estadoId + "] não pertence ao país informado");
				}
			} else {
				errors.rejectValue("estado", null, "Informe um estado válido para o país "+paisId+" informado");
			}
		}
	}

}
