/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;
import services.Log;

/**
 *
 * @author PC
 */
public class AtmLeticia {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Looca looca = new Looca();
        ConexaoBanco conexao = new ConexaoBanco();
        Log gerarLog = new Log();

        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Temperatura temperatura = looca.getTemperatura();

        Integer atmNum = 0;

        System.out.println("ATM: ");
        atmNum = leitor.nextInt();

        gerarLog.gerarLog();
        conexao.equals(looca);

        //=====================GRUPOS=================//
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

        com.github.britooo.looca.api.group.servicos.ServicoGrupo grupoDeServicos = looca.getGrupoDeServicos();
        ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();

        //=====================CAPTANDO INFOS=================//
        System.out.println(
                "***Horário:*** ");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));

        System.out.println(
                "\n");
        System.out.println(sistema);

        System.out.println(
                "*".repeat(45));

        System.out.println(memoria);

        System.out.println(
                "*".repeat(45));

        System.out.println(processador);

        System.out.println(
                "*".repeat(45));

        //System.out.println(temperatura);
        //System.out.println("*".repeat(45));
        //=====================DISCOS=================//
        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            System.out.println(disco);
        }

        System.out.println(
                "*".repeat(45));

        //====================PROCESSOS=================//
        try {
            List<Processo> processos = grupoDeProcessos.getProcessos();

            for (Processo processo : processos) {
                System.out.println(processo);
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "*".repeat(45));

        //====================SERVIÇOS======================//
        List<Servico> servicos = grupoDeServicos.getServicosAtivos();

        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }
}
