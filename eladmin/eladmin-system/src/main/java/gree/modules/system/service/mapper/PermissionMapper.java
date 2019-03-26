package gree.modules.system.service.mapper;

import gree.mapper.EntityMapper;
import gree.modules.system.service.dto.PermissionDTO;
import gree.modules.system.domain.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
