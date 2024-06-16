package Repository;

import Entities.Agenda;
import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda, Long> {
}
