package com.cnc.ecart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnc.ecart.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>
{

}
