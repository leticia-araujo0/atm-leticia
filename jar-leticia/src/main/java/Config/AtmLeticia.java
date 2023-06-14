/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import services.ConectarBanco;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import services.Log;

/**
 *
 * @author PC
 */
public class AtmLeticia {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Log gerarLog = new Log();

        //=================LOOCA===============//
        Looca looca = new Looca();
        //=====================================//

        //=====CONEXÃO BANCO========//
        ConexaoBanco conexao = new ConexaoBanco();
        JdbcTemplate jdbcTemplate = conexao.getConnection();
        ConectarBanco conectar = new ConectarBanco(jdbcTemplate);

        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();

        //==================VALIDAÇÃO LOGIN===============//
        Integer atmNum = 0;
        Integer senha = 0;

        System.out.println("ATM: ");
        atmNum = leitor.nextInt();

        System.out.println("Senha: ");
        senha = leitor.nextInt();

        if (atmNum.equals(9) && (senha.equals(123))) {
            System.out.println("Login efetuado com sucesso!\n");

            gerarLog.gerarLog();

        } else {
            System.out.println("Número do ATM e/ou senha incorreto(s)!");
            System.exit(0);
        }

        //=====================GRUPOS=================//
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();

        //=====================CAPTANDO INFOS=================//
        System.out.println("***Horário:*** ");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));

        String linha = "*".repeat(45);
        System.out.println("\n");
        System.out.println(sistema);
        System.out.println(linha);

        System.out.println(memoria);
        System.out.println("*".repeat(45));

        System.out.println(processador);
        System.out.println("*".repeat(45));

        //=====================DISCOS=================//
        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            System.out.println(disco);
        }

        System.out.println("*".repeat(45));

        //====================PROCESSOS=================//
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                List<Processo> processos = grupoDeProcessos.getProcessos();
                List<Processo> top20 = new ArrayList<>();

                while (top20.size() < 21) {

                    Processo processoAgora = processos.stream()
                            .max(Comparator.comparingDouble(Processo::getUsoCpu))
                            .get();

                    top20.add(processoAgora);

                    processos.remove(processoAgora);
                }

                for (Processo processo : top20) {
                    System.out.println(top20.indexOf(processo));
                    System.out.println(processo);
                }
                System.out.println("*".repeat(45));

                ZonedDateTime dataZoned = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
                LocalDateTime data = dataZoned.toLocalDateTime();

                System.out.println(data);

                conectar.salvarProcessos(top20, data);

            }

        }, 0, 5000);

    }
}
