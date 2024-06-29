package com.yedam.mapper;

import com.yedam.vo.TemplateVO;

public interface ProductMapper {
	int deleteProdAll();
	int insertTemplate(TemplateVO[] array);
	int insertTemplate1(TemplateVO[] array);
}
