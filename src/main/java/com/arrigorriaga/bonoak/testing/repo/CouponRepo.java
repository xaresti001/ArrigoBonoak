package com.arrigorriaga.bonoak.testing.repo;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {
}
