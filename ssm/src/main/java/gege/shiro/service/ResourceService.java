package gege.shiro.service;

import java.util.List;
import java.util.Set;

import gege.shiro.entity.Resource;

public interface ResourceService {
	Set<String> findPermissions(Set<Long> resourceIds); //得到资源对应的权限字符串  
    List<Resource> findMenus(Set<String> permissions); //根据用户权限得到菜单  
}
