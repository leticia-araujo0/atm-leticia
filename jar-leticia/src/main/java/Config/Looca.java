/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

/**
 *
 * @author PC
 */
public class Looca {

    private Sistema sistema;
    private Memoria memoria;
    private Processador processador;
    private Temperatura temperatura;
    private DiscoGrupo grupoDeDiscos;
    private ServicoGrupo grupoDeServicos;
    private ProcessoGrupo grupoDeProcessos;

    public Looca(Sistema sistema, Memoria memoria, Processador processador, Temperatura temperatura, DiscoGrupo grupoDeDiscos, ServicoGrupo grupoDeServicos, ProcessoGrupo grupoDeProcessos) {
        this.sistema = sistema;
        this.memoria = memoria;
        this.processador = processador;
        this.temperatura = temperatura;
        this.grupoDeDiscos = grupoDeDiscos;
        this.grupoDeServicos = grupoDeServicos;
        this.grupoDeProcessos = grupoDeProcessos;
    }

    Looca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public DiscoGrupo getGrupoDeDiscos() {
        return grupoDeDiscos;
    }

    public void setGrupoDeDiscos(DiscoGrupo grupoDeDiscos) {
        this.grupoDeDiscos = grupoDeDiscos;
    }

    public ServicoGrupo getGrupoDeServicos() {
        return grupoDeServicos;
    }

    public void setGrupoDeServicos(ServicoGrupo grupoDeServicos) {
        this.grupoDeServicos = grupoDeServicos;
    }

    public ProcessoGrupo getGrupoDeProcessos() {
        return grupoDeProcessos;
    }

    public void setGrupoDeProcessos(ProcessoGrupo grupoDeProcessos) {
        this.grupoDeProcessos = grupoDeProcessos;
    }

    @Override
    public String toString() {
        return "Looca{" + "sistema=" + sistema + ", memoria=" + memoria + ", processador=" + processador + ", temperatura=" + temperatura + ", grupoDeDiscos=" + grupoDeDiscos + ", grupoDeServicos=" + grupoDeServicos + ", grupoDeProcessos=" + grupoDeProcessos + '}';
    }

}
