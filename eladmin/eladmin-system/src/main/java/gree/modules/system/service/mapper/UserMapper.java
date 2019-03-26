package gree.modules.system.service.mapper;

import gree.mapper.EntityMapper;
import gree.modules.system.service.dto.UserDTO;
import gree.modules.system.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
