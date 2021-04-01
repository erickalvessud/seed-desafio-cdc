package com.deveficiente.util;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.controller.dto.CompraRequest;
import com.deveficiente.controller.dto.PedidoRequest;
import com.deveficiente.jpa.repository.LivroRepository;

@Component
public class ValorTotalLivroValidator implements Validator {
	
	private LivroRepository livroRepository;

	public ValorTotalLivroValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CompraRequest pagamento = (CompraRequest)target;
		
		PedidoRequest pedido = pagamento.getPedido();
		
		BigDecimal result = pedido.getItens().stream()
			.map(item -> (livroRepository.findById(item.getIdLivro()).get().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()))))
			.reduce(BigDecimal.ZERO, BigDecimal::add)
			;
		
		if (!pedido.getTotal().equals(result)) {
			errors.rejectValue("pedido", null, "Total [" + pedido.getTotal() + "] divergente do total calculado no servidor [" + result + "]");
		}
	}

}
