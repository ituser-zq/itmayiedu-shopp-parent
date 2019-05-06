package com.jxau.repository;


import com.jxau.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:OrderMasterDao
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 13:35
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);

}
