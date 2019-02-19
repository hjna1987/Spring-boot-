package com.simplify.sample.db.mapper;

import java.util.List;

import com.simplify.sample.db.dto.Test;

public interface TestMapper {
	
	//mapper xml 에서 mapper tag 안에 선언한 namespace 에 정확하게 일치하는 위치에 같은 이름으로 생성해야 하며, method 이름은 위에 select tag 안에 있는 id 값과 동일하게 작성되어야 자동으로 call 이 이루어진다
	public List<Test> getAll() throws Exception;

}
