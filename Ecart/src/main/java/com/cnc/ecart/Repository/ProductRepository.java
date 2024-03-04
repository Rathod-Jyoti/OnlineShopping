package com.cnc.ecart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cnc.ecart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(nativeQuery = true, value = "select * from products where catId:catId ")
    public List<Product> findByCatId(@Param("catId") Integer catId);

}
