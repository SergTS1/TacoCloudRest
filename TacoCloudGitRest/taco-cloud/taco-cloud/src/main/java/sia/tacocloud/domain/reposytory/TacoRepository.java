package sia.tacocloud.domain.reposytory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sia.tacocloud.domain.entyty.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long>, CrudRepository<Taco, Long> {
}
