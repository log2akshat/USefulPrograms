package com.samsung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samsung.entity.SamsungStoreEntity;

@Repository
public interface SamsungStoreRepository extends CrudRepository<SamsungStoreEntity, String> {

	List<SamsungStoreEntity> findByStoreLocation(String storeLocation);

	List<SamsungStoreEntity> findByPincodeOrCity(int pincode, String city);

	@Query(value = "SELECT * FROM samsung_store WHERE city=?1 AND pincode=?2", nativeQuery = true)
	List<SamsungStoreEntity> getStoreByPincodeAndCityNativeIndexedQuery(String city, int pincode);

	@Query(value = "SELECT * FROM samsung_store WHERE city=:cityName OR pincode=:pincode", nativeQuery = true)
	List<SamsungStoreEntity> getStoreByPincodeOrCityNativeNamedQuery(@Param("cityName") String city, @Param("pincode") int pincode);

	@Query(value = "SELECT s FROM SamsungStoreEntity s WHERE city=?1")
	List<SamsungStoreEntity> getStoreByCityJPQLQuery(String city);

}