package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Factura;
import co.edu.uniquindio.unicine.Entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepo extends JpaRepository<Factura, Integer> {
    @Query("select sum (f.valorCompleto) from Factura  f join f.compras c where c.cliente.id=:idCliente")
    Float calcularTotalGastado(Integer idCliente);
    //UNA FORMA DE HACERLO - se tendría que limitar mediante logica
    @Query("select c.cliente from  Factura f join f.compras c where c.cliente.id=: idCliente order by f.valorCompleto desc " )
    List<Object[]> obtenerCompraMasCostosa(Integer idCliente);

    //UTILIZANDO SUBCONSULTAS
    @Query("select c.cliente, f1 from Factura f1 join f1.compras c where f1.valorCompleto =  (select max(f.valorCompleto) from Factura f)")
    List<Object[]> obtenerCompraMasCostosa();
    @Query("select new co.edu.uniquindio.unicine.Dto.InformacionFacturaDTO(f.valorCompleto,f.fecha, (select sum (e.valor ) from Entrada e where e.factura.id=f.id), (select sum(c.valor) from Compra  c where c.id=f.id) ) from Factura f  join f.compras c  where c.cliente.id =:idCliente ")
    List<Object[]> obtenerInformacionCompras(Integer idCliente);

}
