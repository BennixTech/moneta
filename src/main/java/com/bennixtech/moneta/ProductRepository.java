package com.bennixtech.moneta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Benrodgers Nzoki
 * Date : 3/22/2026
 * Email:nzokibenrodgers@gmail.com
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
