package com.deniswillian.cursomcc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.deniswillian.cursomcc.domain.enums.TipoCliente;
import com.deniswillian.cursomcc.dto.ClienteNewDTO;
import com.deniswillian.cursomcc.resources.exeptions.FieldMessage;
import com.deniswillian.cursomcc.services.validation.utils.BR;

public class CLienteInsertValidator implements ConstraintValidator<CLienteInsert, ClienteNewDTO> {

	@Override
	public void initialize(CLienteInsert ann) {
	}

	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
