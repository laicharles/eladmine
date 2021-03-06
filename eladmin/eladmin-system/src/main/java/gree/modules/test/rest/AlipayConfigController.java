package gree.modules.test.rest;

import gree.modules.test.domain.AlipayConfig;
import gree.modules.test.service.AlipayConfigService;
import gree.aop.log.Log;
import gree.exception.BadRequestException;
import gree.modules.test.service.dto.AlipayConfigDTO;
import gree.modules.test.service.query.AlipayConfigQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author jie
* @date 2019-03-23
*/
@RestController
@RequestMapping("api")
public class AlipayConfigController {

    @Autowired
    private AlipayConfigService alipayConfigService;

    @Autowired
    private AlipayConfigQueryService alipayConfigQueryService;

    private static final String ENTITY_NAME = "alipayConfig";

    @Log("查询AlipayConfig")
    @GetMapping(value = "/alipayConfig")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getAlipayConfigs(AlipayConfigDTO resources, Pageable pageable){
        return new ResponseEntity(alipayConfigQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增AlipayConfig")
    @PostMapping(value = "/alipayConfig")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody AlipayConfig resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(alipayConfigService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AlipayConfig")
    @PutMapping(value = "/alipayConfig")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody AlipayConfig resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        alipayConfigService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AlipayConfig")
    @DeleteMapping(value = "/alipayConfig/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        alipayConfigService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}