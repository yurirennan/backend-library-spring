package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Devolucao;
import br.edu.fafic.backendlibrary.domain.Emprestimo;
import br.edu.fafic.backendlibrary.repository.DevolucaoRepositoy;
import br.edu.fafic.backendlibrary.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.xa.XAException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class DevolucaoService {
    private final DevolucaoRepositoy devolucaoRepositoy;
    private final EmprestimoRepository emprestimoRepository;

    @Autowired
    public DevolucaoService(DevolucaoRepositoy devolucaoRepositoy, EmprestimoRepository emprestimoRepository) {
        this.devolucaoRepositoy = devolucaoRepositoy;
        this.emprestimoRepository= emprestimoRepository;
    }

    public Devolucao create(Devolucao devolucao) throws Exception {
        Optional<Emprestimo> emprestimo = this.emprestimoRepository.findById(devolucao.getEmprestimo().getId());
        if(emprestimo.isEmpty()){
            throw new Exception("Emprestimo não encontrado");
        }

        devolucao.setEmprestimo(emprestimo.get());

        if(devolucao.getEmprestimo().isSituacao() == true) {
            throw new Exception("Emprestimo já foi finalizado");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        if(LocalDate.parse(devolucao.getDataDevolucao(), dtf).isBefore(LocalDate.parse(devolucao.getEmprestimo().getDataEmprestimo(), dtf))) {
            throw new Exception("Data de devolução invalida");
        }

        if(ChronoUnit.DAYS.between(LocalDate.parse(devolucao.getEmprestimo().getDataEmprestimo(), dtf), LocalDate.parse(devolucao.getDataDevolucao(), dtf)) > 3){
            devolucao.setValorMulta(ChronoUnit.DAYS.between(LocalDate.parse(devolucao.getEmprestimo().getDataEmprestimo(), dtf), LocalDate.parse(devolucao.getDataDevolucao(), dtf)) * 2.00);
        } else {
            devolucao.setValorMulta(0.00);
        }

        devolucao.getEmprestimo().setSituacao(true);
        return this.devolucaoRepositoy.save(devolucao);
    }

    public List<Devolucao> show(){
        return this.devolucaoRepositoy.findAll();
    }

    public void delete(Devolucao devolucao) throws Exception{
        if(this.devolucaoRepositoy.findById(devolucao.getId()).isEmpty()) {
            throw new XAException("Devolução não existe");
        }

        this.devolucaoRepositoy.delete(devolucao);
    }
}
