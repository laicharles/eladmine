package gree.modules.test.service.impl;

import gree.modules.test.domain.AlipayConfig;
import gree.modules.test.repository.AlipayConfigRepository;
import gree.modules.test.service.AlipayConfigService;
import gree.modules.test.service.mapper.AlipayConfigMapper;
import gree.utils.ValidationUtil;
import gree.modules.test.service.dto.AlipayConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author jie
* @date 2019-03-23
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AlipayConfigServiceImpl implements AlipayConfigService {

    @Autowired
    private AlipayConfigRepository alipayConfigRepository;

    @Autowired
    private AlipayConfigMapper alipayConfigMapper;

    @Override
    public AlipayConfigDTO findById(Long id) {
        Optional<AlipayConfig> alipayConfig = alipayConfigRepository.findById(id);
        ValidationUtil.isNull(alipayConfig,"AlipayConfig","id",id);
        return alipayConfigMapper.toDto(alipayConfig.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlipayConfigDTO create(AlipayConfig resources) {
        return alipayConfigMapper.toDto(alipayConfigRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AlipayConfig resources) {
        Optional<AlipayConfig> optionalAlipayConfig = alipayConfigRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAlipayConfig,"AlipayConfig","id",resources.getId());

        AlipayConfig alipayConfig = optionalAlipayConfig.get();
        // 此处需自己修改
        resources.setId(alipayConfig.getId());
        alipayConfigRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        alipayConfigRepository.deleteById(id);
    }
}