package gree.modules.test.repository;

import gree.modules.test.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-03-23
*/
public interface AlipayConfigRepository extends JpaRepository<AlipayConfig, Long>, JpaSpecificationExecutor {
}