package gree.modules.test.service.mapper;

import gree.mapper.EntityMapper;
import gree.modules.test.domain.AlipayConfig;
import gree.modules.test.service.dto.AlipayConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-03-23
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlipayConfigMapper extends EntityMapper<AlipayConfigDTO, AlipayConfig> {

}