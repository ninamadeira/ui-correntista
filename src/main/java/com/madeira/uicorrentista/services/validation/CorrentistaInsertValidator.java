package com.madeira.uicorrentista.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.madeira.uicorrentista.domain.enums.TipoCorrentista;
import com.madeira.uicorrentista.dto.CorrentistaNewDTO;
import com.madeira.uicorrentista.resources.exception.FieldMessage;
import com.madeira.uicorrentista.services.validation.utils.Util;

public class CorrentistaInsertValidator implements ConstraintValidator<CorrentistaInsert, CorrentistaNewDTO> {
	
	

	@Override
	public void initialize(CorrentistaInsert ann) {
	}

	@Override
	public boolean isValid(CorrentistaNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		

		if (objDto.getTipo().equals(TipoCorrentista.PESSOAFISICA.getCod()) && !Util.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getTipo().equals(TipoCorrentista.PESSOAJURIDICA.getCod()) && !Util.isValidCNPJ(objDto.getCpfOuCnpj())) {
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
