package br.com.procardio.api.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.procardio.api.dto.MedicoDTO;
import br.com.procardio.api.model.Medico;
import br.com.procardio.api.service.MedicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    public ResponseEntity<Medico> cadastrarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        Medico novoMedico = medicoService.salvarMedico(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @Valid @RequestBody MedicoDTO medicoDTO) {
        Medico medicoAtualizado = medicoService.salvarMedico(id, medicoDTO);

        if(Objects.nonNull(medicoAtualizado)){
            return ResponseEntity.ok(medicoAtualizado);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable Long id) {
        Medico medico = medicoService.buscarMedicoPorId(id);

        if(Objects.nonNull(medico)){
            return ResponseEntity.ok(medico);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Medico>> buscarMedicosPorNome(@PathVariable String nome) {
        List<Medico> medicos = medicoService.buscarMedicosPorNome(nome);
        return ResponseEntity.ok(medicos);
    }

    public ResponseEntity<Medico> buscarMedicoPorEmail(@Valid @PathVariable String email) {
        Medico medico = medicoService.buscarMedicoPorEmail(email);

        if(Objects.nonNull(medico)){
            return ResponseEntity.ok(medico);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Medico> buscarMedicoPorCrm(@Valid @PathVariable String crm) {
        Medico medico = medicoService.buscarMedicoPorCrm(crm);

        if(Objects.nonNull(medico)){
            return ResponseEntity.ok(medico);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Medico>> listarMedicos() {
        List<Medico> medicos = medicoService.listarMedicos();

        if(Objects.nonNull(medicos)){
            return ResponseEntity.ok(medicos);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
