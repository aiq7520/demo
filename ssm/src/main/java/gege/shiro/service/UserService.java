package gege.shiro.service;

import java.util.Set;

import gege.shiro.entity.User;

public interface UserService {
    public void changePassword(Long userId, String newPassword); //�޸�����  
    public User findByUsername(String username); //�����û��������û�  
    public Set<String> findRoles(String username);// �����û����������ɫ  
    public Set<String> findPermissions(String username);// �����û���������Ȩ��  
}
