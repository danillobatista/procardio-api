package br.com.procardio.api.dto;

import br.com.procardio.api.enums.Especialidade;
import jakarta.validation.constraints.NotBlank;

public record MedicoDTO(
    Long id,
    @NotBlank
    String nome,
    @NotBlank
    String email,
    @NotBlank
    String senha,
    String cep,
    String numero,
    String complemento,
    String crm,
    Especialidade especialidade
) {
}