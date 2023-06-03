package repositories;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Config.ConexaoBanco;
import Config.DataBase;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import java.time.LocalDateTime;
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
    
    public JdbcTemplate con = conexao.getConnection();

//    public void enviarMetrica(Integer componenteId, LocalDateTime dtMetrica, Double qtdConsumido) {
//        String script = "insert into MetricaComponente (qtd_consumido,dt_metrica,componente_id) values (?,?,?)";
//
//        conIndividual.update(script, qtdConsumido, dtMetrica, componenteId);
//        
//        con.update(script, qtdConsumido, dtMetrica, componenteId);
//    }
//
//    public void enviarMetrica(Integer componenteId, LocalDateTime dtMetrica, Long qtdConsumido) {
//
//        String script = "insert into MetricaComponente (qtd_consumido,dt_metrica,componente_id) values (?,?,?)";
//
//        conIndividual.update(script, qtdConsumido, dtMetrica, componenteId);
//        con.update(script, qtdConsumido, dtMetrica, componenteId);
//    }
//
//    public void enviarMetrica(Integer componenteId, LocalDateTime dtMetrica, Integer qtdConsumido) {
//        String script = "insert into MetricaComponente (qtd_consumido,dt_metrica,componente_id) values (?,?,?)";
//        conIndividual.update(script, qtdConsumido, dtMetrica, componenteId);
//
//        con.update(script, qtdConsumido, dtMetrica, componenteId);
//    }
//
//    public void enviarMetricaRede(Integer redeId, Long bytesRecebidosSegundo,
//            Long bytesEnviadosSegundo, LocalDateTime dtMetrica) {
//
//        String script = "insert into MetricaRedeInterface (bytes_recebidos_segundo,"
//                + "bytes_enviados_segundo,dt_metrica,network_interface_id) values (?,?,?,?)";
//
//        conIndividual.update(script,
//                bytesRecebidosSegundo, bytesEnviadosSegundo, dtMetrica, redeId);
//
//        con.update(script,
//                bytesRecebidosSegundo, bytesEnviadosSegundo, dtMetrica, redeId);
//    }
}
