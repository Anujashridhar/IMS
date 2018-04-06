package in.cdac.auth.login.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import in.cdac.db.auth.entity.Authorities;
import in.cdac.db.auth.entity.User;

@Repository

public class LoginDaoImpl implements LoginDao{
	@Autowired
    private SessionFactory sessionFactory;
 
	
}
