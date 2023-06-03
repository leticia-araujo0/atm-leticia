/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Config.ConexaoBanco;
import Config.DataBase;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.servicos.Servico;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author PC
 */
public class ConectarBanco {

    private JdbcTemplate jdbcTemplate;

    public ConectarBanco(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void incluir(List<Processo> listaProcessos) {
        String sql = "INSERT INTO Processo(nome, pid, uso_cpu, uso_memoria, byte_utilizado, memoria_virtual_utilizada) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        for (Processo processo : listaProcessos) {
            jdbcTemplate.update(sql,
                    processo.getNome(),
                    processo.getPid(),
                    processo.getUsoCpu(),
                    processo.getUsoMemoria(),
                    processo.getBytesUtilizados(),
                    processo.getMemoriaVirtualUtilizada());
        }
    }
}
