package com.gms.test;

import org.junit.Test;

import com.gms.domain.Site;
import com.gms.service.impl.SiteBusinessServiceImpl;

public class UnitTest {

	@Test
	public void testAddSite(){
		try {
			Site site = new Site();
			site.setFeeScale(10);
			site.setName("ÌåÓý¹Ý");
			site.setStatue("undelete");
			site.setTypeId(38);
			SiteBusinessServiceImpl service =new  SiteBusinessServiceImpl();
			service.addSite(site);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
