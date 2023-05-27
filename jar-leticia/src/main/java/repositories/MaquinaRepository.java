/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import Config.ConexaoBanco;
import Config.DataBase;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 *
 * @author PC
 */
public class MaquinaRepository {

    DataBase conexao = new DataBase();
    RedeParametros redeParametros;

    ConexaoBanco conexaoDocker = new ConexaoBanco();

    public JdbcTemplate conDock = conexaoDocker.getConnection();

    public JdbcTemplate con = conexao.getConnection();

    public void cadastrarSistema(Sistema sistema) {
        String script;
        // Query do SQL
        script = "INSERT INTO Sistema (nome,fabricante,arquitetura) VALUES"
                + "(?,?,?)";

        conDock.update(script, sistema.getSistemaOperacional(), sistema.getFabricante(), sistema.getArquitetura());

        con.update(script,
                sistema.getSistemaOperacional(), sistema.getFabricante(), sistema.getArquitetura());
    }

    public List<Integer> buscarIdMaquina(String nomeMaquina) {
        return con.query("select id from CaixaEletronico where identificador = ?",
                new SingleColumnRowMapper(Integer.class), nomeMaquina);
    }
}
