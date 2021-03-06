package gree.modules.test.service.query;

import gree.modules.test.domain.AlipayConfig;
import gree.modules.test.repository.AlipayConfigRepository;
import gree.modules.test.service.mapper.AlipayConfigMapper;
import gree.utils.PageUtil;
import gree.modules.test.service.dto.AlipayConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "alipayConfig")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AlipayConfigQueryService {

    @Autowired
    private AlipayConfigRepository alipayConfigRepository;

    @Autowired
    private AlipayConfigMapper alipayConfigMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlipayConfigDTO alipayConfig, Pageable pageable){
        Page<AlipayConfig> page = alipayConfigRepository.findAll(new Spec(alipayConfig),pageable);
        return PageUtil.toPage(page.map(alipayConfigMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AlipayConfigDTO alipayConfig){
        return alipayConfigMapper.toDto(alipayConfigRepository.findAll(new Spec(alipayConfig)));
    }

    class Spec implements Specification<AlipayConfig> {

        private AlipayConfigDTO alipayConfig;

        public Spec(AlipayConfigDTO alipayConfig){
            this.alipayConfig = alipayConfig;
        }

        @Override
        public Predicate toPredicate(Root<AlipayConfig> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}