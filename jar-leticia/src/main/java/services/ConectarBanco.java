/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Config.DataBase;
import com.github.britooo.looca.api.group.processos.Processo;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author PC
 */
public class ConectarBanco {

    private JdbcTemplate jdbcTemplate;

    //=============CONEXÃO AZURE==================//
    DataBase conexao = new DataBase();

    public JdbcTemplate con = conexao.getConnection();
    //===========================================//

    public ConectarBanco(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvarProcessos(List<Processo> listaProcessos, LocalDateTime data) {
        String sql = "INSERT INTO Processo(nome, pid, uso_cpu, uso_memoria, byte_utilizado, memoria_virtual_utilizada, dt_processo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        for (Processo processo : listaProcessos) {
            jdbcTemplate.update(sql,
                    processo.getNome(),
                    processo.getPid(),
                    processo.getUsoCpu(),
                    processo.getUsoMemoria(),
                    processo.getBytesUtilizados(),
                    processo.getMemoriaVirtualUtilizada(),
                    data);
        }
    }

    public void salvarProcessosAzure(List<Processo> listaProcessos, LocalDateTime dataHora) {
        String sql = "INSERT INTO Processo(nome, pid, uso_cpu, uso_memoria, byte_utilizado, memoria_virtual_utilizada, dt_processo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        for (Processo processo : listaProcessos) {
            con.update(sql,
                    processo.getNome(),
                    processo.getPid(),
                    processo.getUsoCpu(),
                    processo.getUsoMemoria(),
                    processo.getBytesUtilizados(),
                    processo.getMemoriaVirtualUtilizada(),
                    dataHora);
        }
    }
}
