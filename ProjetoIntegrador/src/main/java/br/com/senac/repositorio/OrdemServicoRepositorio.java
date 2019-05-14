package br.com.senac.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senac.dominio.OrdemServico;

public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Integer> {
	
//	@Query("select os from OrdemServico os where os.colaborador_id=?1")
//	List<OrdemServico> findByColaborador(Integer colaboradorId);
	
//	@Query("select os from OrdemServico os where os.data_abertura between ?1 and ?2")
//	List<OrdemServico> findByIntervaloDataAbertura(Date dataInicial, Date dataFinal);
	
//	@Query("select os from OrdemServico os where os.data_abertura=?1 and data_fechamento is null")
//	List<OrdemServico> findByAbertasHoje(Date hoje);
//	
//	@Query("select os from OrdemServico os where os.data_abertura=?1 and data_fechamento is not null")
//	List<OrdemServico> findByFechadasHoje(Date hoje);

}
