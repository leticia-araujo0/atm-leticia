package repositories;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Config.ConexaoBanco;
import Config.DataBase;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

/**
 *
 * @author PC
 */
public class MonitorarRepository {
    
    DataBase conexao = new DataBase();

    ConexaoBanco conexaoIndividual = new ConexaoBanco();

    JdbcTemplate conIndividual = conexaoIndividual.getConnection();
    RedeParametros redeParametros;

    public JdbcTemplate con = conexao.getConnection();

    public List<Integer> verIdComponente(Integer idAtm, String tipoComponente) {
        return con.query("select id from Componente where caixa_eletronico_id = ? and tipo = ?",
                new SingleColumnRowMapper(Integer.class), idAtm, tipoComponente);
    }

    public List<Integer> verIdSistema(Integer idAtm) {

        return con.query("select s.id from Sistema s join CaixaEletronico ce"
                + " on ce.sistema_id  = s.id where ce.id = ?", new SingleColumnRowMapper(Integer.class), idAtm);
    }

    public List<Map<String, Object>> verIdComponenteVolume(Integer idAtm) {
        return con.queryForList("select id, ponto_montagem from Componente where caixa_eletronico_id = ? and tipo = 'disco' ", idAtm);
    }

    public List<Integer> verIdRede(Integer idAtm) {
        return con.query("select id from NetworkInterface where caixa_eletronico_id = ?",
                new SingleColumnRowMapper(Integer.class), idAtm);
    }

}
