package palvelinohjelmointi.kirjakauppa.domain;

import org.springframework.data.repository.CrudRepository;
//repository interfacen luonti, classi interfaceksi, ja extend valmiin Crudrepon
public interface BookRepository extends CrudRepository<Book, Long> {

}
