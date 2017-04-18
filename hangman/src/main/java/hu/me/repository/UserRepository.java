package hu.me.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.me.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	List<UserEntity>findByLastName(String lastName);

}
