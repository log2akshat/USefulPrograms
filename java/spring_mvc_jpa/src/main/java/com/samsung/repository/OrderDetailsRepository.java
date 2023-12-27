package com.samsung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samsung.entity.OrderDetailsEntity;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Integer> {

	//@Modifying
	@Query(value = "UPDATE order_details set product_name=:pname WHERE order_id=:orderId", nativeQuery = true)
	public void updateOrderDetails(@Param("orderId") Integer orderId, @Param("pname") String pname);

}
