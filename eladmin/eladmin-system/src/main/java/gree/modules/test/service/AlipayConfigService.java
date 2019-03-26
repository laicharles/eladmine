package gree.modules.test.service;

import gree.modules.test.domain.AlipayConfig;
import gree.modules.test.service.dto.AlipayConfigDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author jie
* @date 2019-03-23
*/
@CacheConfig(cacheNames = "alipayConfig")
public interface AlipayConfigService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    AlipayConfigDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    AlipayConfigDTO create(AlipayConfig resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(AlipayConfig resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}