package com.neuesoft.commerce.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuesoft.commerce.pojo.Brand;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;

@Mapper
public interface CompanyMyInfoMapper {

	// 更新公司信息
	@Update("update company set ccname=#{c.ccname},cename = #{c.cename},cinfo = #{c.cinfo},ctype=#{c.ctype},curl=#{c.curl} where cid=#{c.cid}")
	public void updateCompany(@Param("c") Company c);

	// 登陆写死！！！！！！！！！！2020.3.3 请及时替换
	@Select("select * from company_account where ca_name='wy' and ca_pwd='123456'")
	public CompanyAccount companyLogin();

	@Select("select * from company where cid = #{cid}")
	public Company queryCompany(int cid);

	@Select("select * from brand where cid = #{cid}")
	public List<Brand> queryCompanyBrand(int cid);

	// 删除公司品牌
	@Delete("delete from brand where bid = #{bid}")
	public int delectCompanyBrand(int bid);

	// 更新品牌信息
	@Update("update brand set bname=#{bname},blogo = #{blogo} where bid=#{bid}")
	public void updateBrand(@Param("bid") int bid, @Param("bname") String bname, @Param("blogo") String blogo);

	// 插入品牌信息
	@Insert("insert into brand  (bname,blogo,cid) values (#{bname},#{blogo},#{cid})")
	public void insertBrand(@Param("cid") int cid,@Param("bname") String bname, @Param("blogo") String blogo);

}
