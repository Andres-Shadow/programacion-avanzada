package co.edu.uniquindio.unicine.Repo;

import co.edu.uniquindio.unicine.Entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select c.cliente.id, count(c) from Compra c where c.cupon is not null group by c.cliente")
    List<Object[]> contarCuponesRedimidos();


}
