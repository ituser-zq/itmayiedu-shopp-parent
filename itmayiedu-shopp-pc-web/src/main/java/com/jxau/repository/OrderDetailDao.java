package com.jxau.repository;

import com.jxau.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:OrderDetailDao
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 13:38
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);

}
