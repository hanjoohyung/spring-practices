package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml")
public class DVDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	

	// @Autowired
	// 예외 발생
	// 이유는 XML Bean 설정(Avengers)에서는 ID를 자동으로 부여하지 않는다.
	// 그렇기 때문에 @Qualifier를 사용하지 못한다.
	private DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan") // ID로 판단
	private DigitalVideoDisc dvd2;
	
	@Autowired
	@Qualifier("avengersinfinitywar") // ID로 판단
	private DigitalVideoDisc dvd3;
	
	@Autowired
	@Qualifier("avengersendgame") // ID로 판단
	private DigitalVideoDisc dvd4;
	
	@Autowired
	@Qualifier("avengersageofultron") // ID로 판단
	private DigitalVideoDisc dvd5;
	
	@Autowired
	@Qualifier("avengerscaptainamerica") // ID로 판단
	private DigitalVideoDisc dvd6;
	
	@Autowired
	@Qualifier("avengersdirectoredition") // ID로 판단
	private DigitalVideoDisc dvd7;
	
	@Ignore
	@Test
	public void testDVD1NotNull() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDVD2NotNull() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDVD3NotNull() {
		assertNotNull(dvd3);
	}
	
	@Test
	public void testDVD4NotNull() {
		assertNotNull(dvd4);
	}
	
	@Test
	public void testDVD5NotNull() {
		assertNotNull(dvd5);
	}
	
	@Test
	public void testDVD6NotNull() {
		assertNotNull(dvd6);
	}
	
	@Test
	public void testDVD7NotNull() {
		assertNotNull(dvd7);
	}
}
