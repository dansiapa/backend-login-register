package com.digi.springboot;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonModel, Integer> {

	/*
	 *  untuk select person berdasarkan Nama
	 *  get[PersonModel]By[PersonName]
	 *   - PersonModel merupakan nama model nya
	 *   - PersonName merupakan attribute personName di model PersonModel
	 */
	Iterable<PersonModel> getPersonModelByPersonName(String personName);

}
