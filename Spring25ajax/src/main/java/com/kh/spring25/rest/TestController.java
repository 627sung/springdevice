package com.kh.spring25.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring25.entity.StudentDto;

@RestController //@Controller + ResponseBody
@RequestMapping("/test")
public class TestController {

	
	@GetMapping("/")
	public String test(){
		return "Hello Rest Controller";
		}
	
	//사용자(클라이언트)가 데이터가 필요하다고 할 때 주로 어떤 것을 필요로 할까?
	//단순한 결과 (ex:있다/없다) : boolean(x)--> String(o) //스트링만 받을 수 있다. 
	//데이터 목록 (ex:List) : 해당하는 그대로 사용 --> String변환
	//객체  or Map  : 해당하는 형태 그대로 사용 --->String 변환 
	//-요약하면 원시형태를 제외한 모든 형태 그대로 사용 
	
	@GetMapping("/test1")
	public boolean test1(){
		return true;
		}
	
	@GetMapping("/test2")
	public int test2(){
		return 123;
		}
	
	@GetMapping("/test3")
	public float test3(){
		return 3.14f;
		}
	
	@GetMapping("/test4")
	public List<String> test4(){
		List<String> list = new ArrayList<>();
		list.add("윌리엄스");
		list.add("맷데이먼");
		list.add("스필버그");
		return list;
		
	}
	
	@GetMapping("/test5")
	public Map<String,Object> test5(){
		Map<String,Object>map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("score", "999");
		return map;
	}
	
	@GetMapping("/test6")
	public  StudentDto test6(){
		return StudentDto.builder().name("홍길동").age(20).score(99).build();
	}
		
		
	////////////////////////////////////////////////////////
	//sqlsession 이용하여 데이터베이스 조회후 반환 
	/////////////////////////////////////////////////////////
	
	@Autowired private SqlSession sqlSession;
	
	//목록반환 
	@GetMapping("test7")
	public List<StudentDto> test7(){
		List<StudentDto>list = sqlSession.selectList("student.getList");
		return list;
	}
	
	//학생명 조회 
	
	@GetMapping("/test8")
	public StudentDto test8(
			@RequestParam String name ){//받아와야됨 
		StudentDto studentDto = sqlSession.selectOne("student.get",name);
		return studentDto;
	}
	
	@GetMapping("/test9")
	public List<StudentDto> test9(
			@RequestParam int start,
			@RequestParam int finish
			){
		Map<String, Object>map = new HashMap<>();
		map.put("start",start);
		map.put("finish",finish);
		List<StudentDto> list
		= sqlSession.selectList("student.section",map);
		return list;

	}
	
	
	
	
}
