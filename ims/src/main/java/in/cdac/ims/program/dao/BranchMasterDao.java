package in.cdac.ims.program.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import in.cdac.db.program.entity.BranchMaster;
import in.cdac.ims.util.entity.ResultDataMap;

public interface BranchMasterDao {
	
	
	public ResultDataMap saveNewBranch(BranchMaster bm);
	public HashMap<Integer, String> getBranchList();


}
