package br.com.procardio.api.exceptions;

public class MedicoNaoEncontradoException extends RuntimeException {
    public MedicoNaoEncontradoException(Long id) {
        super("Médico não encontrado com ID: " + id);
    }
}
